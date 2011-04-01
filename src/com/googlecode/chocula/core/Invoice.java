package com.googlecode.chocula.core;
import java.awt.List;
import java.util.ArrayList;
import java.util.Date;


public class Invoice implements Record {
	private Patient patient;
	private Date date;
	private Doctor doctorSeen;
	private List itemizedName;
	ArrayList<Integer> itemizedCost;


	
	public Invoice(Patient patient, Date date, Doctor doctorSeen, String itemizedName, Integer itemizedCost){
		this.patient = patient;
		this.doctorSeen = doctorSeen;
		this.date = date;
		this.itemizedName = new List();
		this.itemizedCost = new ArrayList<Integer>();
		this.itemizedName.add(itemizedName);
		this.itemizedCost.add(itemizedCost);
	}



	public String getPatientName() {
		return patient.getFirstname() + " " + patient.getLastname();
	}



	public void setPatient(Patient patient) {
		this.patient = patient;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public Doctor getDoctorSeen() {
		return doctorSeen;
	}



	public void setDoctorSeen(Doctor doctorSeen) {
		this.doctorSeen = doctorSeen;
	}



	public List getItemizedName() {
		return itemizedName;
	}



	public void setItemizedName(List itemizedName) {
		this.itemizedName = itemizedName;
	}



	public ArrayList<Integer> getItemizedCost() {
		return itemizedCost;
	}



	public void setItemizedCost(ArrayList<Integer> itemizedCost) {
		this.itemizedCost = itemizedCost;
	}
}
