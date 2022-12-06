package tui;

public class Login {
	private static Boolean manager;
	
	
	public Login() {
	
	}
	
	public static void start() {
		int choice =writeLogin();
		if(choice==1) {
			setManager(true);
		}
		else {
			setManager(false);
		}
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
    	menu.addOption("Manager");
    	menu.addOption("Salgsassisnt");
    	
    	return menu.prompt();
    }
}
