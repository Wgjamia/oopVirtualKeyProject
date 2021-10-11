package ly.oopVirtualKeyProject.controler;

import ly.oopVirtualKeyProject.welcomescreen.*;

public class ScreenControler {
	// Create static Object of Welcome Screen
	public static WelcomeScreen WelcomeScreen = new WelcomeScreen();
	// Create static Object of File Options Screen.
    public static FileOptionas FileOptionsScreen = new FileOptionas();
    
    
    // Definition of the variable of Screens
    public static Screens CurrentScreen = WelcomeScreen;

    // Create method get Screen 
    public static Screens getCurrentScreen() {
        return CurrentScreen;
    }

    // Create method Set Screen 
    public static void setCurrentScreen(Screens currentScreen) {
        CurrentScreen = currentScreen;
    }
    

}
