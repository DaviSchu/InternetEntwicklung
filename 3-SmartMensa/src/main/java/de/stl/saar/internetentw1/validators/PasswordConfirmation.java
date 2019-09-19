package de.stl.saar.internetentw1.validators;

import de.stl.saar.internetentw1.utils.I18nUtil;
import de.stl.saar.internetentw1.utils.JsfUtils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("passwordConfirmation")
public class PasswordConfirmation implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String passwordConfirmation = (String) o;
        String password = (String) JsfUtils.getBeanAttribute(
                "password","registerView",String.class);

        if (!passwordConfirmation.matches(password)) {
            String message = I18nUtil.getInvalidPasswordConfirmation();
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,message,message));
        }
    }
}
