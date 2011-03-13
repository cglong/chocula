import java.util.Date;

/**
 * Treatment Order
 * 
 * @author Ye Zhefan
 * 
 */
public class TreatmentRecord implements Record {

	private Patient patient;
	private Doctor treatingDoctor;

	private Date dateAndTime;

	private Nurse attendingNurse;

	private DoctorsOrders doctorsOrders;
	/**
	 * I think that could be a class
	 */
	private String chiefComplaint;
	/**
	 * Same here, class?
	 */
	private String vitalSigns;
	/**
	 * Same here, class?
	 */
	private String diagnosis;

	public TreatmentRecord(Doctor treatingDoctor, Date dateAndTime,
			Nurse attendingNurse, DoctorsOrders doctorsOrders,
			String chiefComplaint, String vitalSigns, String diagnosis,
			Patient patient) {
		this.treatingDoctor = treatingDoctor;
		this.dateAndTime = dateAndTime;
		this.attendingNurse = attendingNurse;
		this.doctorsOrders = doctorsOrders;
		this.chiefComplaint = chiefComplaint;
		this.vitalSigns = vitalSigns;
		this.diagnosis = diagnosis;
		this.patient = patient;
	}

	public Doctor getTreatingDoctor() {
		return treatingDoctor;
	}

	public void setTreatingDoctor(Doctor treatingDoctor) {
		this.treatingDoctor = treatingDoctor;
	}

	public Date getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public Nurse getAttendingNurse() {
		return attendingNurse;
	}

	public void setAttendingNurse(Nurse attendingNurse) {
		this.attendingNurse = attendingNurse;
	}

	public DoctorsOrders getDoctorsOrders() {
		return doctorsOrders;
	}

	public void setDoctorsOrders(DoctorsOrders doctorsOrders) {
		this.doctorsOrders = doctorsOrders;
	}

	public String getChiefComplaint() {
		return chiefComplaint;
	}

	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}

	public String getVitalSigns() {
		return vitalSigns;
	}

	public void setVitalSigns(String vitalSigns) {
		this.vitalSigns = vitalSigns;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
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
		TreatmentRecord tr = (TreatmentRecord) o;
		if (tr.getAttendingNurse().equals(this.getAttendingNurse())
				&& tr.getChiefComplaint().equals(this.getChiefComplaint())
				&& tr.getDateAndTime().equals(this.getDateAndTime())
				&& tr.getDiagnosis().equals(this.getDiagnosis())
				&& tr.getDoctorsOrders().equals(this.getDoctorsOrders())
				&& tr.getTreatingDoctor().equals(this.getTreatingDoctor())
				&& tr.getVitalSigns().equals(this.getVitalSigns())
				&& tr.getPatient().equals(this.getPatient())) {
			return true;
		} else {
			return false;
		}
	}
}
