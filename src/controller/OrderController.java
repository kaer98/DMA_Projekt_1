package controller;

import java.util.ArrayList;

import model.*;
import tui.*;
/**
 * Order controller Class
 *
 *@author Rasmus,Cawan,Frederik,Oskar
 *@version 1.0
 *
 */

public class OrderController {

	private OrderContainer orderContainer;
	private ProductController productController;
	private CustomerController customerController;
	private Order order;
	private ArrayList<PartOrder> parts;
	private Product product;
	public OrderController() {
		orderContainer = OrderContainer.getInstance();
		productController = new ProductController();
		customerController = new CustomerController();
		parts = new ArrayList<>();
	}
	public Order makeOrder() {
		return order = new Order(Login.getEmployee());
	}
	public void addOrder(Order order) {
		orderContainer.addOrder(order);		
	}
	
	public void addPartOrder(Order o, PartOrder p) {
		o.addPartOrder(p);
	}
	public void addNewPartOrder(Product product, int quantity) {
		order.addNewPartOrder(product, quantity);
	}

	public Product findProductByBarcode(String searchString) {
		product = productController.findProductByBarcode(searchString);
		return product;
	}
	public ArrayList<Order> getOrders(){
		return orderContainer.getOrders();
	}
	public void newList() {
		parts.clear();
	}
	public void addToList(PartOrder partOrder) {
		parts.add(partOrder);
	}
	public ArrayList<PartOrder> getParts() {
		return parts;
	}
	public int getQuantity(int i) {
		return productController.getQuantity(i);
	}

	public void updateQuantity(int amount, int i) {
		productController.updateQuantity(i, amount);
	}

	public Customer findCustomerByPhoneNo(String searchString) {
		return customerController.findCustomerByPhoneNo(searchString);

	}
}
