/**
 * @author Elise Prado 
 * 
 * Currently not sure how this works, or if it even needs a separate class.
 */
public class Login {
	private String username;
	private String password;
	
	/**
	 *When this hits 3, the person is locked out and the counter reset.
	 */
	private int lockout;
	
	
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
