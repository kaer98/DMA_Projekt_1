package model;
/**
 * Employee Class
 *
 *@author Rasmus,Cawan,Frederik,Oskar
 *@version 1.0
 *
 */
public class Employee {
	private boolean manager;
	private String name, phoneNo, mailAdress;
	private int salary, noSales, totalSales;
	
	public Employee(Boolean manager, String name, String phoneNo, String mailAdress, int salary) {
		this.name = name;
		this.phoneNo = phoneNo;
		this.manager = manager;
		this.mailAdress = mailAdress;
		this.salary = salary;
		noSales = 0;
		totalSales = 0;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getMailAdress() {
		return mailAdress;
	}

	public void setMailAdress(String mailAdress) {
		this.mailAdress = mailAdress;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getNoSales() {
		return noSales;
	}

	public void setNoSales(int noSales) {
		this.noSales = noSales;
	}

	public int getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}

	public String getName() {
		return name;
	}
	public boolean isManager() {
		return manager;
	}
}
