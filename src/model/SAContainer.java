package model;

import java.util.ArrayList;

public class SAContainer {
	private ArrayList<SalesAssistant> container;
	private static SAContainer instance;
	
	private SAContainer() {
		this.container = new ArrayList<>();
		fill();
	}
	
	public static SAContainer getInstance() {
		if(instance == null) {
			instance = new SAContainer();
		}
		return instance;
	}
	
	public void addSalesAssistant(boolean manager, String name) {
		container.add(new SalesAssistant(manager, name));
	}
	
	public ArrayList<SalesAssistant> getAll() {
		return container;
	}
	
	public void fill() {
		addSalesAssistant(false, "fal");
		addSalesAssistant(false, "fals");
		addSalesAssistant(true, "tr");
		addSalesAssistant(false, "false");
		
	}
	
}
