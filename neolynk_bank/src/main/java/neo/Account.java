package neo;

import java.util.Date;

public class Account {

	private Date creationDate;
	private int balance;
	
	public Account() {
		this.creationDate = new Date();
		this.balance = 0;
	}
	
	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setDateCreation(Date newDate) throws NeoLynkBankException {
		
		if(newDate==null) {
			throw new NeoLynkBankException("Invalid argument (null).");
		}
		
		this.creationDate = newDate;
	}

	public int getBalance() {
		return this.balance;
	}

	public void setBalance(int newBalance) {
		this.balance = newBalance;
	}	
}
