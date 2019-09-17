package de.stl.saar.internetentw1.view;

import de.stl.saar.internetentw1.dao.classes.UserDaoImpl;
import de.stl.saar.internetentw1.dao.interfaces.UserDao;
import de.stl.saar.internetentw1.model.Role;
import de.stl.saar.internetentw1.model.User;
import de.stl.saar.internetentw1.spring.configuration.DaoConfiguration;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
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
    public void intialize() {
        userList = userDao.findAllUsers();
    }

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
        /*
        User abdul = new User(1,"Abdul","vollkornkeks",new Role(1,"user"));
        User david = new User(2,"David","davetherave",new Role(1,"user"));

        User[] users = {abdul,david};
        */

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
