package de.stl.saar.internetentw1.dao.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import de.stl.saar.internetentw1.dao.interfaces.RoleDao;
import de.stl.saar.internetentw1.dao.interfaces.UserDao;
import de.stl.saar.internetentw1.model.Role;
import de.stl.saar.internetentw1.model.User;
import de.stl.saar.internetentw1.utils.RandomUtils;

/**
 * Simuliert die User-Tabelle einer Datenbank mithilfe
 * einer Map, wobei der Primärschlüssel der Schlüssel der
 * Map ist. 
 * @author christopher
 *
 */
public class UserDaoImpl implements UserDao {

	private Map<Integer, User> userTable;
	private RoleDao roleDao;

	@PostConstruct
	public void initialize() {
		userTable = new HashMap<>();
		final Role superAdminRole = roleDao.findRoleByName("superadmin");
		final Role adminRole = roleDao.findRoleByName("admin");
		final Role userRole = roleDao.findRoleByName("user");
		final User user1 = new User("colbertz", "1234", "colbertz@htwsaar.de", superAdminRole);
		final User user2 = new User("asdf", "fdsa", "asdf@htwsaar.de", adminRole);
		final User user3 = new User("wpy", "qwertz", "wpy@htwsaar.de", userRole);
		final User user4 = new User( "api", "5678", "api@htwsaar.de", userRole);
		user3.setChangePassword(true);
		addUser(user1);
		addUser(user2);
		addUser(user3);
		addUser(user4);
	}

	/**
	 * Fügt einen neuen User in die Datenbank ein. Dabei wird der
	 * Primärschlüsselwert durch die Größe der Datenbank bestimmt.
	 * @param user Der User, der hinzugefügt werden soll.
	 */
	@Override
	public void addUser(final User user) {

		user.setUserId(userTable.size()+1);
		userTable.put(userTable.size()+1, user);
	}
	
	/**
	 * Erzeugt einen neuen Primärschlüsselwert. Dabei wird der Wert
	 * zufällig erzeugt und dann wird geprüft, ob es bereits einen
	 * Datensatz mit diesem Wert gibt. Falls nein, wird dieser
	 * Primärschlüsselwert zurückgegeben. 
	 * @return Der neu erzeugte und noch nicht vergebene Primärschlüsselwert.
 	 */
	private int createPrimaryKeyValue() {
		int primaryKey = 0;
		
		do {
			primaryKey = RandomUtils.nextInt();
		} while(!primaryKeyValueFree(primaryKey));
		
		return primaryKey;
	}
	
	/**
	 * Prüft, ob ein Primärschlüsselwert bereits vergeben ist. 
	 * @param primaryKeyValue Der zu prüfende Wert.
	 * @return True, falls der Wert bereits als Primärschlüsselwert in 
	 * der Tabelle vorkommt, sonst false. 
	 */
	private boolean primaryKeyValueFree(final int primaryKeyValue) {
		final User userWithPrimaryKey = userTable.get(primaryKeyValue);
		if (userWithPrimaryKey == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Entfernt einen User aus der Datenbank und passt alle folgenden
	 * Primärschlüsselwerte dynamisch an. Dabei wird zuerst der User,
	 * mit der mitgegebenen User-ID aus der Datenbank entfernt.
	 * @param userId Der Primärschlüsselwert des zu entfernenden Users
	 */
	@Override
	public void removeUser(final int userId) {
		User user;
		for (int i = userId; i < userTable.size(); i++) {
			user = userTable.get(i+1);
			user.setUserId(i);
			userTable.put(i,user);
		}
		userTable.remove(userTable.size());
	}

	/**
	 * Gibt eine Liste mit allen User-Objekten zurück.
	 * @return Die Liste mit allen User-Objekten
	 */
	@Override
	public List<User> findAllUsers() {
		final Collection<User> userCollection = userTable.values();
		final List<User> users = new ArrayList<>(userCollection);
		return users;
	}

	/**
	 * Setzt einen übergebenen User an die Stelle seiner Id.
	 * @param user Der User, der eingefügt werden soll
	 */
	@Override
	public void replaceUser(User user) {
		userTable.put(user.getUserId(), user);
	}

	@Override
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

}
