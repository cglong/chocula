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
	 * When this hits 3, the person is locked out and the counter reset.
	 */
	private int lockout = 0;

	/**
	 * This constructor exists only to prevent instantiation.
	 */
	protected Login() {
	}

	/**
	 * Singleton method
	 * 
	 * @return The singleton instance of Login
	 */
	public static Login getInstance() {
		if (instance == null)
			instance = new Login();
		return instance;
	}

	/**
	 * This method will do a check to see if the username/password combo appears
	 * in the database of username/password combos, and will return the username
	 * of the one that fits.
	 * 
	 * @param username
	 *            The username to check for
	 * @param password
	 *            The password to check for
	 */
	public void login(String username, String password) {
		user = Storage.getInstance().readUser(username, password);
		if (user == null && canTry())
			lockout++;
	}

	/**
	 * Checks if a user is currently logged in
	 * 
	 * @return True if the user is logged in; false otherwise
	 */
	public boolean isLoggedIn() {
		return user != null;
	}

	/**
	 * Checks if a user has not hit lockout
	 * 
	 * @return True if the user has not hit lockout; false otherwise
	 */
	public boolean canTry() {
		return lockout < 3;
	}

	/**
	 * Logs the current user out by clearing information about them
	 */
	public void logout() {
		user = null;
		lockout = 0;
	}

	public User getUser() {
		return user;
	}
}
