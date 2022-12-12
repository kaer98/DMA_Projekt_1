package model;

import java.util.ArrayList;

public class CustomerContainer {

private static CustomerContainer instance = null;
private ArrayList<Customer> container;
	
	private CustomerContainer() {
		container = new ArrayList<>();
		fill();
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
	
	public void addNewCustomer(String name, String cvr, String country, String postalCode, String city, String adress,
			String phoneNo, String mailAdress, double discount) {
		Customer c = new Customer (name, cvr, country, postalCode, city, adress, phoneNo, mailAdress, discount);
		container.add(c);
	}	
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
    addNewCustomer("KONTANTKUNDE","00000000","Danmark", "0000","KONTANT SALG", "","00000000","",0);
    

    
    
    



}				
}
