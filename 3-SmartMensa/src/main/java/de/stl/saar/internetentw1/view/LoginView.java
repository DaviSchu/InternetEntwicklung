package de.stl.saar.internetentw1.view;

import de.stl.saar.internetentw1.dao.interfaces.UserDao;
import de.stl.saar.internetentw1.model.Role;
import de.stl.saar.internetentw1.model.User;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class LoginView {

    private List<User> userList;
    private UserDao userDao;

    private String userName;
    private String password;
    private User currentUser;

    @PostConstruct
    public void initialize() {}

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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String login() {

        userList = userDao.findAllUsers();

        for(User u: userList) {
            if(u.getUsername().matches(userName)) {
                if(u.getPassword().matches(password)) {
                    currentUser = u;
                    return "overview";
                }
            }
        }
        return "noSuchUser";
    }

    public void addUser(String name, String password) {
        userDao.addUser(new User(5,name,password,new Role(1,"admin")));
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
