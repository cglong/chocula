package com.googlecode.chocula.core;
import java.awt.List;
import java.util.ArrayList;


public class Invoice implements Record {
	private String patientName;
	private Integer date; 	//uses mmddyy format
	private String doctorSeen;
	private List itemizedName;
	ArrayList<Integer> itemizedCost;


	
	Invoice(String patientName, Integer date, String doctorSeen, String itemizedName, Integer itemizedCost){
		this.patientName = patientName;
		this.doctorSeen = doctorSeen;
		this.date = date;
		this.itemizedName = new List();
		this.itemizedCost = new ArrayList<Integer>();
		this.itemizedName.add(itemizedName);
		this.itemizedCost.add(itemizedCost);
	}



	public String getPatientName() {
		return patientName;
	}



	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}



	public Integer getDate() {
		return date;
	}



	public void setDate(Integer date) {
		this.date = date;
	}



	public String getDoctorSeen() {
		return doctorSeen;
	}



	public void setDoctorSeen(String doctorSeen) {
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
