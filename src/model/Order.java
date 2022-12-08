package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
	private ArrayList<PartOrder> parts;
	private LocalDate dateTime;
	private Customer customer;
	private Employee employee;
	
	public Order(Customer customer, Employee employee) {
		parts = new ArrayList<>();
		this.dateTime = LocalDate.now();
		this.customer = customer;
		this.employee = employee;
	}
	
	public void addPartOrder(Product product, int quantity) {
		parts.add(new PartOrder(product, quantity));
	}
	

}
