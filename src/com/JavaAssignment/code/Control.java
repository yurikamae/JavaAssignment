/*
 * This is the control/main class for my Java Assignment
 */

package com.JavaAssignment.code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.JavaAssignment.code.ScreenGui;

public class Control 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		ScreenGui myGui = new ScreenGui("my search engine in java");
		
		//Code reference from ismailzd on Youtube: https://www.youtube.com/watch?v=lDqP5Y01ce0
		//FileReader f = new FileReader();
		//f.openFile();
		//f.readFile();
		//end of code reference from ismailzd on Youtube: https://www.youtube.com/watch?v=lDqP5Y01ce0
		
		
		ArrayList<String> Search = new ArrayList<String>();
		
		Scanner myScanner = new Scanner(new File("C:/Users/USE/eclipse-workspace/JavaAssignment/src/com/JavaAssignment/code/searchwords.txt"));
		
		//Opens + saves file to array list
		while(myScanner.hasNextLine())
		{
			Search.add(myScanner.nextLine());
		}
		
		for(String line : Search)
		{
			System.out.println(line); //prints to make sure code above works
		}
	}
}
