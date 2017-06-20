package neo;

import org.junit.Assert;
import org.junit.Test;

public class BankTest {

	@Test
	public void getNumberOfUserInit() {
		Bank b = new Bank();
		Assert.assertEquals(0, b.getNumberOfUser());
	}
	
	@Test
	public void getNumberOfUserAfterAdd() {
		Bank b = new Bank();
		b.addUser();
		Assert.assertEquals(1, b.getNumberOfUser());
	}
	
	@Test
	public void getNumberOfUserAfterDelete() {
		Bank b = new Bank();
		b.addUser();
		b.deleteUser();
		Assert.assertEquals(0, b.getNumberOfUser());
	}
}
