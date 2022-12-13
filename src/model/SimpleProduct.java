package model;

public class SimpleProduct extends Product {
	// SimpleProduct class that inherits from Product 
	public SimpleProduct(String description, String location, int quantity,  int minQuantity, int maxQuantity,
			double costPrice, double retailPrice){
		super(description, location, quantity, minQuantity, maxQuantity, costPrice, retailPrice);
	}

}