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
	
	@Test
	public void checkNewAccountBalance() {
		Assert.assertEquals(0, a.getBalance());
	}
	
	@Test
	public void checkBalanceUpdate() {
		a.setBalance(10);
		Assert.assertEquals(10, a.getBalance());
	}
	
	
	
	
	
	/* ******************* *
	 *  TESTS AUX LIMITES  *
	 * ******************* */
	
	@Test(expected=NeoLynkBankException.class)
	public void updateToNullDateIsKO() throws NeoLynkBankException {
		a.setDateCreation(null);
	}
	
	@Test
	public void balanceUpdateToMax() {
		a.setBalance(Integer.MAX_VALUE);
		Assert.assertEquals(Integer.MAX_VALUE, a.getBalance());
	}
	
	@Test
	public void balanceUpdateToMin() {
		a.setBalance(Integer.MIN_VALUE);
		Assert.assertEquals(Integer.MIN_VALUE, a.getBalance());
	}
}
