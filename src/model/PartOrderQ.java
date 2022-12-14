package model;

public class PartOrderQ extends PartOrder {
	private int quantity;

	public PartOrderQ(Product product, int quantity) {
		super(product);
		this.quantity = quantity;
	}

	@Override
	public ApplianceCopy getCopy() {
		// TODO Auto-generated method stub
		return null;
	}

	// Get and Set methods for quantity
	@Override
	public int getQuantity() {
		return quantity;
	}

	// @Override getTotal method from PartOrder to get price of Product * quantity
	// of product ordered
	@Override
	public double getTotal() {
		return getProduct().getRetailPrice() * quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
