package com.googlecode.chocula.core;

/**
 * This abstract class represents a general user in the system.
 * 
 * @author Christopher Long
 * @version 1.0
 */
public abstract class User {
	private String username, password;
	private boolean suspended;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		suspended = false;
	}
	
	/**
	 * This constructor creates an empty user.
	 */
	public User() {
		this(null, null);
	}

	/**
	 * This getter returns the user's username.
	 * 
	 * @return The username of the user.
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * This setter sets the username of the user
	 * 
	 * @param username The new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * This setter returns the user's password.
	 * 
	 * @return The password of the user.
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * This setter sets the password of the user
	 * 
	 * @param password The new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * This setter returns the user's suspended status.
	 * 
	 * @return The suspended status of the user.
	 */
	public boolean getSuspended() {
		return suspended;
	}
	
	/**
	 * This setter sets the suspended status of the user
	 * 
	 * @param suspended The new suspended status
	 */
	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}
}
