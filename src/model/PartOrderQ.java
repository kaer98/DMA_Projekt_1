package model;

public class PartOrderQ extends PartOrder{
	private int quantity;
	
	public PartOrderQ(Product product, int quantity) {
		super(product);
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
