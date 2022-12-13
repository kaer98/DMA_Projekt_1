package model;

import java.util.Random;
public class ApplianceCopy {
	private Appliance appliance;
	private String serialNo;
	Random rand;
	
	  // Constructor for creating a Appliance copy of appliance
	  public ApplianceCopy(Appliance appliance) {
	    this.serialNo = genSerialNo();
	    this.appliance = appliance;
	    rand = new Random();
	    
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
	  
	private String genSerialNo() {
		String returnString = (""+rand.nextInt(100000000, 999999999));
		return returnString;
	}
}
    // Purpose of this class is to create a copy of an "Appliance" object, with a new serial number