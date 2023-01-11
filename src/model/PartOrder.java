package model;

public abstract class PartOrder {

	private Product product;

	public PartOrder() {

	}

	public PartOrder(Product product) {
		this.product = product;
	}

	public abstract ApplianceCopy getCopy();

	public Product getProduct() {
		return product;
	}

	public String getProductName() {
		return product.getDescription();
	}

	// Abstract methods to get quantity of Product and total of the order
	public abstract int getQuantity();

	public abstract double getTotal();
	public abstract double getPrice();
}
