package model;

public class PartOrderAppliance extends PartOrder{
	private String serialNo;
	
	public PartOrderAppliance(Product product, String serialNo) {
		super(product);
		this.serialNo = serialNo;
	}
    // Get and Set methods for SerialNo 
	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	// @Override from PartOrder 
	public double getTotal() {
		return getProduct().getRetailPrice();
	}
	
	public int getQuantity() {
		return 1;
	}
	
}
