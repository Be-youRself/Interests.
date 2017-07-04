package operation;
import object.*;
public class OrderSystem {
	
	static final int maxOfAdmin = 11;
	static final int maxOfMassenger = 501;
	static final int maxOfFlight = 101;
	static final int maxOfCity = 11;
	//约定最大管理员人数为10，最大乘客人数为500，最大航班数为100,最大城市数是10
	
	public static void main(String[] args){
		
		Admin[] admin = new Admin[maxOfAdmin];
		Passenger[] passenger = new Passenger[maxOfMassenger];
		Flight[] flight = new Flight[maxOfFlight];
		City[] city = new City[maxOfCity]; //后面会浪费下标为0的空间
		
		MainOperation main = new MainOperation();
		System.out.println("欢迎使用机票预订系统！");
		main.init(admin,passenger,flight,city);
	}
}
