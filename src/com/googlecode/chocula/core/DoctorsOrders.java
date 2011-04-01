package com.googlecode.chocula.core;

public class DoctorsOrders implements Record {
	private String prescriptions;
	private String labWork;
	private String followUpInstr;
	private String otherInstr;
	
	public DoctorsOrders(String prescriptions, String labWork, String followUpInstr, String otherInstr){
		this.prescriptions = prescriptions;
		this.labWork = labWork;
		this.followUpInstr = followUpInstr;
		this.otherInstr = otherInstr;
	}
	
	public String getPrescriptions() {
		return prescriptions;
	}
	public void setPrescriptions(String prescriptions) {
		this.prescriptions = prescriptions;
	}
	public String getLabWork() {
		return labWork;
	}
	public void setLabWork(String labWork) {
		this.labWork = labWork;
	}
	public String getFollowUpInstr() {
		return followUpInstr;
	}
	public void setFollowUpInstr(String followUpInstr) {
		this.followUpInstr = followUpInstr;
	}
	public String getOtherInstr() {
		return otherInstr;
	}
	public void setOtherInstr(String otherInstr) {
		this.otherInstr = otherInstr;
	}
	
}