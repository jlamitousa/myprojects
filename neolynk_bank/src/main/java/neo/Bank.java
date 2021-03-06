package neo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class Bank {

	private List<User> users;
	private Map<User, List<Account>> accounts;
	
	public Bank() {
		this.users = new ArrayList<User>();
		this.accounts = new HashMap<User, List<Account>>();
	}
	
	

	public int getNumberOfUser() {
		return this.users.size();
	}
	
	public void addUser(String userName, String userLastName, int userAge, String adresseDescription, String phone) throws NeoLynkBankException {
		
		User u = new User(userName, userLastName, userAge, adresseDescription, phone); 
		
		this.users.add(u);
		this.accounts.put(u, new ArrayList<Account>());
	}
	
	public void deleteUser(String name, String lastName) {
		
		User u = findUser(name, lastName);
		
		this.users.remove(u);
		this.accounts.remove(u);
	}
	
	/**
	 * 
	 * @param name
	 * @param lastName
	 * @return The user if found. null otherwise
	 */
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

	/**
	 * Error if user does not exists
	 * @param userName
	 * @param userLastName
	 * @throws NeoLynkBankException
	 */
	public void addNewAccount(String userName, String userLastName) throws NeoLynkBankException {
		
		User u = findUser(userName, userLastName);
		
		if(u==null) {
			throw new NeoLynkBankException("Invalid user");
		}
		
		this.accounts.get(u).add(new Account());
	}

	public int getTotalAccountCount() {
		
		int total = 0;
		
		for(User u : this.accounts.keySet()) {
			total += this.accounts.get(u).size();
		}
		
		return total;
	}

	public Object getAccountCountByUser(String userName, String userLastName) {
		
		User u = findUser(userName, userLastName);
		int total = (u != null) ? this.accounts.get(u).size() : 0;
		
		return total;
	}

	/**
	 * Error if user does not exists or you have to fill your account
	 * @param userName
	 * @param userLastName
	 * @param amount
	 * @throws NeoLynkBankException
	 */
	public void deposite(String userName, String userLastName, int amount) throws NeoLynkBankException {
		
		User u = findUser(userName, userLastName);
		Account a = null;
		
		if(u==null) {
			throw new NeoLynkBankException("Invalid user");
		}
		
		a = this.accounts.get(u).get(0);
		
		if((a.getBalance()+amount) < 0) {
			throw new NeoLynkBankException("Impossible operation. Yes ... You have too much money ...");
		}
		
		a.setBalance(a.getBalance()+amount);
	}
	
	/**
	 * Error if user does not exists or you have not enough money
	 * @param userName
	 * @param userLastName
	 * @param amount
	 * @throws NeoLynkBankException
	 */
	public void withdraw(String userName, String userLastName, int amount) throws NeoLynkBankException {
		
		User u = findUser(userName, userLastName);
		Account a = null;
		
		if(u==null) {
			throw new NeoLynkBankException("Invalid user");
		}
		
		a = this.accounts.get(u).get(0);
		
		if((a.getBalance()-amount) < 0) {
			throw new NeoLynkBankException("Impossible Operation. Dude holidays are finished ... Return to work ...");
		}
		
		a.setBalance(a.getBalance()-amount);
	}

	public int getAmountByUser(String name, String lastName) {
		
		User u = findUser(name, lastName);
		int total = 0;
		
		for(Account a : this.accounts.get(u)) {
			total += a.getBalance();
		}
		
		return total;
	}
}
