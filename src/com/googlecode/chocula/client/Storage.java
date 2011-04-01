package com.googlecode.chocula.client;

import java.util.Date;

import com.db4o.*;
import com.db4o.cs.*;
import com.googlecode.chocula.core.*;
import com.googlecode.chocula.core.User;

/**
 * This class is responsible for storing and retrieving data from the server
 * 
 * @author Christopher Long/Zhefan Ye/Elise Prado
 * @version 1.0
 */
public class Storage implements ServerInfo {
	private static Storage instance = null;
	private ObjectContainer db = null;
	
	/**
	 * This constructor prevents instantiation by other classes. When called from
	 * within the Storage class, it opens a connection to the server.
	 */
	protected Storage() {
		try {
			db = Db4oClientServer.openClient(Db4oClientServer.newClientConfiguration(),
					HOST, PORT, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * The singleton method
	 * 
	 * @return The singleton instance of Storage
	 */
	public static Storage getInstance() {
		if (instance == null)
			instance = new Storage();
		return instance;
	}
	
	/**
	 * Creates and stores a patient in the database
	 * 
	 * @param username The username of the patient
	 * @param password The password of the patient
	 * @param firstname The first name of the patient
	 * @param lastname The last name of the patient
	 * @param address The address of the patient
	 * @param phoneNumber The phone number of the patient
	 * @param gender The gender of the patient
	 * @param pharmacy The pharmacy of the patient
	 * @param insuranceCarrier The insurance carrier of the patient
	 * @param age The age of the patient
	 * @param allergies Any allergies the patient has
	 * @param medicalHistory Any past or present treatments by the patient
	 * @return The new patient
	 */
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
	
	/**
	 * Creates and stores a nurse in the database
	 * 
	 * @param username The username of the nurse
	 * @param password The password of the nurse
	 * @return The new nurse
	 */
	public Nurse createNurse(String username, String password) {
		Nurse nurse = new Nurse(username, password);
		db.store(nurse);
		return nurse;
	}
	
	/**
	 * Creates and stores a doctor in the database
	 * 
	 * @param username The username of the doctor
	 * @param password The password of the doctor
	 * @return The new nurse
	 */
	public Doctor createDoctor(String username, String password) {
		Doctor doctor = new Doctor(username, password);
		db.store(doctor);
		return doctor;
	}
	
	/**
	 * Finds any patients in the database matching the parameter(s)
	 * 
	 * @param username The username of the patient
	 * @param password The password of the patient
	 * @param firstname The first name of the patient
	 * @param lastname The last name of the patient
	 * @param address The address of the patient
	 * @param phoneNumber The phone number of the patient
	 * @param gender The gender of the patient
	 * @param pharmacy The pharmacy of the patient
	 * @param insuranceCarrier The insurance carrier of the patient
	 * @param age The age of the patient
	 * @param allergies Any allergies the patient has
	 * @param medicalHistory Any past or present treatments by the patient
	 * @return Any matching patients
	 */
	public ObjectSet<Patient> readPatient(String username, String password, String firstname,
			String lastname, String address, String phoneNumber, String gender,
			String pharmacy, String insuranceCarrier, int age,
			String[] allergies, TreatmentRecord[] medicalHistory) {
		Patient proto = new Patient(username, password, firstname, lastname,
				address, phoneNumber, gender, pharmacy, insuranceCarrier, age,
				allergies, medicalHistory);
		return db.queryByExample(proto);
	}
	
	/**
	 * Finds any nurses in the database matching the parameter(s)
	 * 
	 * @param username The username of the nurse
	 * @param password The password of the nurse
	 * @return Any matching nurses
	 */
	public ObjectSet<Nurse> readNurse(String username, String password) {
		return db.queryByExample(new Nurse(username, password));
	}
	
	/**
	 * Finds any doctors in the database matching the parameter(s)
	 * 
	 * @param username The username of the doctor
	 * @param password The password of the doctor
	 * @return Any matching doctors
	 */
	public ObjectSet<Doctor> readDoctor(String username, String password) {
		return db.queryByExample(new Doctor(username, password));
	}
	
	/**
	 * Updates a patient in the database
	 * 
	 * @param old The old patient to update
	 * @param username The username of the patient
	 * @param password The password of the patient
	 * @param firstname The first name of the patient
	 * @param lastname The last name of the patient
	 * @param address The address of the patient
	 * @param phoneNumber The phone number of the patient
	 * @param gender The gender of the patient
	 * @param pharmacy The pharmacy of the patient
	 * @param insuranceCarrier The insurance carrier of the patient
	 * @param age The age of the patient
	 * @param allergies Any allergies the patient has
	 * @param medicalHistory Any past or present treatments by the patient
	 */
	public void updatePatient(Patient old, String username, String password, String firstname,
			String lastname, String address, String phoneNumber, String gender,
			String pharmacy, String insuranceCarrier, int age,
			String[] allergies, TreatmentRecord[] medicalHistory) {
		ObjectSet<Patient> result = db.queryByExample(old);
		Patient found = result.next();
		found.setUsername(username);
		found.setPassword(password);
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
	
	/**
	 * Updates a nurse in the database
	 * 
	 * @param old The old nurse to update
	 * @param username The username of the nurse
	 * @param password The password of the nurse
	 */
	public void updateNurse(Nurse old, String username, String password) {
		ObjectSet<Nurse> result = db.queryByExample(old);
		Nurse found = result.next();
		found.setUsername(username);
		found.setPassword(password);
		db.store(found);
	}
	
	/**
	 * Updates a doctor in the database
	 * 
	 * @param old The old doctor to update
	 * @param username The username of the doctor
	 * @param password The password of the doctor
	 */
	public void updateDoctor(Doctor old, String username, String password) {
		ObjectSet<Doctor> result = db.queryByExample(old);
		Doctor found = result.next();
		found.setUsername(username);
		found.setPassword(password);
		db.store(found);
	}
	
	/**
	 * Deletes a patient from the database
	 * 
	 * @param patient The patient to delete
	 */
	public void deletePatient(Patient patient) {
		ObjectSet<Patient> result = db.queryByExample(patient);
		db.delete(result.next());
	}
	
	/**
	 * Deletes a nurse from the database
	 * 
	 * @param nurse The nurse to delete
	 */
	public void deleteNurse(Nurse nurse) {
		ObjectSet<Nurse> result = db.queryByExample(nurse);
		db.delete(result.next());
	}
	
	/**
	 * Deletes a doctor from the database
	 * 
	 * @param doctor The doctor to delete
	 */
	public void deleteDoctor(Doctor doctor) {
		ObjectSet<Doctor> result = db.queryByExample(doctor);
		db.delete(result.next());
	}
	
	/**
	 * Finds and returns a user matching the username and password
	 * 
	 * @param username The username of the user
	 * @param password The password of the user
	 * @return The user, if found; null otherwise
	 */
	public User readUser(String username, String password) {
		ObjectSet<User> result;
		result = db.queryByExample(new Patient(username, password));
		if (!result.hasNext())
			result = db.queryByExample(new Nurse(username, password));
		if (!result.hasNext())
			result = db.queryByExample(new Doctor(username, password));
		if (!result.hasNext())
			result = db.queryByExample(new SystemAdmin(username, password));
		if (result.hasNext())
			return result.next();
		else
			return null;
	}
	
	/**
	 * Finds and returns a patient.
	 * 
	 * @param firstname The first name of the patient
	 * @param lastname The last name of the patient
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
	 * @param date The date of the appointment
	 * @param doctor The doctor seen during the appointment
	 * @param reason The reason for the visit
	 * @param patient The patient
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
	 * @param date The date of the appointment
	 * @param doctor The doctor seen during the appointment
	 * @param reason The reason for the visit
	 * @param patient The patient
	 * @return appointment
	 */
	public ObjectSet<Appointment> readAppointment(Date date, Doctor doctor,
			String reason, Patient patient) {
		return db.queryByExample(new Appointment(date, doctor, reason, patient));
	}

	/**
	 * Update an appointment in the database
	 * 
	 * @param old The old appointment to update
	 * @param date The date of the appointment
	 * @param doctor The doctor seen during the appointment
	 * @param reason The reason for the visit
	 * @param patient The patient
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
	 * @param appointment The appointment to delete
	 */
	public void deleteAppointment(Appointment appointment) {
		ObjectSet<Appointment> result = db.queryByExample(appointment);
		db.delete(result.next());
	}

	/**
	 * Create a new treatment record
	 * 
	 * @param treatingDoctor The doctor in charge of the visit
	 * @param dateAndTime The date the record was created
	 * @param attendingNurse The nurse who aided the doctor
	 * @param doctorsOrders The plan created by the doctor
	 * @param chiefComplaint The patient's main complaint
	 * @param vitalSigns The vital signs of the patient
	 * @param diagnosis The final diagnosis
	 * @param patient The patient
	 * @return treatment record
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
	 * @param treatingDoctor The doctor in charge of the visit
	 * @param dateAndTime The date the record was created
	 * @param attendingNurse The nurse who aided the doctor
	 * @param doctorsOrders The plan created by the doctor
	 * @param chiefComplaint The patient's main complaint
	 * @param vitalSigns The vital signs of the patient
	 * @param diagnosis The final diagnosis
	 * @param patient The patient
	 * @return Any matching treatment records
	 */
	public ObjectSet<TreatmentRecord> readTreatmentRecord(Doctor treatingDoctor,
			Date dateAndTime, Nurse attendingNurse,
			DoctorsOrders doctorsOrders, String chiefComplaint,
			String vitalSigns, String diagnosis, Patient patient) {
		return db.queryByExample(new TreatmentRecord(treatingDoctor, dateAndTime, attendingNurse,
				doctorsOrders, chiefComplaint, vitalSigns, diagnosis, patient));
	}

	/**
	 * Updates a treatment record in the database
	 * 
	 * @param old The record to update
	 * @param treatingDoctor The doctor in charge of the visit
	 * @param dateAndTime The date the record was created
	 * @param attendingNurse The nurse who aided the doctor
	 * @param doctorsOrders The plan created by the doctor
	 * @param chiefComplaint The patient's main complaint
	 * @param vitalSigns The vital signs of the patient
	 * @param diagnosis The final diagnosis
	 * @param patient The patient
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
	
	/**
	 * Deletes a treatment record from the database
	 * 
	 * @param tr The record to delete
	 */
	public void deleteTreatmentRecord(TreatmentRecord tr) {
		ObjectSet<TreatmentRecord> result = db.queryByExample(tr);
		db.delete(result.next());
	}
	
	/**
	 * Create a new doctor's order
	 * 
	 * @param prescriptions The prescriptions prescribed
	 * @param labWork Any lab work performed
	 * @param followUpInstr Any follow-up instructions for the patient
	 * @param otherInstr Any other instructions for the patient
	 * @return The new doctor's order
	 */
	public DoctorsOrders createDoctorsOrders(String prescriptions, String labWork,
			String followUpInstr, String otherInstr) {
		DoctorsOrders doctorsOrders = new DoctorsOrders(prescriptions, labWork,
				followUpInstr, otherInstr);
		db.store(doctorsOrders);
		return doctorsOrders;
	}

	/**
	 * Read the corresponding doctor's orders
	 * 
	 * @param prescriptions The prescriptions prescribed
	 * @param labWork Any lab work performed
	 * @param followUpInstr Any follow-up instructions for the patient
	 * @param otherInstr Any other instructions for the patient
	 * @return Any matching doctor's orders in the database
	 */
	public ObjectSet<DoctorsOrders> readDoctorsOrders(String prescriptions, String labWork,
			String followUpInstr, String otherInstr) {
		return db.queryByExample(new DoctorsOrders(prescriptions, labWork,
				followUpInstr, otherInstr));
	}

	/**
	 * Updates a doctor's order in the database
	 * 
	 * @param old The doctor's order to update
	 * @param prescriptions The prescriptions prescribed
	 * @param labWork Any lab work performed
	 * @param followUpInstr Any follow-up instructions for the patient
	 * @param otherInstr Any other instructions for the patient
	 */
	public void updateDoctorsOrders(DoctorsOrders old, String prescriptions, String labWork,
			String followUpInstr, String otherInstr) {
		ObjectSet<DoctorsOrders> result = db.queryByExample(old);
		DoctorsOrders found = result.next();
		found.setPrescriptions(prescriptions);
		found.setLabWork(labWork);
		found.setFollowUpInstr(followUpInstr);
		found.setOtherInstr(otherInstr);
		db.store(found);
	}

	/**
	 * Delete a doctor's order from the database
	 * 
	 * @param doctorsOrders The doctor's order to delete
	 */
	public void deleteDoctorsOrders(DoctorsOrders doctorsOrders) {
		ObjectSet<Appointment> result = db.queryByExample(doctorsOrders);
		db.delete(result.next());
	}
	
	public ErrorEntry createUnexpectedErrorEntry(Exception e, Object o) {
		ErrorEntry ee = ErrorEntry.newUnexpectedException(e, o);
		db.store(ee);
		return ee;
	}
	
	public ErrorEntry createExpectedErrorEntry(Exception e, Object o) {
		ErrorEntry ee = ErrorEntry.newExpectedException(e, o);
		db.store(ee);
		return ee;
	}
	
	public ObjectSet<ErrorEntry> readErrorEntries(Exception e, Object o) {
		return db.queryByExample(new ErrorEntry(e, o));
	}
	
	public ObjectSet<ErrorEntry> readAllErrorEntries() {
		return db.queryByExample(new ErrorEntry(null, null));
	}
	
	public void deleteErrorEntry(ErrorEntry ee) {
		ObjectSet<ErrorEntry> result = db.queryByExample(ee);
		db.delete(result.next());
	}
}