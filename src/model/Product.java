package model;

public abstract class Product {
	private static int barcodeCount;
	private String barcode, description, location;
	private int quantity, minQuantity, maxQuantity;
	private double costPrice, retailPrice, tradeAllowance;
	private boolean appliance;

	public Product(String description, String location, int quantity, int minQuantity, int maxQuantity,
			double costPrice, double retailPrice) {
		++barcodeCount;
		this.barcode = barcode();
		this.quantity = quantity;
		this.description = description;
		this.location = location;
		this.minQuantity = minQuantity;
		this.maxQuantity = maxQuantity;
		this.costPrice = costPrice;
		this.retailPrice = retailPrice;
		this.tradeAllowance = calTradeAllowance();
	}

	private String barcode() {
		String rbarcode = String.format("%08d", barcodeCount);
		return rbarcode;
	}

	public double calTradeAllowance() {
		return retailPrice - costPrice;
	}

	public abstract ApplianceCopy findApplianceCopyBySerialNo(String serialNo);

	// Get and Set methods for Product
	public String getBarcode() {
		return barcode;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public String getDescription() {
		return description;
	}

	public String getLocation() {
		return location;
	}

	public int getMaxQuantity() {
		return maxQuantity;
	}

	public int getMinQuantity() {
		return minQuantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getRetailPrice() {
		return retailPrice;
	}

	public double getTradeAllowance() {
		return tradeAllowance;
	}

	public boolean isAppliance() {
		return appliance;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	public void setMinQuantity(int minQuantity) {
		this.minQuantity = minQuantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public abstract void updateQuantity(int amount);

	public abstract void updateQuantity(String string);

}
