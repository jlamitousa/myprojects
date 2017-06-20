package neo;

public class User {

	private String userName;
	private String userLastName;
	
	public User(String userName, String userLastName) {
		this.userName = userName;
		this.userLastName = userLastName;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String newUserName) {
		this.userName = newUserName;
	}

	public String getUserLastName() {
		return this.userLastName;
	}

	public void setUserLastname(String newUserLastname) {
		this.userLastName = newUserLastname;
	}

	public int getUserAge() {
		return 10;
	}
}
