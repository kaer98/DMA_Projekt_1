package controller;

import java.util.ArrayList;

import model.Appliance;
import model.ApplianceCopy;
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
	
	public ApplianceCopy findApplianceCopyBySerialNo(Product product2, String serialNo) {
		ApplianceCopy applianceCopy = product2.findApplianceCopyBySerialNo(serialNo);
		return applianceCopy;
		
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

	public void updateQuantity(int amount, Product p) {
		productContainer.updateQuantity(amount, p);
	}
	
	public void updateQuantity(String serialNo) {
		product.updateQuantity(serialNo);
	}
}
