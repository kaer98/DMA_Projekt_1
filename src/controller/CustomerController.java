package controller;

import java.util.ArrayList;

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
	
	public ArrayList<Customer> getAll(){
		return container.getAll();
	}

	public void fill() {
		container.fill();
	}
	
	public Customer addNewCustomer(String name, String phoneNo, String mailAddress, String country, String postalCode,
			String city, String address, String cvr, double discount) {
		Customer c = container.addNewCustomer(name, phoneNo, mailAddress, country, postalCode,
				city, address, cvr, discount);
		
		return c;
	}

	public void updateCustomer(int id, String name, String phone, String email, String country,
			String postalcode, String city, String address, String cvr, double discount) {
		container.updateCustomer(id, name, cvr, phone, email, address, postalcode, city, country, discount);
		
	}
	
	public int findCustomerIndex(int id) {
		return container.findCustomerIndex(id);
	}
}
