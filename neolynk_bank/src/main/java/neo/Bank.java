package neo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class Bank {

	private List<User> users;
	private int nbAccount;
	
	public Bank() {
		this.users = new ArrayList<User>();
		this.nbAccount = 0;
	}
	
	
	public int getNumberOfUser() {
		return this.users.size();
	}
	
	public void addUser(String userName, String userLastName, int userAge, String adresseDescription, String phone) throws NeoLynkBankException {
		this.users.add(new User(userName, userLastName, userAge, adresseDescription, phone));
	}
	
	public void deleteUser(String name, String lastName) {
		User u = findUser(name, lastName);
		this.users.remove(u);
		this.nbAccount--;
	}
	
	public User findUser(String name, String lastName) {
		
		User u = null;
		
		List<User> res = 
				this.users.stream()
				.filter(u1 -> StringUtils.equals(u1.getName(), name))
				.filter(u2 -> StringUtils.equals(u2.getLastName(), lastName))
				.collect(Collectors.toList());
		
		if(res != null && res.size() > 0) {
			u = res.get(0);
		}
		
		return u;
	}

	public boolean updateUserInfos(
			String name, String lastName, 
			String newName, String newLastName, int newAge, String newAdrDesc, String newPhone) {
		
		User u = findUser(name, lastName);
		
		u.setName(newName);
		u.setUserLastname(newLastName);
		u.setUserAge(newAge);
		u.setUserAdresseDescription(newAdrDesc);
		u.setPhone(newPhone);
		
		return true;
	}

	public void addNewAccount(String userName, String userLastName) {
		this.nbAccount++;
	}


	public int getTotalAccountCount() {
		return this.nbAccount;
	}


	public Object getAccountCount(String defaultName, String defaultLastName) {
		return this.nbAccount;
	}
}
