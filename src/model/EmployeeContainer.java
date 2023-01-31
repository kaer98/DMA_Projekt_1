package model;

import java.util.ArrayList;

// Singleton class
public class EmployeeContainer {	
	private static EmployeeContainer instance;
	private ArrayList<Employee> container;
	// Method to create a new instance of class
	public static EmployeeContainer getInstance() {
		if (instance == null) {
			instance = new EmployeeContainer();
		}
		return instance;
	}

	private EmployeeContainer() {
		this.container = new ArrayList<>();
		fill();
	}

	// addEmployee method to add new Employee objects to container list
	public void addEmployee(String name, String phoneNo, String mailAddress, String country, String postalCode,
			String city, String address, Boolean manager, int salary, String password) {
		container.add(new Employee(name, phoneNo, mailAddress, country, postalCode, city, address, manager, salary, password));
	}

	// Fill method to fill container list with Employee objects
	public void fill() {
		addEmployee("Jens", "34567891", "jens@live.com", "Denmark", "9000", "Aalborg", "Østre Havnegade", true, 999, "Manager1");
		addEmployee("Jesper", "12345678", "jesper@gmail.com", "Denmark", "9000", "Aalborg", "Tæt på skole", true, 999, "Manager2");
		addEmployee("Klaus", "23456789", "klaus@hotmail.dk", "Denmark", "9000", "Aalborg", "Islandsgade", false, 999, "");
		addEmployee("Ole", "45678912", "ole@yahoo.dk", "Denmark", "9000", "Aalborg", "Kennedy Street", false, 999, "");

	}

	// getAll method to get list of Employee from Econtainer
	public ArrayList<Employee> getAll() {
		return container;
	}

}
