package controller;

import java.util.ArrayList;

import model.EmployeeContainer;
import model.Employee;

public class EmployeeController {
	private EmployeeContainer container;

	public EmployeeController() {
		container = EmployeeContainer.getInstance();
	}

	// Method for finding customer by phoneNo in class CustomerContainer
	public ArrayList<Employee> getAll() {
		return container.getAll();
	}

}
