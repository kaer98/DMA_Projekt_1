package model;

import java.util.ArrayList;

public class CustomerContainer {

private static CustomerContainer instance = null;
private ArrayList<Customer> container;
	
	private CustomerContainer() {
		container = new ArrayList<>();
	}
	
	public static CustomerContainer getInstance() {
		if(instance == null) {
			instance = new CustomerContainer();
		}
		return instance;
	}
	
	public void addCustomer(Customer customer) {
		container.add(customer);
	}
	
    public Customer findCustomerByName(String name){
        Customer customer = null;
        int index = 0;
        boolean found = false;
        while(index < container.size() && !found){
            customer = container.get(index);
            if(customer.getName().equals(name)){
                found = true;
            }
            else{
                 index++;
                }
         }
        if (found){
            return container.get(index);
        }
        else{   
        	return null;
        }
    }

    public Customer findCustomerByPhoneNo(String phoneNo){
        Customer customer = null;
        int index = 0;
        boolean found = false;
        while(index < container.size() && !found){
            customer = container.get(index);
            if(customer.getPhoneNo().equals(phoneNo)){
                found = true;
            }
            else{
                 index++;
                }
         }
        if (found){
            return container.get(index);
        }
        else{   
        	return null;
        }
    }
    
    public Customer findCustomerByCvr(String Cvr){
        Customer customer = null;
        int index = 0;
        boolean found = false;
        while(index < container.size() && !found){
            customer = container.get(index);
            if(customer.getCvr().equals(Cvr)){
                found = true;
            }
            else{
                 index++;
                }
         }
        if (found){
            return container.get(index);
        }
        else{   
        	return null;
        }
    }
	
}
