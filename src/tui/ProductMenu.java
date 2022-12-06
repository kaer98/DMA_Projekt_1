package tui;

public class ProductMenu {

	private void start(){
		
	}
	
	
	private int writeProductMenu(){
        TextMenu menu = new TextMenu("\n ###Hovedmenu###", "tilbage");
        menu.addOption("Opret produkt");
        menu.addOption("Find produkt");
        menu.addOption("Kunde menu");
        
        return menu.prompt();
	
}
