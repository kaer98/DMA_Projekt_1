package model;

public abstract class PartOrder {

	private Product product;
	public PartOrder(Product product) {
		this.product = product;
	} 
	// getProduct method that returns Product
	public String getProductName() {
		return product.getDescription();
	}
	
	public Product getProduct(){
		return product;
	}
	// Abstract methods to get quantity of Product and total of the order
	public abstract int getQuantity();
	
	public abstract double getTotal();
}
