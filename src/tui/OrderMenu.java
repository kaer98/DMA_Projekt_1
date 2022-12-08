package tui;



/**
 * Class for controlling orders
 *
 *@author Rasmus,Cawan,Frederik,Oskar
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
        	if(Login.isManager()==true) {
        		System.out.println("manager");
        	}
        	else {
        		System.out.println("no entry");
        	}
        	break;
        default:
        	MainMenu.start();  
       }
 	}
    private int writeMenu(){
        TextMenu menu = new TextMenu("\n ###Order###", "Tilbage");
        menu.addOption("Opret ordre");
        menu.addOption("Find ordre");
        menu.addOption("Slet ordre");
        
        return menu.prompt();
    }

}
