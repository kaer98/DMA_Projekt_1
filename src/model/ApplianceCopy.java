package model;

public class ApplianceCopy {
	private Appliance appliance;
	private String serialNo;
	
	  // Constructor for creating copy of appliance
	  public ApplianceCopy(String serialNo) {
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
    // Purpose of this class is to create a copy of "Appliance" object, with a new serial number