package de.stl.saar.internetentw1.dao.interfaces;

import java.util.List;

import de.stl.saar.internetentw1.model.Dish;

public interface DishDao {
	/**
	 * Fügt ein neues Gericht in die Datenbank ein. Dabei wird der
	 * Primärschlüsselwert durch die Größe der Darenbank bestimmt.
	 * @param dish Das Gericht, das hinzugefügt werden soll.
	 */
	void addDish(Dish dish);

	/**
	 * Entfernt ein Gericht aus der Datenbank und passt alle folgenden
	 * Primärschlüsselwerte dynamisch an. Dabei wird zuerst das Gericht,
	 * mit der mitgegebenen Dish-ID aus der Datenbank entfernt.
	 * @param dishId Der Primärschlüsselwert des zu entfernenden Gerichts
	 */
	void removeDish(int dishId);

	/**
	 * Gibt eine Liste mit allen Dish-Objekten zurück.
	 * @return Die Liste mit allen Dish-Objekten
	 */
	List<Dish> findAllDishes();

	/**
	 * Setzt ein übergebenes Gericht an die Stelle seiner Id.
	 * @param dish Das Gericht, das eingefügt werden soll
	 */
	void replaceDish(Dish dish);

}
