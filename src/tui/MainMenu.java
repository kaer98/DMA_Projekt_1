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
	
	public MainMenu() {
		//this.manager = false;
		orderMenu = new OrderMenu();
	}

	 public static void start() {
	        int choice = writeMainMenu();
	        switch(choice) {
	        case 1:
	        	orderMenu.start();
	        	break;
	        case 2:
	        	break;
	        default:
	        	Login.start();       
	       }
	 	}
	    private static int writeMainMenu(){
	        TextMenu menu = new TextMenu("\n ###Hovedmenu###", "Log ud");
	        menu.addOption("Ordre menu");
	        menu.addOption("Produkt menu");
	        menu.addOption("Kunde menu");
	        
	        return menu.prompt();
	    }
	    
	 }
