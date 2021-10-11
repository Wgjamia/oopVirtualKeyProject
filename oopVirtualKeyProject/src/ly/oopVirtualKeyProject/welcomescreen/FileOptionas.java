package ly.oopVirtualKeyProject.welcomescreen;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import ly.oopVirtualKeyProject.model.*;

public class FileOptionas implements Screens 
{
	// Definition of object for Directory.
	private CreateDirectory ls = new CreateDirectory();
	
	// Definition of object options for sub menu as ArrayList.
	private ArrayList<String> options = new ArrayList<>();
	
	// Create and initial values of construct
    public FileOptionas() {
    	
    	options.add("1. Add a File");
        options.add("2. Delete A File");
        options.add("3. Search A File");
        options.add("4. Return to Menu");
        
    }

    //Override the method Show Screen of Menu.
	@Override
	public void ShowSecreen() {
	   	System.out.println("File Options Menu");
        for (String s : options) {
            System.out.println(s);
        }
	}
	
	// Override the method Navigate Option.
	@Override
	public void NavigateOption(int option) {
	 	switch(option) {

        case 1: // Add File
            this.AddFile();
            
            this.ShowSecreen();
            break;
        case 2: // Delete File
            this.DeleteFile();
            
            this.ShowSecreen();
            break;
        case 3: // Search File
            this.SearchFile();
            this.ShowSecreen();
            break;
     
        default:
            System.out.println("Invalid Option");
            break;
            
            
    }
		
	}

	// Override Method Get User Input.
	@Override
	public void GetUserInput() {
	      int selectedOption;
	        while ((selectedOption = this.getOption()) != 4) {
	            this.NavigateOption(selectedOption);
	        }
	}
	

    // Create method for Adding Files.
	public void AddFile() {
        System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are adding a file named: " + fileName);
        
		try {
			Path path = FileSystems.getDefault().getPath(CreateDirectory.dir + fileName).toAbsolutePath();
			File file = new File(ls.getName() + fileName);
			
		      if (file.createNewFile()) {
		    	  System.out.println("File created: " + file.getName());
		    	  ls.getFiles().add(file);
		    	  
		      } else {
		        System.out.println("This File Already Exits, no need to add another");
		      }
		}catch (IOException e){
			System.out.println(e);
		}
	}
        
    
    //Create Method for deletions of files.
    public void DeleteFile() {
    	
    	System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are deleting a file named: " + fileName);
        
        
	     
		Path path = FileSystems.getDefault().getPath(CreateDirectory.dir + fileName).toAbsolutePath();
		File file = path.toFile();
	      if (file.delete()) {
	    	  System.out.println("Deleted File: " + file.getName());
	    	  ls.getFiles().remove(file);
	      } else {
	        System.out.println("Failed to delete file:" + fileName + ", file was not found.");
	      }
    }
    
    //Create Method for Searching file.
    public void SearchFile() {
    	
    	Boolean found = false;
    	
    	System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are searching for a file named: " + fileName);
        
      
        ArrayList<File> files = ls.getFiles();
        
        
        for(int i = 0; i < files.size(); i++) {
			if(files.get(i).getName().equals(fileName)) {
				System.out.println("Found " + fileName);
				found = true;
			}
        }
        if (found == false) {
        	System.out.println("File not found");
        }
    }
    
    //Create private Method to get input Value
    private String getInputString() {

        Scanner in = new Scanner(System.in);
        return(in.nextLine());

    }
    //Create Private Method to get Option.
    private int getOption() {
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {
        	System.out.println("Invalid input");
        }
        return returnOption;

    }
}
