package model;
import java.util.ArrayList;

public class  Appliance extends Product {
	
	private ArrayList<ApplianceCopy> appliances;
	private boolean appliance;

	// Constructor that takes in several parameters to initialize an Appliance object:
	public Appliance(String description, String location, int quantity, int minQuantity, int maxQuantity,
			double costPrice, double retailPrice) {
		super(description, location, quantity, minQuantity, maxQuantity, costPrice, retailPrice);
		appliances = new ArrayList<ApplianceCopy>();
		appliance = true;
		newAppliancecopy(quantity);
	}

// Get method for appliances
    public ArrayList<ApplianceCopy> getApplianceCopy(){
        return appliances;
    }
    
    public int getQuantity(){
        return appliances.size();
    }
    
    
    public boolean isAppliance() {
    	return appliance;
    }

	public void addApplianceCopy(ApplianceCopy applianceCopy) {
		appliances.add(applianceCopy);
	}
	
	public void addNewApplianceCopy(int count) {
		ApplianceCopy applianceCopy = new ApplianceCopy (this, count);
		appliances.add(applianceCopy);
	}	
	
	public void updateQuantity(String SerialNo) {
		appliances.remove(findApplianceCopyBySerialNo(SerialNo));
	}
	// findApplianceCopyBySerialNo takes (String serialNo) and returns ApplianceCopy with given serialNo if its visible in ArrayList through a while-loop.
	public void newAppliancecopy(int quantity) {
		for(int i=0;i<quantity;i++) {
			ApplianceCopy a = new ApplianceCopy(this,i);
			addApplianceCopy(a);
		}
	}
    public ApplianceCopy findApplianceCopyBySerialNo(String serialNo){
        ApplianceCopy applianceCopy = null;
        int index = 0;
        boolean found = false;
        while(index < appliances.size() && !found){
            applianceCopy = appliances.get(index);
            if(applianceCopy.getSerialNo().toLowerCase().contains(serialNo.toLowerCase())){
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
    public void updateQuantity(int amount) {
    	
    }
}
