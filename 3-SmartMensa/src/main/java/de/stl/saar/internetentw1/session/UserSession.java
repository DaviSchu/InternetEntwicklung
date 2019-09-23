package de.stl.saar.internetentw1.session;

import de.stl.saar.internetentw1.model.User;

/**
 * Stores the current logged in user
 */
public class UserSession {

    private int locale;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
