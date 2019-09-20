package de.stl.saar.internetentw1.validators;

import de.stl.saar.internetentw1.dao.interfaces.UserDao;
import de.stl.saar.internetentw1.model.User;
import de.stl.saar.internetentw1.utils.I18nUtil;
import de.stl.saar.internetentw1.utils.JsfUtils;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.List;

@FacesValidator("passwordConfirmation")
public class UserConfirmation implements Validator {


    private UserDao userDao;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String userConfirmation = (String) o;

        List<User> userList = userDao.findAllUsers();

        for(User u: userList) {
            if(!u.getUsername().matches(userConfirmation)) {
                String message = I18nUtil.getInvalidUserConfirmation();
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,message,message));
            }
        }


    }
}
