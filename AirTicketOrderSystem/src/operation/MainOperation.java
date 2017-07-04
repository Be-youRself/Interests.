package operation;

import java.util.*;
import object.*;

public class MainOperation {
	static String originalKey = "OrderSystem";// 设置管理员密钥

	public void init(Admin[] admin, Passenger[] passenger, Flight[] flight, City[] city) {
		// 按题目所给要求进行初始化
		City city1 = new City("西安");
		city[City.getNumOfHaveRegistered()] = city1;
		City city2 = new City("北京");
		city[City.getNumOfHaveRegistered()] = city2;
		City city3 = new City("深圳");
		city[City.getNumOfHaveRegistered()] = city3;
		// 初始化三座城市

		Flight flight1 = new Flight("XTB001", "Tue May 28 10:25:00 CST 2017", "Tue May 28 11:25:00 CST 2017", "西安",
				"北京", 1000, 100);
		flight[Flight.getNumOfHaveRegistered()] = flight1;
		city[AssistantOperation.backObject(city, flight[Flight.getNumOfHaveRegistered()].getStartCity())]
				.setCityFlight(flight[Flight.getNumOfHaveRegistered()]);// 将航班绑定到出发城市
		
		Flight flight2 = new Flight("BTX001", "Tue May 28 11:25:00 CST 2017", "Tue May 28 12:25:00 CST 2017", "北京",
				"西安", 1000, 100);
		flight[Flight.getNumOfHaveRegistered()] = flight2;
		city[AssistantOperation.backObject(city, flight[Flight.getNumOfHaveRegistered()].getStartCity())]
				.setCityFlight(flight[Flight.getNumOfHaveRegistered()]);// 将航班绑定到出发城市

		Flight flight3 = new Flight("XTS001", "Tue May 28 15:25:00 CST 2017", "Tue May 28 19:25:00 CST 2017", "西安",
				"深圳", 3000, 100);
		flight[Flight.getNumOfHaveRegistered()] = flight3;
		city[AssistantOperation.backObject(city, flight[Flight.getNumOfHaveRegistered()].getStartCity())]
				.setCityFlight(flight[Flight.getNumOfHaveRegistered()]);// 将航班绑定到出发城市

		Flight flight4 = new Flight("STX001", "Tue May 28 08:25:00 CST 2017", "Tue May 28 12:25:00 CST 2017", "深圳",
				"西安", 3000, 100);
		flight[Flight.getNumOfHaveRegistered()] = flight4;
		city[AssistantOperation.backObject(city, flight[Flight.getNumOfHaveRegistered()].getStartCity())]
				.setCityFlight(flight[Flight.getNumOfHaveRegistered()]);// 将航班绑定到出发城市

		Flight flight5 = new Flight("STB001", "Tue May 28 06:25:00 CST 2017", "Tue May 28 09:25:00 CST 2017", "深圳",
				"北京", 2000, 100);
		flight[Flight.getNumOfHaveRegistered()] = flight5;
		city[AssistantOperation.backObject(city, flight[Flight.getNumOfHaveRegistered()].getStartCity())]
				.setCityFlight(flight[Flight.getNumOfHaveRegistered()]);// 将航班绑定到出发城市

		Flight flight6 = new Flight("BTS001", "Tue May 28 17:25:00 CST 2017", "Tue May 28 20:25:00 CST 2017", "北京",
				"深圳", 2000, 100);
		flight[Flight.getNumOfHaveRegistered()] = flight6;
		city[AssistantOperation.backObject(city, flight[Flight.getNumOfHaveRegistered()].getStartCity())]
				.setCityFlight(flight[Flight.getNumOfHaveRegistered()]);// 将航班绑定到出发城市
		// 初始化第一天航班

		Flight flight7 = new Flight("XTB002", "Tue May 29 10:25:00 CST 2017", "Tue May 29 11:25:00 CST 2017", "西安",
				"北京", 1000, 100);
		flight[Flight.getNumOfHaveRegistered()] = flight7;
		city[AssistantOperation.backObject(city, flight[Flight.getNumOfHaveRegistered()].getStartCity())]
				.setCityFlight(flight[Flight.getNumOfHaveRegistered()]);// 将航班绑定到出发城市
		
		Flight flight8 = new Flight("BTX002", "Tue May 29 11:25:00 CST 2017", "Tue May 29 12:25:00 CST 2017", "北京",
				"西安", 1000, 100);
		flight[Flight.getNumOfHaveRegistered()] = flight8;
		city[AssistantOperation.backObject(city, flight[Flight.getNumOfHaveRegistered()].getStartCity())]
				.setCityFlight(flight[Flight.getNumOfHaveRegistered()]);// 将航班绑定到出发城市

		Flight flight9 = new Flight("XTS002", "Tue May 29 15:25:00 CST 2017", "Tue May 29 19:25:00 CST 2017", "西安",
				"深圳", 3000, 100);
		flight[Flight.getNumOfHaveRegistered()] = flight9;
		city[AssistantOperation.backObject(city, flight[Flight.getNumOfHaveRegistered()].getStartCity())]
				.setCityFlight(flight[Flight.getNumOfHaveRegistered()]);// 将航班绑定到出发城市

		Flight flight10 = new Flight("STX002", "Tue May 29 08:25:00 CST 2017", "Tue May 29 12:25:00 CST 2017", "深圳",
				"西安", 3000, 100);
		flight[Flight.getNumOfHaveRegistered()] = flight10;
		city[AssistantOperation.backObject(city, flight[Flight.getNumOfHaveRegistered()].getStartCity())]
				.setCityFlight(flight[Flight.getNumOfHaveRegistered()]);// 将航班绑定到出发城市

		Flight flight11 = new Flight("STB002", "Tue May 29 06:25:00 CST 2017", "Tue May 29 09:25:00 CST 2017", "深圳",
				"北京", 2000, 100);
		flight[Flight.getNumOfHaveRegistered()] = flight11;
		city[AssistantOperation.backObject(city, flight[Flight.getNumOfHaveRegistered()].getStartCity())]
				.setCityFlight(flight[Flight.getNumOfHaveRegistered()]);// 将航班绑定到出发城市

		Flight flight12 = new Flight("BTS002", "Tue May 30 17:25:00 CST 2017", "Tue May 30 20:25:00 CST 2017", "北京",
				"深圳", 2000, 100);
		flight[Flight.getNumOfHaveRegistered()] = flight12;
		city[AssistantOperation.backObject(city, flight[Flight.getNumOfHaveRegistered()].getStartCity())]
				.setCityFlight(flight[Flight.getNumOfHaveRegistered()]);// 将航班绑定到出发城市
		// 初始化第二天航班

		Flight flight13 = new Flight("XTB003", "Tue May 30 10:25:00 CST 2017", "Tue May 30 11:25:00 CST 2017", "西安",
				"北京", 1000, 100);
		flight[Flight.getNumOfHaveRegistered()] = flight13;
		city[AssistantOperation.backObject(city, flight[Flight.getNumOfHaveRegistered()].getStartCity())]
				.setCityFlight(flight[Flight.getNumOfHaveRegistered()]);// 将航班绑定到出发城市
		
		Flight flight14 = new Flight("BTX003", "Tue May 30 11:25:00 CST 2017", "Tue May 30 12:25:00 CST 2017", "北京",
				"西安", 1000, 100);
		flight[Flight.getNumOfHaveRegistered()] = flight14;
		city[AssistantOperation.backObject(city, flight[Flight.getNumOfHaveRegistered()].getStartCity())]
				.setCityFlight(flight[Flight.getNumOfHaveRegistered()]);// 将航班绑定到出发城市

		Flight flight15 = new Flight("XTS003", "Tue May 30 15:25:00 CST 2017", "Tue May 30 19:25:00 CST 2017", "西安",
				"深圳", 3000, 100);
		flight[Flight.getNumOfHaveRegistered()] = flight15;
		city[AssistantOperation.backObject(city, flight[Flight.getNumOfHaveRegistered()].getStartCity())]
				.setCityFlight(flight[Flight.getNumOfHaveRegistered()]);// 将航班绑定到出发城市

		Flight flight16 = new Flight("STX003", "Tue May 30 08:25:00 CST 2017", "Tue May 30 12:25:00 CST 2017", "深圳",
				"西安", 3000, 100);
		flight[Flight.getNumOfHaveRegistered()] = flight16;
		city[AssistantOperation.backObject(city, flight[Flight.getNumOfHaveRegistered()].getStartCity())]
				.setCityFlight(flight[Flight.getNumOfHaveRegistered()]);// 将航班绑定到出发城市

		Flight flight17 = new Flight("STB003", "Tue May 30 06:25:00 CST 2017", "Tue May 30 09:25:00 CST 2017", "深圳",
				"北京", 2000, 100);
		flight[Flight.getNumOfHaveRegistered()] = flight17;
		city[AssistantOperation.backObject(city, flight[Flight.getNumOfHaveRegistered()].getStartCity())]
				.setCityFlight(flight[Flight.getNumOfHaveRegistered()]);// 将航班绑定到出发城市

		Flight flight18 = new Flight("BTS003", "Tue May 30 17:25:00 CST 2017", "Tue May 30 20:25:00 CST 2017", "北京",
				"深圳", 2000, 100);
		flight[Flight.getNumOfHaveRegistered()] = flight18;
		city[AssistantOperation.backObject(city, flight[Flight.getNumOfHaveRegistered()].getStartCity())]
				.setCityFlight(flight[Flight.getNumOfHaveRegistered()]);// 将航班绑定到出发城市
		// 初始化第三天航班
		menu1(admin, passenger, flight,city);
	}

	public void menu1(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city) {
		// 打印初始菜单
		System.out.println("1、乘客身份登录");
		System.out.println("2、管理员身份登录");
		System.out.println("3、只是查看航班列表，暂时不登录");
		System.out.println("4、我要注册");
		System.out.println("5、退出");
		choose1(admin, passenger, flight,city);
	}
    public void choose1(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city) {
		// 初始菜单的选择
		System.out.print("请输入指令：");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String order = input.next();
		System.out.println();
		switch (order) {
		case "1":
			passengerLogin(admin, passenger, flight,city);
			break;
		case "2":
			adminLogin(admin, passenger, flight,city);
			break;
		case "3":
			queryFlightList(admin, passenger, flight,city);
			break;
		case "4":
			register(admin, passenger, flight,city);
			break;
		case "5":
			System.exit(0);
		default:
			System.out.println("输入指令不正确！请重新输入！");
			choose1(admin, passenger, flight,city);
		}
	}

	public void register(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city) {
		// 注册新用户入口（注册菜单）
		System.out.println("1、我想注册乘客");
		System.out.println("2、我想注册管理员");
		System.out.println("3、返回上一级");
		choose2(admin, passenger, flight,city);
	}
	public void choose2(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city) {
		// 选择想要注册账号类型
		System.out.print("请输入指令：");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String order = input.next();
		System.out.println();
		switch (order) {
		case "1":
			passengerRegister(admin, passenger, flight,city);
			break;
		case "2":
			adminRegister(admin, passenger, flight,city);
			break;
		case "3":
			menu1(admin, passenger, flight,city);
		default:
			System.out.println("输入指令不正确！请重新输入！");
			choose2(admin, passenger, flight,city);
		}
	}

	public void passengerRegister(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city) {
		// 注册乘客
		System.out.print("请输入真实姓名：");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String realName = input.nextLine();
		System.out.print("请输入身份证号码：");
		String identityID = input.nextLine();
		if(!AssistantOperation.checkIdentityID(passenger, identityID)){
			//确保一个身份证只能注册一个乘客账号
			System.out.println("该身份证已被注册！现已退回初始菜单！");
			menu1(admin,passenger,flight,city);
		}
		else{
			String password = "";
			String password1 = "";
			int tab1 = 0, tab2 = 0;
			do {
				if (tab1 != 0)
					System.out.println("两次输入的密码不一致！");
				do {
					if (tab2 != 0)
						System.out.println("设置密码不符合要求！请重新设置！");
					System.out.println("请设置密码:");
					System.out.println("要求：");
					System.out.println("1.密码至少8位字符");
					System.out.println("2.仅能包含字母和数字");
					System.out.println("3.至少包含两个数字");
					password = input.nextLine();
					tab2++;
				} while (!AssistantOperation.checkPassword(password));
				System.out.print("请确认密码：");
				password1 = input.nextLine();
				tab1++;
			} while (password.compareTo(password1) != 0);
			Passenger passenger1 = new Passenger(realName, identityID, password);
			passenger[Passenger.getNumOfHaveRegistered()] = passenger1;
			System.out.println("注册乘客成功！");
			System.out.println("您的乘客编号为：" + passenger[Passenger.getNumOfHaveRegistered()].getPassengerID());
			System.out.println("请牢记乘客编号与密码！");
			System.out.println();
			menu1(admin, passenger, flight,city);
		}
	}
	public void adminRegister(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city) {
		// 注册管理员
		System.out.print("请输入注册管理员所需密钥：");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String key = input.nextLine();
		if (key.compareTo(originalKey) != 0) {
			// 核对输入秘钥是否正确
			System.out.println("输入密钥不正确！非管理人员请勿注册管理员！已退回！");
			register(admin, passenger, flight,city);
		} else {
			int tab3 = 0;
			String userName = "";
			do {
				if (tab3 != 0)
					System.out.println("输入的用户名已被注册！请重新输入！");
				System.out.print("请输入想要注册的用户名：");
				userName = input.nextLine();
				tab3++;
			} while (!AssistantOperation.checkUserName(admin, userName));
			String password = "";
			String password1 = "";
			int tab1 = 0, tab2 = 0;
			do {
				if (tab1 != 0)
					System.out.println("两次输入的密码不一致！");
				do {
					if (tab2 != 0)
						System.out.println("设置密码不符合要求！请重新设置！");
					System.out.println("请设置密码:");
					System.out.println("要求：");
					System.out.println("1.密码至少8位字符");
					System.out.println("2.仅能包含字母和数字");
					System.out.println("3.至少包含两个数字");
					password = input.nextLine();
					tab2++;
				} while (!AssistantOperation.checkPassword(password));
				System.out.print("请确认密码：");
				password1 = input.nextLine();
				tab1++;
			} while (password.compareTo(password1) != 0);
			Admin admin1 = new Admin(userName, password);
			admin[Admin.getNumOfHaveRegistered()] = admin1;
			System.out.println("注册管理员成功！请牢记用户名与密码！");
			System.out.println();
			menu1(admin, passenger, flight,city);
		}
	}

	
	public void passengerLogin(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int passengerID = 0;
		int tab1 = 0;
		try {
			do {
				if (tab1 != 0)
					System.out.println("输入乘客编号有误！请重新输入！");
				System.out.print("请输入乘客编号：");
				passengerID = input.nextInt();
				tab1++;
			} while (passengerID > Passenger.getNumOfHaveRegistered() || passengerID < 1);
		} catch (InputMismatchException e1) {
			input.next();// 吃掉输入编号后的回车
			System.out.println("输入乘客编号有误！请按正确形式输入！否则程序将直接退出！");
			tab1 = 0;
			try {
				do {
					if (tab1 != 0)
						System.out.println("输入乘客编号有误！请重新输入！");
					System.out.print("请输入乘客编号：");
					passengerID = input.nextInt();
					tab1++;
				} while (passengerID > Passenger.getNumOfHaveRegistered() || passengerID < 1);
			} catch (InputMismatchException e2) {
				System.out.println("程序已自动退出！");
				System.exit(0);
			}
		}
		input.nextLine();// 吃掉输入编号后的回车
		System.out.print("请输入密码：");
		String password = input.nextLine();
		if (password.compareTo(passenger[passengerID].getPassword()) == 0) {
			System.out.println("乘客登录成功！");
			System.out.println();
			passengerMenu(admin, passenger, flight,city, passengerID);
		} else {
			System.out.println("输入密码有误！登录失败！");
			System.out.println("是否想要找回密码？ 1、是,我要找回密码  2、否，我要重新登录  3、返回初始菜单");
			String order = input.next();
			switch (order) {
			case "1":
				findPassword(admin, passenger, flight,city, passengerID);
				break;
			case "2":
				passengerLogin(admin, passenger, flight,city);
				break;
			case "3":
				menu1(admin, passenger, flight,city);
				break;
			default:
				System.out.println("输入指令有误！！");
				passengerLogin(admin, passenger, flight,city);
			}
		}
	}

	public void findPassword(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city, int passengerID) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("请输入真实姓名：");
		String realName = input.nextLine();
		System.out.print("请输入身份证号码：");
		String identityID = input.nextLine();
		if (realName.compareTo(passenger[passengerID].getRealName()) == 0
				&& identityID.compareTo(passenger[passengerID].getIdentityID()) == 0) {
			String password = "";
			String password1 = "";
			int tab1 = 0, tab2 = 0;
			do {
				if (tab1 != 0)
					System.out.println("两次输入的密码不一致！");
				do {
					if (tab2 != 0)
						System.out.println("设置密码不符合要求！请重新设置！");
					System.out.println("请设置新密码:");
					System.out.println("要求：");
					System.out.println("1.密码至少8位字符");
					System.out.println("2.仅能包含字母和数字");
					System.out.println("3.至少包含两个数字");
					password = input.nextLine();
					tab2++;
				} while (!AssistantOperation.checkPassword(password));
				System.out.print("请确认密码：");
				password1 = input.nextLine();
				tab1++;
			} while (password.compareTo(password1) != 0);
			passenger[passengerID].setPassword(password);
			System.out.println("找回密码成功！已返回乘客登录菜单！");
			passengerLogin(admin,passenger,flight,city);
			System.out.println();
		} else {
			System.out.println("输入信息不正确！请重试！");
			System.out.print("是否想返回主菜单？(按 0 返回，按 1 继续)");
			int order = input.nextInt();
			if (order == 0)
				menu1(admin, passenger, flight,city);
			else
				findPassword(admin, passenger, flight,city, passengerID);
		}
	}

	public void adminLogin(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String userName = "";
		int tab1 = 0;
		do {
			if (tab1 != 0)
				System.out.println("输入用户名不存在！请重新输入！");
			System.out.print("请输入用户名：");
			userName = input.nextLine();
			tab1++;
		} while (AssistantOperation.checkUserName(admin, userName));
		System.out.print("请输入密码：");
		String password = input.nextLine();
		if (password.compareTo(admin[AssistantOperation.backObject(admin, userName)].getPassword()) == 0) {
			System.out.println("管理员登录成功！");
			System.out.println();
			int adminNum = AssistantOperation.backObject(admin, userName);
            adminMenu(admin,passenger,flight,city,adminNum);
		} else {
			System.out.println("输入密码有误！登录失败！");
			System.out.println("是否想要找回密码？ 1、是,我要找回密码  2、否，我要重新登录  3、返回初始菜单");
			String order = input.next();
			switch (order) {
			case "1":
				findPassword(admin, passenger, flight,city, userName);
				break;
			case "2":
				adminLogin(admin, passenger, flight,city);
				break;
			case "3":
				menu1(admin, passenger, flight,city);
				break;
			default:
				System.out.println("输入指令有误！！");
				adminLogin(admin, passenger, flight,city);
			}
		}
	}

	public void findPassword(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city, String userName) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("请输入管理员密钥：");
		String key = input.nextLine();
		if (key.compareTo(originalKey) == 0) {
			String password = "";
			String password1 = "";
			int tab1 = 0, tab2 = 0;
			do {
				if (tab1 != 0)
					System.out.println("两次输入的密码不一致！");
				do {
					if (tab2 != 0)
						System.out.println("设置密码不符合要求！请重新设置！");
					System.out.println("请设置新密码:");
					System.out.println("要求：");
					System.out.println("1.密码至少8位字符");
					System.out.println("2.仅能包含字母和数字");
					System.out.println("3.至少包含两个数字");
					password = input.nextLine();
					tab2++;
				} while (!AssistantOperation.checkPassword(password));
				System.out.print("请确认密码：");
				password1 = input.nextLine();
				tab1++;
			} while (password.compareTo(password1) != 0);
			admin[AssistantOperation.backObject(admin, userName)].setPassword(password);
			System.out.println("找回密码成功！已返回管理员登录菜单！");
			adminLogin(admin,passenger,flight,city);
			System.out.println();
		} else {
			System.out.println("输入密钥不正确！请重试！");
			System.out.print("是否想返回初始菜单？(按 0 返回，按 1 继续)");
			int order = input.nextInt();
			if (order == 0)
				menu1(admin, passenger, flight,city);
			else
				findPassword(admin, passenger, flight,city, userName);
		}
	}

	
	// 游客功能
	public void queryFlightList(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city) {
		// 打印航班列表
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("航班列表如下:");
		System.out.println(
				"航班号                         起飞时间                                          到达时间                            起飞城市       到达城市      价格         当前预定人数       可载最大人数               航班状态");
		for (int i = 1; i <= Flight.getNumOfHaveRegistered(); i++) {
			if(flight[i] != null){
				flight[i].statusChange();// 刷新航班状态
				System.out.printf(
						"%s   %s   %s        %s             %s        %5d        %3d             %3d             %s\n",
						flight[i].getFlightID(), flight[i].getStartTime(), flight[i].getArrivalTime(),
						flight[i].getStartCity(), flight[i].getArrivalCity(), flight[i].getPrice(),
						flight[i].getCurrentPassengers(), flight[i].getSeatCapacity(), flight[i].getFlightStatus());
			}
		}
		System.out.println();
		commonQuery(flight);
		System.out.println();
		System.out.println("按任意键可返回初始菜单");
		input.next();
		menu1(admin, passenger, flight,city);
	}
	public void commonQuery(Flight[] flight){
		//普通按项目查找
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("您可以选择按项目查找");
		System.out.println("1、航班号");
	    System.out.println("2、起飞城市");
	    System.out.println("3、到达城市");
	    System.out.println("4、航班价格");
	    System.out.println("5、起飞时间");
	    System.out.println("6、放弃按项目查找");
	    System.out.print("请输入指令：");
		String order = input.nextLine();
		System.out.println();
		switch (order) {
		case "1":
			System.out.print("请输入想要查询的航班号：");
			String flightID = input.nextLine();
			if(AssistantOperation.checkFlight(flight,flightID)){
				int i = AssistantOperation.backObject(flight, flightID);
				System.out.println("航班信息如下:");
				System.out.println(
						"航班号                         起飞时间                                          到达时间                            起飞城市       到达城市      价格         当前预定人数       可载最大人数               航班状态");
				flight[i].statusChange();// 刷新航班状态
				System.out.printf(
						"%s   %s   %s        %s             %s        %5d        %3d             %3d             %s\n",
						flight[i].getFlightID(), flight[i].getStartTime(), flight[i].getArrivalTime(),
						flight[i].getStartCity(), flight[i].getArrivalCity(), flight[i].getPrice(),
						flight[i].getCurrentPassengers(), flight[i].getSeatCapacity(), flight[i].getFlightStatus());
			}
			else
				System.out.println("未查询到该航班！");
			break;
		case "2":
			System.out.print("请输入想要查询航班的起飞城市：");
			String startCity = input.nextLine();
			int num1 = 0;
			System.out.println("航班信息如下:");
			System.out.println(
					"航班号                         起飞时间                                          到达时间                            起飞城市       到达城市      价格         当前预定人数       可载最大人数               航班状态");
			for(int i = 1; i <= Flight.getNumOfHaveRegistered(); i++){
				flight[i].statusChange();// 刷新航班状态
				if(flight[i].getStartCity().compareTo(startCity) == 0){
					System.out.printf(
							"%s   %s   %s        %s             %s        %5d        %3d             %3d             %s\n",
							flight[i].getFlightID(), flight[i].getStartTime(), flight[i].getArrivalTime(),
							flight[i].getStartCity(), flight[i].getArrivalCity(), flight[i].getPrice(),
							flight[i].getCurrentPassengers(), flight[i].getSeatCapacity(), flight[i].getFlightStatus());
					num1++;
				}
			}
			if(num1 == 0)
				System.out.println("没有查询到符合条件的航班！");
			System.out.println();
			break;
		case "3":
			System.out.print("请输入想要查询航班的到达城市：");
			String arrivalCity = input.nextLine();
			int num2 = 0;
			System.out.println("航班信息如下:");
			System.out.println(
					"航班号                         起飞时间                                          到达时间                            起飞城市       到达城市      价格         当前预定人数       可载最大人数               航班状态");
			for(int i = 1; i <= Flight.getNumOfHaveRegistered(); i++){
				flight[i].statusChange();// 刷新航班状态
				if(flight[i].getArrivalCity().compareTo(arrivalCity) == 0){
					System.out.printf(
							"%s   %s   %s        %s             %s        %5d        %3d             %3d             %s\n",
							flight[i].getFlightID(), flight[i].getStartTime(), flight[i].getArrivalTime(),
							flight[i].getStartCity(), flight[i].getArrivalCity(), flight[i].getPrice(),
							flight[i].getCurrentPassengers(), flight[i].getSeatCapacity(), flight[i].getFlightStatus());
					num2++;
				}
			}
			if(num2 == 0)
				System.out.println("没有查询到符合条件的航班！");
			System.out.println();
			break;
		case "4":
			System.out.print("你可以查询输入价格以内的航班，请输入想要的价格：");
			int tab;
			int price = 0;
			try {
				tab = 0;
				do {
					if (tab != 0)
						System.out.println("输入价格有误！请重新输入！");
					System.out.print("请输入航班价格：");
					price = input.nextInt();
					tab++;
				} while (price <= 0);//价格为正数
			} catch (InputMismatchException e1) {
				input.next();// 吃掉输入编号后的回车
				System.out.println("输入价格有误！请按正确形式输入！否则程序将直接退出！");
				tab = 0;
				try {
					do {
						if (tab != 0)
							System.out.println("输入价格有误！请重新输入！");
						System.out.print("请输入航班价格：");
						price = input.nextInt();
						tab++;
					} while (price <= 0);
				} catch (InputMismatchException e2) {
					System.out.println("程序已自动退出！");
					System.exit(0);
				}
			}
			int num3 = 0;
			System.out.println("航班信息如下:");
			System.out.println(
					"航班号                         起飞时间                                          到达时间                            起飞城市       到达城市      价格         当前预定人数       可载最大人数               航班状态");
			for(int i = 1; i <= Flight.getNumOfHaveRegistered(); i++){
				flight[i].statusChange();// 刷新航班状态
				if(flight[i].getPrice() <= price){
					System.out.printf(
							"%s   %s   %s        %s             %s        %5d        %3d             %3d             %s\n",
							flight[i].getFlightID(), flight[i].getStartTime(), flight[i].getArrivalTime(),
							flight[i].getStartCity(), flight[i].getArrivalCity(), flight[i].getPrice(),
							flight[i].getCurrentPassengers(), flight[i].getSeatCapacity(), flight[i].getFlightStatus());
					num3++;
				}
			}
			if(num3 == 0)
				System.out.println("没有查询到符合条件的航班！");
			System.out.println();
			break;
		case "5":
			System.out.println("请输入想要查询的起飞时间，将显示起飞时间以前的所有航班:");
			System.out.println("注意！时间设置必须按照  Tue May 18 10:25:00 CST 2017 格式！！！");
			String startTime = input.nextLine();
			int num4 = 0;
			for(int i = 1; i <= Flight.getNumOfHaveRegistered(); i++){
				flight[i].statusChange();// 刷新航班状态
				if(AssistantOperation.checkArrivalTime(flight[i].getStartTime(), startTime)){
					System.out.printf(
							"%s   %s   %s        %s             %s        %5d        %3d             %3d             %s\n",
							flight[i].getFlightID(), flight[i].getStartTime(), flight[i].getArrivalTime(),
							flight[i].getStartCity(), flight[i].getArrivalCity(), flight[i].getPrice(),
							flight[i].getCurrentPassengers(), flight[i].getSeatCapacity(), flight[i].getFlightStatus());
					num4++;
				}
			}
			if(num4 == 0)
				System.out.println("没有查询到符合条件的航班！");
			System.out.println();
			break;
		case "6":
			break;
		default:
			System.out.println("输入指令不正确！请重新输入！");
			commonQuery(flight);
		}
	}

	
	// 乘客功能
	public void passengerMenu(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city, int passengerID) {
		// 乘客登陆后的功能菜单
		System.out.println("1、航班查询");
		System.out.println("2、航班预订");
		System.out.println("3、查看订单以及订单处理");
		System.out.println("4、查看个人资料");
		System.out.println("5、修改密码");
		System.out.println("6、返回初始菜单");
		choose3(admin, passenger, flight,city, passengerID);
	}
	public void choose3(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city, int passengerID) {
		// 乘客菜单的选择
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("请输入指令：");
		String order = input.next();
		System.out.println();
		switch (order) {
		case "1":
			queryFlightList1(admin, passenger, flight,city, passengerID);
			break;
		case "2":
			orderFlight(admin, passenger, flight,city, passengerID);
			break;
		case "3":
			visitOrder(admin, passenger, flight,city, passengerID);
			break;
		case "4":
			passengerData(admin, passenger, flight,city, passengerID);
			break;
		case "5":
			changePassword1(admin, passenger, flight,city, passengerID);
			break;
		case "6":
			menu1(admin, passenger, flight,city);
			break;
		default:
			System.out.println("输入指令不正确！请重新输入！");
			choose3(admin, passenger, flight,city, passengerID);
		}
	}

	public void queryFlightList1(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city, int passengerID) {
		// 打印航班列表
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("航班列表如下:");
		System.out.println(
				"航班号                         起飞时间                                          到达时间                            起飞城市       到达城市      价格         当前预定人数       可载最大人数               航班状态");
		for (int i = 1; i <= Flight.getNumOfHaveRegistered(); i++) {
			if(flight[i] != null){
				flight[i].statusChange();// 刷新航班状态
				System.out.printf(
						"%s   %s   %s        %s             %s        %5d        %3d             %3d             %s\n",
						flight[i].getFlightID(), flight[i].getStartTime(), flight[i].getArrivalTime(),
						flight[i].getStartCity(), flight[i].getArrivalCity(), flight[i].getPrice(),
						flight[i].getCurrentPassengers(), flight[i].getSeatCapacity(), flight[i].getFlightStatus());
			}
		}
		System.out.println();
		commonQuery(flight);
		System.out.println();
		System.out.println("按任意键可返回上一级");
		input.next();
		passengerMenu(admin, passenger, flight,city, passengerID);
	}

	public void orderFlight(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city, int passengerID) {
		// 预订航班
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String flightID = "";
		int tab1 = 0;
		do {
			if (tab1 != 0)
				System.out.println("不存在该航班！请重新输入！");
			System.out.print("请输入想要预订的航班号：");
			flightID = input.nextLine();
			tab1++;
		} while (!AssistantOperation.checkFlight(flight, flightID));
		int flightNum = AssistantOperation.backObject(flight, flightID);
		if(AssistantOperation.checkPassengerID(flight,flightNum,passengerID)){
			System.out.println("预定失败！您已经预定过该航班！已返回乘客菜单！");
			System.out.println();
			passengerMenu(admin,passenger,flight,city,passengerID);
		}
		else{
			String seat = "";
			int tab2 = 0;
			try {
				do {
					if (tab2 != 0)
						System.out.println("输入座位号有误！不存在该座位号或是座位号已被预订！请重新输入！");
					System.out.print("请输入座位号(如001)：");
					seat = input.nextLine();
					tab2++;
				} while ((!AssistantOperation.checkSeat(flight, flightNum, seat))
						|| (Integer.parseInt(seat) > flight[flightNum].getSeatCapacity() || Integer.parseInt(seat) < 1));
			} catch (NumberFormatException e1) {
				tab2 = 0;
				System.out.println("输入座位号有误！请按正确形式输入！否则程序将直接退出！");
				try {
					do {
						if (tab2 != 0)
							System.out.println("输入座位号有误！不存在该座位号或是座位号已被预订！请重新输入！");

						System.out.print("请输入座位号(如001)：");
						seat = input.nextLine();
						tab2++;
					} while ((!AssistantOperation.checkSeat(flight, flightNum, seat))
							|| (Integer.parseInt(seat) > flight[flightNum].getSeatCapacity()
									|| Integer.parseInt(seat) < 1));
				} catch (NumberFormatException e2) {
					System.out.println("程序已自动退出！");
					System.exit(0);
				}
			} // 避免用户错误输入非数字型座位引发异常
			flight[flightNum].statusChange();// 刷新航班状态
			if (flight[flightNum].getFlightStatus().compareTo("AVAILABLE") == 0) {
				Order order = new Order(passengerID, seat, flight[flightNum]);
				flight[flightNum].setOrders(order);
				passenger[passengerID].setPassengerOrders(order);
				System.out.println("航班预订成功！");
				System.out.println();
				System.out.println("是否现在付款？1、是的，我要付款  2、等会付款，返回上一级");
				int orderNum;// 订单编号
				orderNum = passenger[passengerID].getCurrentOrders();
				choose4(admin, passenger, flight,city, passengerID, orderNum, flightNum);
			} else {
				System.out.println("航班状态异常！请仔细确认！航班预定失败！已返回乘客菜单！");
				System.out.println();
				passengerMenu(admin, passenger, flight,city, passengerID);
			}
		}
	}
	public void choose4(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city, int passengerID, int orderNum,
			int flightNum) {
		// 乘客对于预订航班后是否付款的选择
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String order = input.next();
		switch (order) {
		case "1":
			pay(admin, passenger, flight,city, passengerID, orderNum, flightNum);
			break;
		case "2":
			passengerMenu(admin, passenger, flight,city, passengerID);
			break;
		default:
			System.out.println("输入指令有误！请重新输入！");
			choose4(admin, passenger, flight,city, passengerID, orderNum, flightNum);
		}
	}

	public void visitOrder(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city, int passengerID) {
		// 查询订单（乘客）以及退订支付等操作
		Order[] Order = passenger[passengerID].getPassengerOrders();
		System.out.println("您已提交的订单如下：");
		System.out.println("订单编号    航班号      座位号                        提交时间                           订单状态");
		for (int i = 1; i <= passenger[passengerID].getCurrentOrders(); i++) {
			System.out.println("   " + i + "      " + Order[i].getFlight().getFlightID() + "    " + Order[i].getSeat() + "      "
					+ Order[i].getCreateDate().toString() + "    " + Order[i].getStatus());
		}
		System.out.println("温馨提示：如果订单取消后，需要重新预订一次！");
		System.out.println();
		System.out.println("您可执行以下操作来处理订单：");
		System.out.println("1、支付订单");
		System.out.println("2、取消订单");
		System.out.println("3、查询订单中具体航班情况");
		System.out.println("4、返回上一级");
		choose5(admin, passenger, flight,city, passengerID);
	}
	public void choose5(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city, int passengerID) {
		// 对于订单处理菜单的选择
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("请输入指令：");
		String order = input.next();
		int orderNum = 0;
		int tab1 = 0;
		int flightNum;
		switch (order) {
		case "1":
			try {
				do {
					if (tab1 != 0)
						System.out.println("输入订单编号有误！请重新输入！");
					System.out.print("请输入想要支付的订单编号：");
					orderNum = input.nextInt();
					tab1++;
				} while (orderNum > passenger[passengerID].getCurrentOrders() || orderNum < 1);
			} catch (InputMismatchException e1) {
				input.next();// 吃掉输入编号后的回车
				System.out.println("输入订单编号有误！请按正确形式输入！否则程序将直接退出！");
				tab1 = 0;
				try {
					do {
						if (tab1 != 0)
							System.out.println("输入订单编号有误！请重新输入！");
						System.out.print("请输入想要支付的订单编号：");
						orderNum = input.nextInt();
						tab1++;
					} while (orderNum > passenger[passengerID].getCurrentOrders() || orderNum < 1);
				} catch (InputMismatchException e2) {
					System.out.println("程序已自动退出！");
					System.exit(0);
				}
			}
			flightNum = AssistantOperation.backObject(flight,
					passenger[passengerID].getPassengerOrders()[orderNum].getFlight().getFlightID());
			pay(admin, passenger, flight,city, passengerID, orderNum, flightNum);
			break;
		case "2":
			try {
				do {
					if (tab1 != 0)
						System.out.println("输入订单编号有误！请重新输入！");
					System.out.print("请输入想要取消的订单编号：");
					orderNum = input.nextInt();
					tab1++;
				} while (orderNum > passenger[passengerID].getCurrentOrders() || orderNum < 1);
			} catch (InputMismatchException e1) {
				input.next();// 吃掉输入编号后的回车
				System.out.println("输入订单编号有误！请按正确形式输入！否则程序将直接退出！");
				tab1 = 0;
				try {
					do {
						if (tab1 != 0)
							System.out.println("输入订单编号有误！请重新输入！");
						System.out.print("请输入想要取消的订单编号：");
						orderNum = input.nextInt();
						tab1++;
					} while (orderNum > passenger[passengerID].getCurrentOrders() || orderNum < 1);
				} catch (InputMismatchException e2) {
					System.out.println("程序已自动退出！");
					System.exit(0);
				}
			}
			flightNum = AssistantOperation.backObject(flight,
					passenger[passengerID].getPassengerOrders()[orderNum].getFlight().getFlightID());
			passenger[passengerID].getPassengerOrders()[orderNum].setStatus("CANCEL");
			flight[flightNum].cancel(passengerID);
			System.out.println("取消成功！已返回订单页面！");
			System.out.println();
			visitOrder(admin, passenger, flight,city, passengerID);
			break;
		case "3":
			try {
				do {
					if (tab1 != 0)
						System.out.println("输入订单编号有误！请重新输入！");
					System.out.print("请输入想要查看的订单编号：");
					orderNum = input.nextInt();
					tab1++;
				} while (orderNum > passenger[passengerID].getCurrentOrders() || orderNum < 1);
			} catch (InputMismatchException e1) {
				input.next();// 吃掉输入编号后的回车
				System.out.println("输入订单编号有误！请按正确形式输入！否则程序将直接退出！");
				tab1 = 0;
				try {
					do {
						if (tab1 != 0)
							System.out.println("输入订单编号有误！请重新输入！");
						System.out.print("请输入想要查看的订单编号：");
						orderNum = input.nextInt();
						tab1++;
					} while (orderNum > passenger[passengerID].getCurrentOrders() || orderNum < 1);
				} catch (InputMismatchException e2) {
					System.out.println("程序已自动退出！");
					System.exit(0);
				}
			}
			flightNum = AssistantOperation.backObject(flight,
					passenger[passengerID].getPassengerOrders()[orderNum].getFlight().getFlightID());
			int i = flightNum;
		    System.out.println("航班情况如下：");
		    System.out.println(
					"航班号                         起飞时间                                          到达时间                            起飞城市       到达城市      价格         当前预定人数       可载最大人数               航班状态");
		    System.out.printf(
					"%s   %s   %s        %s             %s        %5d        %3d             %3d             %s\n",
					flight[i].getFlightID(), flight[i].getStartTime(), flight[i].getArrivalTime(),
					flight[i].getStartCity(), flight[i].getArrivalCity(), flight[i].getPrice(),
					flight[i].getCurrentPassengers(), flight[i].getSeatCapacity(), flight[i].getFlightStatus());
		    break;
		case "4":
			passengerMenu(admin,passenger,flight,city,passengerID);
			break;
		default:
			System.out.println("输入指令不正确！请重新输入！");
		    choose5(admin, passenger, flight,city,passengerID);
		    break;
		}
	}

	public void passengerData(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city, int passengerID) {
		// 乘客个人资料打印
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("乘客编号：" + passenger[passengerID].getPassengerID());
		System.out.println("真实姓名：" + passenger[passengerID].getRealName());
		System.out.println("身份证号码：" + passenger[passengerID].getIdentityID());
		System.out.println();
		System.out.println("按任意键可返回上一级");
		input.next();
		passengerMenu(admin, passenger, flight,city, passengerID);
	}

	public void changePassword1(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city, int passengerID) {
		// 乘客修改密码
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String password = "";
		String password1 = "";
		int tab1 = 0, tab2 = 0;
		do {
			if (tab1 != 0)
				System.out.println("两次输入的密码不一致！");
			do {
				if (tab2 != 0)
					System.out.println("设置密码不符合要求！请重新设置！");
				System.out.println("请设置新密码:");
				System.out.println("要求：");
				System.out.println("1.密码至少8位字符");
				System.out.println("2.仅能包含字母和数字");
				System.out.println("3.至少包含两个数字");
				password = input.nextLine();
				tab2++;
			} while (!AssistantOperation.checkPassword(password));
			System.out.print("请确认密码：");
			password1 = input.nextLine();
			tab1++;
		} while (password.compareTo(password1) != 0);
		passenger[passengerID].setPassword(password);
		System.out.println("修改密码成功！请重新登录！");
		System.out.println();
		passengerLogin(admin, passenger, flight,city);
	}

	public void pay(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city, int passengerID, int orderNum,
			int flightNum) {
		// 支付订单
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("您需要为此订单支付" + flight[flightNum].getPrice() + "元");
		System.out.println("输入Y确认支付订单,任意键可放弃支付: ");
		String order = input.nextLine();
		if (order.compareTo("Y") == 0) {
			passenger[passengerID].getPassengerOrders()[orderNum].setStatus("PAID");
			System.out.println("支付成功！已自动退回乘客菜单！");
		} else
			System.out.println("支付失败！已自动退回乘客菜单！");
		System.out.println();
		passengerMenu(admin, passenger, flight,city, passengerID);
	}

	
	// 管理员功能
	public void adminMenu(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city, int adminNum) {
		// 管理员登陆后的功能菜单
		System.out.println("1、航班及订单查询");
		System.out.println("2、创建航班");
		System.out.println("3、发布航班");
		System.out.println("4、修改航班");
		System.out.println("5、删除航班");
		System.out.println("6、添加管理员");
		System.out.println("7、修改密码");
		System.out.println("8、返回初始菜单");
		choose6(admin, passenger, flight,city, adminNum);
	}
	public void choose6(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city, int adminNum) {
		// 管理员菜单的选择
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("请输入指令：");
		String order = input.next();
		System.out.println();
		int flightNum = 0;
		String flightID = "";
		int tab1;
		switch (order) {
		case "1":
			queryFlightList2(admin, passenger, flight,city, adminNum);
			break;
		case "2":
			createFlight(admin, passenger, flight,city, adminNum);
			break;
		case "3":
			tab1 = 0;
			input.nextLine();
			do {
				if (tab1 != 0)
					System.out.println("不存在该航班！请重新输入！");
				System.out.print("请输入想要发布的航班号：");
				flightID = input.nextLine();
				tab1++;
			} while (!AssistantOperation.checkFlight(flight, flightID));
			flightNum = AssistantOperation.backObject(flight, flightID);
			publishFlight(admin, passenger, flight,city, adminNum,flightNum);
			break;
		case "4":
			tab1 = 0;
			input.nextLine();
			do {
				if (tab1 != 0)
					System.out.println("不存在该航班！请重新输入！");
				System.out.print("请输入想要修改的航班号：");
				flightID = input.nextLine();
				tab1++;
			} while (!AssistantOperation.checkFlight(flight, flightID));
			flightNum = AssistantOperation.backObject(flight, flightID);
			changeFlight(admin, passenger, flight,city, adminNum,flightNum);
			break;
		case "5":
			tab1 = 0;
			input.nextLine();
			do {
				if (tab1 != 0)
					System.out.println("不存在该航班！请重新输入！");
				System.out.print("请输入想要删除的航班号：");
				flightID = input.nextLine();
				tab1++;
			} while (!AssistantOperation.checkFlight(flight, flightID));
			flightNum = AssistantOperation.backObject(flight, flightID);
			deleteFlight(admin, passenger, flight,city, adminNum,flightNum);
			break;
		case "6":
			addAdmin(admin, passenger, flight,city, adminNum);
			break;
		case "7":
			changePassword2(admin, passenger, flight,city, adminNum);
			break;
		case "8":
			menu1(admin, passenger, flight,city);
			break;
		default:
			System.out.println("输入指令不正确！请重新输入！");
			choose6(admin, passenger, flight,city, adminNum);
		}
	}
	
	public void changePassword2(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city, int adminNum) {
		// 管理员修改密码
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String password = "";
		String password1 = "";
		int tab1 = 0, tab2 = 0;
		do {
			if (tab1 != 0)
				System.out.println("两次输入的密码不一致！");
			do {
				if (tab2 != 0)
					System.out.println("设置密码不符合要求！请重新设置！");
				System.out.println("请设置新密码:");
				System.out.println("要求：");
				System.out.println("1.密码至少8位字符");
				System.out.println("2.仅能包含字母和数字");
				System.out.println("3.至少包含两个数字");
				password = input.nextLine();
				tab2++;
			} while (!AssistantOperation.checkPassword(password));
			System.out.print("请确认密码：");
			password1 = input.nextLine();
			tab1++;
		} while (password.compareTo(password1) != 0);
		admin[adminNum].setPassword(password);
		System.out.println("修改密码成功！请重新登录！");
		System.out.println();
		adminLogin(admin, passenger, flight,city);
	}

	public void addAdmin(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city, int adminNum){
		//管理员添加管理员用户
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("您是管理员，不需要输入注册秘钥，即可添加管理员用户！");
		int tab3 = 0;
		String userName = "";
		do {
			if (tab3 != 0)
				System.out.println("输入的用户名已被注册！请重新输入！");
			System.out.print("请输入想要添加的管理员的用户名：");
			userName = input.nextLine();
			tab3++;
		} while (!AssistantOperation.checkUserName(admin, userName));
		String password = "";
		String password1 = "";
		int tab1 = 0, tab2 = 0;
		do {
			if (tab1 != 0)
				System.out.println("两次输入的密码不一致！");
			do {
				if (tab2 != 0)
					System.out.println("设置密码不符合要求！请重新设置！");
				System.out.println("请设置密码:");
				System.out.println("要求：");
				System.out.println("1.密码至少8位字符");
				System.out.println("2.仅能包含字母和数字");
				System.out.println("3.至少包含两个数字");
				password = input.nextLine();
				tab2++;
			} while (!AssistantOperation.checkPassword(password));
			System.out.print("请确认密码：");
			password1 = input.nextLine();
			tab1++;
		} while (password.compareTo(password1) != 0);
		Admin admin1 = new Admin(userName, password);
		admin[Admin.getNumOfHaveRegistered()] = admin1;
		System.out.println("添加管理员用户成功！请牢记用户名与密码！");
		System.out.println("已退回管理员菜单！");
		System.out.println();
		adminMenu(admin,passenger,flight,city,adminNum);
	}
	
	public void queryFlightList2(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city, int adminNum){
		// 打印航班列表
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("航班列表如下:");
		System.out.println(
				"航班号                         起飞时间                                          到达时间                            起飞城市       到达城市      价格         当前预定人数       可载最大人数               航班状态");
		for (int i = 1; i <= Flight.getNumOfHaveRegistered(); i++) {
			if(flight[i] != null){
				flight[i].statusChange();// 刷新航班状态
				System.out.printf(
						"%s   %s   %s        %s             %s        %5d        %3d             %3d             %s\n",
						flight[i].getFlightID(), flight[i].getStartTime(), flight[i].getArrivalTime(),
						flight[i].getStartCity(), flight[i].getArrivalCity(), flight[i].getPrice(),
						flight[i].getCurrentPassengers(), flight[i].getSeatCapacity(), flight[i].getFlightStatus());
			}
		}
		System.out.println();
		specialQuery(passenger,flight);
		System.out.println();
		System.out.println("按任意键可返回上一级");
		input.next();
		adminMenu(admin, passenger, flight,city, adminNum);
	}
	public void specialQuery(Passenger[] passenger,Flight[] flight){
		//高级查找
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("您可以选择按项目查找");
		System.out.println("1、航班号");
	    System.out.println("2、起飞城市");
	    System.out.println("3、到达城市");
	    System.out.println("4、航班价格");
	    System.out.println("5、查询航班预订信息");
	    System.out.println("6、放弃按项目查找");
	    System.out.print("请输入指令：");
		String order = input.nextLine();
		System.out.println();
		String flightID = "";
		switch (order) {
		case "1":
			System.out.print("请输入想要查询的航班号：");
			flightID = input.nextLine();
			if(AssistantOperation.checkFlight(flight,flightID)){
				int i = AssistantOperation.backObject(flight, flightID);
				System.out.println("航班信息如下:");
				System.out.println(
						"航班号                         起飞时间                                          到达时间                            起飞城市       到达城市      价格         当前预定人数       可载最大人数               航班状态");
				flight[i].statusChange();// 刷新航班状态
				System.out.printf(
						"%s   %s   %s        %s             %s        %5d        %3d             %3d             %s\n",
						flight[i].getFlightID(), flight[i].getStartTime(), flight[i].getArrivalTime(),
						flight[i].getStartCity(), flight[i].getArrivalCity(), flight[i].getPrice(),
						flight[i].getCurrentPassengers(), flight[i].getSeatCapacity(), flight[i].getFlightStatus());
			}
			else
				System.out.println("未查询到该航班！");
			break;
		case "2":
			System.out.print("请输入想要查询航班的起飞城市：");
			String startCity = input.nextLine();
			int num1 = 0;
			System.out.println("航班信息如下:");
			System.out.println(
					"航班号                         起飞时间                                          到达时间                            起飞城市       到达城市      价格         当前预定人数       可载最大人数               航班状态");
			for(int i = 1; i <= Flight.getNumOfHaveRegistered(); i++){
				flight[i].statusChange();// 刷新航班状态
				if(flight[i].getStartCity().compareTo(startCity) == 0){
					System.out.printf(
							"%s   %s   %s        %s             %s        %5d        %3d             %3d             %s\n",
							flight[i].getFlightID(), flight[i].getStartTime(), flight[i].getArrivalTime(),
							flight[i].getStartCity(), flight[i].getArrivalCity(), flight[i].getPrice(),
							flight[i].getCurrentPassengers(), flight[i].getSeatCapacity(), flight[i].getFlightStatus());
					num1++;
				}
			}
			if(num1 == 0)
				System.out.println("没有查询到符合条件的航班！");
			System.out.println();
			break;
		case "3":
			System.out.print("请输入想要查询航班的到达城市：");
			String arrivalCity = input.nextLine();
			int num2 = 0;
			System.out.println("航班信息如下:");
			System.out.println(
					"航班号                         起飞时间                                          到达时间                            起飞城市       到达城市      价格         当前预定人数       可载最大人数               航班状态");
			for(int i = 1; i <= Flight.getNumOfHaveRegistered(); i++){
				flight[i].statusChange();// 刷新航班状态
				if(flight[i].getArrivalCity().compareTo(arrivalCity) == 0){
					System.out.printf(
							"%s   %s   %s        %s             %s        %5d        %3d             %3d             %s\n",
							flight[i].getFlightID(), flight[i].getStartTime(), flight[i].getArrivalTime(),
							flight[i].getStartCity(), flight[i].getArrivalCity(), flight[i].getPrice(),
							flight[i].getCurrentPassengers(), flight[i].getSeatCapacity(), flight[i].getFlightStatus());
					num2++;
				}
			}
			if(num2 == 0)
				System.out.println("没有查询到符合条件的航班！");
			System.out.println();
			break;
		case "4":
			System.out.print("你可以查询输入价格以内的航班，请输入想要的价格：");
			int tab;
			int price = 0;
			try {
				tab = 0;
				do {
					if (tab != 0)
						System.out.println("输入价格有误！请重新输入！");
					System.out.print("请输入航班价格：");
					price = input.nextInt();
					tab++;
				} while (price <= 0);//价格为正数
			} catch (InputMismatchException e1) {
				input.next();// 吃掉输入编号后的回车
				System.out.println("输入价格有误！请按正确形式输入！否则程序将直接退出！");
				tab = 0;
				try {
					do {
						if (tab != 0)
							System.out.println("输入价格有误！请重新输入！");
						System.out.print("请输入航班价格：");
						price = input.nextInt();
						tab++;
					} while (price <= 0);
				} catch (InputMismatchException e2) {
					System.out.println("程序已自动退出！");
					System.exit(0);
				}
			}
			int num3 = 0;
			System.out.println("航班信息如下:");
			System.out.println(
					"航班号                         起飞时间                                          到达时间                            起飞城市       到达城市      价格         当前预定人数       可载最大人数               航班状态");
			for(int i = 1; i <= Flight.getNumOfHaveRegistered(); i++){
				flight[i].statusChange();// 刷新航班状态
				if(flight[i].getPrice() <= price){
					System.out.printf(
							"%s   %s   %s        %s             %s        %5d        %3d             %3d             %s\n",
							flight[i].getFlightID(), flight[i].getStartTime(), flight[i].getArrivalTime(),
							flight[i].getStartCity(), flight[i].getArrivalCity(), flight[i].getPrice(),
							flight[i].getCurrentPassengers(), flight[i].getSeatCapacity(), flight[i].getFlightStatus());
					num3++;
				}
			}
			if(num3 == 0)
				System.out.println("没有查询到符合条件的航班！");
			System.out.println();
			break;
		case "5":
			System.out.print("请输入想要查询的航班号：");
			flightID = input.nextLine();
			int num4 = 0;
			if(AssistantOperation.checkFlight(flight,flightID)){
				int i = AssistantOperation.backObject(flight, flightID);
				Order[] order1 = flight[i].getOrders();
				System.out.println("该航班订单信息如下：");
				System.out.println("乘客姓名 身份证号 座位号 预订时间 订单状态 ");
				for(int j = 1; j <= flight[i].getCurrentOrders();j++){
					System.out.println(passenger[order1[i].getPassengerID()].getRealName() + " " + 
							passenger[order1[i].getPassengerID()].getIdentityID() + " " + 
							order1[i].getSeat() + " " + order1[i].getCreateDate() + " " + order1[i].getStatus());
				num4++;
				}
			if(num4 == 0)
				System.out.println("该航班还没有任何订单信息！");
			}
			else
				System.out.println("未能查询到该航班！");
			break;
		case "6":
			break;
		default:
			System.out.println("输入指令不正确！请重新输入！");
			specialQuery(passenger,flight);
		}
	}
	
	public void publishFlight(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city, int adminNum,int flightNum){
		//发布航班
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		flight[flightNum].statusChange();//确认是否在出发前两小时前
		int i = flightNum;
		System.out.println("该航班信息如下：");
		System.out.println(
				"航班号                         起飞时间                                          到达时间                            起飞城市       到达城市      价格         当前预定人数       可载最大人数               航班状态");
		System.out.printf(
				"%s   %s   %s        %s             %s        %5d        %3d             %3d             %s\n",
				flight[i].getFlightID(), flight[i].getStartTime(), flight[i].getArrivalTime(),
				flight[i].getStartCity(), flight[i].getArrivalCity(), flight[i].getPrice(),
				flight[i].getCurrentPassengers(), flight[i].getSeatCapacity(), flight[i].getFlightStatus());
		System.out.println("输入Y确认发布航班,任意键可放弃发布: ");
		String order = input.nextLine();
		if (order.compareTo("Y") == 0) {
			if(flight[flightNum].getFlightStatus().compareTo("UNPUBLISHED") == 0){
				flight[flightNum].setFlightStatus("AVAILABLE");
				System.out.println("发布航班成功！已退回管理员菜单！");
			}
			else{
				System.out.println("想要发布的航班状态有误！请仔细确认！现已退回管理员菜单！");
			}
		} else
			System.out.print("发布航班失败！已退回管理员菜单！");
		System.out.println();
		adminMenu(admin,passenger,flight,city,adminNum);
	}
	
	public void deleteFlight(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city, int adminNum,int flightNum){
		//删除航班
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		flight[flightNum].statusChange();//确认是否为可删除的状态
		int i = flightNum;
		System.out.println("该航班信息如下：");
		System.out.println(
				"航班号                         起飞时间                                          到达时间                            起飞城市       到达城市      价格         当前预定人数       可载最大人数               航班状态");
		System.out.printf(
				"%s   %s   %s        %s             %s        %5d        %3d             %3d             %s\n",
				flight[i].getFlightID(), flight[i].getStartTime(), flight[i].getArrivalTime(),
				flight[i].getStartCity(), flight[i].getArrivalCity(), flight[i].getPrice(),
				flight[i].getCurrentPassengers(), flight[i].getSeatCapacity(), flight[i].getFlightStatus());
		System.out.println("输入Y确认删除航班,任意键可放弃删除: ");
		String order = input.nextLine();
		if (order.compareTo("Y") == 0) {
			if(flight[flightNum].getFlightStatus().compareTo("UNPUBLISHED") == 0 ||
					flight[flightNum].getFlightStatus().compareTo("TERMINATE") == 0){
				flight[flightNum] = null;//通过删除航班对象的引用来删除航班
				System.out.println("删除航班成功！已退回管理员菜单！");
			}
			else{
				System.out.println("想要删除的航班状态有误！请仔细确认！现已退回管理员菜单！");
			}
		} else
			System.out.print("删除航班失败！已退回管理员菜单！");
		System.out.println();
		adminMenu(admin,passenger,flight,city,adminNum);
	}
	
	public void createFlight(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city, int adminNum){
		//创建航班
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String flightID = "";
		String startTime = "";
		String arrivalTime = "";
		String startCity = "";
		String arrivalCity = "";
		int price = 0;
		int seatCapacity = 0;
		int tab = 0;
		do {
			if (tab != 0)
				System.out.println("该航班已创建！请重新输入！");
			System.out.print("请输入想要创建的航班号(如 XTB001 )：");
			flightID = input.nextLine();
			tab++;
		} while (AssistantOperation.checkFlight(flight, flightID));
		//输入正确航班号
		String startTime1 = "";
		tab = 0;
		do {
			if (tab != 0 && startTime.compareTo(startTime1) != 0)
				System.out.println("出错！两次输入不一致！");
			if(tab != 0 && !AssistantOperation.checkStartTime(startTime))
				System.out.println("出错！起飞时间设置有误！应在当前时间两小时以后！");
			System.out.println("请设置起飞时间:");
			System.out.println("注意！时间设置必须按照  Tue May 18 10:25:00 CST 2017 格式！！！");
			startTime = input.nextLine();
			System.out.print("请再次输入起飞时间以确认无误：");
			startTime1 = input.nextLine();
			tab++;
		} while (startTime.compareTo(startTime1) != 0 || !AssistantOperation.checkStartTime(startTime));
	    //输入正确起飞时间
		String arrivalTime1 = "";
		tab = 0;
		do {
			if (tab != 0 && arrivalTime.compareTo(arrivalTime1) != 0)
				System.out.println("出错！两次输入不一致！");
			if(tab != 0 && !AssistantOperation.checkArrivalTime(startTime,arrivalTime))
				System.out.println("出错！到达时间设置有误！应在起飞时间之后！");
			System.out.println("请设置到达时间:");
			System.out.println("注意！时间设置必须按照  Tue May 18 10:25:00 CST 2017 格式！！！");
			arrivalTime = input.nextLine();
			System.out.print("请再次输入到达时间以确认无误：");
			arrivalTime1 = input.nextLine();
			tab++;
		} while (arrivalTime.compareTo(arrivalTime1) != 0 || !AssistantOperation.checkArrivalTime(startTime,arrivalTime));
        //输入正确到达时间
		System.out.print("当前可设置航班城市有：");
		for(int i = 1; i <= City.getNumOfHaveRegistered(); i++){
			System.out.print(city[i].getName() + " ");
		}
		System.out.println();
		tab = 0;
		do {
			if (tab != 0)
				System.out.println("该城市不支持设置航班！请重新输入！");
			System.out.print("请输入起飞城市：");
			startCity = input.nextLine();
			tab++;
		} while (!AssistantOperation.checkCity(city,startCity));
		//输入正确起飞城市
		tab = 0;
		do {
			if (tab != 0 && AssistantOperation.checkCity(city,arrivalCity))
				System.out.println("该城市不支持设置航班！请重新输入！");
			if(tab != 0 && arrivalCity.compareTo(startCity) == 0)
				System.out.println("到达城市不能与初始城市相同！");
			System.out.print("请输入到达城市：");
			arrivalCity = input.nextLine();
			tab++;
		} while (!AssistantOperation.checkCity(city,arrivalCity) || arrivalCity.compareTo(startCity) == 0);
		//输入正确到达城市
		try {
			tab = 0;
			do {
				if (tab != 0)
					System.out.println("输入价格有误！请重新输入！");
				System.out.print("请输入航班价格：");
				price = input.nextInt();
				tab++;
			} while (price <= 0);//价格为正数
		} catch (InputMismatchException e1) {
			input.next();// 吃掉输入编号后的回车
			System.out.println("输入价格有误！请按正确形式输入！否则程序将直接退出！");
			tab = 0;
			try {
				do {
					if (tab != 0)
						System.out.println("输入价格有误！请重新输入！");
					System.out.print("请输入航班价格：");
					price = input.nextInt();
					tab++;
				} while (price <= 0);
			} catch (InputMismatchException e2) {
				System.out.println("程序已自动退出！");
				System.exit(0);
			}
		}
	    //输入正确航班价格
		try {
			tab = 0;
			do {
				if (tab != 0)
					System.out.println("输入可载最大人数有误！请重新输入！");
				System.out.print("请输入可载最大人数：");
				seatCapacity = input.nextInt();
				tab++;
			} while (seatCapacity <= 0);//可载最大人数为正数
		} catch (InputMismatchException e1) {
			input.next();// 吃掉输入编号后的回车
			System.out.println("输入可载最大人数有误！请按正确形式输入！否则程序将直接退出！");
			tab = 0;
			try {
				do {
					if (tab != 0)
						System.out.println("输入可载最大人数有误！请重新输入！");
					System.out.print("请输入可载最大人数：");
					seatCapacity = input.nextInt();
					tab++;
				} while (seatCapacity <= 0);
			} catch (InputMismatchException e2) {
				System.out.println("程序已自动退出！");
				System.exit(0);
			}
		}
		//输入正确可载最大人数
		Flight flight1 = new Flight(flightID, startTime,arrivalTime, startCity,arrivalCity, price, seatCapacity);
		flight[Flight.getNumOfHaveRegistered()] = flight1;
		city[AssistantOperation.backObject(city, flight[Flight.getNumOfHaveRegistered()].getStartCity())]
				.setCityFlight(flight[Flight.getNumOfHaveRegistered()]);// 将航班绑定到出发城市
		System.out.println("航班创建成功！");
		System.out.println();
		System.out.println("是否现在发布？1、是的，我要发布  2、等会发布，返回上一级");
		int flightNum = Flight.getNumOfHaveRegistered();// 航班编号
		choose7(admin, passenger, flight,city, adminNum,flightNum);
	}
	public void choose7(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city, int adminNum,int flightNum){
		//管理员对于创建航班后是否发布的选择
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String order = input.next();
		switch (order) {
		case "1":
			publishFlight(admin, passenger, flight,city, adminNum, flightNum);
			break;
		case "2":
			adminMenu(admin, passenger, flight,city, adminNum);
			break;
		default:
			System.out.println("输入指令有误！请重新输入！");
			choose7(admin, passenger, flight,city, adminNum ,flightNum);
		}
	}
	
	public void changeFlight(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city, int adminNum,int flightNum){
		//修改航班信息
		flight[flightNum].statusChange();//更新航班状态
		int i = flightNum;
		System.out.println("该航班信息如下：");
		System.out.println(
				"航班号                         起飞时间                                          到达时间                            起飞城市       到达城市      价格         当前预定人数       可载最大人数               航班状态");
		System.out.printf(
				"%s   %s   %s        %s             %s        %5d        %3d             %3d             %s\n",
				flight[i].getFlightID(), flight[i].getStartTime(), flight[i].getArrivalTime(),
				flight[i].getStartCity(), flight[i].getArrivalCity(), flight[i].getPrice(),
				flight[i].getCurrentPassengers(), flight[i].getSeatCapacity(), flight[i].getFlightStatus());
	    if(flight[flightNum].getFlightStatus().compareTo("TERMINATE") == 0){
	    	System.out.println("该航班为终止状态，不可再修改航班信息！已退回管理员菜单！");
	    	System.out.println();
	    	adminMenu(admin,passenger,flight,city,adminNum);
	    }//航班终止状态不可修改信息
		System.out.println("请选择想要修改的项目：");
	    System.out.println("1、起飞时间");
	    System.out.println("2、到达时间");
	    System.out.println("3、起飞城市");
	    System.out.println("4、到达城市");
	    System.out.println("5、航班价格");
	    System.out.println("6、可载最大人数");
	    System.out.println("7、退回管理员菜单");
	    System.out.println("温馨提示：航班发布后，起飞时间、起飞城市、到达城市等重要信息不可修改；"
	    		+ "航班终止后，管理员不可再修改航班！");
	    choose8(admin,passenger,flight,city,adminNum,flightNum);
	}
	public void choose8(Admin[] admin, Passenger[] passenger, Flight[] flight,City[] city, int adminNum,int flightNum){
		//对于修改菜单中的选择
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String startTime = "";
		String arrivalTime = "";
		String startCity = "";
		String arrivalCity = "";
		int price = 0;
		int seatCapacity = 0;
		int tab = 0;
		System.out.print("请输入指令：");
		String order = input.nextLine();
		System.out.println();
		switch (order) {
		case "1":
			if(flight[flightNum].getFlightStatus().compareTo("UNPUBLISHED") == 0){
				System.out.print("");
				String startTime1 = "";
				tab = 0;
				do {
					if (tab != 0 && startTime.compareTo(startTime1) != 0)
						System.out.println("出错！两次输入不一致！");
					if(tab != 0 && !AssistantOperation.checkStartTime(startTime))
						System.out.println("出错！起飞时间设置有误！应在当前时间两小时以后！");
					if(tab != 0 && !AssistantOperation.checkArrivalTime(startTime,flight[flightNum].getArrivalTime()))
						System.out.println("出错！起飞时间设置有误！应在到达时间之前！");
					System.out.println("请设置修改后的起飞时间:");
					System.out.println("注意！时间设置必须按照  Tue May 18 10:25:00 CST 2017 格式！！！");
					startTime = input.nextLine();
					System.out.print("请再次输入起飞时间以确认无误：");
					startTime1 = input.nextLine();
					tab++;
				} while (startTime.compareTo(startTime1) != 0 ||
						!AssistantOperation.checkStartTime(startTime) ||
						!AssistantOperation.checkArrivalTime(startTime,flight[flightNum].getArrivalTime()));
				flight[flightNum].setStartTime(startTime);
				System.out.println("起飞时间修改成功！已退回上一级！");
				System.out.println();
				changeFlight(admin,passenger,flight,city,adminNum,flightNum);
			}
			else{
				System.out.println("该航班已发布！不可修改起飞时间！已退回上一级！");
				System.out.println();
				changeFlight(admin,passenger,flight,city,adminNum,flightNum);
			}
			break;
		case "2":
			String arrivalTime1 = "";
			tab = 0;
			do {
				if (tab != 0 && arrivalTime.compareTo(arrivalTime1) != 0)
					System.out.println("出错！两次输入不一致！");
				if(tab != 0 && !AssistantOperation.checkArrivalTime(flight[flightNum].getStartTime(),arrivalTime))
					System.out.println("出错！到达时间设置有误！应在起飞时间之后！");
				System.out.println("请设置修改后的到达时间:");
				System.out.println("注意！时间设置必须按照  Tue May 18 10:25:00 CST 2017 格式！！！");
				arrivalTime = input.nextLine();
				System.out.print("请再次输入到达时间以确认无误：");
				arrivalTime1 = input.nextLine();
				tab++;
			} while (arrivalTime.compareTo(arrivalTime1) != 0 ||
					!AssistantOperation.checkArrivalTime(flight[flightNum].getStartTime(),arrivalTime));
			flight[flightNum].setArrivalTime(arrivalTime);
			System.out.println("到达时间修改成功！已退回上一级！");
			System.out.println();
			changeFlight(admin,passenger,flight,city,adminNum,flightNum);
			break;
		case "3":
			if(flight[flightNum].getFlightStatus().compareTo("UNPUBLISHED") == 0){
				System.out.print("当前可设置航班城市有：");
				for(int i = 1; i <= City.getNumOfHaveRegistered(); i++){
					System.out.print(city[i].getName() + " ");
				}
				System.out.println();
				tab = 0;
				do {
					if (tab != 0)
						System.out.println("该城市不支持设置航班！请重新输入！");
					System.out.print("请输入修改后起飞城市：");
					startCity = input.nextLine();
					tab++;
				} while (!AssistantOperation.checkCity(city,startCity));
				flight[flightNum].setStartCity(startCity);
				System.out.println("起飞城市修改成功！已退回上一级！");
				System.out.println();
				changeFlight(admin,passenger,flight,city,adminNum,flightNum);
			}
			else{
				System.out.println("该航班已发布！不可修改起飞城市！已退回上一级！");
				System.out.println();
				changeFlight(admin,passenger,flight,city,adminNum,flightNum);
			}
			break;
		case "4":
			tab = 0;
			if(flight[flightNum].getFlightStatus().compareTo("UNPUBLISHED") == 0){
				do {
					if (tab != 0 && !AssistantOperation.checkCity(city,arrivalCity))
						System.out.println("该城市不支持设置航班！请重新输入！");
					if(tab != 0 && arrivalCity.compareTo(flight[flightNum].getStartCity()) == 0)
						System.out.println("到达城市不能与初始城市相同！");
					System.out.print("请输入修改后的到达城市：");
					arrivalCity = input.nextLine();
					tab++;
				} while (!AssistantOperation.checkCity(city,arrivalCity) ||
						arrivalCity.compareTo(flight[flightNum].getStartCity()) == 0);
				flight[flightNum].setArrivalCity(arrivalCity);
				System.out.println("到达城市修改成功！已退回上一级！");
				System.out.println();
				changeFlight(admin,passenger,flight,city,adminNum,flightNum);
			}
			else{
				System.out.println("该航班已发布！不可修改到达城市！已退回上一级！");
				System.out.println();
				changeFlight(admin,passenger,flight,city,adminNum,flightNum);
			}
			break;
		case "5":
			try {
				tab = 0;
				do {
					if (tab != 0)
						System.out.println("输入价格有误！请重新输入！");
					System.out.print("请输入修改后的航班价格：");
					price = input.nextInt();
					tab++;
				} while (price <= 0);//价格为正数
			} catch (InputMismatchException e1) {
				input.next();// 吃掉输入编号后的回车
				System.out.println("输入价格有误！请按正确形式输入！否则程序将直接退出！");
				tab = 0;
				try {
					do {
						if (tab != 0)
							System.out.println("输入价格有误！请重新输入！");
						System.out.print("请输入修改后的航班价格：");
						price = input.nextInt();
						tab++;
					} while (price <= 0);
				} catch (InputMismatchException e2) {
					System.out.println("程序已自动退出！");
					System.exit(0);
				}
			}
			flight[flightNum].setPrice(price);
			System.out.println("航班价格修改成功！已退回上一级！");
			System.out.println();
			changeFlight(admin,passenger,flight,city,adminNum,flightNum);
			break;
		case "6":
			tab = 0;
			try {
				do {
					if (tab != 0 && seatCapacity < flight[flightNum].getCurrentPassengers())
						System.out.println("输入可载最大人数有误！不能小于已预订乘客人数！请重新输入！");
					if(tab != 0 && seatCapacity <= 0)
						System.out.println("输入可载最大人数有误！应为正整数！请重新输入！");
					System.out.print("请输入修改后的可载最大人数：");
					seatCapacity = input.nextInt();
					tab ++;
				} while (seatCapacity <= 0 &&
						seatCapacity < flight[flightNum].getCurrentPassengers());
				//可载最大人数为正数 且 不能小于已经预定乘客人数！
			} catch (InputMismatchException e1) {
				input.next();// 吃掉输入编号后的回车
				System.out.println("输入可载最大人数有误！请按正确形式输入！否则程序将直接退出！");
				tab = 0;
				try {
					do {
						if (tab != 0 && seatCapacity < flight[flightNum].getCurrentPassengers())
							System.out.println("输入可载最大人数有误！不能小于已预订乘客人数！请重新输入！");
						if(tab != 0 && seatCapacity <= 0)
							System.out.println("输入可载最大人数有误！应为正整数！请重新输入！");
						System.out.print("请输入修改后的可载最大人数：");
						seatCapacity = input.nextInt();
					} while (seatCapacity <= 0 &&
							seatCapacity < flight[flightNum].getCurrentPassengers());
					//可载最大人数为正数 且 不能小于已经预定乘客人数！
				} catch (InputMismatchException e2) {
					System.out.println("程序已自动退出！");
					System.exit(0);
				}
			}
			flight[flightNum].setSeatCapacity(seatCapacity);
			System.out.println("可载最大人数修改成功！已退回上一级！");
			System.out.println();
			changeFlight(admin,passenger,flight,city,adminNum,flightNum);
			break;
		case "7":
			adminMenu(admin,passenger,flight,city,adminNum);
			break;
		default:
			System.out.println("输入指令不正确！请重新输入！");
			choose6(admin, passenger, flight,city, adminNum);
		}
	}
}
