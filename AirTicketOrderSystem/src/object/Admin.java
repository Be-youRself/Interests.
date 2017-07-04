package object;

public class Admin {
	private String userName ;
	private String password ;
	private static int numOfHaveRegistered = 0;
	
	public Admin(String userName,String password){
		numOfHaveRegistered++;
		this.userName = userName;
		this.password = password;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public static int getNumOfHaveRegistered() {
		return numOfHaveRegistered;
	}
}
