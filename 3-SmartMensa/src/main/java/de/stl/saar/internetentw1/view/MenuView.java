package de.stl.saar.internetentw1.view;

import de.stl.saar.internetentw1.model.Dish;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.LinkedList;
import java.util.List;

@ManagedBean
@ViewScoped
public class MenuView {

    private List<Dish> orderList = new LinkedList<>();
    private double total;
    private boolean shoppingCartEmpty= true;

    public List<Dish> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Dish> orderList) {
        this.orderList = orderList;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double newTotal) {
        total = newTotal;
    }

    /**
     * Fügt ein neues Dish-Objekt zur Datenbank hinzu. Existiert das
     * Objekt bereits, wird dieses durch das neue ersetzt.
     * @param dish Das hinzuzufügende Dish-Objekt
     */
    public void addDish (Dish dish) {
        orderList.add(dish);
        total += dish.getPrice();

        shoppingCartEmpty= orderList.isEmpty();

    }

    /**
     * Entfernt das angegebene Dish-Objekt aus der Bestell-Liste.
     * @param dish Das zu entfernende Dish-Objekt
     */
    public void removeDish (Dish dish) {
        orderList.remove(dish);
        total -= dish.getPrice();

        shoppingCartEmpty= orderList.isEmpty();
    }

    public boolean isShoppingCartEmpty() {
        return shoppingCartEmpty;
    }

    public void setShoppingCartEmpty(boolean shoppingCartEmpty) {
        this.shoppingCartEmpty = shoppingCartEmpty;
    }

}
