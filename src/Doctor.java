/**
 * 
 * @author Ye Zhefan
 * 
 */
public class Doctor extends Nurse implements IDoctor {
	private String name;
	private int id;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	/**
	 * Needs to be implemented
	 */
	public String toString() {
		return "";
	}

}
