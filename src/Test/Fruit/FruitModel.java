package Test.Fruit;
/**
 * 
 * @author dell
 *水果实体类
 */
public class FruitModel {
	 private int stock;//每次进货的数量
	 private double inPrice;
	 private double outPrice;
	 private String name;
	 
	 
	 


	public FruitModel(double outPrice, String name) {
		super();
		this.outPrice = outPrice;
		this.name = name;
	}



	public FruitModel(String name) {
		super();
		this.name = name;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FruitModel other = (FruitModel) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}



	public FruitModel(int stock, double inPrice, double outPrice, String name) {
		super();
		this.stock = stock;
		this.inPrice = inPrice;
		this.outPrice = outPrice;
		this.name = name;
	}

	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getInPrice() {
		return inPrice;
	}
	public void setInPrice(int inPrice) {
		this.inPrice = inPrice;
	}
	public double getOutPrice() {
		return outPrice;
	}
	public void setOutPrice(int outPrice) {
		this.outPrice = outPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	 
	 
	 
}
