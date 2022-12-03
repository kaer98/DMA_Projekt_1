package tui;

import java.util.ArrayList;



	/**
	 * Class for making ui menus
	 *
	 *@auther Rasmus,Cawan,Frederik,Oskar
	 *@version 1.0
	 *
	 */
	public class TextMenu {
		private ArrayList<String> options;
		private String title;
		private boolean cancellable;

		public TextMenu(String title, String cancelText) {
	        options = new ArrayList<>();
	        this.title = title;
	        if(cancelText != null) {
	            cancellable = true;
	        }
	        addOption(cancelText);
	    }
		
		public TextMenu(String title) {
	        this(title, null);
	    }
	    //set and get methods
	    public void addOption(String option) {
	        options.add(option);
	    }
	    
	    public int prompt() {
	        System.out.println(title);
	        int size = options.size();
	        for (int i = 0; i < size; i++){
	            String currentOption = options.get(i);
	            if (currentOption != null) {
	                System.out.println(" [" + i + "]\t" + currentOption);
	            }
	        }
	        int choice = -1;
	        int lowerBound = 0;
	        if (!cancellable) {
	            lowerBound = 1;
	        }
	        while (choice < lowerBound || choice >= size) {
	           choice = Input.inputInt("Vælg et tal"); 
	        }
	        return choice;
	    }
	
	
		
		
		
	}