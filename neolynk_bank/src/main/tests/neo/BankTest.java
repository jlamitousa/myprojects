package neo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTest {

	private Bank emptyBank;
	private Bank bankWithUser;
	private String defaultString;
	private String defaultName;
	private String defaultLastName;
	private String defaultPhone;
	private int defaultAge;

	@Before
	public void init() throws NeoLynkBankException {
		this.defaultString = "blabla";
		this.defaultName = "Boris";
		this.defaultLastName = "Dupont";
		this.defaultPhone = "0605040302";
		this.defaultAge = 26;
		this.emptyBank = new Bank();
		this.bankWithUser = new Bank();
		this.bankWithUser.addUser(this.defaultName, this.defaultLastName, this.defaultAge, this.defaultString, this.defaultPhone);
	}
	
	
	
	
	
	/* **************** *
	 *  TESTS BASIQUES  *
	 * **************** */
	
	@Test
	public void getNumberOfUserInit() {
		Assert.assertEquals(0, emptyBank.getNumberOfUser());
	}
	
	@Test
	public void getNumberOfUserAfterAdd() throws NeoLynkBankException {
		emptyBank.addUser(this.defaultName, this.defaultLastName, this.defaultAge, this.defaultString, this.defaultPhone);
		Assert.assertEquals(1, emptyBank.getNumberOfUser());
	}
	
	@Test
	public void getNumberOfUserAfterDelete() throws NeoLynkBankException {
		emptyBank.addUser(this.defaultName, this.defaultLastName, this.defaultAge, this.defaultString, this.defaultPhone);
		emptyBank.deleteUser(this.defaultName, this.defaultLastName);
		Assert.assertEquals(0, emptyBank.getNumberOfUser());
	}
	
	@Test
	public void findUserJeanLucAmitousaAfterAdd() throws NeoLynkBankException {
		
		User u = null;
		String name = "Jean-Luc";
		String lastName = "Amitousa";
		
		emptyBank.addUser(name, lastName, this.defaultAge, this.defaultString, this.defaultPhone);
		u = emptyBank.findUser(name, lastName);
		
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
		
		emptyBank.addUser(name, lastName, this.defaultAge, this.defaultString, this.defaultPhone);
		u = emptyBank.findUser(name, lastName);
		
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
		
		emptyBank.addUser(name, lastName, this.defaultAge, this.defaultString, this.defaultPhone);
		emptyBank.deleteUser(name, lastName);
		u = emptyBank.findUser(name, lastName);
		
		Assert.assertEquals(null, u);
	}
	
	@Test
	public void findUserJeanLucAfterDelDavid() throws NeoLynkBankException {
		
		String name1 = "Jean-Luc";
		String lastName1 = "Amitousa";
		String name2 = "David";
		String lastName2 = "DuLac";
		User u = null;
		
		emptyBank.addUser(name1, lastName1, this.defaultAge, this.defaultString, this.defaultPhone);
		emptyBank.addUser(name2, lastName2, this.defaultAge, this.defaultString, this.defaultPhone);
		emptyBank.deleteUser(name2, lastName2);
		
		u = emptyBank.findUser(name1, lastName1);
		
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
		
		emptyBank.addUser(
				this.defaultName, 
				this.defaultLastName, 
				this.defaultAge, this.defaultString, this.defaultPhone);
		
		emptyBank.updateUserInfos(
				this.defaultName, 
				this.defaultLastName, 
				newName, newLastName, newAge, newAdrDesc, newPhone);
		
		u = emptyBank.findUser(newName, newLastName);
		
		Assert.assertEquals(newName, u.getName());
		Assert.assertEquals(newLastName, u.getLastName());
		Assert.assertEquals(newAge, u.getAge());
		Assert.assertEquals(newAdrDesc, u.getAdresseDescription());
		Assert.assertEquals(newPhone, u.getPhone());
	}
	
	@Test 
	public void addNewAccountToUser() throws NeoLynkBankException {
		emptyBank.addUser(
				this.defaultName, 
				this.defaultLastName, 
				this.defaultAge, this.defaultString, this.defaultPhone);
		emptyBank.addNewAccount(this.defaultName, this.defaultLastName);
		Assert.assertEquals(1, emptyBank.getAccountCountByUser(this.defaultName, this.defaultLastName));
	}
	
	@Test
	public void checkGlobalAccountCountAfterDelete() throws NeoLynkBankException {
		bankWithUser.addNewAccount(this.defaultName, this.defaultLastName);
		bankWithUser.deleteUser(this.defaultName, this.defaultLastName);
		Assert.assertEquals(0, bankWithUser.getTotalAccountCount());
	}
	
	@Test
	public void checkUserAccountCountAfterDelete() throws NeoLynkBankException {
		bankWithUser.addNewAccount(this.defaultName, this.defaultLastName);
		bankWithUser.deleteUser(this.defaultName, this.defaultLastName);
		Assert.assertEquals(0, bankWithUser.getAccountCountByUser(this.defaultName, this.defaultLastName));
	}
	
	@Test
	public void checkAccountCreationImpactOnOtherUser() throws NeoLynkBankException {
		
		String secondUserName = "John";
		String secondUserLastName = "Amitousa";
		
		bankWithUser.addUser(
				secondUserName, 
				secondUserLastName, 
				this.defaultAge, this.defaultString, this.defaultPhone);
		
		bankWithUser.addNewAccount(this.defaultName, this.defaultLastName);
		bankWithUser.addNewAccount(secondUserName, secondUserLastName);

		Assert.assertEquals(1, bankWithUser.getAccountCountByUser(this.defaultName, this.defaultLastName));
	}
	
	@Test
	public void checkMoneyDeposite() throws NeoLynkBankException {
		bankWithUser.addNewAccount(this.defaultName, this.defaultLastName);
		bankWithUser.deposite(this.defaultName, this.defaultLastName, 20);
		Assert.assertEquals(20, bankWithUser.getAmountByUser(this.defaultName, this.defaultLastName));
	}
	
	@Test
	public void checkMoneyWithdraw() throws NeoLynkBankException {
		bankWithUser.addNewAccount(this.defaultName, this.defaultLastName);
		bankWithUser.deposite(this.defaultName, this.defaultLastName, 20);
		bankWithUser.withdraw(this.defaultName, this.defaultLastName, 20);
		Assert.assertEquals(0, bankWithUser.getAmountByUser(this.defaultName, this.defaultLastName));
	}
	
	
	
	
	
	/* ******************* *
	 *  TESTS AUX LIMITES  *
	 * ******************* */
	
	@Test
	public void invalidUserNotAdded() {
		
		try {
			emptyBank.addUser(
					null, 
					this.defaultLastName, 
					this.defaultAge, this.defaultString, this.defaultPhone);
		} catch(NeoLynkBankException nbe) {
			//In order to avoid ambiguity in ouput, we don't log this exception.
		}

		Assert.assertTrue(emptyBank.getNumberOfUser()==0);
	}
	
	@Test(expected=NeoLynkBankException.class)
	public void addMoneyToNonExistingUserIsKO() throws NeoLynkBankException {
		emptyBank.deposite(this.defaultName, this.defaultLastName, 50);
	}
	
	@Test(expected=NeoLynkBankException.class)
	public void takeMoneyToNonExistingUserIsKO() throws NeoLynkBankException {
		emptyBank.withdraw(this.defaultName, this.defaultLastName, 50);
	}
	
	@Test(expected=NeoLynkBankException.class)
	public void addAccountToNonExistingUserIsKO() throws NeoLynkBankException {
		emptyBank.addNewAccount(this.defaultName, this.defaultLastName);
	}
}
