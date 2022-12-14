package model;

/**
 * Employee Class
 *
 * @author Rasmus,Cawan,Frederik,Oskar
 * @version 1.0
 *
 */
public class Employee extends Person {
	private boolean manager;
	private int noOfSales;
	private double salary, totalSales;

	public Employee(String name, String phoneNo, String mailAddress, String country, String postalCode, String city,
			String address, Boolean manager, double salary) {

		super(name, phoneNo, mailAddress, country, postalCode, city, address);
		this.manager = manager;
		this.salary = salary;
		noOfSales = 0;
		totalSales = 0;
	}

	public int getNoOfSales() {
		return noOfSales;
	}

	// Get and Set methods for Salary, noOfSales and totalSales
	public double getSalary() {
		return salary;
	}

	public double getTotalSales() {
		return totalSales;
	}

	// isManager method that determines access to other menus
	public boolean isManager() {
		return manager;
	}

	public void setNoOfSales(int noSales) {
		this.noOfSales = noSales;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setTotalSales(double totalSales) {
		this.totalSales += totalSales;
	}

	// tickSale method that ++ noOfSales
	public void tickSale() {
		noOfSales++;
	}
}
