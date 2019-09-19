package de.stl.saar.internetentw1.view;

import de.stl.saar.internetentw1.dao.interfaces.UserDao;
import de.stl.saar.internetentw1.model.Role;
import de.stl.saar.internetentw1.model.User;
import de.stl.saar.internetentw1.session.CurrentUser;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class LoginView {

    @ManagedProperty("#{userDao}")
    private UserDao userDao;

    @ManagedProperty("#{currentUser}")
    private CurrentUser currentUser;

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

    public CurrentUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    public String login() {

        List<User> userList = userDao.findAllUsers();


        for(User u: userList) {
            if(u.getUsername().matches(userName)) {
                if (u.getPassword().matches(password)) {
                    currentUser.setUser(u);
                    userName="";
                    password="";
                    return "overview";
                }
            }
        }
        return "wrongLogin";
    }

    public void logOut(){
        currentUser.setUser(null);
    }

}
