package de.stl.saar.internetentw1.session;

import de.stl.saar.internetentw1.model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Stores the current logged in user
 */
@ManagedBean
@SessionScoped
public class UserSession {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
