package model;

public abstract class Product {
	private String barcode, description, location; 
	private int quantity, minQuantity, maxQuantity;
	private static int barcodeCount;
	private double costPrice, retailPrice, tradeAllowance;
	
	public Product(String description, String location, int quantity, int minQuantity, int maxQuantity, double costPrice, double retailPrice) {
		++barcodeCount;
		this.barcode = barcode();
		this.description = description;
		this.location = location;
		this.minQuantity = minQuantity;
		this.maxQuantity = maxQuantity;
		this.costPrice = costPrice;
		this.retailPrice = retailPrice;
		this.tradeAllowance = calTradeAllowance();
	}
	public String getBarcode() {
		return barcode;
	}
	private String barcode() {
		String rbarcode = String.format("%08d", barcodeCount);
		return rbarcode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public int getMinQuantity() {
		return minQuantity;
	}
	public void setMinQuantity(int minQuantity) {
		this.minQuantity = minQuantity;
	}
	public int getMaxQuantity() {
		return maxQuantity;
	}
	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}
	public double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}
	public double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}
	public double getTradeAllowance() {
		return tradeAllowance;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double calTradeAllowance() {
		return retailPrice - costPrice;
	}
	public void updateQuantity(int amount) {
		this.setQuantity(this.getQuantity() - amount);
	}

}
