package controller;

import java.util.ArrayList;

import model.Product;
import model.ProductContainer;
import model.SimpleProduct;

/**
 * Product controller Class
 *
 * @author Rasmus,Cawan,Frederik,Oskar
 * @version 1.0
 *
 */
public class ProductController {
	private ArrayList<Product> products;
	private ProductContainer productContainer;
	private Product product;

	public ProductController() {
		productContainer = ProductContainer.getInstance();
	}

	public Product findProductByBarcode(String searchString) {
		product = productContainer.findProductByBarcode(searchString);
		return product;
	}
	
	public void addProduct(Product p) {
		productContainer.addProduct(p);
	}
	
	public void fill() {
		productContainer.fill();
	}
	
	public boolean isEmpty() {
		return productContainer.isEmpty();
	}

	public ArrayList<Product> getAll() {
		return productContainer.getAll();
	}

	public int getQuantity(int i) {
		return productContainer.getQuantity(i);
	}

	public void updateQuantity(int amount, int i) {
		productContainer.updateQuantity(i, amount);
	}
}
