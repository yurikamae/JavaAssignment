/*
 * This is the control class for my Java Assignment
 */

package com.JavaAssignment.code;

import java.util.ArrayList;

import com.JavaAssignment.code.ScreenGui;
import com.JavaAssignment.code.SearchEngine;

public class Control 
{
	public static void main(String[] args)
	{
		ScreenGui myGui = new ScreenGui("my search engine in java");
		
		SearchEngine s1 = new SearchEngine();
		
		ArrayList<SearchEngine> mySearch = new ArrayList<SearchEngine>();
		
		mySearch.add(s1);
		
		System.out.println(mySearch);
	}
}
