package controller;

import java.util.ArrayList;
import model.ApplianceCopy;
import model.Customer;
import model.Order;
import model.OrderContainer;
import model.PartOrder;
import model.Product;
import tui.Login;

/**
 * Order controller Class
 *
 * @author Rasmus,Cawan,Frederik,Oskar
 * @version 1.0
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

	public void addNewPartOrderAppliance(ApplianceCopy p) {
		order.addNewPartOrderAppliance(p);
	}

	public void clearList() {
		parts.clear();
	}
	
	public void addNewPartOrderQ(Product product, int quantity) {
		order.addNewPartOrderQ(product, quantity);
	}

	public void addOrder(Order order) {
		orderContainer.addOrder(order);
	}

	public void addPartOrder(Order o, PartOrder po) {
		o.addPartOrder(po);
	}

	public void addToList(PartOrder po) {
		parts.add(po);
	}

	public void fill() {
		productController.fill();
		customerController.fill();
	}
	
	public Customer findCustomerByPhoneNo(String phoneNo) {
		return customerController.findCustomerByPhoneNo(phoneNo);

	}

	public Product findProductByBarcode(String barcode) {
		product = productController.findProductByBarcode(barcode);
		return product;
	}

	public ArrayList<Order> getOrders() {
		return orderContainer.getOrders();
	}

	public ArrayList<PartOrder> getParts() {
		return parts;
	}

	public int getQuantity(int i) {
		return productController.getQuantity(i);
	}
	
	public boolean productIsEmpty() {
		return productController.isEmpty();
	}

	public Order makeOrder() {
		return order = new Order(Login.getEmployee());
	}

	public void newList() {
		parts.clear();
	}

	
	public Order findOrderByCustomer(Customer customer) {
		Order order = orderContainer.findOrderByCustomer(customer);
		return order;
	}
	
	public PartOrder findPartOrderByProductName(String pName) {
		PartOrder part = order.findPartOrderByProductName(pName);
		return part;
	}
	
	public void setCustomerToOrder(Order o, Customer c) {
		o.setCustomer(c);
	}
	
	public void setProduct(ApplianceCopy ac, PartOrder po) {
		PartOrder currPO = po;
		currPO.setProduct(ac);
	}
	
	public void partOrderSetQuantity(int amount, PartOrder po) {
		PartOrder currPO = po;
		currPO.setQuantity(amount);
	}
}
