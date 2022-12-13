package model;
import java.util.ArrayList;

public class  Appliance extends Product {
	
	private ArrayList<ApplianceCopy> appliances;
	
	// Constructor that takes in several parameters to initialize an Appliance object:
	public Appliance(String description, String location, int quantity, int minQuantity, int maxQuantity,
			double costPrice, double retailPrice) {
		super(description, location, quantity, minQuantity, maxQuantity, costPrice, retailPrice);
		appliances = new ArrayList<ApplianceCopy>();
	}

// Get and Set methods for field "serialNo"
    public ArrayList<ApplianceCopy> getApplianceCopy(){
        return appliances;
    }

	public void addApplianceCopy(String serialNo) {
		this.serialNo = serialNo;
	}
}
