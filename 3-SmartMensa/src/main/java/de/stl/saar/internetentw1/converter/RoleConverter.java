package de.stl.saar.internetentw1.converter;

import de.stl.saar.internetentw1.dao.classes.RoleDaoImpl;
import de.stl.saar.internetentw1.dao.interfaces.RoleDao;
import de.stl.saar.internetentw1.model.Role;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Role.class)
public class RoleConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context,
                              UIComponent component,
                              String value) {
        final RoleDao roleDao = new RoleDaoImpl();
        final Role role = roleDao.findRoleByName(value);
        return role;
    }

    @Override
    public String getAsString(FacesContext context,
                              UIComponent component,
                              Object value) {
        final Role role = (Role)value;
        return role.getRoleName();

    }
}
