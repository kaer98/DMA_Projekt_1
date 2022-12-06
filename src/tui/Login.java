package tui;

import model.SAContainer;
import model.SalesAssistant;
import java.util.ArrayList;

public class Login {
	private static Boolean manager;
	private SAContainer sAC;
	private static ArrayList<SalesAssistant> staff;
	private static String staffName;

	public Login() {
		sAC = SAContainer.getInstance();
		staff = sAC.getAll();
	}

	public static void start() {
		int choice =writeLogin();
		staffName =staff.get(choice-1).getName();
		manager = staff.get(choice-1).isManager();
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
		for(SalesAssistant sa : staff) {
			menu.addOption(sa.getName());
		}
		return menu.prompt();
	}
}
