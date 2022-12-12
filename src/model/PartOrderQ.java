package model;

public class PartOrderQ extends PartOrder{
	private int quantity;
	public PartOrderQ(Product product, int quantity) {
		super(product, quantity);
	}

	public double getTotal() {
		return product.getRetailPrice()*quantity;
	}
	public int getQuantity() {
		return quantity;
}
