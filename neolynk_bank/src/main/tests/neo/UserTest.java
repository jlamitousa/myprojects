package neo;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	private User u;
	
	@Before
	public void init() {
		this.u = new User("Jean-Luc", "Amitousa");
	}
	
	@Test
	public void createUserJeanLuc() {
		Assert.assertThat(u.getUserName(), IsEqual.equalTo("Jean-Luc"));
	}
	
	@Test
	public void renameUserToJeanMarc() {
		u.setUserName("Jean-Mark");
		Assert.assertThat(u.getUserName(), IsEqual.equalTo("Jean-Mark"));
	}
	
	@Test
	public void createUserWithLastnameJeanLuc() {
		Assert.assertThat(u.getUserLastName(), IsEqual.equalTo("Amitousa"));
	}
	
	@Test
	public void changeLastnameToMojito() {
		u.setUserLastname("Mojito");
		Assert.assertThat(u.getUserLastName(), IsEqual.equalTo("Mojito"));
	}
}
