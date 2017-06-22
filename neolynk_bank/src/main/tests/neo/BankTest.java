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
	public void findUserJeanLucAmitousaAfterDel() throws NeoLynkBankException {
		
		User u = null;
		String name = "Jean-Luc";
		String lastName = "Amitousa";
		
		b.addUser(name, lastName, this.defaultAge, this.defaultString, this.defaultPhone);
		b.deleteUser(name, lastName);
		u = b.findUser(name, lastName);
		
		Assert.assertEquals(null, u);
	}
}
