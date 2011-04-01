package com.googlecode.chocula.core;
import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class represents an invoice created following an appointment
 * 
 * @author Priya Kurani
 * @version 1.0
 */
public class Invoice implements Record {
	private Patient patient;
	private Date date;
	private Doctor doctorSeen;
	private List itemizedName;
	ArrayList<Integer> itemizedCost;
	
	/**
	 * This constructor creates a new invoice with required fields
	 * 
	 * @param patient The patient seen
	 * @param date The date of the appointment
	 * @param doctorSeen The doctor seen
	 * @param itemizedName The first item on the invoice
	 * @param itemizedCost The cost of the first item in the invoice
	 */
	public Invoice(Patient patient, Date date, Doctor doctorSeen, String itemizedName, Integer itemizedCost){
		this.patient = patient;
		this.doctorSeen = doctorSeen;
		this.date = date;
		this.itemizedName = new List();
		this.itemizedCost = new ArrayList<Integer>();
		this.itemizedName.add(itemizedName);
		this.itemizedCost.add(itemizedCost);
	}
	
	/**
	 * Getter for the patient's name on the invoice
	 * 
	 * @return The name of the patient
	 */
	public String getPatientName() {
		return patient.getFirstname() + " " + patient.getLastname();
	}
	
	/**
	 * Setter for the patient of the invoice
	 * 
	 * @param patient The new patient
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	/**
	 * Getter for the date of the invoice
	 * 
	 * @return The date of the invoice
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * Setter for the date of the invoice
	 * 
	 * @param date The new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * Getter for the date of the invoice
	 * 
	 * @return The date of the invoice
	 */
	public Doctor getDoctorSeen() {
		return doctorSeen;
	}
	
	/**
	 * Setter for the doctor seen on the invoice
	 * 
	 * @param doctorSeen The new doctor
	 */
	public void setDoctorSeen(Doctor doctorSeen) {
		this.doctorSeen = doctorSeen;
	}
	
	/**
	 * Getter for the itemized names of items on the invoice
	 * 
	 * @return The itemized names of items on the invoice
	 */
	public List getItemizedName() {
		return itemizedName;
	}
	
	/**
	 * Setter for the itemized list names on the invoice
	 * 
	 * @param patient The new list
	 */
	public void setItemizedName(List itemizedName) {
		this.itemizedName = itemizedName;
	}
	
	/**
	 * Getter for the costs of items on the invoice
	 * 
	 * @return The costs of items on the invoice
	 */
	public ArrayList<Integer> getItemizedCost() {
		return itemizedCost;
	}
	
	/**
	 * Setter for the costs of items on the invoice
	 * 
	 * @param patient The new list
	 */
	public void setItemizedCost(ArrayList<Integer> itemizedCost) {
		this.itemizedCost = itemizedCost;
	}
}
