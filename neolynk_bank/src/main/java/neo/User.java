package neo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;


public class User {

	private String name;
	private String lastName;
	private int age;
	private String adresseDescription;
	private String phone;
	
	/**
	 * 
	 * @param userName never null or empty (throw exception)
	 * @param userLastName never null or empty (throw exception)
	 * @param userAge never negative  (throw exception)
	 * @param adresseDescription
	 * @param phone number only (throw exception)
	 * @throws NeoLynkBankException
	 */
	public User(String userName, String userLastName, int userAge, String adresseDescription, String phone) throws NeoLynkBankException {
		
		if(StringUtils.isEmpty(userName)) {
			throw new NeoLynkBankException("Invalid username (null or empty)");
		}
		
		if(StringUtils.isEmpty(userLastName)) {
			throw new NeoLynkBankException("Invalid lastname (null or empty)");
		}
		
		if(userAge < 0) {
			throw new NeoLynkBankException("Invalid age (negative)");
		}
		
		if(StringUtils.isNotEmpty(phone) && !isValidPhone(phone)) {
			throw new NeoLynkBankException("Invalid phone (non numeric characters)");
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

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	private boolean isValidPhone(String phone) {
		Pattern p = Pattern.compile("^[0-9]+$");
		Matcher m = p.matcher(phone);
		return m.matches();
	}
}
