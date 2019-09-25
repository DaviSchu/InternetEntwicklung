package de.stl.saar.internetentw1.view;

import de.stl.saar.internetentw1.dao.interfaces.UserDao;
import de.stl.saar.internetentw1.model.Role;
import de.stl.saar.internetentw1.model.User;
import de.stl.saar.internetentw1.session.UserSession;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;


@ManagedBean
@SessionScoped
public class UserAdministrationView {

    @ManagedProperty("#{userDao}")
    private UserDao userDao;

    @ManagedProperty("#{userSession}")
    private UserSession userSession;



    private int userId;
    private String userName;
    private String password;
    private Role role;
    private boolean changePassword;
    private User user;

    public void saveUser() {
        User newUser = new User(userName, password, role);
        if (user != null) {
            newUser.setUserId(userId);
            userDao.replaceUser(newUser);
        } else {
            userDao.addUser(newUser);
        }
    }

    public void changeProfile() {
        User currentUser = userSession.getUser();
        if (currentUser != null) {
            currentUser.setUsername(userName);
            currentUser.setPassword(password);
            userSession.setUser(currentUser);
            userDao.replaceUser(currentUser);
        }
    }

    public void print() {
        System.out.println(userId);
        System.out.println(userName);
        System.out.println(password);
        System.out.println(role);
        System.out.println(changePassword);
    }

    public void loadUser(User user) {
        this.user = user;
        userId = user.getUserId();
        userName = user.getUsername();
        password = user.getPassword();
        role = user.getRole();
        changePassword = user.isChangePassword();
    }

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
