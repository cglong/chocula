package com.googlecode.chocula.client;

import java.util.Collection;
import java.util.Date;

import com.db4o.*;
import com.db4o.cs.*;
import com.googlecode.chocula.core.*;

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
	public Collection<Appointment> readAppointment(Date date, Doctor doctor,
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
	public void deleteAppointment(Date date, Doctor doctor,
			String reason, Patient patient) {
		ObjectSet<Appointment> result = db.queryByExample(new Appointment(date, doctor, reason, patient));
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
	public Collection<TreatmentRecord> readTreatmentRecord(Doctor treatingDoctor,
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

	public void deleteTreatmentRecord(Doctor treatingDoctor, Date dateAndTime,
			Nurse attendingNurse, DoctorsOrders doctorsOrders,
			String chiefComplaint, String vitalSigns, String diagnosis,
			Patient patient) {
		ObjectSet<TreatmentRecord> result = db.queryByExample(new TreatmentRecord(treatingDoctor, dateAndTime,
				attendingNurse, doctorsOrders, chiefComplaint, vitalSigns, diagnosis, patient));
		db.delete(result.next());
	}
}