package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
	private ArrayList<PartOrder> parts;
	private LocalDate dateTime;
	private Customer customer;
	private Employee employee;
	
	public Order(Employee employee) {
		parts = new ArrayList<>();
		this.dateTime = LocalDate.now();
		this.employee = employee;
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

	public void addPartOrder(Product product, int quantity) {
		parts.add(new PartOrder(product, quantity));
	}
	

}
