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
	
	public void addEmployee(boolean manager, String name, String phoneNo, String mailAdress, int salary) {
		container.add(new Employee(manager, name, phoneNo, mailAdress, salary));
	}
	
	public ArrayList<Employee> getAll() {
		return container;
	}
	
	public void fill() {
		addEmployee(true, "Jens", "34567891", "jens@live.com", 999);
		addEmployee(false, "Jesper", "12345678", "jesper@gmail.com", 888);
		addEmployee(false, "Klaus", "23456789", "klaus@hotmail.dk", 777);
		addEmployee(false, "Ole", "45678912", "ole@yahoo.dk", 666);
		
	}
	
}
