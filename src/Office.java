import java.util.Collection;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author Elise Prado
 * @author Ye Zhefan
 * 
 */
public class Office {
	private Collection<User> users;
	private ArrayList<Record> appointments;
	private ArrayList<Record> treatmentrecords;
	private ArrayList<Record> doctorsorders;
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
	public Patient findPatient(String name) {
		for (User user : users)
			if (user instanceof Patient) {
				Patient patient = (Patient) user;
				if (patient.getName().equals(name))
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
	public ArrayList<Record> createAppointment(Date date, Doctor doctor,
			String reason, Patient patient) {
		Appointment ret = new Appointment(date, reason, doctor, patient);
		appointments.add(ret);
		return appointments;
	}

	/**
	 * Single parameter should work?
	 * 
	 * @param date
	 * @param doctor
	 * @param reason
	 * @return appointment
	 */
	public Appointment readAppointment(Date date, Doctor doctor, String reason,
			Patient patient) {
		Appointment ret = new Appointment(date, reason, doctor, patient);
		for (Record appointment : appointments) {
			if (ret.equals(appointment)) {
				return ret;
			}
		}
		return null;
	}

	/**
	 * Helper method of Appointment - only date
	 * 
	 * @param date
	 * @return ret
	 */
	public ArrayList<Record> readAppointment(Date date) {
		ArrayList<Record> ret = new ArrayList<Record>();
		for (Record check : appointments) {
			if (((Appointment) check).getDesiredDateAndTime().equals(date)) {
				ret.add(check);
			}
		}
		return ret;
	}

	/**
	 * Helper method of Appointment - only doctor
	 * 
	 * @param date
	 * @return ret
	 */
	public ArrayList<Record> readAppointment(Doctor doctor) {
		ArrayList<Record> ret = new ArrayList<Record>();
		for (Record check : appointments) {
			if (((Appointment) check).getDesiredDoctor().equals(doctor)) {
				ret.add(check);
			}
		}
		return ret;
	}

	/**
	 * Helper method of Appointment - only reason
	 * 
	 * @param reason
	 * @return ret
	 */
	public ArrayList<Record> readAppointment(String reason) {
		ArrayList<Record> ret = new ArrayList<Record>();
		for (Record check : appointments) {
			if (((Appointment) check).getReason().equals(reason)) {
				ret.add(check);
			}
		}
		return ret;
	}

	/**
	 * Return anything?
	 */
	public void updateAppointment() {
	}

	/**
	 * Delete an appointment
	 * 
	 * @param date
	 * @param doctor
	 * @param reason
	 * @param patient
	 */
	public void deleteAppointment(Date date, Doctor doctor, String reason,
			Patient patient) {
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
	public ArrayList<Record> createTreatmentRecord(Doctor treatingDoctor,
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
	public void updateTreatmentRecord() {
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
	 * This method will do a check to see if the username/password combo
	 * appears in the database of username/password combos, and will return
	 * the username of the one that fits.
	 */
	public void login(String username, String password) {
		this.username = username;
		
		//lockout++ when username and password don't match any in database.
	}

	public String logout() {
		return username;
	}
}
