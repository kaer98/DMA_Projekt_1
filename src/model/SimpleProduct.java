package model;

public class SimpleProduct extends Product {
	private int quantity;
	
	public SimpleProduct(String description, String location, int minQuantity, int maxQuantity,
			double costPrice, double retailPrice, int quantity){
		super(description, location, minQuantity, maxQuantity, costPrice, retailPrice);
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void updateQuantity(int amount) {
		this.quantity -= amount;
	}

}