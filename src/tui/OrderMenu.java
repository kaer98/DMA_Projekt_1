package tui;
import controller.OrderController;
import model.Order;
import model.PartOrder;


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
			order = orderController.makeOrder();
			po.clear();
			String s =Input.inputString("skriv Telefon Nummer på kunden (00000000 hvis kontantkunde)");
			order.setCustomer(orderController.findCustomerByPhoneNo(s));
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
		menu.addOption("lav som tilbud");
		menu.addOption("lav som Ordre");
		menu.addOption("færdig");

		return menu.prompt();
	}

	private boolean addOrder() {
		boolean done = false;
		int orderChoice = ordermenu();

		orderController.newList();
		switch(orderChoice) {
		case 0:
			start();
		case 1:
			String pro = Input.inputString("Barcode");
			int amount = Input.inputInt("\nhvor mange");
			po.add(new PartOrder(orderController.findProductByBarcode(pro), amount));
			orderController.findProductByBarcode(pro).updateQuantity(amount);
			break;
		case 2:
			order.setFinal(true);
			break;
		case 3:
			order.setFinal(false);
			break;
		case 4: 
			order.setParts(po);
			orderController.addOrder(order);
			done = true;
			order.createInvoice();
			break;
		}
		return done;
	}

	//private int 

}
