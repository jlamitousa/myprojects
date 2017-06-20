package neo;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	private User u;
	
	@Before
	public void init() {
		this.u = new User("Jean-Luc", "Amitousa", 10, "9, allée des rosiers 92230 Genneviliers, France");
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
	
	
	
	
	
	
	/* ******************* *
	 *  TESTS AUX LIMITES  *
	 * ******************* */
	//TODO
}
