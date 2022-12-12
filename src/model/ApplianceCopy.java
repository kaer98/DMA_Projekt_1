package model;

public class ApplianceCopy {
	private Appliance appliance;
	private String serialNo;
	
	  // Constructor for creating a BookCopy of Book
	  public ApplianceCopy(Appliance appliance, String serialNo) {
	    this.appliance = appliance;
	    this.serialNo = serialNo;
	    
	  }

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