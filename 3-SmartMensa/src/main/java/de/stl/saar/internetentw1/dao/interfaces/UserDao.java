package de.stl.saar.internetentw1.dao.interfaces;

import java.util.List;

import de.stl.saar.internetentw1.model.User;

public interface UserDao {

	/**
	 * Fügt einen neuen User in die Datenbank ein. Dabei wird der
	 * Primärschlüsselwert durch die Größe der Datenbank bestimmt.
	 * @param user Der User, der hinzugefügt werden soll.
	 */
	void addUser(User user);

	/**
	 * Entfernt einen User aus der Datenbank und passt alle folgenden
	 * Primärschlüsselwerte dynamisch an. Dabei wird zuerst der User,
	 * mit der mitgegebenen User-ID aus der Datenbank entfernt.
	 * @param userId Der Primärschlüsselwert des zu entfernenden Users
	 */
	void removeUser(int userId);

	/**
	 * Gibt eine Liste mit allen User-Objekten zurück.
	 * @return Die Liste mit allen User-Objekten
	 */
	List<User> findAllUsers();

	void setRoleDao(RoleDao roleDao);

	/**
	 * Setzt einen übergebenen User an die Stelle seiner Id.
	 * @param user Der User, der eingefügt werden soll
	 */
	void replaceUser(User user);

}
