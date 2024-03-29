package model;

import java.util.ArrayList;

public class CustomerContainer {

	private static CustomerContainer instance;
	private ArrayList<Customer> container;

	// Get instance method that returns a Singleton
	public static CustomerContainer getInstance() {
		if (instance == null) {
			instance = new CustomerContainer();
		}
		return instance;
	}

	// Private constructor that creates a new ArrayList and calls fill method to add
	// to ArrayList with Customer objects.
	private CustomerContainer() {
		container = new ArrayList<>();
	}
	
	public void updateCustomer(int id, String name, String cvr, String phone, String email, String adress, String postalcode, String city, String country, double discount) {
		container.get(findCustomerIndex(id)).setName(name);
		container.get(findCustomerIndex(id)).setCvr(cvr);
		container.get(findCustomerIndex(id)).setPhoneNo(phone);
		container.get(findCustomerIndex(id)).setMailAddress(email);
		container.get(findCustomerIndex(id)).setAddress(adress);
		container.get(findCustomerIndex(id)).setPostalCode(postalcode);
		container.get(findCustomerIndex(id)).setCity(city);
		container.get(findCustomerIndex(id)).setCountry(country);
		container.get(findCustomerIndex(id)).setDiscount(discount);
	}
	
	// addCustomer method that adds a Customer to ArrayList
	public void addCustomer(Customer customer) {
		container.add(customer);
	}

	// addNewCustomer method with parameters to create new Customer and add to
	// ArrayList.
	public Customer addNewCustomer(String name, String phoneNo, String mailAddress, String country, String postalCode,
			String city, String address, String cvr, double discount) {
		Customer c = new Customer(name, phoneNo, mailAddress, country, postalCode, city, address, cvr, discount);
		container.add(c);
		return c;
	}

	public ArrayList<Customer> getAll(){
		return container;
	}
	

	// Fill method that fills Customer objects to ArrayList.
	public void fill() {
		addNewCustomer("Jens", "12345678", "jens0@ucn.dk", "Danmark", "9000", "Aalborg", "Jens vej 1", "11111111",10);
		addNewCustomer("Jonas", "88888888", "jonas@ucn.dk", "Danmark", "8000", "København", "Jonas vej 2", "22222222",20);
		addNewCustomer("Jeppe", "11111111", "jeppe@ucn.dk", "Danmark", "7000", "Odense", "Jeppe vej 3", "33333333",50);
		addNewCustomer("Ole", "88888888", "ole@ucn.dk", "Danmark", "1000", "Skagen", "Ole vej 9", "44444444", 40);
		addNewCustomer("Ib", "01010101", "ib@ucn.dk", "Danmark", "8888", "Herning", "Ib vej 2", "5555555", 22);
		addNewCustomer("Christian", "77777777", "christian@ucn.dk", "Danmark", "7777", "Århus", "Christian vej 7", "66666666", 15);
		addNewCustomer("Michael", "81818181", "michael@ucn.dk", "Danmark", "8111", "Brovst", "Michael vej 8","77777777", 22);
		addNewCustomer("Ole", "88888888", "ole@ucn.dk", "Danmark", "1000", "Skagen", "Ole vej 9", "98765432", 40);
		addNewCustomer("Thomas", "55555555", "thomas@ucn.dk", "Danmark", "5000", "Middelfart", "Thomas vej 5","55555555", 23);
		addNewCustomer("John", "12121212", "john@ucn.dk", "Danmark", "2000", "Rødekro", "John vej 2", "25252525", 25);
		addNewCustomer("KONTANTKUNDE", "00000000", "", "Danmark", "0000", "KONTANT SALG", "", "00000000", 0);
		addNewCustomer("Jesper", "98758548", "jesper@gmail.com", "Danmark", "5260", "Odense S","Jesper vej 4", "00000000", 5);		
	}

	// findCustomerByPhoneNo takes in (String phoneNo) and returns the Customer with -
	// the given phoneNo if its visible in ArrayList through a while-loop.
	public Customer findCustomerByPhoneNo(String phoneNo) {
		Customer customer = null;
		int index = 0;
		boolean found = false;
		while (index < container.size() && !found) {
			customer = container.get(index);
			if (customer.getPhoneNo().contains(phoneNo)) {
				found = true;
			} else {
				index++;
			}
		}
		if (found) {
			return container.get(index);
		} else {
			return null;
		}
	}
	
	public int findCustomerIndex(int id) {
		int i = 0;
		boolean found = false;
		while(i<container.size() && !found) {
			if(container.get(i).getId()==id) {
				found = true;
			}
			else {
				i++;
			}
		}
		return i;		
	}
	
	public void removeCustomer(Customer c) {
		container.remove(c);
	}
	
	public int size() {
		return container.size();
	}
	
}
