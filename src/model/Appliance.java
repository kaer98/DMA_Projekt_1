package model;

public class  Appliance extends Product {
	private String serialNo;
	
	public Appliance(String description, String location, int quantity, int minQuantity, int maxQuantity,
			double costPrice, double retailPrice, String serialNo) {
		super(description, location, quantity, minQuantity, maxQuantity, costPrice, retailPrice);
		this.serialNo=serialNo;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
}
