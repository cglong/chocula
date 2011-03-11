import java.util.Collection;
import java.util.ArrayList;

public class Office {
	private Collection<User> users;
	
	public Office() {
		users = new ArrayList<User>();
	}
	
	/**
	 * Finds and returns a patient.
	 * 
	 * @param name The name of the patient to find.
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
}
