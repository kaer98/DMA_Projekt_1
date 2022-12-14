package tui;

import java.util.ArrayList;
import controller.EmployeeController;
import model.Employee;

/**
 * Login Class
 *
 * @author Rasmus,Cawan,Frederik,Oskar
 * @version 1.0
 *
 */
public class Login {
	private static Boolean manager;
	private static ArrayList<Employee> staff;
	private static String staffName;
	private static Employee employee;
	public static Employee getEmployee() {
		return employee;
	}

	public static String getEmployeeName() {
		return staffName;
	}

	public static boolean isManager() {
		if (manager == null) {
			manager = false;
		}
		return manager;
	}

	public static void setManager(boolean tf) {
		manager = tf;
	}

	public static void start() {
		int choice = writeLogin();
		staffName = staff.get(choice - 1).getName();
		manager = staff.get(choice - 1).isManager();
		employee = staff.get(choice - 1);
		MainMenu menu = new MainMenu();
		MainMenu.start(); 
	}

	private static int writeLogin() {
		TextMenu menu = new TextMenu("\n ###Login###");
		for (Employee sa : staff) {
			menu.addOption(sa.getName());
		}
		return menu.prompt();
	}

	private EmployeeController controller;

	public Login() {
		controller = new EmployeeController();
		staff = controller.getAll();
	}
}
