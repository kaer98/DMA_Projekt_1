package model;

public class PartOrderQ extends PartOrder{
	private int quantity;
	private Product product;
	public PartOrderQ(Product product, int quantity) {
		super(product);
		this.quantity = quantity;
	}

	public double getTotal() {
		return product.getRetailPrice()*quantity;
	}
	public int getQuantity() {
		return quantity;
}
}
