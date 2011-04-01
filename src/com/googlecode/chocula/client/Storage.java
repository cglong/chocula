package com.googlecode.chocula.client;

import java.util.Date;

import com.db4o.*;
import com.db4o.cs.*;
import com.googlecode.chocula.core.*;
import com.googlecode.chocula.core.User;

/**
 * @(#)Storage.java
 *
 *
 * @author Christopher Long/Zhefan Ye/Elise Prado
 * @version 1.00 2011/3/15
 *
 *
 * This class takes care of persistent storage... I guess.
 * Maybe other classes call on it to save their information for them?
 */
public class Storage implements ServerInfo {
	private static Storage instance = null;
	private ObjectContainer db = null;
	
	protected Storage() {
		try {
			db = Db4oClientServer.openClient(Db4oClientServer.newClientConfiguration(),
					HOST, PORT, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Storage getInstance() {
		if (instance == null)
			instance = new Storage();
		return instance;
	}
	
	public Patient createPatient(String username, String password, String firstname,
			String lastname, String address, String phoneNumber, String gender,
			String pharmacy, String insuranceCarrier, int age,
			String[] allergies, TreatmentRecord[] medicalHistory) {
		Patient patient = new Patient(username, password, firstname, lastname,
				address, phoneNumber, gender, pharmacy, insuranceCarrier, age,
				allergies, medicalHistory);
		db.store(patient);
		return patient;
	}
	
	public Nurse createNurse(String username, String password) {
		Nurse nurse = new Nurse(username, password);
		db.store(nurse);
		return nurse;
	}
	
	public Doctor createDoctor(String username, String password) {
		Doctor doctor = new Doctor(username, password);
		db.store(doctor);
		return doctor;
	}
	
	public ObjectSet<Patient> readPatient(String username, String password, String firstname,
			String lastname, String address, String phoneNumber, String gender,
			String pharmacy, String insuranceCarrier, int age,
			String[] allergies, TreatmentRecord[] medicalHistory) {
		Patient proto = new Patient(username, password, firstname, lastname,
				address, phoneNumber, gender, pharmacy, insuranceCarrier, age,
				allergies, medicalHistory);
		return db.queryByExample(proto);
	}
	
	public ObjectSet<Nurse> readNurse(String username, String password) {
		return db.queryByExample(new Nurse(username, password));
	}
	
	public ObjectSet<Doctor> readDoctor(String username, String password) {
		return db.queryByExample(new Doctor(username, password));
	}
	
	public void updatePatient(Patient old, String username, String password, String firstname,
			String lastname, String address, String phoneNumber, String gender,
			String pharmacy, String insuranceCarrier, int age,
			String[] allergies, TreatmentRecord[] medicalHistory) {
		ObjectSet<Patient> result = db.queryByExample(old);
		Patient found = result.next();
		found.setFirstname(firstname);
		found.setLastname(lastname);
		found.setAddress(address);
		found.setPhoneNumber(phoneNumber);
		found.setGender(gender);
		found.setPharmacy(pharmacy);
		found.setInsuranceCarrier(insuranceCarrier);
		found.setAge(age);
		found.setAllergies(allergies);
		found.setMedicalHistory(medicalHistory);
		db.store(found);
	}
	
	public void updateNurse(Nurse old, String username, String password) {
		ObjectSet<Nurse> result = db.queryByExample(old);
		Nurse found = result.next();
		found.setUsername(username);
		found.setPassword(password);
		db.store(found);
	}
	
	public void updateDoctor(Doctor old, String username, String password) {
		ObjectSet<Doctor> result = db.queryByExample(old);
		Doctor found = result.next();
		found.setUsername(username);
		found.setPassword(password);
		db.store(found);
	}
	
	public void deletePatient(Patient patient) {
		ObjectSet<Patient> result = db.queryByExample(patient);
		db.delete(result.next());
	}
	
	public void deleteNurse(Nurse nurse) {
		ObjectSet<Nurse> result = db.queryByExample(nurse);
		db.delete(result.next());
	}
	
	public void deleteDoctor(Doctor doctor) {
		ObjectSet<Doctor> result = db.queryByExample(doctor);
		db.delete(result.next());
	}
	
	public User readUser(String username, String password) {
		User user = (User) db.queryByExample(new Patient(username, password)).next();
		if (user == null)
			user = (User) db.queryByExample(new Nurse(username, password)).next();
		if (user == null)
			user = (User) db.queryByExample(new Doctor(username, password)).next();
		if (user == null)
			user = (User) db.queryByExample(new SystemAdmin(username, password)).next();
		return user;
	}
	
	/**
	 * Finds and returns a patient.
	 * 
	 * @param name
	 *            The name of the patient to find.
	 * @return The patient with the specified name.
	 */
	public Patient findPatient(String firstname, String lastname) {
		ObjectSet<Patient> result = db.queryByExample(new Patient(firstname, lastname));
		if (result.hasNext())
			return result.next();
		else
			return null;
	}

	/**
	 * Create a new appointment
	 * 
	 * @param newAP
	 * @return created appointment
	 */
	public Appointment createAppointment(Date date, Doctor doctor,
			String reason, Patient patient) {
		Appointment appointment = new Appointment(date, doctor, reason, patient);
		db.store(appointment);
		return appointment;
	}

	/**
	 * Read the corresponding appointments
	 * 
	 * @param date
	 * @param doctor
	 * @param reason
	 * @return appointment
	 */
	public ObjectSet<Appointment> readAppointment(Date date, Doctor doctor,
			String reason, Patient patient) {
		return db.queryByExample(new Appointment(date, doctor, reason, patient));
	}

	/**
	 * Return anything?
	 */
	public void updateAppointment(Appointment old, Date date, Doctor doctor,
			String reason, Patient patient) {
		ObjectSet<Appointment> result = db.queryByExample(old);
		Appointment found = result.next();
		found.setDesiredDateAndTime(date);
		found.setReason(reason);
		found.setDesiredDoctor(doctor);
		found.setPatient(patient);
		db.store(found);
	}

	/**
	 * Delete an appointment
	 * 
	 * @param date
	 * @param doctor
	 * @param reason
	 * @param patient
	 */
	public void deleteAppointment(Appointment appointment) {
		ObjectSet<Appointment> result = db.queryByExample(appointment);
		db.delete(result.next());
	}

	/**
	 * Create a new treatment record
	 * 
	 * @param treatingDoctor
	 * @param dateAndTime
	 * @param attendingNurse
	 * @param doctorsOrders
	 * @param chiefComplaint
	 * @param vitalSigns
	 * @param diagnosis
	 * @param patient
	 * @return treatment records
	 */
	public TreatmentRecord createTreatmentRecord(Doctor treatingDoctor,
			Date dateAndTime, Nurse attendingNurse,
			DoctorsOrders doctorsOrders, String chiefComplaint,
			String vitalSigns, String diagnosis, Patient patient) {
		TreatmentRecord tr = new TreatmentRecord(treatingDoctor, dateAndTime, attendingNurse,
				doctorsOrders, chiefComplaint, vitalSigns, diagnosis, patient);
		db.store(tr);
		return tr;
	}

	/**
	 * Find and read a Treatment Record
	 * 
	 * @param treatingDoctor
	 * @param dateAndTime
	 * @param attendingNurse
	 * @param doctorsOrders
	 * @param chiefComplaint
	 * @param vitalSigns
	 * @param diagnosis
	 * @param patient
	 * @return tr
	 */
	public ObjectSet<TreatmentRecord> readTreatmentRecord(Doctor treatingDoctor,
			Date dateAndTime, Nurse attendingNurse,
			DoctorsOrders doctorsOrders, String chiefComplaint,
			String vitalSigns, String diagnosis, Patient patient) {
		return db.queryByExample(new TreatmentRecord(treatingDoctor, dateAndTime, attendingNurse,
				doctorsOrders, chiefComplaint, vitalSigns, diagnosis, patient));
	}

	/**
	 * Return anything?
	 */
	public void updateTreatmentRecord(TreatmentRecord old, Doctor treatingDoctor, Date dateAndTime,
			Nurse attendingNurse, DoctorsOrders doctorsOrders,
			String chiefComplaint, String vitalSigns, String diagnosis,
			Patient patient) {
		ObjectSet<TreatmentRecord> result = db.queryByExample(old);
		TreatmentRecord found = result.next();
		found.setTreatingDoctor(treatingDoctor);
		found.setDateAndTime(dateAndTime);
		found.setAttendingNurse(attendingNurse);
		found.setDoctorsOrders(doctorsOrders);
		found.setChiefComplaint(chiefComplaint);
		found.setVitalSigns(vitalSigns);
		found.setDiagnosis(diagnosis);
		found.setPatient(patient);
		db.store(found);
	}

	public void deleteTreatmentRecord(TreatmentRecord tr) {
		ObjectSet<TreatmentRecord> result = db.queryByExample(tr);
		db.delete(result.next());
	}
}