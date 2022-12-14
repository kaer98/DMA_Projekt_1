package tui;

import model.EContainer;
import model.Employee;
import java.util.ArrayList;

import controller.EmployeeController;

/**
 * Login Class
 *
 *@author Rasmus,Cawan,Frederik,Oskar
 *@version 1.0
 *
 */
public class Login {
	private static Boolean manager;
	private EmployeeController controller;
	private static ArrayList<Employee> staff;
	private static String staffName;
	private static Employee employee;

	public Login() {
		controller = new EmployeeController();
		staff = controller.getAll();
	}
    
	public static void start() {
		int choice =writeLogin();
		staffName =staff.get(choice-1).getName();
		manager = staff.get(choice-1).isManager();
		employee = staff.get(choice-1);
		MainMenu menu = new MainMenu();
		menu.start();
	}

	public static void setManager(boolean tf) {
		manager = tf;
	}
	public static boolean isManager() {
		if(manager == null) {
			manager = false;
		}
		return manager;
	}
	private static int writeLogin() {
		TextMenu menu = new TextMenu("\n ###Login###");
		for(Employee sa : staff) {
			menu.addOption(sa.getName());
		}
		return menu.prompt();
	}
	public static String getEmployeeName() {
		return staffName;
	}
	public static Employee getEmployee() {
		return employee;
	}
}
