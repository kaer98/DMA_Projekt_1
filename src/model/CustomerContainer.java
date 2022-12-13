package model;

import java.util.ArrayList;

public class CustomerContainer {

private static CustomerContainer instance = null;
private ArrayList<Customer> container;
	
    // Private constructor that creates a new ArrayList and calls the "fill" method to add to the ArrayList with Customer objects. 
	private CustomerContainer() {
		container = new ArrayList<>();
		fill();
	}
	// Get instance method that returns a Singleton
	public static CustomerContainer getInstance() {
		if(instance == null) {
			instance = new CustomerContainer();
		}
		return instance;
	}
	// addCustomer method that adds a Customer to ArrayList
	public void addCustomer(Customer customer) {
		container.add(customer);
	}
	// findCustomerByName takes in a (String name) and returns the Customer with the given name if it is visible in ArrayList through a while-loop.
    public Customer findCustomerByName(String name){
        Customer customer = null;
        int index = 0;
        boolean found = false;
        while(index < container.size() && !found){
            customer = container.get(index);
            if(customer.getName().contains(name)){
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
   // findCustomerByPhoneNo takes in a (String phoneNo) and returns the Customer with the given phoneNo if it is visible in the ArrayList through a while-loop.
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
// findCustomerByCvr takes in a (String Cvr) and returns the Customer with the given Cvr if it is visible in the ArrayList through a while-loop.
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
	// addNewCustomer method with parameters to create new Customer and add to ArrayList. 
	public void addNewCustomer(String name, String phoneNo, String mailAdress, String postalCode, String city, String adress,
			String country, String cvr, double discount) {
		Customer c = new Customer (name, phoneNo, mailAdress, country, postalCode, city, adress, cvr, discount);
		container.add(c);
	}	
// Fill method that fills Customer objects to ArrayList. 
	public void fill() {
	addNewCustomer("Jens", "11111111", "Danmark", "9000", "Aalborg", "Jens vej 1", "12345678", "jens0@ucn.dk", 0.10);
	addNewCustomer("Jonas", "22222222", "Danmark", "8000", "København", "Jonas vej 2", "88888888", "jonas@ucn.dk", 0.20);
	addNewCustomer("Jeppe", "33333333", "Danmark", "7000", "Odense", "Jeppe vej 3", "11111111", "jeppe@ucn.dk", 0.50);
    addNewCustomer("Ole", "88888888", "Danmark", "1000", "Skagen", "Ole vej 9", "98765432", "ole@ucn.dk", 0.40);
    addNewCustomer("Ib", "01010101", "Danmark", "8888", "Herning", "Ib vej 2", "00110121", "ib@ucn.dk", 0.22);
    addNewCustomer("Christian", "77777777", "Danmark", "7777", "Århus", "Christian vej 7", "7777777", "christian@ucn.dk", 0.15);
    addNewCustomer("Michael", "81818181", "Danmark", "8111", "Brovst", "Michael vej 8", "81818181", "michael@ucn.dk", 0.22);
    addNewCustomer("Ole", "88888888", "Danmark", "1000", "Skagen", "Ole vej 9", "98765432", "ole@ucn.dk", 0.40);
    addNewCustomer("Thomas", "55555555", "Danmark", "5000","Middelfart", "Thomas vej 5", "55555555", "thomas@ucn.dk", 0.23);
    addNewCustomer("John", "12121212", "Danmark", "2000", "Rødekro", "John vej 2", "25252525", "john@ucn.dk", 0.25);
    addNewCustomer("KONTANTKUNDE","00000000","Danmark", "0000","KONTANT SALG", "","00000000","intet@intet.dk",0);
    

    
    
    



}				
}
