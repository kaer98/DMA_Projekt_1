package tui;


/**
 * Class for the main menu
 *
 *@auther Rasmus,Cawan,Frederik,Oskar
 *@version 1.0
 *
 */
public class MainMenu {
	private static OrderMenu orderMenu;
	
	
	public MainMenu() {
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
	 }
