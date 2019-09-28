package de.stl.saar.internetentw1.model;

/**
 * Eine Klasse zur Verwaltung von Benutzern. Benutzer bestehen hierbei aus
 * einer ID, die in der Datenbank ermittelt wird, einem Namen, einem Passwort,
 * einer Email-Adresse, einer Rolle und einem Boolean-Wert, der bestimmt,
 * ob der Benutzer sein Passwort ändern muss.
 */
public class User {
	private int userId;
	private String username;
	private String password;
	private String email;
	private Role role;
	private boolean changePassword;

	public User(String username, String password, String email, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
