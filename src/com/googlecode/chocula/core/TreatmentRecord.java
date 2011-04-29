package com.googlecode.chocula.core;

import java.util.Date;

/**
 * This class represents a treatment record
 * 
 * @author Ye Zhefan
 * @version 1.0
 */
public class TreatmentRecord implements Record {

	private Patient patient;
	private Doctor treatingDoctor;

	private String dateAndTime;

	private Nurse attendingNurse;

	private DoctorsOrders doctorsOrders;

	private String chiefComplaint;

	private String vitalSigns;

	private String diagnosis;

	/**
	 * This constructor creates a new treatment record with required fields
	 * 
	 * @param treatingDoctor
	 *            The doctor in charge of the visit
	 * @param dateAndTime
	 *            The date the record was created
	 * @param attendingNurse
	 *            The nurse who aided the doctor
	 * @param doctorsOrders
	 *            The plan created by the doctor
	 * @param chiefComplaint
	 *            The patient's main complaint
	 * @param vitalSigns
	 *            The vital signs of the patient
	 * @param diagnosis
	 *            The final diagnosis
	 * @param patient
	 *            The patient
	 */
	public TreatmentRecord(Doctor treatingDoctor, String dateAndTime,
			Nurse attendingNurse, DoctorsOrders doctorsOrders,
			String chiefComplaint, String vitalSigns, String diagnosis,
			Patient patient) {
		this.treatingDoctor = treatingDoctor;
		this.dateAndTime = dateAndTime;
		this.attendingNurse = attendingNurse;
		this.doctorsOrders = doctorsOrders;
		this.chiefComplaint = chiefComplaint;
		this.vitalSigns = vitalSigns;
		this.diagnosis = diagnosis;
		this.patient = patient;
	}

	/**
	 * Getter for the treating doctor
	 * 
	 * @return The doctor of the record
	 */
	public Doctor getTreatingDoctor() {
		return treatingDoctor;
	}

	/**
	 * Setter for the treating doctor
	 * 
	 * @param treatingDoctor
	 *            The new treating doctor
	 */
	public void setTreatingDoctor(Doctor treatingDoctor) {
		this.treatingDoctor = treatingDoctor;
	}

	/**
	 * Getter for the date
	 * 
	 * @return The date of the record
	 */
	public String getDateAndTime() {
		return dateAndTime;
	}

	/**
	 * Setter for the date
	 * 
	 * @param dateAndTime
	 *            The new date
	 */
	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	/**
	 * Getter for the nurse
	 * 
	 * @return The nurse of the record
	 */
	public Nurse getAttendingNurse() {
		return attendingNurse;
	}

	/**
	 * Setter for the attending nurse
	 * 
	 * @param attending
	 *            Nurse The new attending nurse
	 */
	public void setAttendingNurse(Nurse attendingNurse) {
		this.attendingNurse = attendingNurse;
	}

	/**
	 * Getter for the doctor's order
	 * 
	 * @return The doctor's order of the record
	 */
	public DoctorsOrders getDoctorsOrders() {
		return doctorsOrders;
	}

	/**
	 * Setter for the doctor's order
	 * 
	 * @param doctorsOrders
	 *            The new doctor's order
	 */
	public void setDoctorsOrders(DoctorsOrders doctorsOrders) {
		this.doctorsOrders = doctorsOrders;
	}

	/**
	 * Getter for the chief complaint
	 * 
	 * @return The chief complaint of the record
	 */
	public String getChiefComplaint() {
		return chiefComplaint;
	}

	/**
	 * Setter for the chief complaint
	 * 
	 * @param chiefComplaint
	 *            The new chief complaint
	 */
	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}

	/**
	 * Getter for the vital signs
	 * 
	 * @return The vital signs of the record
	 */
	public String getVitalSigns() {
		return vitalSigns;
	}

	/**
	 * Setter for the vital signs
	 * 
	 * @param vitalSigns
	 *            The new vital signs
	 */
	public void setVitalSigns(String vitalSigns) {
		this.vitalSigns = vitalSigns;
	}

	/**
	 * Getter for the diagnosis
	 * 
	 * @return The diagnosis of the record
	 */
	public String getDiagnosis() {
		return diagnosis;
	}

	/**
	 * Setter for the diagnosis
	 * 
	 * @param diagnosis
	 *            The new diagnosis
	 */
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	/**
	 * Setter for the patient
	 * 
	 * @param patient
	 *            The new patient
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * Getter for the patient
	 * 
	 * @return The patient of the record
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * Override equals method
	 * 
	 * @param o
	 *            The treatment record to compare to
	 * @return true if the two are equal; false otherwise
	 */
	public boolean equals(Object o) {
		TreatmentRecord tr = (TreatmentRecord) o;
		if (tr.getAttendingNurse().equals(this.getAttendingNurse())
				&& tr.getChiefComplaint().equals(this.getChiefComplaint())
				&& tr.getDateAndTime().equals(this.getDateAndTime())
				&& tr.getDiagnosis().equals(this.getDiagnosis())
				&& tr.getDoctorsOrders().equals(this.getDoctorsOrders())
				&& tr.getTreatingDoctor().equals(this.getTreatingDoctor())
				&& tr.getVitalSigns().equals(this.getVitalSigns())
				&& tr.getPatient().equals(this.getPatient())) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		return dateAndTime;
	}
}
