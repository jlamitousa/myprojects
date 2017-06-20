package neo;


public class User {

	private String name;
	private String lastName;
	private int age;
	private String adresseDescription;
	private String phone;
	
	public User(String userName, String userLastName, int userAge, String adresseDescription, String phone) throws NeoLynkBankException {
		
		if(userName==null) {
			throw new NeoLynkBankException("Invalid username (null)");
		}
		
		this.name = userName;
		this.lastName = userLastName;
		this.age = userAge;
		this.adresseDescription = adresseDescription;
		this.phone = phone;
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

	public Object getAdresseDescription() {
		return this.adresseDescription;
	}

	public void setUserAdresseDescription(String adresseDescription) {
		this.adresseDescription = adresseDescription;
	}

	public String getPhone() {
		return this.phone;
	}

	public void sePhone(String phone) {
		this.phone = phone;
	}
}
