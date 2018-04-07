/*
 * Scanner to search a text file for a string in Java (REF: cvarta from github.com)
 */
package com.JavaAssignment.code;

import java.io.*;
import java.util.Scanner;

public class FileSearch
{
	public static boolean find(File myFile, String searchString)
	{
        boolean result = false;
        Scanner in = null;
        
        try 
        {
            while(in.hasNextLine() && !result) 
            {
                result = in.nextLine().indexOf(searchString) >= 0;
            }
        }
        finally 
        {
            try
            { 
            	in.close() ; 
            } 
            catch(Exception e) 
            { 
            	/* ignore */ 
            }  
        }
        return result;
    }
}
