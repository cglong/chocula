package com.googlecode.chocula.client;

import com.googlecode.chocula.core.User;

/**
 * This class is responsible for user login and maintenance of the current user.
 * 
 * @author Christopher Long/Elise Prado
 */
public class Login {
	private static Login instance = null;
	private User user = null;
	
	/**
	 *When this hits 3, the person is locked out and the counter reset.
	 */
	private int lockout = 0;
	
	protected Login() {
	}
	
	public static Login getInstance() {
		if (instance == null)
			instance = new Login();
		return instance;
	}
	
	/**
	 * This method will do a check to see if the username/password combo
	 * appears in the database of username/password combos, and will return
	 * the username of the one that fits.
	 */
	public void login(String username, String password) {
		user = Storage.getInstance().readUser(username, password);
		if (user == null)
			lockout++;
	}
	
	public boolean isLoggedIn() {
		return user != null;
	}
	
	public boolean canTry() {
		return lockout < 3;
	}

	public void logout() {
		user = null;
		lockout = 0;
	}
}
