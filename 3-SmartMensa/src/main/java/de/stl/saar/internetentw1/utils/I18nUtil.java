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

}
