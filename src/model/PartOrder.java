package model;

public class PartOrder {

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
}
