package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
	private ArrayList<PartOrder> parts;
	private LocalDate dateTime;
	private Customer customer;
	private Employee employee;
	private int orderNo;
	
	public Order(Employee employee) {
		this.parts = new ArrayList<>();
		this.dateTime = LocalDate.now();
		this.employee = employee;
		++this.orderNo;
	}
	
	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public ArrayList<PartOrder> getParts() {
		return parts;
	}

	public void setParts(ArrayList<PartOrder> parts) {
		this.parts = parts;
	}

	public LocalDate getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDate dateTime) {
		this.dateTime = dateTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public void addPartOrder(PartOrder partOrder) {
		parts.add(partOrder);
	}
	
	public void addNewPartOrder(Product product, int quantity) {
		parts.add(new PartOrder(product, quantity));
	}
	public void createInvoice() {
		System.out.println("Vestbjerg Byggecenter A/S");
		System.out.println("Adresse");
		System.out.println("By");
		System.out.println("CVR-nr.:");
		System.out.println();
		System.out.println("Dato:					Fakturanr.:"+ orderNo);
		System.out.println();
		System.out.println("Faktura");
		System.out.println("Beskrivelse: " + product "Antal: " + amount, "Stk. Pris", "Pris" + totalPrice);
		System.out.println();
		System.out.println("Produkt" + product, "Antal"+  amount, "Stk. Pris" + retailPrice, "Pris" + totalPrice);
		System.out.println("");
		System.out.println("Subtotal: "+ subTotal);
		System.out.println("Moms (25.00%)" + moms);
		System.out.println("Total DKK" +sum);

	}
	
	

}
