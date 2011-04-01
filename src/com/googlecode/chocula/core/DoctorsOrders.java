package com.googlecode.chocula.core;

/**
 * This class represents a doctor's order
 * 
 * @author Priya Kurani
 * @version 1.0
 */
public class DoctorsOrders implements Record {
	private String prescriptions;
	private String labWork;
	private String followUpInstr;
	private String otherInstr;
	
	/**
	 * This constructor creates a new doctor's order with required fields
	 * 
	 * @param prescriptions The prescriptions prescribed
	 * @param labWork Any lab work performed
	 * @param followUpInstr Any follow-up instructions for the patient
	 * @param otherInstr Any other instructions for the patient
	 */
	public DoctorsOrders(String prescriptions, String labWork, String followUpInstr, String otherInstr){
		this.prescriptions = prescriptions;
		this.labWork = labWork;
		this.followUpInstr = followUpInstr;
		this.otherInstr = otherInstr;
	}
	
	/**
	 * Getter for the prescriptions of the doctor's order
	 * 
	 * @return The prescriptions of the doctor's order
	 */
	public String getPrescriptions() {
		return prescriptions;
	}
	
	/**
	 * Setter for the prescription of the doctor's order
	 * 
	 * @param prescriptions The new prescriptions
	 */
	public void setPrescriptions(String prescriptions) {
		this.prescriptions = prescriptions;
	}
	
	/**
	 * Getter for the lab work of the doctor's order
	 * 
	 * @return The lab work of the doctor's order
	 */
	public String getLabWork() {
		return labWork;
	}
	
	/**
	 * Setter for the lab work of the doctor's order
	 * 
	 * @param labWork The new lab work
	 */
	public void setLabWork(String labWork) {
		this.labWork = labWork;
	}
	
	/**
	 * Getter for the follow-up instructions of the doctor's order
	 * 
	 * @return The follow-up instructions of the doctor's order
	 */
	public String getFollowUpInstr() {
		return followUpInstr;
	}
	
	/**
	 * Setter for the follow-up instructions of the doctor's order
	 * 
	 * @param followUpInstr The new follow-up instructions
	 */
	public void setFollowUpInstr(String followUpInstr) {
		this.followUpInstr = followUpInstr;
	}
	
	/**
	 * Getter for the other instructions of the doctor's order
	 * 
	 * @return The other instructions of the doctor's order
	 */
	public String getOtherInstr() {
		return otherInstr;
	}
	
	/**
	 * Setter for the other instructions of the doctor's order
	 * 
	 * @param prescriptions The new other instructions
	 */
	public void setOtherInstr(String otherInstr) {
		this.otherInstr = otherInstr;
	}
	
}