package object;

public class City {
	static final int maxOfCityFlight = 11;
	
	private String name;
	private static int numOfHaveRegistered = 0;
	private int numOfCityFlight = 0;
	private Flight[] cityFlightList = new Flight[maxOfCityFlight];//存储从该城市出发的航班
	
	public City(String name){
		numOfHaveRegistered++;
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setCityFlight(Flight flight){
		cityFlightList[++numOfCityFlight]= flight;
	}
	
	public static int getNumOfHaveRegistered() {
		return numOfHaveRegistered;
	}

	public int getNumOfCityFlight() {
		return numOfCityFlight;
	}

	public Flight[] getCityFlightList() {
		return cityFlightList;
	}
}
