package neo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTest {

	private Bank b;
	private String defaultString;
	private String defaultName;
	private String defaultLastName;
	private String defaultPhone;
	private int defaultAge;

	@Before
	public void init() {
		this.defaultString = "blabla";
		this.defaultName = "Boris";
		this.defaultLastName = "Dupont";
		this.defaultPhone = "0605040302";
		this.defaultAge = 26;
		this.b = new Bank();
	}
	
	
	
	
	
	/* **************** *
	 *  TESTS BASIQUES  *
	 * **************** */
	
	@Test
	public void getNumberOfUserInit() {
		Assert.assertEquals(0, b.getNumberOfUser());
	}
	
	@Test
	public void getNumberOfUserAfterAdd() throws NeoLynkBankException {
		b.addUser(this.defaultName, this.defaultLastName, this.defaultAge, this.defaultString, this.defaultPhone);
		Assert.assertEquals(1, b.getNumberOfUser());
	}
	
	@Test
	public void getNumberOfUserAfterDelete() throws NeoLynkBankException {
		b.addUser(this.defaultName, this.defaultLastName, this.defaultAge, this.defaultString, this.defaultPhone);
		b.deleteUser(this.defaultName, this.defaultLastName);
		Assert.assertEquals(0, b.getNumberOfUser());
	}
	
	@Test
	public void findUserJeanLucAmitousaAfterAdd() throws NeoLynkBankException {
		
		User u = null;
		String name = "Jean-Luc";
		String lastName = "Amitousa";
		
		b.addUser(name, lastName, this.defaultAge, this.defaultString, this.defaultPhone);
		u = b.findUser(name, lastName);
		
		Assert.assertEquals(name, u.getName());
		Assert.assertEquals(lastName, u.getLastName());
		Assert.assertEquals(this.defaultAge, u.getAge());
		Assert.assertEquals(this.defaultString, u.getAdresseDescription());
		Assert.assertEquals(this.defaultPhone, u.getPhone());
	}
	
	@Test
	public void findUserDavidDuLacAfterAdd() throws NeoLynkBankException {
		
		User u = null;
		String name = "David";
		String lastName = "DuLac";
		
		b.addUser(name, lastName, this.defaultAge, this.defaultString, this.defaultPhone);
		u = b.findUser(name, lastName);
		
		Assert.assertEquals(name, u.getName());
		Assert.assertEquals(lastName, u.getLastName());
		Assert.assertEquals(this.defaultAge, u.getAge());
		Assert.assertEquals(this.defaultString, u.getAdresseDescription());
		Assert.assertEquals(this.defaultPhone, u.getPhone());
	}
	
	@Test
	public void findUserJeanLucAmitousaAfterDel() throws NeoLynkBankException {
		
		User u = null;
		String name = "Jean-Luc";
		String lastName = "Amitousa";
		
		b.addUser(name, lastName, this.defaultAge, this.defaultString, this.defaultPhone);
		b.deleteUser(name, lastName);
		u = b.findUser(name, lastName);
		
		Assert.assertEquals(null, u);
	}
	
	@Test
	public void findUserJeanLucAfterDelDavid() throws NeoLynkBankException {
		
		String name1 = "Jean-Luc";
		String lastName1 = "Amitousa";
		String name2 = "David";
		String lastName2 = "DuLac";
		User u = null;
		
		b.addUser(name1, lastName1, this.defaultAge, this.defaultString, this.defaultPhone);
		b.addUser(name2, lastName2, this.defaultAge, this.defaultString, this.defaultPhone);
		b.deleteUser(name2, lastName2);
		
		u = b.findUser(name1, lastName1);
		
		Assert.assertEquals(name1, u.getName());
		Assert.assertEquals(lastName1, u.getLastName());
		Assert.assertEquals(this.defaultAge, u.getAge());
		Assert.assertEquals(this.defaultString, u.getAdresseDescription());
		Assert.assertEquals(this.defaultPhone, u.getPhone());
	}
	
	@Test
	public void updateUserInfos() throws NeoLynkBankException {
		
		User u = null;
		String newName = "newName";
		String newLastName = "newLastName";
		int newAge = 30;
		String newAdrDesc = "Loin dans l'espace";
		String newPhone = "0706050403";
		
		b.addUser(
				this.defaultName, 
				this.defaultLastName, 
				this.defaultAge, this.defaultString, this.defaultPhone);
		
		b.updateUserInfos(
				this.defaultName, 
				this.defaultLastName, 
				newName, newLastName, newAge, newAdrDesc, newPhone);
		
		u = b.findUser(newName, newLastName);
		
		Assert.assertEquals(newName, u.getName());
		Assert.assertEquals(newLastName, u.getLastName());
		Assert.assertEquals(newAge, u.getAge());
		Assert.assertEquals(newAdrDesc, u.getAdresseDescription());
		Assert.assertEquals(newPhone, u.getPhone());
	}
	
	
	
	
	
	/* ******************* *
	 *  TESTS AUX LIMITES  *
	 * ******************* */
}
