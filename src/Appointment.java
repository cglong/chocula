import java.util.Date;

/**
 * Appointment
 * 
 * @author Ye Zhefan
 * 
 */
public class Appointment implements Record {

	private Date desiredDateAndTime;

	/**
	 * Class??
	 */
	private String reason;

	private Doctor desiredDoctor;

	private Patient patient;

	public Appointment(Date desiredDateAndTime, String reason,
			Doctor desiredDoctor, Patient patient) {
		this.desiredDateAndTime = desiredDateAndTime;
		this.reason = reason;
		this.desiredDoctor = desiredDoctor;
		this.patient = patient;
	}

	public Date getDesiredDateAndTime() {
		return desiredDateAndTime;
	}

	public void setDesiredDateAndTime(Date desiredDateAndTime) {
		this.desiredDateAndTime = desiredDateAndTime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Doctor getDesiredDoctor() {
		return desiredDoctor;
	}

	public void setDesiredDoctor(Doctor desiredDoctor) {
		this.desiredDoctor = desiredDoctor;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Patient getPatient() {
		return patient;
	}

	/**
	 * Override equals method
	 */
	public boolean equals(Object o) {
		Appointment apt = (Appointment) o;
		if (apt.getDesiredDateAndTime().equals(this.getDesiredDateAndTime())
				&& apt.getDesiredDoctor().equals(this.getDesiredDoctor())
				&& apt.getReason().equals(this.getReason())
				&& apt.getPatient().equals(this.getPatient())) {
			return true;
		} else {
			return false;
		}
	}

}
