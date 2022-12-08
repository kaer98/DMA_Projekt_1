package model;

import java.util.ArrayList;

public class OrderContainer {

	private static OrderContainer instance = null;
	private ArrayList<Order> container;
	
	private OrderContainer() {
		container = new ArrayList<>();
	}
	
	public static OrderContainer getInstance() {
		if(instance == null) {
			instance = new OrderContainer();
		}
		return instance;
	}
	public void addOrder(Order order) {
		container.add(order);
	}
	
	public void addNewOrder(Employee employee) {
		container.add(new Order(employee));
	}
	
	public ArrayList<Order> getOrders(){
		return container;   
	}
	
	
}
