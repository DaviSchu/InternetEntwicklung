package de.stl.saar.internetentw1.view;

import de.stl.saar.internetentw1.dao.interfaces.UserDao;
import de.stl.saar.internetentw1.model.User;
import de.stl.saar.internetentw1.session.UserSession;
import de.stl.saar.internetentw1.utils.I18nUtil;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class ChangePasswordView {

    @ManagedProperty("#{userSession}")
    private UserSession userSession;

    private String oldPassword;
    private String password;
    private String passwordConfirmation;

    private User user;

    /**
     * Ändert das Passwort eines Benutzers und erwartet vorher das
     * ursprüngliche Passwort. Stimmen diese nicht überein, wird
     * eine Fehlermeldung angezeigt.
     * @return Die Seite, auf die als nächstes navigiert werden soll
     */
    public String changePassword() {
        user = userSession.getUser();
        if (user.getPassword().matches(oldPassword)) {
            user.setPassword(password);
            user.setChangePassword(false);
            return "overview";
        } else {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                            I18nUtil.getInvalidPassword()));
        }
        return null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public UserSession getUserSession() {
        return userSession;
    }

    public void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

}
