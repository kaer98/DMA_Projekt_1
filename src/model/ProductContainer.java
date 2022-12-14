package model;

import java.util.ArrayList;

public class ProductContainer {

	private static ProductContainer instance;
	// Singleton method.
	public static ProductContainer getInstance() {
		if (instance == null) {
			instance = new ProductContainer();
		}
		return instance;
	}

	private ArrayList<Product> container;

	private ProductContainer() {
		container = new ArrayList<>();
		fill();
	}

	public void addNewAppliance(String description, String location, int quantity, int minQuantity, int maxQuantity,
			double costPrice, double retailPrice) {
		Product p = new Appliance(description, location, quantity, minQuantity, maxQuantity, costPrice, retailPrice);
		container.add(p);
	}

	// addNewProduct method to create and add new Product object to container
	// creates new SimpleProduct
	public void addNewProduct(String description, String location, int quantity, int minQuantity, int maxQuantity,
			double costPrice, double retailPrice) {
		Product p = new SimpleProduct(description, location, quantity, minQuantity, maxQuantity, costPrice,
				retailPrice);
		container.add(p);
	}

	// adds product to ArrayList.
	public void addProduct(Product product) {
		container.add(product);
	}

	// fill method to fill Product objects to container
	public void fill() {
		addNewProduct("Træ 200x400", "Timber department", 200, 50, 300, 100, 124.99);
		addNewProduct("Gipsplade 90x240", "Timber department", 50, 20, 150, 70, 125);
		addNewProduct("Krydsfiner 122x244", "Timber department", 50, 25, 200, 650, 920);
		addNewProduct("Dampspærre 50x5000", "Timber department", 15, 5, 30, 800, 1300);
		addNewProduct("Dampspærretape 5x250", "Timber department", 10, 5, 20, 120, 170);
		addNewProduct("Søm 8cm 400 stk", "Timber department", 20, 5, 50, 120, 180);
		addNewProduct("Skruer 6cm 350 stk", "Timber department", 25, 5, 50, 150, 220);
		addNewProduct("Hoveddør 204x82", "Timber department", 5, 2, 8, 400, 600);
		addNewProduct("Ovenlys Vindue 78x140", "Timber department", 5, 2, 10, 4800, 5700);
		addNewProduct("Lofttrappe 280x70x120", "Timber department", 3, 1, 5, 1500, 2300);
		addNewProduct("Rulleklæber 15l", "DIY department", 5, 2, 10, 200, 400);
		addNewProduct("Tapet 53x3350 HVID", "DIY department", 5, 2, 10, 40, 120);
		addNewProduct("Loft/Væg maling 9l HVID", "DIY department", 5, 2, 10, 700, 1300);
		addNewProduct("Træbeskyttelse 5l SORT", "DIY department", 5, 2, 10, 350, 670);
		addNewProduct("Skabslåge 60x80 HVID,", "DIY department", 25, 5, 50, 175, 350);
		addNewProduct("Vægskab 120x160 HVID", "DIY department", 10, 2, 20, 1000, 1400);
		addNewProduct("Underskab 120x160 HVID", "DIY department", 2, 10, 20, 1100, 1500);
		addNewProduct("Bordplade Finer 186x3.8", "DIY department", 5, 2, 10, 600, 1000);
		addNewProduct("Vægmonteret emhætte 90x47", "DIY department", 3, 2, 5, 1500, 1999);
		addNewProduct("LED-spot 2,2W", "DIY department", 16, 8, 30, 40, 99);
		addNewProduct("Køkkenø 126x79x90", "DIY department", 4, 2, 6, 2800, 3599);
		addNewProduct("Reol 254x40x190 HVID", "DIY department", 4, 2, 6, 1800, 2475);
		addNewProduct("Indbygningsvask 56x53", "DIY department", 4, 2, 6, 550, 849);
		addNewProduct("Blandingsbatteri køkken HVID", "DIY department", 4, 2, 6, 1200, 1799);
		addNewAppliance("Opvaskemaskine 57x60x82", "DIY department", 4, 2, 6, 2400, 4350);
		addNewAppliance("Kølefryseskab 226/111L HVID", "DIY department", 3, 2, 4, 3967, 5299);
		addNewAppliance("Kummefryser 99L HVID", "DIY department", 5, 2, 8, 975, 1399);
		addNewAppliance("Samsung skabsfryser 323L SORT", "DIY department", 3, 2, 5, 8499, 10999);
		addNewAppliance("Induktionskogeplade 59x52", "DIY department", 3, 2, 6, 1200, 1800);
		addNewAppliance("Varmluftovn 72l", "DIY department", 3, 2, 5, 6500, 7500);
		addNewAppliance("Opvaskemaskine 55x90", "DIY department", 3, 2, 5, 2700, 3799);
		addNewAppliance("Vaskemaskine 8kg HVID", "DIY department", 3, 2, 6, 4600, 5999);
		addNewAppliance("Tørretubmler 8kg HVID", "DIY department", 3, 2, 5, 3600, 4999);
		addNewAppliance("Mikroovn 20L SORT", "DIY department", 5, 2, 10, 350, 699);
	}

	// search pattern using searchString
	public Product findProductByBarcode(String searchString) {
		int index = 0;
		boolean found = false;
		Product returnProduct = null;
		while (index < container.size() && !found) {
			if (container.get(index).getBarcode().contains(searchString)) {
				found = true;
				returnProduct = container.get(index);
			} else {
				index++;
			}
		}
		return returnProduct;

	}

	// returns content of ArrayList
	public ArrayList<Product> getAll() {
		return container;
	}

	public int getQuantity(int i) {
		return container.get(i).getQuantity();
	}

	public void updateQuantity(int amount, int i) {
		container.get(i).updateQuantity(amount);
	}
}
