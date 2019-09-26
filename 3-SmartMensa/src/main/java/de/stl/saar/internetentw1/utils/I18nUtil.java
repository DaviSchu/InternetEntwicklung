package de.stl.saar.internetentw1.utils;

import java.util.ResourceBundle;

public class I18nUtil {

    private static ResourceBundle messages = ResourceBundle.getBundle("i18n/messages");

    public static String getInvalidPasswordConfirmation () {
        return messages.getString("passwordsNotEqual");
    }

    public static String getInvalidUserConfirmation () {
        return messages.getString("usernameExists");
    }

    public static String getInvalidUserData () {
        return messages.getString("wrongLogInData");
    }

    public static String getInvalidPassword() { return messages.getString("wrongPassword"); }

    public static String getRoomLengthError() {
        return messages.getString("roomLengthError");
    }

    public static String getRoomRequired() {
        return messages.getString("roomRequired");
    }

    public static String getRoomError() {
        return messages.getString("roomError");
    }

    public static String getFloorError() {
        return messages.getString("floorError");
    }

    public static String getBuildingError() {
        return messages.getString("buildingError");
    }
}
