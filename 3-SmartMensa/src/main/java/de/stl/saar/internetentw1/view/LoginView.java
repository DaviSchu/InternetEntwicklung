package de.stl.saar.internetentw1.view;

import de.stl.saar.internetentw1.dao.interfaces.UserDao;
import de.stl.saar.internetentw1.model.User;
import de.stl.saar.internetentw1.session.UserSession;
import de.stl.saar.internetentw1.utils.I18nUtil;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@SessionScoped
public class LoginView {

    @ManagedProperty("#{userDao}")
    private UserDao userDao;

    @ManagedProperty("#{userSession}")
    private UserSession userSession;

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserSession getUserSession() {
        return userSession;
    }

    public void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }

    /**
     * Nimmt Daten aus der Login-Seite entgegen und speichert diese in die Klasse ab.
     * Existiert ein User in der Datenbank, mit den selben Eingaben, wird dieser eingeloggt,
     * in die UserSession zwischengespeichert und zur Hauptseite weitergeleitet.
     * Vorher wird überprüft, ob der Benutzer sein Passwort ändern muss.
     * Existiert kein User in der Datenbank, mit den selben Eingaben, wird eine Fehlermeldung
     * erzeugt.
     * @return Die Seite, auf die als nächstes navigiert werden soll
     */
    public String login() {

        List<User> userList = userDao.findAllUsers();


        for(User u: userList) {
            if(u.getUsername().matches(userName)) {
                if (u.getPassword().matches(password)) {
                    userSession.setUser(u);
                    userName="";
                    password="";
                    if (u.isChangePassword()) {
                        return "changePassword";
                    } else {
                        return "overview";
                    }
                }
            }
        }
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        I18nUtil.getInvalidUserData()));
        return null;
    }


    /**
     * Löscht die Daten aus der UserSession.
     */
    public void logOut(){
        userSession.setUser(null);
    }

}
