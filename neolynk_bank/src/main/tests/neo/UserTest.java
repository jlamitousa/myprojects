package neo;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

public class UserTest {

	@Test
	public void createUserJeanLuc() {
		User u = new User("Jean-Luc");
		Assert.assertThat(u.getUsername(), IsEqual.equalTo("Jean-Luc"));
	}
}
