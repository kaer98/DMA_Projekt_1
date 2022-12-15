package controller;

import model.Customer;
import model.CustomerContainer;

/**
 * Customer controller Class
 *
 * @author Rasmus,Cawan,Frederik,Oskar
 * @version 1.0
 *
 */
public class CustomerController {
	private CustomerContainer container;

	public CustomerController() {
		container = CustomerContainer.getInstance();
	}
	
	public void addCustomer(Customer c) {
		container.addCustomer(c);
	}

	// Method for finding customer by phoneNo in class CustomerContainer
	public Customer findCustomerByPhoneNo(String phoneNo) {
		return container.findCustomerByPhoneNo(phoneNo);
	}

	public void fill() {
		container.fill();
	}
}
