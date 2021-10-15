package ly.oopVirtualKeyProject.welcomescreen;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ly.oopVirtualKeyProject.controler.DirectoryControler;
import ly.oopVirtualKeyProject.controler.ScreenControler;


public class WelcomeScreen implements Screens 
{

	// Create Variable of Welcome Main Menu.
    private String welcomeMainMenu = "=============> Welcome to the project Virtual Key <===========";
    
    // Create Variable of Owner of Project.
    private String developerName = "================>> Developer: Wesam Alghjamia <<================";

    // Create Object of options as ArrayList.
    private ArrayList<String> options = new ArrayList<>();
	
    // Create Constructor of Welcome Screen and initial options values
    public WelcomeScreen() {
    	  options.add("1. Show Files");
          options.add("2. Show File Options Menu");
          options.add("3. Quit");
    }
    
    // Create method of print initial of Welcome Main Menu.
    public void printSoftD() {
    	System.out.println("\n");
    	System.out.println(welcomeMainMenu);
    	System.out.println("\n");
    	System.out.println(developerName);
        System.out.println("\n");
        ShowSecreen();
    }
    
    // Override the method of Show Screen.
	@Override
	public void ShowSecreen() {
		System.out.println();
		System.out.println("Main Menu");
        for (String s : options)  {
            System.out.println(s);
        }
        
	}
	// Override the method of Navigate Option.
	@Override
	public void NavigateOption(int option) {
		  switch(option) {

          case 1: // Show Files in Directory
              this.ShowFiles();
           
              this.ShowSecreen();
              
              break;
              
          case 2: // Show File Options menu
        	  ScreenControler.setCurrentScreen(ScreenControler.FileOptionsScreen);
        	  ScreenControler.getCurrentScreen().ShowSecreen();
        	  ScreenControler.getCurrentScreen().GetUserInput();
              this.ShowSecreen();
              break;
          case 3: // close of the program.
        	  System.out.println("Thank you for your cooperation, good bye....");
        	  System.exit(0);
              
          default:
              System.out.println("Invalid Option");
              break;
      }
	}
	// Override the method Get User Input of option.
	@Override
	public void GetUserInput() {
		   int selectedOption  = 0;
	        while ((selectedOption = this.getOption()) != 4) {
	            this.NavigateOption(selectedOption);
	        }
	}
	
	// Create method of show files.
	  public void ShowFiles() {
		  System.out.println("\n");
	      System.out.println("List of Files: ");
	      System.out.println("\n");
	      DirectoryControler.PrintFiles();
	      System.out.println("\n");
	      System.out.println("=============================================================");
	    }
	    
	  // Create method to get Option.
	  
	    private int getOption() {
	        Scanner in = new Scanner(System.in);
	        int returnOption = 0;
	        try {
	            returnOption = in.nextInt();
	        }
	        catch (InputMismatchException ex) {

	        }
	        return returnOption;
	    }
}
