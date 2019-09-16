package de.stl.saar.internetentw1.view;

import de.stl.saar.internetentw1.model.Role;
import de.stl.saar.internetentw1.model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LoginView {

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

    public String login() {

        User abdul = new User(1,"Abdul","vollkornkeks",new Role(1,"user"));
        User david = new User(2,"David","davetherave",new Role(1,"user"));

        User[] users = {abdul,david};

        for(User u: users) {
            if(u.getUsername().matches(userName)) {
                if(u.getPassword().matches(password)) {
                    currentUser = u;
                    return "toOverview";
                }
            }
        }
        return "noSuchUser";
    }

}
