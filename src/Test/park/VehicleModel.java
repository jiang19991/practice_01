package Test.park;

public class VehicleModel {

	private int height;//车的高度
	//public boolean license;//是否有车牌
	private String license;//车牌
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((license == null) ? 0 : license.hashCode());
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
		VehicleModel other = (VehicleModel) obj;
		if (license == null) {
			if (other.license != null)
				return false;
		} else if (!license.equals(other.license))
			return false;
		return true;
	}
	public VehicleModel(int height, String license) {
		super();
		this.height = height;
		this.license = license;
	}
	@Override
	public String toString() {
		return "Vehicle [ license:" + license + "]";
	}
	public VehicleModel(String license) {
		super();
		this.license = license;
	}
	
	
}
