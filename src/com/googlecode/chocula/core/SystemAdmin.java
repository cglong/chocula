package com.googlecode.chocula.core;

/**
 * This class represents a system administrator.
 * 
 * @author Christopher Long
 * @version 1.0
 */
public class SystemAdmin extends Nurse implements IPatient, IDoctor {
	/**
	 * This constructor creates a system admin with required fields
	 * 
	 * @param username The username of the sysadmin
	 * @param password The password of the sysadmin
	 */
	public SystemAdmin(String username, String password) {
		super(username, password);
	}
}
