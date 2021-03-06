package de.stl.saar.internetentw1.view;

import de.stl.saar.internetentw1.dao.interfaces.DishDao;
import de.stl.saar.internetentw1.model.Category;
import de.stl.saar.internetentw1.model.Dish;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;


@ManagedBean
@SessionScoped
public class DishView {

    @ManagedProperty("#{dishDao}")
    private DishDao dishDao;

    private int dishId;
    private String dishName;
    private double price;
    private Category category;
    private Category[] categories;
    private String imageName;
    private Dish dish;

    public Category[] getCategories() {
        return Category.values();
    }

    /**
     * Fügt ein neues Dish-Objekt zur Datenbank hinzu. Existiert das
     * Objekt bereits, wird dieses durch das neue ersetzt.
     * @return Die Seite, auf die als nächstes navigiert werden soll
     */
    public String saveDish() {
        Dish newDish = new Dish(dishName, price, category, imageName);
        if (dish != null) {
            newDish.setDishId(dishId);
            dishDao.replaceDish(newDish);
        } else {
            dishDao.addDish(newDish);
        }

        return "dishes";
    }

    public void print() {
        System.out.println(dishId);
        System.out.println(dishName);
        System.out.println(price);
        System.out.println(category);
        System.out.println(categories);
        System.out.println(imageName);
    }

    /**
     * Lädt ein mitgegebenes Dish-Objekt in die Klasse.
     * @param dish Das Dish-Objekt, was geladen werden soll
     */
    public void loadDish(Dish dish) {
        this.dish = dish;
        dishId = dish.getDishId();
        dishName = dish.getDishName();
        price = dish.getPrice();
        category = dish.getCategory();
        imageName = dish.getImageName();
    }

    /**
     * Setzt alle relevanten Dish-Attribute zurück.
     */
    public void purge() {
        this.dish = null;
        dishId = 0;
        dishName = null;
        price = 0.0;
        category = null;
        imageName = "";
    }

    public DishDao getDishDao() {
        return dishDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

}
