package controller;

import model.Employee;

import java.util.ArrayList;

import model.EContainer;

public class EmployeeController {
	private EContainer container;
	public EmployeeController() {
		container = EContainer.getInstance();
	}
	// Method for finding customer by phoneNo in class CustomerContainer
	public ArrayList<Employee> getAll() {
		return container.getAll();
	}
	
}
	


