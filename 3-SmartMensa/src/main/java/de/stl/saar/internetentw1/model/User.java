package de.stl.saar.internetentw1.model;

/**
 * Eine Klasse zur Verwaltung von Benutzern. Benutzer bestehen hierbei aus
 * einer ID, die in der Datenbank ermittelt wird, einem Namen, einem Passwort,
 * einer Rolle und einem Boolean-Wert, der bestimmt, ob der Benutzer sein
 * Passwort ändern muss.
 */
public class User {
	private int userId;
	private String username;
	private String password;
	private Role role;
	private boolean changePassword;

	public User(String username, String password, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.changePassword = false;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isChangePassword() {
		return changePassword;
	}

	public void setChangePassword(boolean changePassword) {
		this.changePassword = changePassword;
	}
}
