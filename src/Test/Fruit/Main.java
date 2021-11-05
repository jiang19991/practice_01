package Test.Fruit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.xml.transform.Source;
/**
 * 
 * @author 姜柏宇
 * 销售摊位管理
 * 
 *
 */
public class Main {

	List<SaleRecordModel> saleRecordslist = new ArrayList<SaleRecordModel>();//记录销售记录
	Map<FruitModel,Integer> stockMap = new HashMap<>();//用于记录库存
	Map<FruitModel,Integer> saleCountMap = new HashMap<FruitModel, Integer>();//用于记录销量
	List<FruitModel> fruitlist = new ArrayList<FruitModel>();//
	Map<FruitModel,Integer> temp = new HashMap<>();;//用于记录累计进货量
	static FruitModel fruit1 = new FruitModel(10, 1, 2, "苹果");
	static FruitModel fruit2 = new FruitModel(10, 2, 3, "桃子");
	static FruitModel fruit3 = new FruitModel(10,3,5, "香蕉");
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		m.stockMap.put(fruit1, fruit1.getStock());
		m.stockMap.put(fruit2, fruit2.getStock());
		m.stockMap.put(fruit3, fruit3.getStock());
		m.temp.put(fruit1, fruit1.getStock());
		m.temp.put(fruit2, fruit2.getStock());
		m.temp.put(fruit3, fruit3.getStock());
		m.print();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("请输入操作：");
			String s1 = scanner.nextLine();
			int operation = Integer.valueOf(s1);
			if(operation==0) {
				System.out.println("再见！");
				break;
			}
			while(operation!=0) {
				if(operation==1) {
					m.stockUp();
					break;
				}else if(operation==2) {
					System.out.println("输入顾客id:");
					String Customerid = scanner.nextLine();

					System.out.println("输入顾客性别：（0代表男/1代表女）");
					String string = scanner.nextLine();
					String sex;
					if(string.equals("0")) {
						sex = "男";
					}else {
						sex = "女";
					}
					System.out.println("输入购买的水果：");
					String fruitName = scanner.nextLine();

					System.out.println("输入购买数量（kg）:");
					String s4 = scanner.nextLine();
					int weight = Integer.valueOf(s4);

					
					FruitModel fruit = new FruitModel(fruitName);
					double outPrice=0;
					for(FruitModel fruit2 : m.stockMap.keySet()) {
						if(fruit2.equals(fruit)) {
							outPrice = fruit2.getOutPrice();
							System.out.println("该水果的售价："+outPrice);
						}
					}
					
					m.recordSaleServices(Customerid,sex,fruitName,weight,outPrice);
					break;
				}else if(operation==3) {
					m.showStock();
					break;
				}else if (operation==4) {
					m.showSaleRecords();
					break;
				}else if(operation==5) {
					m.stockUp();
					break;
				}else if(operation==6) {
					System.out.println("输入起始时间：");
					String startDate = scanner.nextLine();
					System.out.println("输入结束时间：");
					String endDate = scanner.nextLine();
					m.searchProfit(startDate, endDate);
					break;
					
				}else if(operation==7) {
					m.orderBySaleCount();
					break;
				}else if(operation==8) {
					m.showAll();
					break;
				}
			}
			
		}

	}
	public void print() {
		System.out.println("----------------------");
		System.out.println("------摊位销售管理--------");
		System.out.println("1:添加进货");
		System.out.println("2:记录销售业务");
		System.out.println("3:显示当前各种水果的库存");
		System.out.println("4:查询所有的销售记录");
		System.out.println("5:添加其他品种的水果");
		System.out.println("6:查询指定日期间隔的销售利润");
		System.out.println("7:显示销售数量的前三名");
		System.out.println("8:显示摊位的详细信息");
		System.out.println("0:退出");
		
	}
	
	//进货
	public void stockUp() {
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("输入进货的水果和进货数量：");
		String FruitName = scanner1.nextLine();
		String string = scanner1.nextLine();
		int fruitWeight = Integer.valueOf(string);
		System.out.println("进货价格：");
		String string2 = scanner1.nextLine();
		int inPrice = Integer.valueOf(string2);
		System.out.println("售价：");
		String string3 = scanner1.nextLine();
		int outPrice = Integer.valueOf(string3);
		FruitModel fruit = new FruitModel(fruitWeight, inPrice, outPrice, FruitName);
		if(stockMap.containsKey(fruit)) {
			stockMap.put(fruit, stockMap.get(fruit)+fruitWeight);
		}else {
			stockMap.put(fruit, fruitWeight);
		}
		
		//记录累计进货量
		if(temp.containsKey(fruit)) {
			temp.put(fruit, temp.get(fruit)+fruitWeight);
		}else {
			temp.put(fruit, fruitWeight);
		}

		System.out.println("水果" + FruitName + "  进货完成");

		
		
	}
	
	//记录销售业务
	public void recordSaleServices(String customerid, String sex, String fruitName, int weight, double outPrice) {
		Date d = new Date();
		String date = d.toLocaleString();
		//女顾客8折
		if(sex.equals("女")) {
			outPrice = 0.8*outPrice;
		}
		//17点之后半价
		if(d.getHours()>=17) {
			outPrice = 0.5*outPrice;
		}
		//获取水果进价
		FruitModel fruit = new FruitModel(outPrice, fruitName);
		double inPrice=0;
		for(FruitModel fruit2 : stockMap.keySet()) {
			if(fruit2.equals(fruit)) {
				inPrice = fruit2.getInPrice();
			}
		}
		//记录
		double profit = (outPrice-inPrice)*weight;
		if(weight>stockMap.get(fruit)) {
			System.out.println("库存不足,请重新输入");
			return;
		}
		
		SaleRecordModel saleRecord = new SaleRecordModel(customerid, sex, fruitName, weight, outPrice,date,profit);
		saleRecordslist.add(saleRecord);
		System.out.println("记录成功！");
		//扣减库存

		stockMap.put(fruit, stockMap.get(fruit)-weight);
		
		//记录销量
		if(saleCountMap.containsKey(fruit)) {
			saleCountMap.put(fruit, saleCountMap.get(fruit)+weight);
		}else {
			saleCountMap.put(fruit, weight);
		}
		
		
	}
	//显示库存
	public void showStock() {
		System.out.println("当前库存：");
		for(FruitModel fruit:stockMap.keySet()) {
			System.out.println("水果   "+fruit.getName() + "  库存：" + stockMap.get(fruit)+"kg");
		}
	}
	
	//查询所有销售记录
	public void showSaleRecords() {
		for(SaleRecordModel saleRecord : saleRecordslist) {
			System.out.println(saleRecord.toString());
		}
	}
	
	//查询指定日期间隔的销售利润
	public double searchProfit(String startDate,String endDate) {
		double sum=0;
		for(SaleRecordModel saleRecord : saleRecordslist) {
			if(saleRecord.getDate().compareTo(startDate)>=0&&
					saleRecord.getDate().compareTo(endDate)<0) {
				sum += saleRecord.getProfit();
			}
		}
		System.out.println("当前时间段的销售利润： "+sum+"元");
		return sum;
	}

	//按销售数量排序显示
	public void orderBySaleCount() {
		//对saleCountMap排序
		List<Map.Entry<FruitModel, Integer>> list = new ArrayList<>(saleCountMap.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<FruitModel, Integer>>() {
			
			@Override
            public int compare(Map.Entry<FruitModel, Integer> o1, Map.Entry<FruitModel, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
		});
		int count =3;
		System.out.println("销量排名前三位的：");
		for(Map.Entry<FruitModel, Integer> mapping : list) {
			if(count-- > 0) {
				
				System.out.println(mapping.getKey().getName()+" 水果 ，销量为："+mapping.getValue());
			}
		}
		
	}
	
	//展示摊位详细信息
	public void showAll() {
		System.out.println("当前所有信息：");
		for(Map.Entry<FruitModel, Integer> mapping : stockMap.entrySet()) {
			System.out.print(" 水果 " + mapping.getKey().getName() + " 库存数："
					+mapping.getValue()+" 进价:"+mapping.getKey().getInPrice()+" 售价："+
					mapping.getKey().getOutPrice());
			int saleCount = 0;
			double saleMoney = 0;
			int inStockCount = 0;
			double inMoney = 0;
			//从销售记录获取累计销量
			for(SaleRecordModel saleRecord : saleRecordslist) {
				if(saleRecord.getFruitid().equals(mapping.getKey().getName())) {
					saleCount += saleRecord.getWeight();
					saleMoney +=  saleRecord.getWeight() * saleRecord.getOutPrice();
				}
			}
			System.out.print("  累计销量/销售额：" + saleCount + "kg / " + saleMoney+"￥");
			//获取累计进货量
			for(Map.Entry<FruitModel, Integer> mapping1 : temp.entrySet()) {
				if(mapping.getKey().getName().equals(mapping1.getKey().getName())) {
					inStockCount += mapping1.getValue();
					inMoney += mapping1.getValue() * mapping1.getKey().getInPrice();
				}
			}
			System.out.println("  累计进货量/进货金额：" + inStockCount + "kg / " + inMoney+"￥");
		}
		
		
	}
}
