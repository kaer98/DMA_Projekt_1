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
	
	
}
