package ly.oopVirtualKeyProject;

import ly.oopVirtualKeyProject.welcomescreen.WelcomeScreen;

public class MainApp {

	// Main Method of the project Virtual Key
	public static void main(String[] args) {
		// Create object of welcome Screen.
		WelcomeScreen welcome = new WelcomeScreen();
		// call method print of Main Menu from Class WelcomeScreen
    	welcome.printSoftD();
    	// call method get User Input1 of Main Menu from Class WelcomeScreen
    	welcome.GetUserInput();
	}

}
