package tui;

/**
 * Class for the main menu
 *
 * @author Rasmus,Cawan,Frederik,Oskar
 * @version 1.0
 *
 */
public class MainMenu {
	private static OrderMenu orderMenu;

	public static void start() {
		int choice = writeMainMenu();
		switch (choice) {
		case 0:
			Login.start();
		case 1:
			orderMenu.start();
			break;
		}
	}

	private static int writeMainMenu() {
		TextMenu menu = new TextMenu("\n ###Hovedmenu###", "Log ud");
		menu.addOption("Ordre menu");

		return menu.prompt();
	}

	public MainMenu() {
		// this.manager = false;
		orderMenu = new OrderMenu();
	}

}
