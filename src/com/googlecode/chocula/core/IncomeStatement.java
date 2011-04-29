package com.googlecode.chocula.core;

/**
 * IncomeStatement class
 * 
 * @author Ye Zhefan
 * 
 */
public class IncomeStatement implements Record {
	private String month;
	private int patientNumber;
	private double expenditure;
	private double aggregateIncome;

	/**
	 * contructor
	 * 
	 * @param month
	 * @param patientNumber
	 * @param expenditure
	 * @param aggreagateincome
	 * @param netIncome
	 */
	public IncomeStatement(String month, int patientNumber, double expenditure,
			double aggreagateincome) {
		this.patientNumber = patientNumber;
		this.month = month;
		this.expenditure = expenditure;
		this.aggregateIncome = aggreagateincome;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getMonth() {
		return month;
	}

	public void setPatientNumber(int patientNumber) {
		this.patientNumber = patientNumber;
	}

	public int getPatientNumber() {
		return patientNumber;
	}

	public void setExpenditure(double expenditure) {
		this.expenditure = expenditure;
	}

	public double getExpenditure() {
		return expenditure;
	}

	public void setAggregateincome(double aggregateincome) {
		this.aggregateIncome = aggregateincome;
	}

	public double getAggregateincome() {
		return aggregateIncome;
	}

	public double getNetIncome() {
		return aggregateIncome - expenditure;
	}
}
