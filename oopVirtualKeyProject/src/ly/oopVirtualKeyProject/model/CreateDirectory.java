package ly.oopVirtualKeyProject.model;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

public class CreateDirectory 
{
	//The definition of the variable name of Directory is Static and Final.
	public static final String dir = "src/workplace/";
	 
	 // Create constructor of Create Directory if not exists.
	 public CreateDirectory(){
		 File directory  = new File(dir);
		// If the folder does not exist, it will be created.
		 if (! directory.exists()){
		        directory.mkdir();
		    }
	 }
	// The definition of the object variable files is ArrayList
	 private ArrayList<File> files = new ArrayList<File>();
	    
	 // Create initial object pathFileName
	    Path pathFileName = FileSystems.getDefault().getPath(dir).toAbsolutePath();
	    
	 // Create initial object File
	    File DircOfFiles = pathFileName.toFile();
	    
	    // Create Setter of the variable of name   
	    public String getName() {
	        return dir;
	    }	    
	    // Print file name from Directory.
	    public void print() {
	    	System.out.println("Existing Files: ");
	    	files.forEach(f -> System.out.println(f));
	    }
	    // Create the method to fill and return an ArrayList of files..
	    public ArrayList<File> fillFiles() {
	    	File[] directoryFiles = DircOfFiles.listFiles();
	        files.clear();
	    	for (int i = 0; i < directoryFiles.length; i++) {
	    		if (directoryFiles[i].isFile()) {
	    			files.add(directoryFiles[i]);
	    		}
	    	}
	    	Collections.sort(files);
	    	return files;
	    }
	    // Create Method to get files As ArrayList.
	    public ArrayList<File> getFiles() {
	    	fillFiles();
	    	return files;
	    }
	    
}
