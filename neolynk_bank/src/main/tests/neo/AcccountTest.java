package neo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class AcccountTest {

	@Test
	public void checkNewAccountCreationDate() {
		
		Account a = new Account();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String now = sdf.format(new Date());
		String accountCreationDate = sdf.format(a.getCreationDate()); 
		
		Assert.assertEquals(now, accountCreationDate);
	}
}
