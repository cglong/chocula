/**
 * 
 * @author Ye Zhefan - M5 CRUD appointment and treatment record
 * 
 */
public class Nurse extends User {
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
	 * 
	 * @return
	 */
	public String toStirng() {
		return "";
	}
}
