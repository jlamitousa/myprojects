package neo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTest {

	Bank b;

	@Before
	public void init() {
		this.b = new Bank();
	}
	
	@Test
	public void getNumberOfUserInit() {
		Assert.assertEquals(0, b.getNumberOfUser());
	}
	
	@Test
	public void getNumberOfUserAfterAdd() {
		b.addUser();
		Assert.assertEquals(1, b.getNumberOfUser());
	}
	
	@Test
	public void getNumberOfUserAfterDelete() {
		b.addUser();
		b.deleteUser();
		Assert.assertEquals(0, b.getNumberOfUser());
	}
}
