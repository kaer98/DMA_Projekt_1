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
	private int salary, noOfSales;
	private double totalSales;
	
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

	public void tickSale() {
		noOfSales++;
	}
	public void setNoOfSales(int noSales) {
		this.noOfSales = noSales;
	}

	public double getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(double totalSales) {
		this.totalSales += totalSales;
	}

	public boolean isManager() {
		return manager;
	}
}
