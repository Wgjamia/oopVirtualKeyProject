package ly.oopVirtualKeyProject.controler;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import ly.oopVirtualKeyProject.model.*;



public class DirectoryControler {
	
	// Create private and static Object of fileDirectory 
    private static CreateDirectory fileDirectory = new CreateDirectory();
    
    // Create method for print file name, lastModified Date and Size of file.
    public static void PrintFiles() {
    	
    	fileDirectory.fillFiles();
    	
    	//Create Object of Format Date
    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
    	
        for (File file : DirectoryControler.getFileDirectory().getFiles())
        {
        	System.out.println(file.getAbsolutePath()+" || "+ dateFormat.format(file.lastModified())+" || "+file.length());
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
