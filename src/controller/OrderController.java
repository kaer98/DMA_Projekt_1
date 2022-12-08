package controller;

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
private Order order;
	public OrderController() {
		orderContainer = OrderContainer.getInstance();
		productController = new ProductController();
	}
	public void makeOrder() {
		order = new Order(Login.getEmployee());
	}
	public void addOrder() {
		orderContainer.addOrder(order);		
		}
		
	public void addPartOrder(Product product, int quantity) {
		order.addPartOrder(product, quantity);
	}
	
	public Product findProductByBarcode(String searchString) {
		return productController.findProductByBarcode(searchString);
	}
	
	
	
	
}
