package model;

public abstract class PartOrder {

	private Product product;
	public PartOrder(Product product) {
		this.product = product;
	} 
	public String getProductName() {
		return product.getDescription();
	}
	
	public Product getProduct(){
		return product;
	}
	
	public abstract int getQuantity();
	
	public abstract double getTotal();
}
