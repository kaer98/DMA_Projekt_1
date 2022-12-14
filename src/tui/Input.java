package tui;

import java.util.Scanner;

/**
 * Class for simplifying string and integer input
 *
 * @author Rasmus,Cawan,Frederik,Oskar
 * @version 1.0
 *
 */
public class Input {
	private static Scanner keyboard;

	public static int inputInt(String question) {
		keyboard = new Scanner(System.in);
		int number = 0;
		printQuesiton(question);
		while (!keyboard.hasNextInt()) {
			System.out.println("Input skal være et tal - prøv igen");
			keyboard.nextLine();
		}
		number = keyboard.nextInt();
		return number;
	}

	public static String inputString(String question) {
		keyboard = new Scanner(System.in);
		printQuesiton(question);
		return keyboard.nextLine();
	}

	private static void printQuesiton(String question) {
		System.out.print(" " + question + ": ");
	}

	public Input() {

	}

}
