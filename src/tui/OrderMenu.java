package tui;
import controller.OrderController;
import model.Order;
import model.PartOrder;
import model.Product;

import java.util.ArrayList;


/**
 * Class for controlling orders
 *
 *@author Rasmus,Cawan,Frederik,Oskar
 *@version 1.0
 *
 */
public class OrderMenu {
	private OrderController orderController;
	private Order order;
	private ArrayList<PartOrder> po;
	public OrderMenu() {
		orderController = new OrderController();
		po = new ArrayList<>();
	}
	public void start() {
        int choice = writeMenu();
        switch(choice) {
        case 1:
        	boolean done = false;
        	po.clear();
        	while(!done) {
        		done = addOrder();	
        	}
        	for(int i = 0; i<=orderController.getOrders().get(0).getParts().size()-1;i++) {
        		System.out.println(orderController.getOrders().get(0).getParts().get(i).getProductName());
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
    	int orderChoice = ordermenu();
    	order = orderController.makeOrder();
    	orderController.newList();
    	switch(orderChoice) {
    	case 0:
    		start();
    	case 1:
    		po.add(new PartOrder(orderController.findProductByBarcode(Input.inputString("Barcode")), Input.inputInt("\nhvor mange")));
    		break;
    	case 2: 
    		order.setParts(po);
    		orderController.addOrder(order);
    		done = true;
    		
    	}
    	return done;
    }
    
    //private int 

}
