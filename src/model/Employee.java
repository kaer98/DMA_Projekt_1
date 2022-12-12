package model;
/**
 * Employee Class
 *
 *@author Rasmus,Cawan,Frederik,Oskar
 *@version 1.0
 *
 */
public class Employee extends Person {
	private boolean manager;
	private String name, phoneNo, mailAddress, country, postalCode, city, address, cvr;
	private int salary, noOfSales, totalSales;
	
	public Employee(String name, String phoneNo, String mailAddress, String country, String postalCode, String city,
			String address, Boolean manager, int salary) {
		
		super(name, phoneNo, mailAddress, country, postalCode, city, address);
		this.manager = manager;
		this.salary = salary;
		noOfSales = 0;
		totalSales = 0;
	}
	

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getNoOfSales() {
		return noOfSales;
	}

	public void setNoOfSales(int noSales) {
		this.noOfSales = noSales;
	}

	public int getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}

	public boolean isManager() {
		return manager;
	}
}
