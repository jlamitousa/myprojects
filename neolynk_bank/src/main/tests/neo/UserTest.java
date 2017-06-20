package neo;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	private User u;
	
	@Before
	public void init() {
		this.u = new User("Jean-Luc");
	}
	
	@Test
	public void createUserJeanLuc() {
		Assert.assertThat(u.getUsername(), IsEqual.equalTo("Jean-Luc"));
	}
	
	@Test
	public void renameUserToJeanMarc() {
		u.setUsername("Jean-Mark");
		Assert.assertThat(u.getUsername(), IsEqual.equalTo("Jean-Mark"));
	}
	
	@Test
	public void createUserWithLastnameJeanLuc() {
		Assert.assertThat(u.getUserLastname(), IsEqual.equalTo("Amitousa"));
	}
}
