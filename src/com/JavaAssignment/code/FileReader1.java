/*
 * FileReader class which will read text file for search engine, will also store text file contents into array for easy searching
 */
package com.JavaAssignment.code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader1 
{
	File myFile;
	Scanner myScanner;
	String line;
	String fileName = "searchwords.txt";
	static String searchResults;
	
	ArrayList<String> SearchWords = new ArrayList<String>(); //Text file content will be stored into this array
	
	//code ref: https://stackoverflow.com/questions/16100175/store-text-file-content-line-by-line-into-array
	public void FileReader() //stores txt file line by line into array
	{
		try 
		{
			myScanner = new Scanner(new File(fileName));
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		ArrayList<String> SearchWords = new ArrayList<String>();
		
		while((line = myScanner.nextLine()) != null)
		{
		    SearchWords.add(line);
		}

		String[] line = SearchWords.toArray(new String[0]);
	}
	//end of code ref: https://stackoverflow.com/questions/16100175/store-text-file-content-line-by-line-into-array
	
	public void openFile()
	{
		try
		{
			myScanner = new Scanner(new File(fileName));
			System.out.println("file opened"); //checks if file opens
		}
		catch(FileNotFoundException e)
		{
			System.out.println("file not found");
		}
	}
	
	public void readFile()
	{
		do
		{
			searchResults = myScanner.next();
		}
		while(myScanner.hasNext());
		System.out.println(searchResults);
		
		myScanner.close();
	}
	
	public String scanFile()
	{
		try
		{
			myScanner = new Scanner(myFile);
			line = myScanner.nextLine();
		}
		catch(FileNotFoundException myFile)
		{
			System.out.println("file not found");
		}
		
		return line;
	}
}
