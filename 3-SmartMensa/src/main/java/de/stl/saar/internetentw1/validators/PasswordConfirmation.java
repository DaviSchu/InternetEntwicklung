package de.stl.saar.internetentw1.validators;

import de.stl.saar.internetentw1.utils.I18nUtil;

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
        Object pw = uiComponent.getValueExpression("password").getValue(facesContext.getELContext());
        String password = (String) pw;


        System.out.println(password);

        if (!passwordConfirmation.equals(password)) {
            String message = I18nUtil.getInvalidPasswordConfirmation();
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,message,message));
        }
    }
}
