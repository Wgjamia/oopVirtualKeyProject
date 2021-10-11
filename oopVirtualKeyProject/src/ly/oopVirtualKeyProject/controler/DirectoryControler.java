package ly.oopVirtualKeyProject.controler;

import java.io.File;

import ly.oopVirtualKeyProject.model.*;



public class DirectoryControler {
	
	// Create private and static Object of fileDirectory 
    private static CreateDirectory fileDirectory = new CreateDirectory();
    
    // Create method for print file name.
    public static void PrintFiles() {
    	
    	fileDirectory.fillFiles();

        for (File file : DirectoryControler.getFileDirectory().getFiles())
        {
            System.out.println(file.getName());
        }
    }
    // Create Method to get Directory of File.
    public static CreateDirectory getFileDirectory() {
        return fileDirectory;
    }
    // Create method to set Directory of file.
    public static void setFileDirectory(CreateDirectory fileDirectory) {
    	DirectoryControler.fileDirectory = fileDirectory;
    }

}
