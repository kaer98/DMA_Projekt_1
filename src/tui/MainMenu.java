package tui;


/**
 * Class for the main menu
 *
 *@author Rasmus,Cawan,Frederik,Oskar
 *@version 1.0
 *
 */
public class MainMenu {
	private static OrderMenu orderMenu;
	private static Boolean manager;
	
	public MainMenu() {
		//this.manager = false;
		orderMenu = new OrderMenu();
	}

	 public static void start() {
		 	int log = writeLogin();
		 	if(log==1) {
		 		setManager();
		 	}
	        int choice = writeMainMenu();
	        switch(choice) {
	        case 1:
	        	orderMenu.start();
	        	break;
	        case 2:
	        	break;
	        default:
	        	System.out.println("bye");       
	       }
	 	}
	    private static int writeMainMenu(){
	        TextMenu menu = new TextMenu("\n ###Hovedmenu###", "Afslut programmet");
	        menu.addOption("Lav ordre");
	        menu.addOption("Lav tilbud");
	        menu.addOption("Opret nyt produkt");
	        menu.addOption("Find ordre");
	        menu.addOption("Find firmakunde");
	        menu.addOption("Find enkelt produkt");
	        
	        return menu.prompt();
	    }
	    private static int writeLogin() {
	    	TextMenu menu = new TextMenu("\n ###Login###", "Afslut");
	    	menu.addOption("Manager");
	    	menu.addOption("Salgsassisnt");
	    	
	    	return menu.prompt();
	    }
	    private static void setManager() {
	    	manager = true;
	    }
	    public static boolean isManager() {
	    	if(manager == null) {
	    		manager = false;
	    	}
	    	return manager;
	    }
	    
	 }
