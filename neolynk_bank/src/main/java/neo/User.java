package neo;

public class User {

	private String username;
	
	public User(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String newUsername) {
		this.username = newUsername;
	}

	public String getUserLastname() {
		return "Amitousa";
	}
}
