package model;

public class PartOrderAppliance extends PartOrder{
	private ApplianceCopy applianceCopy;
	
	public PartOrderAppliance(ApplianceCopy product) {
		super();
		this.applianceCopy = product;
	}

	// @Override from PartOrder 
	public double getTotal() {
		return applianceCopy.getRetailPrice();
	}
	
	public String getProductName() {
		return applianceCopy.getDescription();
	}
	public int getQuantity() {
		return 1;
	}
	public Appliance getProduct() {
		return applianceCopy.getAppliance();
	}
	public ApplianceCopy getCopy() {
	return applianceCopy;
}
}
