package model;

public class PartOrderAppliance extends PartOrder {
	private ApplianceCopy applianceCopy;

	public PartOrderAppliance(ApplianceCopy ac) {
		super();
		this.applianceCopy = ac;
	}

	@Override
	public ApplianceCopy getCopy() {
		return applianceCopy;
	}

	@Override
	public Appliance getProduct() {
		return applianceCopy.getAppliance();
	}

	@Override
	public String getProductName() {
		return applianceCopy.getDescription();
	}

	@Override
	public int getQuantity() {
		return 1;
	}

	// @Override from PartOrder
	@Override
	public double getTotal() {
		return applianceCopy.getRetailPrice();
	}
	
	public double getPrice() {
		return applianceCopy.getRetailPrice();
	}

	@Override
	public void setQuantity(int quantity) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setProduct(ApplianceCopy ac) {
		this.applianceCopy = ac;
		
	}
}