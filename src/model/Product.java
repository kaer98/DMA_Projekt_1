package model;

public class Product {
	private String barcode, description, location; 
	private int quantity, minQuantity, maxQuantity;
	private double costPrice, retailPrice, tradeAllowance;
	
	public Product(String barcode, String description, String location, int quantity, int minQuantity, int maxQuantity,
			double costPrice, double retailPrice) {
		this.barcode = barcode;
		this.description = description;
		this.location = location;
		this.quantity = quantity;
		this.minQuantity = minQuantity;
		this.maxQuantity = maxQuantity;
		this.costPrice = costPrice;
		this.retailPrice = retailPrice;
		this.tradeAllowance = calTradeAllowance();
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	public double calTradeAllowance() {
		return retailPrice - costPrice;
	}
	

}
