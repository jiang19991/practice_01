package Test.park;

public class ParkingLotModel {

	private boolean stateOfParkingSpqce;
	private int numOfParkingSpace;
	public boolean isStateOfParkingSpqce() {
		return stateOfParkingSpqce;
	}
	public void setStateOfParkingSpqce(boolean stateOfParkingSpqce) {
		this.stateOfParkingSpqce = stateOfParkingSpqce;
	}
	public int getNumOfParkingSpace() {
		return numOfParkingSpace;
	}
	public void setNumOfParkingSpace(int numOfParkingSpace) {
		this.numOfParkingSpace = numOfParkingSpace;
	}
	@Override
	public String toString() {
		return "ParkingLot [stateOfParkingSpqce=" + stateOfParkingSpqce + ", numOfParkingSpace=" + numOfParkingSpace
				+ "]";
	}
	public ParkingLotModel(boolean stateOfParkingSpqce, int numOfParkingSpace) {
		super();
		this.stateOfParkingSpqce = stateOfParkingSpqce;
		this.numOfParkingSpace = numOfParkingSpace;
	}
	public ParkingLotModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ParkingLotModel(int numOfParkingSpace) {
		super();
		this.numOfParkingSpace = numOfParkingSpace;
	}
	public ParkingLotModel(boolean stateOfParkingSpqce) {
		super();
		this.stateOfParkingSpqce = stateOfParkingSpqce;
	}
	
}
