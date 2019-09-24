package de.stl.saar.internetentw1.view;

import de.stl.saar.internetentw1.model.Dish;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.LinkedList;
import java.util.List;

@ManagedBean
@ViewScoped
public class menuView {

    private List<Dish> orderList = new LinkedList<>();
    private double total;

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

    public void addDish (Dish dish) {
        orderList.add(dish);
        total += dish.getPrice();
    }

    public void removeDish (Dish dish) {
        orderList.remove(dish);
        total -= dish.getPrice();
    }

}
