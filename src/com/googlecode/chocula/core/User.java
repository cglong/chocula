package com.googlecode.chocula.core;

import java.util.Collection;
import java.util.Date;

import com.googlecode.chocula.client.Storage;

/**
 * This abstract class represents a general user in the system.
 * 
 * @author Christopher Long
 * @version 1.0
 */
public abstract class User {
	private String username, password;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

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
	 * This setter returns the user's password.
	 * 
	 * @return The password of the user.
	 */
	public String getPassword() {
		return password;
	}

	public Appointment createAppointment(Date date, Doctor doctor,
			String reason, Patient patient) {
		return Storage.getInstance().createAppointment(date, doctor, reason, patient);
	}

	public Collection<Appointment> readAppointment(Date date, Doctor doctor,
			String reason, Patient patient) {
		return Storage.getInstance().readAppointment(date, doctor, reason, patient);
	}

	public void updateAppointment(Appointment old, Date date, Doctor doctor, String reason,
			Patient patient) {
		Storage.getInstance().updateAppointment(old, date, doctor, reason, patient);
	}

	public void deleteAppointment(Date date, Doctor doctor, String reason,
			Patient patient) {
		Storage.getInstance().deleteAppointment(date, doctor, reason, patient);
	}

}
