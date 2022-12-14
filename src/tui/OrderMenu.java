package tui;

import java.util.ArrayList;

import controller.OrderController;
import model.ApplianceCopy;
import model.Order;
import model.PartOrder;
import model.PartOrderAppliance;
import model.PartOrderQ;
import model.Product;

/**
 * Class for controlling orders
 *
 * @author Rasmus,Cawan,Frederik,Oskar
 * @version 1.0
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
		switch (choice) {
		case 1:
			boolean done = false;
			order = orderController.makeOrder();
			po.clear();
			while (order.getCustomer() == null) {
				String s = Input.inputString("skriv Telefon Nummer på kunden (00000000 hvis kontantkunde)");
				order.setCustomer(orderController.findCustomerByPhoneNo(s));
			}
			System.out.println(order.getCustomer().getName());
			while (!done) {
				done = addOrder();
			}
			start();
			break;
		case 2:
			orderController.fill();
			System.out.println("Data genereret");
			start();
			break;
		default:
			MainMenu.start();
		}
	}


	private boolean addOrder() {
		boolean done = false;
		int orderChoice = ordermenu();
		switch (orderChoice) {
		case 0:
			start();
		case 1:
			Product p = null;
			ApplianceCopy ac = null;
			while (p == null) {
				p = orderController.findProductByBarcode(Input.inputString("Barcode: "));
				if (p == null) {
					System.out.println("Produkt ikke fundet! prøv igen");
				}
			}
			System.out.println(p.getDescription());
			System.out.println(p.getQuantity() + " på lager");
			System.out.println("Pris: " + p.getRetailPrice() + "kr");

			if (p.isAppliance()) {
				while (ac == null) {
					String s = Input.inputString("Serienummer: ");
					ac = p.findApplianceCopyBySerialNo(s);
					if (ac == null) {
						System.out.println("serienummer ikke fundet. prøv igen");
					} else {
						po.add(new PartOrderAppliance(ac));
						p.updateQuantity(s);
					}
				}
			} else {
				int amount = 0;
				do {
					amount = Input.inputInt("\nHvor mange: ");
					if (amount > p.getQuantity()) {
						System.out.println("Der er kun: " + p.getQuantity() + " på lager");
					}
				} while (amount < 0 || amount > p.getQuantity());

				po.add(new PartOrderQ(p, amount));
				p.updateQuantity(amount);
			}
			break;
		case 2:
			order.setParts(po);
			done = true;
			int choice2 = offerMenu();
			switch (choice2) {
			case 1:
				order.setFinal("Salg(ikke Betalt)");
				break;
			case 2:
				order.setFinal("Tilbud");
				break;
			}
			orderController.addOrder(order);
			order.createInvoice();
			if (order.getFinal() != "Tilbud") {
				int choice1 = payMenu();
				switch (choice1) {
				case 1:
					order.setFinal("Betalt");
					order.getEmployee().tickSale();
					order.getEmployee().setTotalSales(order.getTotal());
					order.createInvoice();
					break;
				case 2:
					order.setFinal("Faktura");
					order.getEmployee().tickSale();
					order.getEmployee().setTotalSales(order.getTotal());
					order.createInvoice();
				}
			}
			break;
		}
		return done;
	}

	private int offerMenu() {
		TextMenu menu = new TextMenu("\n ###Hvordan skal salget laves?###");
		menu.addOption("lav som salg");
		if (!order.getCustomer().getCvr().contains("00000000"))
			menu.addOption("Lav som tilbud");
		return menu.prompt();
	}

	private int ordermenu() {
		TextMenu menu = new TextMenu("\n ###Opret Order###", "afbrud");
		menu.addOption("Tilføj nyt Product");
		menu.addOption("færdig");

		return menu.prompt();
	}

	private int payMenu() {
		TextMenu menu = new TextMenu("\n ###Betaling###");
		String s = "";
		if (order.getCustomer().getCvr().contains("00000000")) {
			menu.addOption("betal nu (" + order.getTotalWDiscount() * 1.25 + " kr)");
		} else {
			menu.addOption("betal nu (" + order.getTotalWDiscount() * 1.25 + " kr)");
			menu.addOption("faktura");
		}
		return menu.prompt();
	}


	private int writeMenu() {
		TextMenu menu = new TextMenu("\n ###Order###", "Tilbage");
		menu.addOption("Opret ordre");
		menu.addOption("Generer test data");
		return menu.prompt();
	}

}
