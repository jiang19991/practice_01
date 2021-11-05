package Test.Fruit;

//import java.util.Date;
/**
 * 
 * @author dell
 *销售记录实体类
 */
public class SaleRecordModel {
	private String id;
	private String sex;
	private String fruitName;
	private double weight;
	private double outPrice;
	private String date;
	private double Profit;
	
	

	
	public SaleRecordModel(String id, String sex, String fruitName, double weight, double outPrice, String date,
			double profit) {
		super();
		this.id = id;
		this.sex = sex;
		this.fruitName = fruitName;
		this.weight = weight;
		this.outPrice = outPrice;
		this.date = date;
		Profit = profit;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getFruitid() {
		return fruitName;
	}
	public void setFruitid(String fruitid) {
		this.fruitName = fruitid;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public double getOutPrice() {
		return outPrice;
	}
	public void setOutPrice(int outPrice) {
		this.outPrice = outPrice;
	}

	public double getProfit() {
		return Profit;
	}

	public void setProfit(double profit) {
		Profit = profit;
	}

	@Override
	public String toString() {
		return "SaleRecord [顾客=" + id + ", 性别=" + sex + ", 水果=" + fruitName + ", 购买数量=" + weight
				+ ", 售价=" + outPrice + ", 时间=" + date + ", 利润=" + Profit +"]";
	}
	
	

}
