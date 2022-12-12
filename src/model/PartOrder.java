package model;

public class PartOrder {

	private Product product;
	private int quantity;

	public PartOrder(Product product) {
		this.product = product;
	} 
	
	public String getProductName() {
		return product.getDescription();
	}
	
	public double getTotal() {
		return product.getRetailPrice()*quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public Product getProduct(){
		return product;
	}
}
