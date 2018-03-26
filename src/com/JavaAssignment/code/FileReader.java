/*
 * FileReader class which will read text files for search engine
 */
package com.JavaAssignment.code;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FileReader
{
	String fileName;
	File myFile; //global access
	Scanner myScanner;
	String line;
		
	public FileReader(String fileName)
	{
		this.fileName = fileName;
	}
		
	public void openFile()
	{
		File myFile = new File(fileName);
	}	
	
	public String scanFile()
	{
		try
		{
			myScanner = new Scanner(myFile);
			line = myScanner.nextLine();
		}
		catch(FileNotFoundException fileName)
		{
			System.out.println("file not found");
		}
		
		return line;
	}
}
