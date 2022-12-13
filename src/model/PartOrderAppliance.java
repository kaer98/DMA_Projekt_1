package model;

public class PartOrderAppliance extends PartOrder{
	private ApplianceCopy appliancecopy;
	
	public PartOrderAppliance(ApplianceCopy product) {
		super();
		this.appliancecopy = product;
	}

	// @Override from PartOrder 
	public double getTotal() {
		return getProduct().getRetailPrice();
	}
	
	public int getQuantity() {
		return 1;
	}
	
}
