package model;

public class ApplianceCopy{
	private Appliance appliance;
	private String serialNo;
	private int count;

	// Constructor for creating a Appliance copy of appliance
	public ApplianceCopy(Appliance appliance, int count) {

		this.appliance = appliance;
		this.count = count;
		this.serialNo = genSerialNo();

	}

	private String genSerialNo() {
		String returnString = (appliance.getDescription().substring(0, 4) + count);
		return returnString;
	}

	// Get and Set methods for fields appliance and serialNo
	public Appliance getAppliance() {
		return appliance;
	}

	public String getDescription() {
		return appliance.getDescription();
	}

	public double getRetailPrice() {
		return appliance.getRetailPrice();
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setAppliance(Appliance appliance) {
		this.appliance = appliance;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
}