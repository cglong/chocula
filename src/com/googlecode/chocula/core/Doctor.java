package com.googlecode.chocula.core;
/**
 * This class represents a doctor
 * 
 * @author Ye Zhefan
 * @version 1.0
 */
public class Doctor extends Nurse implements IDoctor {
	/**
	 * This constructor creates a new doctor
	 * 
	 * @param username The username of the doctor
	 * @param password The password of the doctor
	 */
	public Doctor(String username, String password) {
		super(username, password);
	}
}
