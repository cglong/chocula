package com.googlecode.chocula.core;
import java.util.Date;

/**
 * Appointment
 * 
 * @author Ye Zhefan
 * 
 */
public class Appointment implements Record {

	private Date desiredDateAndTime;

	/**
	 * Class??
	 */
	private String reason;

	private Doctor doctor;

	private Patient patient;

	public Appointment(Date desiredDateAndTime, Doctor doctor,
			String reason, Patient patient) {
		this.desiredDateAndTime = desiredDateAndTime;
		this.reason = reason;
		this.doctor = doctor;
		this.patient = patient;
	}

	public Date getDesiredDateAndTime() {
		return desiredDateAndTime;
	}

	public void setDesiredDateAndTime(Date desiredDateAndTime) {
		this.desiredDateAndTime = desiredDateAndTime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDesiredDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Patient getPatient() {
		return patient;
	}

	/**
	 * Override equals method
	 */
	public boolean equals(Object o) {
		Appointment apt = (Appointment) o;
		if (apt.getDesiredDateAndTime().equals(this.getDesiredDateAndTime())
				&& apt.getDoctor().equals(this.getDoctor())
				&& apt.getReason().equals(this.getReason())
				&& apt.getPatient().equals(this.getPatient())) {
			return true;
		} else {
			return false;
		}
	}

}
