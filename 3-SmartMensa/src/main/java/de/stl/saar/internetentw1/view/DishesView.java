package de.stl.saar.internetentw1.view;

import de.stl.saar.internetentw1.dao.interfaces.DishDao;
import de.stl.saar.internetentw1.model.Dish;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class DishesView {

    @ManagedProperty("#{dishDao}")
    private DishDao dishDao;

    private List<Dish> dishList;

    public void intialize() {
        dishList = dishDao.findAllDishes();
    }

    public DishDao getDishDao() {
        return dishDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

}
