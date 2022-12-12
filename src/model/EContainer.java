package model;

import java.util.ArrayList;

public class EContainer {
	private ArrayList<Employee> container;
	private static EContainer instance;
	
	private EContainer() {
		this.container = new ArrayList<>();
		fill();
	}
	
	public static EContainer getInstance() {
		if(instance == null) {
			instance = new EContainer();
		}
		return instance;
	}
	
	public void addEmployee(String name, String phoneNo, String mailAddress, String country, String postalCode, String city,
			String address, Boolean manager, int salary) {
		container.add(new Employee(name, phoneNo, mailAddress, country, postalCode, city, address, manager, salary));
	}
	
	public ArrayList<Employee> getAll() {
		return container;
	}
	
	public void fill() {
		addEmployee("Jens", "34567891", "jens@live.com", "Denmark", "9000", "Aalborg", "Østre Havnegade", true, 999);
		addEmployee("Jesper", "12345678", "jesper@gmail.com", "Denmark", "9000", "Aalborg", "Tæt på skole", false, 999);
		addEmployee("Klaus", "23456789", "klaus@hotmail.dk", "Denmark", "9000", "Aalborg", "Islandsgade", false, 999);
		addEmployee("Ole", "45678912", "ole@yahoo.dk", "Denmark", "9000", "Aalborg", "Kennedy Street", false, 999);
		
	}
	
}
