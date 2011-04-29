package com.googlecode.chocula.core;
import java.util.Date;

/**
 * This class represents an appointment
 * 
 * @author Ye Zhefan
 * @version 1.0
 */
public class Appointment implements Record {

	private Date desiredDateAndTime;

	private String reason;

	private Doctor doctor;

	private Patient patient;
	
	/**
	 * This constructor creates a new appointment with required fields
	 * 
	 * @param desiredDateAndTime The date of the new appointment
	 * @param doctor The doctor the patient will see
	 * @param reason The main reason for the appointment
	 * @param patient The patient
	 */
	public Appointment(Date desiredDateAndTime, Doctor doctor,
			String reason, Patient patient) {
		this.desiredDateAndTime = desiredDateAndTime;
		this.reason = reason;
		this.doctor = doctor;
		this.patient = patient;
	}
	
	/**
	 * Getter for the date of the appointment
	 * 
	 * @return The date of the appointment
	 */
	public Date getDesiredDateAndTime() {
		return desiredDateAndTime;
	}
	
	/**
	 * Setter for the date of the appointment
	 * 
	 * @param desiredDateAndTime The new date
	 */
	public void setDesiredDateAndTime(Date desiredDateAndTime) {
		this.desiredDateAndTime = desiredDateAndTime;
	}
	
	/**
	 * Getter for the reason for the appointment
	 * 
	 * @return The reason for the appointment
	 */
	public String getReason() {
		return reason;
	}
	
	/**
	 * Setter for the reason for the appointment
	 * 
	 * @param reason The new reason
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	/**
	 * Getter for the doctor for the appointment
	 * 
	 * @return The doctor for the appointment
	 */
	public Doctor getDoctor() {
		return doctor;
	}
	
	/**
	 * Setter for the doctor for the appointment
	 * 
	 * @param doctor The new doctor
	 */
	public void setDesiredDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	/**
	 * Setter for the patient for the appointment
	 * 
	 * @param patient The new patient
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	/**
	 * Getter for the patient for the appointment
	 * 
	 * @return The patient for the appointment
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * Determines if two appointments are equal
	 * 
	 * @param o The appointment to compare to
	 * @boolean true if the two are equal; false otherwise
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
	
	@Override
	public String toString() {
		return desiredDateAndTime.toString() + ": " + patient.getName() + " (" + reason + "): " + doctor.getUsername();
	}
}
