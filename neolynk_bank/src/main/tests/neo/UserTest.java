package neo;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	private User u;
	private String bigString;
	private String defaultPhone;
	
	@Before
	public void init() throws NeoLynkBankException {
		this.bigString = "ce que dit cette phrase est faux. le kfc c'est bon. de lettres inutiles.";
		this.defaultPhone = "0102030405";
		this.u = new User("Jean-Luc", "Amitousa", 10, "9, allée des rosiers 92230 Genneviliers, France", "0605040302");
	}
	
	
	
	
	
	/* **************** *
	 *  TESTS BASIQUES  *
	 * **************** */
	
	@Test
	public void checkUserNameJeanLuc() {
		Assert.assertThat(u.getName(), IsEqual.equalTo("Jean-Luc"));
	}
	
	@Test
	public void renameUserToJeanMarc() {
		
		String name = "Jean-Mark";
		
		u.setName(name);
		Assert.assertThat(u.getName(), IsEqual.equalTo(name));
	}
	
	@Test
	public void checkUserLastnameJeanLuc() {
		Assert.assertThat(u.getLastName(), IsEqual.equalTo("Amitousa"));
	}
	
	@Test
	public void changeLastnameToMojito() {
		
		String lastName = "Mojito";
		
		u.setUserLastname(lastName);
		Assert.assertThat(u.getLastName(), IsEqual.equalTo(lastName));
	}
	
	@Test
	public void checkUserAge10() {
		Assert.assertThat(u.getAge(), IsEqual.equalTo(10));
	}
	
	@Test
	public void changeAgeTo12() {
		
		int age = 12;
		
		u.setUserAge(age);
		Assert.assertThat(u.getAge(), IsEqual.equalTo(age));
	}
	
	@Test
	public void checkUserAdress9AlleeDesRosiers() {
		Assert.assertThat(u.getAdresseDescription(), IsEqual.equalTo("9, allée des rosiers 92230 Genneviliers, France"));
	}
	
	@Test
	public void changeAdresseTo18rueHauteville() {
		
		String description = "18, rue d'hauteville 75010 Paris, France";
		
		u.setUserAdresseDescription(description);
		Assert.assertThat(u.getAdresseDescription(), IsEqual.equalTo(description));
	}
	
	@Test
	public void checkPhone0605040302() {
		Assert.assertThat(u.getPhone(), IsEqual.equalTo("0605040302"));
	}
	
	@Test
	public void changePhoneTo0102030405() {
		
		String phone = "0102030405";
		
		u.sePhone(phone);
		Assert.assertThat(u.getPhone(), IsEqual.equalTo(phone));
	}
	
	
	
	
	
	
	/* ******************* *
	 *  TESTS AUX LIMITES  *
	 * ******************* */
	
	@Test(expected=NeoLynkBankException.class)
	public void cannotInitializeNameNull() throws NeoLynkBankException {
		new User(null, "test", 1, "test", this.defaultPhone);
	}
	
	@Test(expected=NeoLynkBankException.class)
	public void cannotInitializeNameEmpty() throws NeoLynkBankException {
		new User("", "tet", 1, "test", this.defaultPhone);
	}
	
	@Test
	public void initializeBigName() throws NeoLynkBankException {
		User u = new User(this.bigString, "test", 1, "", "");
		Assert.assertEquals(this.bigString, u.getName());
	}
	
	@Test(expected=NeoLynkBankException.class)
	public void cannotInitializeLastNameNull() throws NeoLynkBankException {
		new User("Jean", null, 1, "test", this.defaultPhone);
	}
	
	@Test(expected=NeoLynkBankException.class)
	public void cannotInitializeLastNameEmpty() throws NeoLynkBankException {
		new User("Jean", "", 1, "test", this.defaultPhone);
	}
	
	@Test
	public void initializeBigLastName() throws NeoLynkBankException {
		User u = new User("test", this.bigString, 1, "", "");
		Assert.assertEquals(this.bigString, u.getLastName());
	}
	
	@Test(expected=NeoLynkBankException.class)
	public void cannotInitializeNegativeAge() throws NeoLynkBankException {
		new User("Jean", "test", -1, "test", this.defaultPhone);
	}
	
	@Test
	public void initializeAgeMax() throws NeoLynkBankException {
		User u = new User("Jean", "test", Integer.MAX_VALUE, "test", "0102030405");
		Assert.assertEquals(Integer.MAX_VALUE, u.getAge());
	}
	
	@Test
	public void nullAdresseIsPossible() throws NeoLynkBankException {
		User u = new User("Jean", "test", 10, null, "0102034005");
		Assert.assertEquals(null, u.getAdresseDescription());
	}
	
	@Test
	public void emptyAdresseIsPossible() throws NeoLynkBankException {
		User u = new User("Jean", "test", 10, "", this.defaultPhone);
		Assert.assertEquals("", u.getAdresseDescription());
	}
	
	@Test
	public void initializeBigAdresse() throws NeoLynkBankException {
		User u = new User("test", "test", 1, this.bigString, "");
		Assert.assertEquals(this.bigString, u.getAdresseDescription());
	}
	
	@Test
	public void nullPhoneIsPossible() throws NeoLynkBankException {
		User u = new User("Jean", "test", 10, "", null);
		Assert.assertEquals(null, u.getPhone());
	}
	
	@Test
	public void emptyPhoneIsPossible() throws NeoLynkBankException {
		User u = new User("Jean", "test", 10, "", "");
		Assert.assertEquals("", u.getPhone());
	}
	
	@Test
	public void phoneWithNumberOnlyIsOK() throws NeoLynkBankException {
		new User("Jean", "test", 10, "", "0605040302");
	}
	
	@Test(expected=NeoLynkBankException.class)
	public void phoneWithNonNumberOnlyIsKO() throws NeoLynkBankException {
		new User("Jean", "test", 10, "", "a6004+302");
	}
}
