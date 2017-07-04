package object;
import java.util.*;
public class Flight {
	private String FlightID;
	private String startTime;
	private String arrivalTime;
	private String startCity;
	private String arrivalCity;
	private int price;
	private int currentPassengers = 0;
	private int currentOrders = 0;
	private int seatCapacity;
	private String flightStatus = "UNPUBLISHED";
	
	private int[] passengerIDs;//存放乘客
	private Order[] orders;//存放订单
	
	private static int numOfHaveRegistered = 0;
	
	
	public Flight(String FlightID,String startTime,String arrivalTime,
			String startCity,String arrivalCity,
			int price,int seatCapacity){
		numOfHaveRegistered++;
		this.FlightID = FlightID;
		this.startTime = startTime;
		this.arrivalTime = arrivalTime;
		this.startCity = startCity;
		this.arrivalCity = arrivalCity;
		this.price = price;
		this.seatCapacity = seatCapacity;
		passengerIDs = new int[seatCapacity + 1];
		orders = new Order[seatCapacity * 2 + 1];//两倍航班容量是因为会有 取消状态订单
	}

	
	public String getFlightID() {
		return FlightID;
	}

	public void setFlightID(String flightID) {
		FlightID = flightID;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getStartCity() {
		return startCity;
	}

	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCurrentPassengers() {
		return currentPassengers;
	}
	
	public void setCurrentPassengers(int currentPassengers) {
		this.currentPassengers = currentPassengers;
	}

	public int getCurrentOrders() {
		return currentOrders;
	}

	public void setCurrentOrders(int currentOrders) {
		this.currentOrders = currentOrders;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	public String getFlightStatus() {
		return flightStatus;
	}

	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
	}

	public int[] getPassengerIDs() {
		return passengerIDs;
	}

	public void setPassengerIDs(int passengerID) {
		passengerIDs[++currentPassengers] = passengerID;
		statusChange();
	}
	
	public Order[] getOrders() {
		return orders;
	}

	public void setOrders(Order order) {
		orders[++currentOrders] = order;
		setPassengerIDs(order.getPassengerID());
	}

	public static int getNumOfHaveRegistered() {
		return numOfHaveRegistered;
	}
	//以上为getter与setter
	
	public void cancel(int passengerID){
		//乘客取消订单
		int i = 0;
		tab:for(i = 1;i <= currentPassengers;i++){
			if(passengerIDs[i] == passengerID){
				passengerIDs[i] = 0;
				break tab;
			}
		}
		for(int j = i; j < currentPassengers;j++){
			int temp = passengerIDs[j];
			passengerIDs[j] = passengerIDs[j + 1];
			passengerIDs[j + 1] = temp;
		}
		//移除取消订单乘客，并将之后乘客前移，填补缺漏
		currentPassengers--;
		statusChange();
	}
	
	public void statusChange(){
		//每次访问该对象时，执行来改变航班状态
		if(seatCapacity == currentPassengers) 
			flightStatus = "FULL";
		
		Date nowTime = new Date();
		long nowElapseTime = nowTime.getTime();
		long startElapseTime = nowElapseTime + 7200000;
		Date startTime = new Date(startElapseTime);
		if((startTime.toString().substring(3)).compareTo(this.startTime.substring(3)) >= 0)
			//比较从星期以后的字符（同一个月内都满足）
			flightStatus = "TERMINATE";
	}
}
