package model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
	private static int orderNo;
	private static final DecimalFormat dfSharp = new DecimalFormat("#.##");
	private ArrayList<PartOrder> parts;
	private LocalDate dateTime;
	private Customer customer;
	private Employee employee;
	private String finalized;
	private double total;

	public Order(Employee employee) {
		this.parts = new ArrayList<>();
		this.dateTime = LocalDate.now();
		this.employee = employee;
		++Order.orderNo;
		this.finalized = "intet";
	}

	public void addNewPartOrderAppliance(ApplianceCopy product) {
		parts.add(new PartOrderAppliance(product));
	}
	/*
	 * createInvoice() is used to create an invoice.
	 */

	public void addNewPartOrderQ(Product product, int quantity) {
		parts.add(new PartOrderQ(product, quantity));
	}

	public void addPartOrder(PartOrder partOrder) {
		parts.add(partOrder);
	}

	public void createInvoice() {
		double discount = 0;
		System.out.println("#######Vestbjerg Byggecenter A/S#######");
		System.out.println("Medarbejder: " + employee.getName());
		System.out.println();
		System.out.println("Dato: " + dateTime + " 					Fakturanr.:" + orderNo);
		System.out.println();
		System.out.println("Faktura");
		if (getFinal() == "Salg")
			System.out.println("Betalingsdato: " + dateTime + " 					Type: " + getFinal());
		if (getFinal() == "Faktura")
			System.out.println("Betalingsdato: " + dateTime.plusDays(14) + " 					Type: " + getFinal());
		if (getFinal() == "Tilbud")
			System.out.println("Tilbud acceptdato: " + dateTime.plusDays(14) + " 					Type: " + getFinal());
		System.out.println("Kunde: " + customer.getName() + " \nKundes telefon: " + customer.getPhoneNo());
		System.out.println("Kundes e-mail: " + customer.getMailAddress() + " \nKundes adresse: " + customer.getAddress());
		System.out.println("Kundes CVR-nr: " + customer.getCvr());
		for (PartOrder parts : getParts()) {
			if (parts.getQuantity() != 0 && !parts.getProduct().isAppliance())
				System.out.println("\nBeskrivelse: " + parts.getProductName() + " Antal: " + parts.getQuantity() + " Stk. Pris: " + parts.getProduct().getRetailPrice() + " Pris: " + dfSharp.format(parts.getTotal()));
			if (parts.getProduct().isAppliance()) {
				System.out.println("\nBeskrivelse: " + parts.getProductName() + " Pris: " + dfSharp.format(parts.getTotal()));
				System.out.println("serienummer: " + parts.getCopy().getSerialNo());
			}
		}
		System.out.println(""); 
		System.out.println("Subtotal: " + dfSharp.format(getTotal())+"kr");
		if (customer.getDiscount() != 0) {
			discount = getTotal() * (customer.getDiscount());
			System.out.println("-" + (customer.getDiscount() * 100) + "% rabat " + "(" + discount + ")");
		}
		System.out.println("Moms (25%): " + dfSharp.format(getTotalWDiscount() * 0.25) + "kr af " + dfSharp.format(getTotalWDiscount())+"kr");
		System.out.println("Total DKK: " + (dfSharp.format(getTotalWDiscount() * 1.25)));

	}

	public Customer getCustomer() {
		return customer;
	}

	public LocalDate getDateTime() {
		return dateTime;
	}

	public Employee getEmployee() {
		return employee;
	}

	public String getFinal() {
		return finalized;
	}

	// Getters and setters
	public int getOrderNo() {
		return orderNo;
	}

	public ArrayList<PartOrder> getParts() {
		return parts;
	}

	public double getTotal() {
		total = 0;
		for (PartOrder p : parts) {
			total += p.getTotal();
		}
		return total;
	}

	public double getTotalWDiscount() {
		double total = getTotal() * (1 - getCustomer().getDiscount());
		return total;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setDateTime(LocalDate dateTime) {
		this.dateTime = dateTime;
	}

	/*
	 * The following methods adds partOrders/changes the quantity/ adds appliance
	 */

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setFinal(String string) {
		finalized = string;
	}

	public void setOrderNo(int orderNo) {
		Order.orderNo = orderNo;
	}

	public void setParts(ArrayList<PartOrder> parts) {
		this.parts = parts;
	}

}
