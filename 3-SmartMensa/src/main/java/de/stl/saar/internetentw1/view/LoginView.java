package de.stl.saar.internetentw1.view;

import de.stl.saar.internetentw1.dao.interfaces.UserDao;
import de.stl.saar.internetentw1.model.Role;
import de.stl.saar.internetentw1.model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class LoginView {

    @ManagedProperty("#{userDao}")
    private UserDao userDao;

    private List<User> userList;

    private String userName;
    private String password;
    private User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

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

    public String login() {

        userList = userDao.findAllUsers();


        for(User u: userList) {
            if(u.getUsername().matches(userName)) {
                if (u.getPassword().matches(password)) {
                    currentUser = u;
                    this.userName="";
                    return "overview";
                }
            }
        }
        return "";
    }

    public void logOut(){
        this.currentUser=null;
        this.userName="";
    }

}
