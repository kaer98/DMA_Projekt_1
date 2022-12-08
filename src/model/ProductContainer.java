package model;

import java.util.ArrayList;

public class ProductContainer {

private static ProductContainer instance = null;
private ArrayList<Product> container;

	
	private ProductContainer() {
		container = new ArrayList<>();
	}
	
	public static ProductContainer getInstance() {
		if(instance == null) {
			instance = new ProductContainer();
		}
		return instance;
	}
	
	public void addProduct(Product product) {
		container.add(product);
	}
	
	public void addNewProduct(String description, String location, int quantity, int minQuantity, int maxQuantity,
			double costPrice, double retailPrice, double tradeAllowance) {
		Product p = new Product(description, location, quantity, minQuantity, maxQuantity, costPrice, retailPrice, tradeAllowance);
		container.add(p);
	}
	
	public double 

	addNewProduct("Træ 2x4m", "Timber department", 200, 50, 300, 100, 124.99, 24.99);
	addNewProduct(, "")
	
}
