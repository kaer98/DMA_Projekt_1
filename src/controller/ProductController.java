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
	public ArrayList<Product> products;
	public ProductContainer productContainer;
	
	public ProductController() {
		productContainer = ProductContainer.getInstance();
	}
	
	public ArrayList<Product> getAll(){
		return products;
	}
	public Product findProductByName() {
		return productContainer.findProductByName();
	}
}
