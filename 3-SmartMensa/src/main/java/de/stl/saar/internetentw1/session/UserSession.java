package de.stl.saar.internetentw1.session;

import de.stl.saar.internetentw1.model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Speichert den User, der derzeit eingeloggt ist.
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
