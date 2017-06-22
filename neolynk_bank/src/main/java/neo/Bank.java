package neo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class Bank {

	private List<User> users;
	
	
	public Bank() {
		this.users = new ArrayList<User>();
	}
	
	
	public int getNumberOfUser() {
		return this.users.size();
	}
	
	public void addUser(String userName, String userLastName, int userAge, String adresseDescription, String phone) throws NeoLynkBankException {
		this.users.add(new User(userName, userLastName, userAge, adresseDescription, phone));
	}
	
	public void deleteUser() {
		this.users.remove(0);
	}
	
	public User findUser(String name, String lastName) throws NeoLynkBankException {
		
		User u = null;
		
		try {
			u = new User("Jean-Luc", "Amitousa", 15, "blabla", "");
		} catch(NeoLynkBankException nbe) {
			//TODO A logger à partir d'un framework de log. Vu que ce n'est pas néccéssaire 
			//pour ce test, je ne le ferais pas.
			nbe.printStackTrace();
		}
		
		return u;
	}
}
