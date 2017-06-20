package neo;

public class Bank {

	private int nbOfUser;
	
	public Bank() {
		this.nbOfUser = 0;
	}
	
	public int getNumberOfUser() {
		return this.nbOfUser;
	}
	
	public void addUser() {
		this.nbOfUser++;
	}
	
	public void deleteUser() {
		this.nbOfUser--;
	}
}
