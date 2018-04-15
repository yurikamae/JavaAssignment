/* 
 * This is the control/main class for my Java Assignment
 */

package com.JavaAssignment.code;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.JavaAssignment.code.ScreenGui;

public class Control 
{
	public static void main(String[] args) throws IOException
	{
		ScreenGui myGui = new ScreenGui("my search engine in java"); //Displays ScreenGUI
		
		ArrayList<String> SearchWords = new ArrayList<String>(); //Array that stores text file contents
		
		String[] searchWords = readArray("searchwords.txt");
		for(int i = 0; i < searchWords.length; i = i + 1)
		{
			System.out.println(searchWords[i]);
		}
		
		String fileName = "searchwords.txt";
		Scanner myScanner = new Scanner(new File(fileName));
		
	}
	
	public static String[] readArray(String file)
	{
		int count = 0;
		
		try
		{
			Scanner scan = new Scanner(new File(file));
			while(scan.hasNextLine())
			{
				count = count + 1;
				scan.nextLine();
			}
			String[] searchWords = new String[count];
			
			Scanner scan2 = new Scanner(new File(file));
			for(int i = 0; i < count; i = i +1)
			{
				searchWords[i] = scan2.nextLine();
			}
			return searchWords;
		}
		catch(FileNotFoundException e)
		{
			
		}
		return null;
	}
	
	public static String readString(String file)
	{
		String text = " ";
		try 
		{
			Scanner s = new Scanner(new File(file));
			while(s.hasNextLine())
			{
				text = text + s.nextLine() + " ";
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("file not found");
		}
		return text;
	}
}
