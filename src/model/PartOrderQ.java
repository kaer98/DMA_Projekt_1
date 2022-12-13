package model;

public class PartOrderQ extends PartOrder{
	private int quantity;
	
	public PartOrderQ(Product product, int quantity) {
		super(product);
		this.quantity = quantity;
	}
    // Get and Set methods for quantity 
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// @Override getTotal method from PartOrder to get price of Product * quantity of product ordered
	public double getTotal() {
		return getProduct().getRetailPrice()*quantity;
	}
}
