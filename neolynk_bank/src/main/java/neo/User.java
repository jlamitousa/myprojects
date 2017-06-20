package neo;

public class User {

	private String name;
	private String lastName;
	private int age;
	
	public User(String userName, String userLastName, int userAge) {
		this.name = userName;
		this.lastName = userLastName;
		this.age = userAge;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String newUserName) {
		this.name = newUserName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setUserLastname(String newUserLastname) {
		this.lastName = newUserLastname;
	}

	public int getAge() {
		return this.age;
	}

	public void setUserAge(int newUserAge) {
		this.age = newUserAge;
	}
}
