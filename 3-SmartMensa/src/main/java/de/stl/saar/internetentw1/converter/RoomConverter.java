package de.stl.saar.internetentw1.converter;

import de.stl.saar.internetentw1.model.Room;
import de.stl.saar.internetentw1.utils.I18nUtil;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Room.class)
public class RoomConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context,
                              UIComponent component,
                              String value) {
        int building;
        int floor;
        int room;
        FacesContext facesContext;
        FacesMessage roomLengthError = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Error", I18nUtil.getRoomLengthError());
        FacesMessage roomRequired = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Error", I18nUtil.getRoomRequired());

        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, roomRequired);
        }

        if (value.length() != 4) {
            facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, roomLengthError);
        }

            building= Integer.parseInt(value.substring(0,1));
            floor= Integer.parseInt(value.substring(1,2));
            room= Integer.parseInt(value.substring(2,4));

            return new Room(building, floor, room);

    }

    @Override
    public String getAsString(FacesContext context,
                              UIComponent component,
                              Object value) {
        final Room room = (Room)value;

        if (room.getRoom() < 10) {
            return String.valueOf(room.getBuilding()) + room.getFloor()
                    + "0" + room.getRoom();
        } else {
            return room.toString();
        }


    }
}