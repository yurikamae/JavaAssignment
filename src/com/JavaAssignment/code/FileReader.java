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
	File myFile; //global access
	Scanner myScanner;
	String line;
		
	public FileReader(File fileName)
	{
		this.fileName = fileName;
	}
		
	public void openFile()
	{
		fileName = new File("searchwords.txt");
	}	
	
	public String scanFile()
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
	}
}
