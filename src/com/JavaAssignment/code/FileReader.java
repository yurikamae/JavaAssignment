/*
 * FileReader class which will read text file for search engine
 */
package com.JavaAssignment.code;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FileReader
{
	File fileName;
	File myFile;
	Scanner myScanner;
	String line;
	static String searchTerm;
	
	//Code reference from ismailzd on Youtube: https://www.youtube.com/watch?v=lDqP5Y01ce0
	public void openFile()
	{
		try
		{
			myScanner = new Scanner(new File("C:/Users/USE/eclipse-workspace/JavaAssignment/src/com/JavaAssignment/code/searchwords.txt"));
			System.out.println("it works!");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("doesn't work!");
		}
	}	
	
	public void readFile()
	{
		do
		{
			searchTerm = myScanner.next();
		}
		while(myScanner.hasNext());
		System.out.println(searchTerm);
		
		myScanner.close();
	}
	//End of code reference from ismailzd on Youtube: https://www.youtube.com/watch?v=lDqP5Y01ce0
	
	/*public String scanFile()
	{
		try
		{
			myScanner = new Scanner(fileName);
			line = myScanner.nextLine();
			System.out.println(line);
		}
		
		catch(FileNotFoundException fileName)
		{
			System.out.println("file not found");
		}
		
		return line;
	}*/
}
