package model;

import java.util.Random;

public abstract class PartOrder {

	private Product product;
	private int id;
	public PartOrder() {

	}

	public PartOrder(Product product) {
		this.product = product;
		Random rand = new Random();
		id = rand.nextInt(9999999);
	}

	public abstract ApplianceCopy getCopy();

	public Product getProduct() {
		return product;
	}
	public int getId() {
		return id;
	}
	public String getProductName() {
		return product.getDescription();
	}
	
	public abstract void setQuantity(int quantity);

	// Abstract methods to get quantity of Product and total of the order
	public abstract int getQuantity();

	public abstract double getTotal();
	
	public abstract double getPrice();
}
