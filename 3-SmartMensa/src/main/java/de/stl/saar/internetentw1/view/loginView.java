package de.stl.saar.internetentw1.view;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class loginView {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String carryOn() {
        return "toLogin";
    }
}
