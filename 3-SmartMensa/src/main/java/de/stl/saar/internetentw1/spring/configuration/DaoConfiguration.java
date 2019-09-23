package de.stl.saar.internetentw1.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.stl.saar.internetentw1.dao.classes.DishDaoImpl;
import de.stl.saar.internetentw1.dao.classes.RoleDaoImpl;
import de.stl.saar.internetentw1.dao.classes.UserDaoImpl;
import de.stl.saar.internetentw1.dao.interfaces.DishDao;
import de.stl.saar.internetentw1.dao.interfaces.RoleDao;
import de.stl.saar.internetentw1.dao.interfaces.UserDao;

@Configuration
public class DaoConfiguration {

	private UserDao userDao = new UserDaoImpl();
	private DishDao dishDao = new DishDaoImpl();
	private RoleDao roleDao = new RoleDaoImpl();

	@Bean(name = "dishDao")
	public DishDao createDishDao() {
		return dishDao;
	}
	
	@Bean(name = "userDao")
	public UserDao createUserDao() {
		userDao.setRoleDao(createRoleDao());
		return userDao;
	}
	
	@Bean(name = "roleDao")
	public RoleDao createRoleDao() {
		return roleDao;
	}
}
