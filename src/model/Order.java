package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
	private ArrayList<PartOrder> parts;
	private LocalDate dateTime;
	private Customer customer;
	private Employee employee;
	private static int orderNo;
	private boolean finalized;
	private double total, discount;
	
	public Order(Employee employee) {
		this.parts = new ArrayList<>();
		this.dateTime = LocalDate.now();
		this.employee = employee;
		++this.orderNo;
		this.finalized = false;
	}
	
	public int getOrderNo() {
		return orderNo;
	}
	
	public void setFinal(boolean b) {
		finalized = b;
	}
	
	public double getTotal() {
		total = 0;
		for(PartOrder p : parts) {
			total += p.getTotal();
		}
		return total;
	}
	
	public double getTotalWDiscount() {
		return getTotal()*discount;
	}
	public void  setOrderNo(int orderNo) {
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
	
	
	

}
