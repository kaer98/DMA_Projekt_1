package tui;



/**
 * Class for controlling orders
 *
 *@auther Rasmus,Cawan,Frederik,Oskar
 *@version 1.0
 *
 */
public class OrderMenu {
	
	public void start() {
        int choice = writeMenu();
        switch(choice) {
        case 1:
        	//some thing
        	break;
        case 2:
        	break;
        default:
        	MainMenu.start();  
       }
 	}
    private int writeMenu(){
        TextMenu menu = new TextMenu("\n ###Order###", "Tilbage");
        menu.addOption("Firmakunde");
        menu.addOption("Opret Firmakunde");
        menu.addOption("Kontant kunde");
        
        return menu.prompt();
    }

}
