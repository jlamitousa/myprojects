package neo;

import java.util.Date;

public class Account {

	private Date creationDate;
	
	public Account() {
		this.creationDate = new Date();
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
		return 0;
	}	
}
