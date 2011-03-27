package com.googlecode.chocula.server;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Date;

import com.googlecode.chocula.core.Appointment;
import com.googlecode.chocula.core.Doctor;
import com.googlecode.chocula.core.DoctorsOrders;
import com.googlecode.chocula.core.Nurse;
import com.googlecode.chocula.core.Patient;
import com.googlecode.chocula.core.Record;
import com.googlecode.chocula.core.TreatmentRecord;
import com.googlecode.chocula.core.User;

/**
 * 
 * @author Elise Prado
 * @author Ye Zhefan
 * 
 */
public class Office {
	private Collection<User> users;
	private static Collection<Record> appointments;
	private static Collection<Record> treatmentrecords;
	private static Collection<Record> doctorsorders;
	private String username;
	private String password;
	private int lockout;

	public Office() {
		users = new ArrayList<User>();
		appointments = new ArrayList<Record>();
		treatmentrecords = new ArrayList<Record>();
		doctorsorders = new ArrayList<Record>();
	}

	/**
	 * Finds and returns a patient.
	 * 
	 * @param name
	 *            The name of the patient to find.
	 * @return The patient with the specified name.
	 */
	public Patient findPatient(String firstname, String lastname) {
		for (User user : users)
			if (user instanceof Patient) {
				Patient patient = (Patient) user;
				if (patient.getFirstname().equals(firstname)
						&& patient.getLastname().equals(lastname))
					return patient;
			}
		return null;
	}

	/**
	 * Create a new appointment
	 * 
	 * @param newAP
	 * @return created appointment
	 */
	public static Appointment createAppointment(Date date, Doctor doctor,
			String reason, Patient patient) {
		Appointment ret = new Appointment(date, reason, doctor, patient);
		appointments.add(ret);
		return ret;
	}

	/**
	 * Read the corresponding appointments
	 * 
	 * @param date
	 * @param doctor
	 * @param reason
	 * @return appointment
	 */
	public static Collection<Record> readAppointment(Date date, Doctor doctor,
			String reason, Patient patient) {
		Collection<Record> ret = new ArrayList<Record>();
		if (date != null) {
			for (Record check : appointments) {
				if (((Appointment) check).getDesiredDateAndTime().equals(date)) {
					ret.add(check);
				}
			}
		}
		if (doctor != null) {
			for (Record check : appointments) {
				if (((Appointment) check).getDesiredDoctor().equals(doctor)
						&& date == null) {
					ret.add(check);
				}
			}
		}
		if (reason != null) {
			for (Record check : appointments) {
				if (((Appointment) check).getReason().equals(reason)
						&& date == null && doctor == null) {
					ret.add(check);
				}
			}
		}
		if (patient != null) {
			for (Record check : appointments) {
				if (((Appointment) check).getPatient().equals(patient)
						&& date == null && doctor == null && reason == null) {
					ret.add(check);
				}
			}
		}
		return ret;
	}

	/**
	 * Return anything?
	 */
	public static void updateAppointment(Date date, Doctor doctor,
			String reason, Patient patient) {
		Collection<Record> update = readAppointment(date, doctor, reason,
				patient);

	}

	/**
	 * Delete an appointment
	 * 
	 * @param date
	 * @param doctor
	 * @param reason
	 * @param patient
	 */
	public static void deleteAppointment(Date date, Doctor doctor,
			String reason, Patient patient) {
		Appointment del = new Appointment(date, reason, doctor, patient);
		for (Record appointment : appointments) {
			if (del.equals(appointment)) {
				appointments.remove(del);
			}
		}

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
	public Collection<Record> createTreatmentRecord(Doctor treatingDoctor,
			Date dateAndTime, Nurse attendingNurse,
			DoctorsOrders doctorsOrders, String chiefComplaint,
			String vitalSigns, String diagnosis, Patient patient) {
		TreatmentRecord tr = new TreatmentRecord(treatingDoctor, dateAndTime,
				attendingNurse, doctorsOrders, diagnosis, diagnosis, diagnosis,
				patient);
		treatmentrecords.add(tr);
		return treatmentrecords;
	}

	/**
	 * Find and read a Treatment Record Does this need helper methods??
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
	public TreatmentRecord readTreatmentRecord(Doctor treatingDoctor,
			Date dateAndTime, Nurse attendingNurse,
			DoctorsOrders doctorsOrders, String chiefComplaint,
			String vitalSigns, String diagnosis, Patient patient) {
		TreatmentRecord tr = new TreatmentRecord(treatingDoctor, dateAndTime,
				attendingNurse, doctorsOrders, diagnosis, diagnosis, diagnosis,
				patient);
		for (Record temp : treatmentrecords) {
			if (temp.equals(tr)) {
				return tr;
			}
		}
		return null;
	}

	/**
	 * Return anything?
	 */
	public void updateTreatmentRecord(Doctor treatingDoctor, Date dateAndTime,
			Nurse attendingNurse, DoctorsOrders doctorsOrders,
			String chiefComplaint, String vitalSigns, String diagnosis,
			Patient patient) {
	}

	public void deleteTreatmentRecord(Doctor treatingDoctor, Date dateAndTime,
			Nurse attendingNurse, DoctorsOrders doctorsOrders,
			String chiefComplaint, String vitalSigns, String diagnosis,
			Patient patient) {
		TreatmentRecord tr = new TreatmentRecord(treatingDoctor, dateAndTime,
				attendingNurse, doctorsOrders, diagnosis, diagnosis, diagnosis,
				patient);
		for (Record temp : treatmentrecords) {
			if (temp.equals(tr)) {
				treatmentrecords.remove(tr);
			}
		}
	}

	/**
	 * This method will do a check to see if the username/password combo appears
	 * in the database of username/password combos, and will return the username
	 * of the one that fits.
	 */
	public void login(String username, String password) {
		this.username = username;

		// lockout++ when username and password don't match any in database.
	}

	public String logout() {
		return username;
	}
}
