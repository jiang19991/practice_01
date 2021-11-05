package Test.park;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class Main {
	
	//统计停车记录<车辆，停车费用>
	Map<VehicleModel,Integer> map = new HashMap<>();
	//记录停车位状态
//	Map<K, V>
	//停车位<车位号码，车位状态>
	Map<Integer, Boolean> parkMap = new HashMap<Integer, Boolean>();
	static int initHour=0;
	static int endHour=0;
	public static void main(String[] args) {
		Main m = new Main();
		m.print();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入初始化停车位的数量：");
		String numString = scanner.nextLine();
		int numLot = Integer.valueOf(numString);
		m.initParkingLot(numLot);
		m.stateOfAll();
		while(true){
			System.out.println("请输入操作：");
			String string = scanner.nextLine();
			int operation = Integer.valueOf(string);
			if(operation==0) {
				break;
			}
			
			while(operation!=0) {
				if(operation==1) {//停车
					System.out.println("输入车辆高度及车牌号码：");
					String h = scanner.nextLine();
					int high = Integer.valueOf(h);
					String licenseString = scanner.nextLine();
					if(high>3||licenseString==null) {
						System.out.println("您的车辆不符合停车场要求");
						break;
					}
					System.out.println("输入所停在的车位：");
					String string2 = scanner.nextLine();
					int num = Integer.valueOf(string2);
					if(num>numLot) {
						System.out.println("没有此停车位，重新输入");
						break;
					}
					if(m.parkMap.get(num)==false) {
						System.out.println("当前车位已被占用！");
						break;
					}
					initHour = m.ParkCar(num);
//					System.out.println(initHour);
					System.out.println(licenseString+" 号车---停车完成");
					break;
				}else if(operation==2) {
					System.out.println("还车请输入您的车位号：");
					String s = scanner.nextLine();
					int num = Integer.valueOf(s);
					System.out.println("请输入您的车牌号码：");
					String caLlicense = scanner.nextLine();
//					int caLlicense = Integer.valueOf(s1);
					endHour = m.getCar(num,caLlicense);
//					System.out.println(endHour);
//					System.out.println("感谢使用本停车场，您的停车费用："+(endHour-initHour)*2);
					m.getMoney(num, caLlicense);
					break;
				}else if(operation==3) {
					m.stateOfAll();
					break;
				}else if (operation==4) {
					m.findAll();
					break;
				}
			}
			
		}
		
		scanner.close();
	}
	
	public void print() {
		System.out.println("--------停车场管理 ---------");
		System.out.println("--------1:停车      ---------");
		System.out.println("--------2:取车      ---------");
		System.out.println("--------3:查询当前所有车位状态-");
		System.out.println("--------4:查询所有停车收费记录--");
		System.out.println("--------0:退出      ---------");
	}
	
	//停车位初始化
	public void initParkingLot(int n) {
		for (int i = 1; i <= n; i++) {
			parkMap.put(i, true);
		}
		System.out.println("本停车场共有"+ n + "个车位");
		
	}
	
	//停车
	//@Test
	public int ParkCar(int num) {
		parkMap.put(num, false);
		
		
		Date date = new Date();
		System.out.println("当前时间是："+date.toLocaleString());
		long m = date.getTime();//毫秒数
		int hour =  (int) (m / 1000 );//按秒///小时

		return hour;
	}
	//还车
	public int getCar(int num,String caLlicense) {
		parkMap.put(num, true);
		
		
		Date date = new Date();
		System.out.println("取车时间："+date.toLocaleString());
		long m = date.getTime();//毫秒数
		int hour =  (int) (m / 1000 );//按秒,每秒2元
		System.out.println(num+" 号车位 "+" 车牌号为："+caLlicense+" ---还车成功！");
		return hour;
	}
	//获取停车费用及记录统计停车费用
	public double getMoney(int num,String license) {
		//return num;
		VehicleModel vehicle = new VehicleModel(license);
		int res = (endHour-initHour) * 2;
		map.put(vehicle, res);
		System.out.println("感谢使用本停车场，您的停车费用："+res);
		return res;
	}
	//查询所有车位的情况
	public void stateOfAll() {
		System.out.println("当前停车位的情况：");
		for(Integer i: parkMap.keySet()) {
			if(parkMap.get(i)==true) {
				System.out.println(i +"号车位当前空闲");
			}else {
				System.out.println(i +"号车位当前已占");
			}
		}
	}
	//查询统计全部的收费记录
	public void findAll() {
		System.out.println("收费统计如下：");
		for(VehicleModel vehicle : map.keySet()) {
			System.out.println(vehicle.toString()+"收费："+map.get(vehicle)+" ￥");
		}
	}
	
}
