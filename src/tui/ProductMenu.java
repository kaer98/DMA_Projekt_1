package tui;

public class ProductMenu {

	public void start(){
		int choice = writeProductMenu();
		switch(choice) {
		case 0:
			MainMenu.start();
		case 1:
			//
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		}
	}
	
	private int writeProductMenu(){
        TextMenu menu = new TextMenu("\n ###Produkt menu###", "tilbage");
        menu.addOption("Opret produkt");
        menu.addOption("Find produkt");
        menu.addOption("Slet produkt");
        menu.addOption("Rediger produkt");
        
        return menu.prompt();
}
}
