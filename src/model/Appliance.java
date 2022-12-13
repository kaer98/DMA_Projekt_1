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

// Get method for appliances
    public ArrayList<ApplianceCopy> getApplianceCopy(){
        return appliances;
    }
    
    public int getApplianceQuantity(){
        return appliances.size();
    }

	public void addApplianceCopy(ApplianceCopy applianceCopy) {
		appliances.add(applianceCopy);
	}
	
	public void addNewApplianceCopy(String serialNo) {
		ApplianceCopy applianceCopy = new ApplianceCopy (serialNo);
		appliances.add(applianceCopy);
	}	
	
	// findApplianceCopyBySerialNo takes in a (String serialNo) and returns the ApplianceCopy with the given serialNo if it is visible in the ArrayList through a while-loop.
    public ApplianceCopy findApplianceCopyBySerialNo(String serialNo){
        ApplianceCopy applianceCopy = null;
        int index = 0;
        boolean found = false;
        while(index < appliances.size() && !found){
            applianceCopy = appliances.get(index);
            if(applianceCopy.getSerialNo().equals(serialNo)){
                found = true;
            }
            else{
                 index++;
                }
         }
        if (found){
            return appliances.get(index);
        }
        else{   
        	return null;
        }
    }
}
