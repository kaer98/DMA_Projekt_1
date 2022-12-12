package model;

public class PartOrderAppliance extends PartOrder{
	private String serialNo;
	
	public PartOrderAppliance(Product product, String serialNo) {
		super(product);
		this.serialNo = serialNo;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
}
