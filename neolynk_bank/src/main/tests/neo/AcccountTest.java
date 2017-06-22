package neo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AcccountTest {

	Account a;
	SimpleDateFormat sdf;
	
	@Before
	public void init() {
		this.a = new Account();
		this.sdf = new SimpleDateFormat("dd/MM/yyyy");
	}
	
	
	

	
	/* **************** *
	 *  TESTS BASIQUES  *
	 * **************** */
	
	@Test
	public void checkNewAccountCreationDate() {
		
		String now = sdf.format(new Date());
		String accountCreationDate = sdf.format(a.getCreationDate()); 
		
		Assert.assertEquals(now, accountCreationDate);
	}
	
	@Test
	public void checkDateCreationUpdate() throws ParseException, NeoLynkBankException {
		
		String newDateStr = "22/06/2017";
		Date newDate = sdf.parse(newDateStr);
		String accountCreationDate = null; 
		
		a.setDateCreation(newDate);
		accountCreationDate = sdf.format(a.getCreationDate());
		
		Assert.assertEquals(newDateStr, accountCreationDate);
	}
	
	
	
	
	
	/* ******************* *
	 *  TESTS AUX LIMITES  *
	 * ******************* */
	
	@Test(expected=NeoLynkBankException.class)
	public void updateToNullDateIsKO() throws NeoLynkBankException {
		a.setDateCreation(null);
	}
}
