package object;

public class Passenger {
	static final int maxOfPassengerOrder = 101;
	
	private int passengerID;
	private String realName;
	private String identityID;
	private String password;
	
	private int currentOrders = 0;
	private Order[] passengerOrders = new Order[maxOfPassengerOrder];
	
	//订单列表
	private static int numOfHaveRegistered = 0;
	
	public Passenger(String realName,String identityID,String password){
		numOfHaveRegistered++;
		passengerID = numOfHaveRegistered;
		this.realName = realName;
		this.identityID = identityID;
		this.password = password;
	}
	
	public int getPassengerID() {
		return passengerID;
	}

	public String getRealName() {
		return realName;
	}

	public String getIdentityID() {
		return identityID;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getCurrentOrders() {
		return currentOrders;
	}

	public void setCurrentOrders(int currentOrders) {
		this.currentOrders = currentOrders;
	}
	
	public Order[] getPassengerOrders() {
		return passengerOrders;
	}

	public void setPassengerOrders(Order order) {
		passengerOrders[++currentOrders] = order;
	}


	public static int getNumOfHaveRegistered() {
		return numOfHaveRegistered;
	}
}
