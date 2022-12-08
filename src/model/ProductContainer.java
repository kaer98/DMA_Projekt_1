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
			double costPrice, double retailPrice) {
		Product p = new Product(description, location, quantity, minQuantity, maxQuantity, costPrice, retailPrice);
		container.add(p);
	}

	public void fill() {
		addNewProduct("Træ 200x400", "Timber department", 200, 50, 300, 100, 124.99);
		addNewProduct("Gipsplade 90x240", "Timber department", 50, 20, 150, 70, 125);
		addNewProduct("Krydsfiner 122x244", "Timber department", 50, 25, 200, 650, 920);
	}
}
