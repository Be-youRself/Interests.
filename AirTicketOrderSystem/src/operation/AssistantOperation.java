package operation;
import java.util.Date;

import object.*;
public class AssistantOperation {
	public static boolean checkPassword(String s){
		//验证密码是否符合要求
	    for (int i = 0; i < s.length(); i++) {
	        if (!Character.isLetter(s.charAt(i)) && 
	            !Character.isDigit(s.charAt(i)))
	          return false;
	      }
	      if (s.length() < 8)
	        return false;
	      int count = 0;
	      for (int i = 0; i < s.length(); i++) {
	        if (Character.isDigit(s.charAt(i)))
	          count++;
	      }
	      if (count >= 2)
	        return true;
	      else 
	        return false;
	}
	
	public static boolean checkUserName(Admin[] admin,String userName){
		//检验管理员用户名是否已经被注册
		for(int i = 1; i <= Admin.getNumOfHaveRegistered(); i++)
			if(userName.compareTo(admin[i].getUserName()) == 0) 
				return false;//即返回已被注册
		return true;//即返回未被注册
	}
	
	public static boolean checkIdentityID(Passenger[] passenger,String identityID){
		//检验管理员用户名是否已经被注册
		for(int i = 1; i <= Passenger.getNumOfHaveRegistered(); i++)
			if(identityID.compareTo(passenger[i].getIdentityID()) == 0) 
				return false;//即返回已被注册
		return true;//即返回未被注册
	}
	
	public static boolean checkFlight(Flight[] flight,String flightID){
		//检验航班是否存在
		for(int i = 1; i <= Flight.getNumOfHaveRegistered(); i++)
			if(flightID.compareTo(flight[i].getFlightID()) == 0) 
				return true;//即的确有此航班
		return false;//即没有此航班
	}
	
	public static boolean checkPassengerID(Flight[] flight,int flightNum,int passengerID){
		//检验一位乘客是否在同一航班预订多个座位
		for(int i = 1; i <= flight[flightNum].getCurrentPassengers(); i++)
			if(flight[flightNum].getPassengerIDs()[i] == passengerID) 
				return true;//即的预订多个座位
		return false;//即没有预订多个座位
	}
	
	public static boolean checkSeat(Flight[] flight,int num,String seat){
		//检验座位是否已被预订
		for(int i = 1; i <= flight[num].getCurrentOrders(); i++)
			if(seat.compareTo(flight[num].getOrders()[i].getSeat()) == 0 
			&& flight[num].getOrders()[i].getStatus().compareTo("CANCEL") != 0) 
				return false;//此座位已被预订
		return true;//即座位空闲
	}
	
	public static boolean checkStartTime(String startTime){
		//检验起飞时间是否比现在晚两个小时
		Date nowTime = new Date();
		long nowElapseTime = nowTime.getTime();
		long startElapseTime = nowElapseTime + 7200000;
		Date startTime1 = new Date(startElapseTime);
		if((startTime1.toString().substring(3)).compareTo(startTime.substring(3)) >= 0)
			return false;//起飞时间在两小时之内（包括两小时）
		else 
			return true;//起飞时间在两小时后
	}
	
	public static boolean checkArrivalTime(String startTime,String arrivalTime){
		//检验到达时间是否晚于起飞时间
		if((arrivalTime.toString().substring(3)).compareTo(startTime.substring(3)) > 0)
			return true;//到达时间晚于起飞时间
		else 
			return false;//到达时间早于或等于起飞时间
	}
	
	public static boolean checkCity(City[] city,String name){
		//检验城市是否支持设置航班
		for(int i = 1; i <= City.getNumOfHaveRegistered(); i++)
			if(name.compareTo(city[i].getName()) == 0) 
				return true;//该城市支持设置航班
		return false;//该城市不支持设置航班
	}
	
	public static int backObject(Admin[] admin, String userName){
		//根据用户名返回管理员对象下标
		int i = 0;
		tab:for(i = 1; i <= Admin.getNumOfHaveRegistered(); i++)
			if(userName.compareTo(admin[i].getUserName()) == 0) break tab;
		return i;
	}
	public static int backObject(City[] city, String name){
		//根据城市名名返回城市对象下标
		int i = 0;
		tab:for(i = 1; i <= City.getNumOfHaveRegistered(); i++)
			if(name.compareTo(city[i].getName()) == 0) break tab;
		return i;
	}
	public static int backObject(Flight[] flight, String flightID){
		//根据航班号名返回航班对象下标
		int i = 0;
		tab:for(i = 1; i <= Flight.getNumOfHaveRegistered(); i++)
			if(flightID.compareTo(flight[i].getFlightID()) == 0) break tab;
		return i;
	}
}
