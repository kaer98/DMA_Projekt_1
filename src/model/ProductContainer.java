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
}
