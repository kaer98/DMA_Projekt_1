package model;

public class SimpleProduct extends Product {
	// SimpleProduct class that inherits from Product
	public SimpleProduct(String description, String location, int quantity, int minQuantity, int maxQuantity,
			double costPrice, double retailPrice) {
		super(description, location, quantity, minQuantity, maxQuantity, costPrice, retailPrice);
	}

	@Override
	public ApplianceCopy findApplianceCopyBySerialNo(String serialNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateQuantity(int amount) {
		this.setQuantity(this.getQuantity() - amount);
	}

	@Override
	public void updateQuantity(String string) {
		// TODO Auto-generated method stub

	}

}