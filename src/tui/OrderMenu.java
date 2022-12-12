package tui;
import controller.OrderController;
import model.Order;
import model.PartOrder;
import model.PartOrderQ;
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
			order = orderController.makeOrder();
			po.clear();
			while(order.getCustomer()==null) {
			String s =Input.inputString("skriv Telefon Nummer på kunden (00000000 hvis kontantkunde)");
			order.setCustomer(orderController.findCustomerByPhoneNo(s));
			}
			System.out.println(order.getCustomer().getName());
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
	
	private boolean addOrder() {
		boolean done = false;
		int orderChoice = ordermenu();
		switch(orderChoice) {
		case 0:
			start();
		case 1:
			Product p =null;
			while(p==null) {
			p = orderController.findProductByBarcode(Input.inputString("Barcode: "));
			if(p==null) {
				System.out.println("Produkt ikke fundet! prøv igen");
			}
			else {
			System.out.println(p.getDescription());
			System.out.println(p.getQuantity()+" på lager");
			}
			}
			int amount = 0;
			while(amount <=0 || amount>p.getQuantity()) {
				amount = Input.inputInt("\nHvor mange: ");
				if(amount>p.getQuantity()) {
					System.out.println("Der er kun: "+ p.getQuantity() + " på lager");
				}
			}
			po.add(new PartOrderQ(p, amount));
			p.updateQuantity(amount);
			break;
		case 2: 
			order.setParts(po);
			done = true;
			int choice2 = offerMenu();
			switch(choice2) {
			case 1:
				order.setFinal("Tilbud");
				break;
			case 2:
				order.setFinal("Faktura");
				break;
			case 3: 
				order.setFinal("Betalt");
				break;
			}
			order.getEmployee().tickSale();
			order.getEmployee().setTotalSales(order.getSubTotal());
			orderController.addOrder(order);
			order.createInvoice();
			
			break;
		}
		return done;
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

		orderController.newList();
		switch(orderChoice) {
		case 0:
			start();
		case 1:
			String pro = Input.inputString("Barcode");
			int amount = Input.inputInt("\nhvor mange");
			po.add(new PartOrderQ(orderController.findProductByBarcode(pro), amount));
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
	
	private int offerMenu() {
		TextMenu menu = new TextMenu("\n ###Hvordan skal salget laves?###");
		menu.addOption("Lav som tilbud");
		menu.addOption("lav som faktura");
		menu.addOption("lav som salg");
		return menu.prompt();
	}

}
