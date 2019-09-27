package de.stl.saar.internetentw1.view;

import de.stl.saar.internetentw1.dao.interfaces.UserDao;
import de.stl.saar.internetentw1.model.Role;
import de.stl.saar.internetentw1.model.User;
import de.stl.saar.internetentw1.session.UserSession;
import de.stl.saar.internetentw1.utils.RandomUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;



@ManagedBean
@SessionScoped
public class UserAdministrationView {

    @ManagedProperty("#{userDao}")
    private UserDao userDao;

    @ManagedProperty("#{userSession}")
    private UserSession userSession;
    private User currentUser;

    private int userId;
    private String userName;
    private String password;
    private Role role;
    private boolean changePassword;
    private User user;

    /**
     * Fügt ein neues User-Objekt zur Datenbank hinzu. Existiert das
     * Objekt bereits, wird dieses durch das neue ersetzt.
     */
    public void saveUser() {
        User newUser = new User(userName, password, role);

        if(user.equals(userSession.getUser())) {
            newUser.setUserId(userId);
            newUser.setChangePassword(changePassword);
            userDao.replaceUser(newUser);
            userSession.setUser(newUser);
        } else {
            if (user != null) {
                newUser.setUserId(userId);
                newUser.setChangePassword(changePassword);
                userDao.replaceUser(newUser);
            } else {
                userDao.addUser(newUser);
            }
        }
    }

    /**
     * Lädt das User-Objekt aus der UserSession und überschreibt seine Daten,
     * mit den mitgegebenen Eingaben.
     */
    public void changeProfile() {
        currentUser = userSession.getUser();
        if (currentUser != null ) {
            currentUser.setUsername(userName);
            currentUser.setPassword(password);
            userDao.replaceUser(currentUser);
            userSession.setUser(currentUser);
        }
    }

    /**
     * Weist einem User-Objekt einen zufälligen String aus der RandomUtil hinzu
     * und setzt seinen Boolean-Wert für die Passwortveränderung auf true.
     */
    public void createRandomPassword() {
        setPassword(RandomUtils.createStringWithRandomChars(8));
        setChangePassword(true);
    }

    public void print() {
        System.out.println(userId);
        System.out.println(userName);
        System.out.println(password);
        System.out.println(role);
        System.out.println(changePassword);
    }

    /**
     * Lädt ein mitgegebenes User-Objekt in die Klasse.
     * @param user Das User-Objekt, was geladen werden soll
     */
    public void loadUser(User user) {
        this.user = user;
        userId = user.getUserId();
        userName = user.getUsername();
        password = user.getPassword();
        role = user.getRole();
        changePassword = user.isChangePassword();
        print();
    }

    /**
     * Setzt alle relevanten User-Attribute zurück.
     */
    public void purge() {
        this.user = null;
        userId = 0;
        userName = null;
        password = null;
        role = null;
        changePassword = false;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isChangePassword() {
        return changePassword;
    }

    public void setChangePassword(boolean changePassword) {
        this.changePassword = changePassword;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
