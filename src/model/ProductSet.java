package model;

import java.util.ArrayList;

public class ProductSet {
	private ArrayList<Product> products;
	private double totalPrice;
	private String description;
	
	public ProductSet(ArrayList<Product> products, double totalPrice, String description) {
		products = new ArrayList<>();
		this.totalPrice = totalPrice;
		this.description = description;
	}

}
