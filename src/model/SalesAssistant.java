package model;

public class SalesAssistant {
	private boolean manager;
	private String name;
	
	public SalesAssistant(Boolean manager, String name) {
		this.name = name;
		this.manager = manager;
	}
	
	public String getName() {
		return name;
	}
	public boolean isManager() {
		return manager;
	}
}
