/**
 * This class represents a patient.
 * 
 * @author Christopher Long
 * @version 1.0
 */
public class Patient extends User implements IPatient {
	private String firstname, lastname, address, phoneNumber, gender, pharmacy,
			insuranceCarrier;
	private int age;
	private String[] allergies;
	private TreatmentRecord[] medicalHistory;

	public Patient(String username, String password, String firstname,
			String lastname, String address, String phoneNumber, String gender,
			String pharmacy, String insuranceCarrier, int age,
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
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(String pharmacy) {
		this.pharmacy = pharmacy;
	}

	public String getInsuranceCarrier() {
		return insuranceCarrier;
	}

	public void setInsuranceCarrier(String insuranceCarrier) {
		this.insuranceCarrier = insuranceCarrier;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String[] getAllergies() {
		return allergies;
	}

	public void setAllergies(String[] allergies) {
		this.allergies = allergies;
	}

	public TreatmentRecord[] getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(TreatmentRecord[] medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLastname() {
		return lastname;
	}
}