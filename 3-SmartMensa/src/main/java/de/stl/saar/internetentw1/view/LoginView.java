package de.stl.saar.internetentw1.view;

import de.stl.saar.internetentw1.dao.classes.UserDaoImpl;
import de.stl.saar.internetentw1.model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class LoginView {

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

    public String login() {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.initialize();

        List<User> users = userDao.findAllUsers();

        for(User u: users) {
            if(u.getUsername().matches(userName)) {
                if(u.getPassword().matches(password)) {
                    return "toOverview";
                }
            }
        }
        return "noSuchUser";
    }

}
