package model;

public class ApplianceCopy {
	private Appliance appliance;
	private String serialNo;
	
	  // Constructor for creating a Appliance copy of appliance
	  public ApplianceCopy(Appliance appliance, String serialNo) {
	    this.appliance = appliance;
	    this.serialNo = serialNo;
	    
	  }
    // Get and Set methods for fields appliance and serialNo
	public Appliance getAppliance() {
		return appliance;
	}

	public void setAppliance(Appliance appliance) {
		this.appliance = appliance;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	  
}
    // Purpose of this class is to create a copy of an "Appliance" object, with a new serial number