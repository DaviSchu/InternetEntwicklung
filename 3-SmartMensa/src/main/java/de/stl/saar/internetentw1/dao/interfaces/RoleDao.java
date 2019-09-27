package de.stl.saar.internetentw1.dao.interfaces;

import java.util.List;

import de.stl.saar.internetentw1.model.Role;

public interface RoleDao {

	/**
	 * Fügt eine neue Rolle in die Datenbank ein.
	 * @param role Die Role, die hinzugefügt werden soll.
	 */
	void addRole(Role role);

	/**
	 * Entfernt eine Role aus der Datenbank.
	 * @param roleId Der Primärschlüsselwert der zu entfernenden Role
	 */
	void removeRole(int roleId);

	/**
	 * Gibt eine Liste mit allen Role-Objekten zurück.
	 * @return Die Liste mit allen Role-Objekten
	 */
	List<Role> findAllRoles();

	/**
	 * Gibt eine Liste mit allen Role-Objekten zurück,
	 * die bei der Erstellung neuer User verwendet werden sollen.
	 * @return Die Liste mit allen Role-Objekten
	 */
	List<Role> findCreatableRoles();

	/**
	 * Gibt eine Liste mit allen Role-Objekten zurück, deren
	 * Name dem mitgegebenem String entspricht.
	 * @param roleName Der zu vergleichende String
	 * @return Die Liste mit allen Role-Objekten
	 */
	Role findRoleByName(String roleName);

}
