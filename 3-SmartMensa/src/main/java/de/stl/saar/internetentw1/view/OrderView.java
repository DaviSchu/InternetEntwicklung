package de.stl.saar.internetentw1.view;

import de.stl.saar.internetentw1.model.Room;
import de.stl.saar.internetentw1.utils.I18nUtil;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ErrorMessages;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
@ViewScoped
public class OrderView {

    private String name;
    private Room room;
    private boolean order=false;

    public String goBack() {
        if (order){
            return "overview";
        } else {
            setOrder(false);

            return "menu";
        }
    }

    public void validateRoom (FacesContext facesContext, UIComponent component,
                              Object value) throws ValidatorException {
        Room validateRoom = (Room)value;
        int building =validateRoom.getBuilding();
        int floor=validateRoom.getFloor();
        int roomNumber=validateRoom.getRoom();

        if(building<1 ^ building>9) {
            throw new ValidatorException(new FacesMessage
                    (I18nUtil.getBuildingError()));
        } else if (floor<0 ^ floor>2) {
            throw new ValidatorException(new FacesMessage
                    (I18nUtil.getFloorError()));
        } else if (roomNumber<1 ^ roomNumber>20) {
            throw new ValidatorException(new FacesMessage
                    (I18nUtil.getRoomError()));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() { return room; }

    public void setPassword(Room room) {
        this.room = room;
    }

    public boolean isOrder() {
        return order;
    }

    public void setOrder(boolean order) {
        this.order = order;
    }

}
