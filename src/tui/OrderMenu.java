package tui;
import controller.OrderController;


/**
 * Class for controlling orders
 *
 *@author Rasmus,Cawan,Frederik,Oskar
 *@version 1.0
 *
 */
public class OrderMenu {
	private OrderController orderController;
	
	public OrderMenu() {
		orderController = new OrderController();
	}
	public void start() {
        int choice = writeMenu();
        switch(choice) {
        case 1:
        	boolean done = false;
        	while(!done) {
        		done = addOrder();
        		
        	}
        	start();
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
    
    private int ordermenu() {
    	TextMenu menu = new TextMenu("\n ###Opret Order###", "afbrud");
    	menu.addOption("Tilføj nyt Product");
    	menu.addOption("færdig");
    	
    	return menu.prompt();
    }
    
    private boolean addOrder() {
    	boolean done = false;
    	int orderChoice =ordermenu();
    	orderController.makeOrder();
    	switch(orderChoice) {
    	case 0:
    		start();
    	case 1:
    		String s = Input.inputString("Barcode: ");
    		orderController.addPartOrder(orderController.findProductByBarcode(s), Input.inputInt("\nhvor mange: "));
    		break;
    	case 2: 
    		orderController.addOrder();
    		done = true;
    		
    	}
    	return done;
    }
    
    //private int 

}
