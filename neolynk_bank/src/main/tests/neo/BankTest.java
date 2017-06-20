package neo;

import org.junit.Assert;
import org.junit.Test;

public class BankTest {

	@Test
	public void getInitNumberOfUser() {
		Bank b = new Bank();
		Assert.assertEquals(0, b.getNumberOfUser());
	}
}
