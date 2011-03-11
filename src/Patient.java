
public class Patient extends User implements IPatient {
	private PatientInformation info;
	
	public Patient(String username, String password, String name) {
		super(username, password);
		this.info = new PatientInformation(name);
	}
	
	public String getName() {
		return info.getName();
	}
}
