package de.stl.saar.internetentw1.view;

import de.stl.saar.internetentw1.dao.interfaces.DishDao;
import de.stl.saar.internetentw1.model.Category;
import de.stl.saar.internetentw1.model.Dish;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


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

    public Category[] getCategories() {
        return Category.values();
    }

    public String saveDish() {
        print();
        Dish newDish = new Dish(dishName, price, category, imageName);
        dishDao.addDish(newDish);

        return "dishes";
    }

    public String refresh() {

        //dishDao.removeDish(dishId);

        return "";
    }

    public void print() {
        System.out.println(dishId);
        System.out.println(dishName);
        System.out.println(price);
        System.out.println(category);
        System.out.println(categories);
        System.out.println(imageName);
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
