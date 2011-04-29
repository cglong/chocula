package com.googlecode.chocula.core;

/**
 * This class represents a patient.
 * 
 * @author Christopher Long
 * @version 1.0
 */
public class Patient extends User implements IPatient {
	private String firstname, lastname, address, phoneNumber, gender, pharmacy,
			insuranceCarrier, date;
	private int age;
	private String[] allergies;
	private TreatmentRecord[] medicalHistory;

	/**
	 * This constructor creates a new patient with required patient information
	 * 
	 * @param username
	 *            The username of the patient
	 * @param password
	 *            The password of the patient
	 * @param firstname
	 *            The first name of the patient
	 * @param lastname
	 *            The last name of the patient
	 * @param address
	 *            The address of the patient
	 * @param phoneNumber
	 *            The phone number of the patient
	 * @param gender
	 *            The gender of the patient
	 * @param pharmacy
	 *            The pharmacy of the patient
	 * @param insuranceCarrier
	 *            The insurance carrier of the patient
	 * @param age
	 *            The age of the patient
	 * @param allergies
	 *            Any allergies of the patient
	 * @param medicalHistory
	 *            Any previous medical history of the patient
	 */
	public Patient(String username, String password, String firstname,
			String lastname, String address, String phoneNumber, String gender,
			String pharmacy, String insuranceCarrier, String date, int age,
			String[] allergies, TreatmentRecord[] medicalHistory) {
		super(username, password);
		this.setLastname(lastname);
		this.setFirstname(firstname);
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.pharmacy = pharmacy;
		this.insuranceCarrier = insuranceCarrier;
		this.age = age;
		this.allergies = allergies;
		this.medicalHistory = medicalHistory;
		this.date = date;
	}

	/**
	 * This constructor creates a patient with just a first and last name
	 * 
	 * @param firstname
	 *            The first name of the patient
	 * @param lastname
	 *            The last name of the patient
	 */
	public Patient(String firstname, String lastname, String date) {
		this(null, null, firstname, lastname, null, null, null, null, null,
				date, 0, null, null);
	}

	/**
	 * Getter for the address of the patient
	 * 
	 * @return The address of the patient
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Setter for the address of the patient
	 * 
	 * @param address
	 *            The new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Getter for the phone number of the patient
	 * 
	 * @return The phone number of the patient
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Setter for the phone number of the patient
	 * 
	 * @param phoneNumber
	 *            The new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Getter for the gender of the patient
	 * 
	 * @return The gender of the patient
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Setter for the gender of the patient
	 * 
	 * @param gender
	 *            The new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Getter for the pharmacy of the patient
	 * 
	 * @return The pharmacy of the patient
	 */
	public String getPharmacy() {
		return pharmacy;
	}

	/**
	 * Setter for the pharmacy of the patient
	 * 
	 * @param pharmacy
	 *            The new pharmacy
	 */
	public void setPharmacy(String pharmacy) {
		this.pharmacy = pharmacy;
	}

	/**
	 * Getter for the insurance carrier of the patient
	 * 
	 * @return The insurance carrier of the patient
	 */
	public String getInsuranceCarrier() {
		return insuranceCarrier;
	}

	/**
	 * Setter for the insurance carrier of the patient
	 * 
	 * @param insuranceCarrier
	 *            The new insurance carrier
	 */
	public void setInsuranceCarrier(String insuranceCarrier) {
		this.insuranceCarrier = insuranceCarrier;
	}

	/**
	 * Getter for the age of the patient
	 * 
	 * @return The age of the patient
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Setter for the age of the patient
	 * 
	 * @param age
	 *            The new age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Getter for the allergies of the patient
	 * 
	 * @return The allergies of the patient
	 */
	public String[] getAllergies() {
		return allergies;
	}

	/**
	 * Setter for the allergies of the patient
	 * 
	 * @param allergies
	 *            The new allergies
	 */
	public void setAllergies(String[] allergies) {
		this.allergies = allergies;
	}

	/**
	 * Getter for the medical history of the patient
	 * 
	 * @return The medical history of the patient
	 */
	public TreatmentRecord[] getMedicalHistory() {
		return medicalHistory;
	}

	/**
	 * Setter for the medical history of the patient
	 * 
	 * @param medicalHistory
	 *            The new medical history
	 */
	public void setMedicalHistory(TreatmentRecord[] medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	/**
	 * Setter for the first name of the patient
	 * 
	 * @param firstname
	 *            The new first name
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Getter for the first name of the patient
	 * 
	 * @return The first name of the patient
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Setter for the last name of the patient
	 * 
	 * @param lastname
	 *            The new last name
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Getter for the last name of the patient
	 * 
	 * @return The last name of the patient
	 */
	public String getLastname() {
		return lastname;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}
}