package de.stl.saar.internetentw1.utils;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;

public class JsfUtils {
    /**
     * Ermittelt aus einer ManagedBean ein Attribut, das ein Dto-Objekt ist.
     * @param attributeName Der Name des Attributs.
     * @param beanName Der Name der ManagedBean.
     * @return Das Dto-Objekt.
     */
    public static Object getBeanAttribute(String attributeName, String beanName, Class objectClass) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application application = facesContext.getApplication();
        ExpressionFactory expressionFactory = application.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        String elExpression = "#{" + beanName + "." + attributeName + "}";
        return expressionFactory.createValueExpression(elContext, elExpression, objectClass).getValue(elContext);
    }
}
