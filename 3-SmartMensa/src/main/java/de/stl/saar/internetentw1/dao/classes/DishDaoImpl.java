package de.stl.saar.internetentw1.dao.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.stl.saar.internetentw1.dao.interfaces.DishDao;
import de.stl.saar.internetentw1.model.Category;
import de.stl.saar.internetentw1.model.Dish;
import de.stl.saar.internetentw1.utils.RandomUtils;

/**
 * Simuliert die Dish-Tabelle einer Datenbank mithilfe
 * einer Map, wobei der Primärschlüssel der Schlüssel der
 * Map ist. 
 * @author christopher
 *
 */
public class DishDaoImpl implements DishDao {
	private Map<Integer, Dish> dishTable;

	public DishDaoImpl() {
		dishTable = new HashMap<>();
		final Dish dish1 = new Dish("Baumkuchen", 2.0, Category.DESSERT, "baumkuchen");
		final Dish dish2 = new Dish("Creme Brulee", 2.5, Category.DESSERT, "cremeBrulee");
		final Dish dish3 = new Dish("Flammkuchen", 7.5, Category.MAIN_DISH, "flammkuchen");
		final Dish dish4 = new Dish("Griessnockerl-Suppe", 4, Category.SOUP, "griessnockerlsuppe");
		final Dish dish5 = new Dish("Pudding", 2, Category.DESSERT, "pudding");
		final Dish dish6 = new Dish("Rindfleischsuppe", 3.5, Category.SOUP, "rindfleischsuppe");
		final Dish dish7 = new Dish("Rumänischer Salat", 3.5, Category.SALAD, "rumaenischerSalat");
		final Dish dish8 = new Dish("Einfach nur Salat", 3.5, Category.SALAD, "salat");
		final Dish dish9 = new Dish("Wiener Schnitzel", 7.0, Category.MAIN_DISH, "schnitzel");
		final Dish dish10 = new Dish("Tomate-Mozarella", 4.0, Category.SALAD, "tomateMozarella");
		addDish(dish1);
		addDish(dish2);
		addDish(dish3);
		addDish(dish4);
		addDish(dish5);
		addDish(dish6);
		addDish(dish7);
		addDish(dish8);
		addDish(dish9);
		addDish(dish10);
	}
	/**
	 * Fügt ein neues Gericht in die Datenbank ein. Dabei wird der
	 * Primärschlüsselwert durch die Größe der Darenbank bestimmt.
	 * @param dish Das Gericht, das hinzugefügt werden soll.
	 */
	@Override
	public void addDish(final Dish dish) {
		dish.setDishId(dishTable.size()+1);
		dishTable.put(dishTable.size()+1, dish);
	}
	
	/**
	 * Erzeugt einen neuen Primärschlüsselwert. Dabei wird der Wert
	 * zufällig erzeugt und dann wird geprüft, ob es bereits einen
	 * Datensatz mit diesem Wert gibt. Falls nein, wird dieser
	 * Primärschlüsselwert zurückgegeben. 
	 * @return Der neu erzeugte und noch nicht vergebene Primärschlüsselwert.
 	 */
	private int createPrimaryKeyValue() {
		int primaryKey = 0;
		
		do {
			primaryKey = RandomUtils.nextInt();
		} while(!primaryKeyValueFree(primaryKey));
		
		return primaryKey;
	}
	
	/**
	 * Prüft, ob ein Primärschlüsselwert bereits vergeben ist. 
	 * @param primaryKeyValue Der zu prüfende Wert.
	 * @return True, falls der Wert bereits als Primärschlüsselwert in 
	 * der Tabelle vorkommt, sonst false. 
	 */
	private boolean primaryKeyValueFree(final int primaryKeyValue) {
		final Dish dishWithPrimaryKey = dishTable.get(primaryKeyValue);
		if (dishWithPrimaryKey == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Entfernt ein Gericht aus der Datenbank und passt alle folgenden
	 * Primärschlüsselwerte dynamisch an. Dabei wird zuerst das Gericht,
	 * mit der mitgegebenen Dish-ID aus der Datenbank entfernt.
	 * @param dishId Der Primärschlüsselwert des zu entfernenden Gerichts
	 */
	@Override
	public void removeDish(final int dishId) {
		Dish dish;
		for (int i = dishId; i < dishTable.size(); i++) {
			dish = dishTable.get(i+1);
			dish.setDishId(i);
			dishTable.put(i,dish);
		}
		dishTable.remove(dishTable.size());
	}

	/**
	 * Setzt ein übergebenes Gericht an die Stelle seiner Id.
	 * @param dish Das Gericht, das eingefügt werden soll
	 */
	@Override
	public void replaceDish(Dish dish) {
		dishTable.put(dish.getDishId(), dish);
	}

	/**
	 * Gibt eine Liste mit allen Dish-Objekten zurück.
	 * @return Die Liste mit allen Dish-Objekten
	 */
	@Override
	public List<Dish> findAllDishes() {
		final Collection<Dish> dishCollection = dishTable.values();
		final List<Dish> dishes = new ArrayList<>(dishCollection);
		return dishes;
	}

}
