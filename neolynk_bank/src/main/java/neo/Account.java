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

	public void setDateCreation(Date newDate) {
		this.creationDate = newDate;
	}	
}
