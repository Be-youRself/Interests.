package object;
import java.util.*;
public class Order {
	private int passengerID;
	private String seat;
	private Flight flight;
	private Date createDate;
	private String status = "UNPAID";
	
	public Order(int passengerID,String seat,Flight flight){
		this.passengerID = passengerID;
		this.seat = seat;
		this.flight = flight;
		createDate = new Date();
	}
	
	
	public int getPassengerID() {
		return passengerID;
	}
	public void setPassengerID(int passengerID) {
		this.passengerID = passengerID;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	//以上是getter与setter	
}
