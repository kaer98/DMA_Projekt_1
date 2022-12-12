package controller;
import java.util.ArrayList;

import model.Product;
import model.ProductContainer;
/**
 * Product controller Class
 *
 *@author Rasmus,Cawan,Frederik,Oskar
 *@version 1.0
 *
 */
public class ProductController {
	private ArrayList<Product> products;
	private ProductContainer productContainer;
	private Product product;
	
	public ProductController() {
		productContainer = ProductContainer.getInstance();
	}
	
	public ArrayList<Product> getAll(){
		return products;
	}
	public Product findProductByBarcode(String searchString) {
		product = productContainer.findProductByBarcode(searchString);
		return product;
	}
	
	public int getQuantity(int i) {
		return getQuantity(i);
	}
}
