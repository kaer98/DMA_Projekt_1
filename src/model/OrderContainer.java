package model;

import java.util.ArrayList;

public class OrderContainer {
    // Singleton class
	private static OrderContainer instance = null;
	private ArrayList<Order> container;
	
	private OrderContainer() {
		container = new ArrayList<>();
	}
	// Create new instance if it doesn't exist
	public static OrderContainer getInstance() {
		if(instance == null) {
			instance = new OrderContainer();
		}
		return instance;
	}
	// addOrder method to create new Order object to container
	public void addOrder(Order order) {
		container.add(order);
	}
	//addNewOrder to to create new Order with Employee object which adds to container
	public void addNewOrder(Employee employee) {
		container.add(new Order(employee));
	}
	// return Order container from OrderContainer class
	public ArrayList<Order> getOrders(){
		return container;   
	}
	
	
	
}
