package de.stl.saar.internetentw1.view;

import de.stl.saar.internetentw1.dao.interfaces.UserDao;
import de.stl.saar.internetentw1.model.Role;
import de.stl.saar.internetentw1.model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class RegisterView {

    @ManagedProperty("#{userDao}")
    private UserDao userDao;

    private String userName;
    private String password;
    private String email;
    private String confirmPassword;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * Fügt einen neuen Benutzer zur User-Datenbank hinzu. Hierfür müssen beide
     * Passwörter übereinstimmen und die E-Mail-Adresse mit "htwsaar.de" enden.
     */
    public void register() {

        Role role = new Role(2,"user");
        User newUser = new User(userName, password, email, role);
        userDao.addUser(newUser);
        userName="";
        email="";
    }

}
