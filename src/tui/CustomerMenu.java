package tui;

public class CustomerMenu {
	
	public void start(){
		int choice = writeCustomerMenu();
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
	
	private int writeCustomerMenu(){
        TextMenu menu = new TextMenu("\n ###Kunde menu###", "tilbage");
        menu.addOption("Opret kunde");
        menu.addOption("Find kunde");
        menu.addOption("Slet kunde");
        menu.addOption("Rediger kunde");
        
        return menu.prompt();
}

}
