package neo;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	private User u;
	
	@Before
	public void init() {
		this.u = new User("Jean-Luc", "Amitousa", 10);
	}
	
	@Test
	public void checkUserNameJeanLuc() {
		Assert.assertThat(u.getName(), IsEqual.equalTo("Jean-Luc"));
	}
	
	@Test
	public void renameUserToJeanMarc() {
		u.setName("Jean-Mark");
		Assert.assertThat(u.getName(), IsEqual.equalTo("Jean-Mark"));
	}
	
	@Test
	public void checkUserLastnameJeanLuc() {
		Assert.assertThat(u.getLastName(), IsEqual.equalTo("Amitousa"));
	}
	
	@Test
	public void changeLastnameToMojito() {
		u.setUserLastname("Mojito");
		Assert.assertThat(u.getLastName(), IsEqual.equalTo("Mojito"));
	}
	
	@Test
	public void checkUserAge10() {
		Assert.assertThat(u.getAge(), IsEqual.equalTo(10));
	}
	
	@Test
	public void changeAgeTo12() {
		u.setUserAge(12);
		Assert.assertThat(u.getAge(), IsEqual.equalTo(12));
	}
	
	@Test
	public void checkUserAdress9AlleeDesRosiers() {
		Assert.assertThat(u.getAdresseDescription(), IsEqual.equalTo("9, allée des rosiers 92230 Genneviliers, France"));
	}
}
