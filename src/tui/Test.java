package tui;
import static org.junit.Assert.*;
import controller.*;
import model.*;

import org.junit.Before;

public class Test {
private OrderController orderController;
private CustomerController customerController;
private ProductController productController;
private EmployeeController employeeController;
private EContainer eContainer;
private boolean success;
	@Before
	public void setup() {
		orderController = new OrderController();
		customerController = new CustomerController();
		productController = new ProductController();
		employeeController = new EmployeeController();
		eContainer = EContainer.getInstance();
		
	}
	
	@org.junit.Test
	public void testAddProductToOrder() {
		//arrange 
		Product p = new SimpleProduct("description", "loacation", 5, 2, 10, 10, 20);
		Order o = new Order(eContainer.getAll().get(0));
		success = false;
		
		
		//act
		PartOrder po = new PartOrderQ(p,1);
		o.addPartOrder(po);
		orderController.addOrder(o);
		
		//assert
		int i = 0;
		
		while(success == false && orderController.getOrders().size()>i) {
			Order order = orderController.getOrders().get(i);
			if(order.getParts().size() != 0) {
			if(order.getParts().get(0).getProductName()==o.getParts().get(0).getProductName()) {
				success = true;
			}
			}
			i++;
		}
		if(!success) {
		fail("something went wrong");
		}
		return;
	}
	
	@org.junit.Test
	public void testAddCustomerToOrder() {
		//arrange
		Order o = new Order(eContainer.getAll().get(0));
		Customer c = new Customer("name", "phoneNo", "mailAddress", "country", "postalCode", "city", "address", "cvr", 0);
		success = false;
		
		//act
		customerController.addCustomer(c);
		o.setCustomer(c);
		orderController.addOrder(o);
		
		//assert
		for(Order order : orderController.getOrders()) {
			if(order.getCustomer().getName()==o.getCustomer().getName()) {
				success = true;
			}	
		}
		if(!success) {
			fail("something went wrong");
		}	
	}
	
}
