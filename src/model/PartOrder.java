package model;

public class PartOrder {

	private Product product;
	private int quantity;

	public PartOrder(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	} 
	
	public double getTotal() {
		return product.getRetailPrice()*quantity;
	}
	
}
