/*
 * This is the ScreenGui class which contains the GUI for my Search Engine.
 */
package com.JavaAssignment.code;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class ScreenGui extends JFrame implements ActionListener
{
	//attributes
	JButton searchButton, history, clearHistory; //buttons
	JTextField searchBar; //area where user inputs search term
	JTextArea searchResults, historyDisplay; //displays search results+history
	
	String searchTerm; //variable that will take input from searchBar and save it to searchResults+historyDisplay
	static String fileName = "C:/Users/USE/eclipse-workspace/JavaAssignment/src/com/JavaAssignment/code/searchwords.txt";
	
	public ArrayList<String> Search = new ArrayList<String>(); //Array that will store search history (historyDisplay)
	public ArrayList<String> SearchWords = new ArrayList<String>(); //Text file content is stored into this array
	
	//constructors (screen)
	public ScreenGui(String title)
	{
		super(title);
		setSize(500,300);
		setLayout(new FlowLayout());
		
		searchBar = new JTextField();
		searchBar.setText("I'm looking for...");
		
		searchButton = new JButton("Search");
		history = new JButton("Search History");
		clearHistory = new JButton("Clear History");
		
		searchResults = new JTextArea(10,20);
		historyDisplay = new JTextArea(10,20);
		
		//Action Listeners
		add(searchBar);
		searchBar.addActionListener(this);
		
		add(searchButton);
		searchButton.addActionListener(this);
		
		add(history);
		history.addActionListener(this);
		
		add(clearHistory);
		clearHistory.addActionListener(this);
		
		add(searchResults);
		add(historyDisplay);
		
		//Restricts user from editing the output
		searchResults.setEditable(false);
		historyDisplay.setEditable(false);
		
		//Make screen visible
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) //different actions take place when user interacts with different elements(button, etc)
	{
		//SEARCH BUTTON
		if(event.getSource() == searchButton)
		{
			searchTerm = searchBar.getText(); //takes the input from searchBar, assigns it to variable searchTerm and put it into array Search
			Search.add(searchTerm);
			//searchTerm.equals(myScanner.nextLine().trim())
			
			for(String element1 : SearchWords)
				searchResults.append(element1.toString() + "\n");
			
			if(SearchWords.contains(searchTerm))
			{
				JOptionPane.showMessageDialog(this,searchTerm + "\nresults found: ");
				System.out.print(SearchWords);
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,searchTerm + "\nshows no result. ");
			}
		}
		
		//SEARCH HISTORY BUTTON (Displays Search History)
		else if(event.getSource() == history)
		{
			for(String element : Search)
				historyDisplay.append(element.toString() + "\n");
		}
		
		//CLEAR HISTORY BUTTON
		else if(event.getSource() == clearHistory)
		{
			historyDisplay.setText(null);
			Search.clear();
		}
	}
	
	public static boolean compareInFile(String line) 
	{
	 
	    File file = new File(fileName);
	    try 
	    {
	        Scanner myScanner = new Scanner(file);
	        while (myScanner.hasNextLine()) 
	        {
	            line = myScanner.nextLine();
	            if (myScanner.equals(line)) 
	            {
	                return true;
	            }
	        }
	    } 
	    catch (Exception error) 
	    {
	    }
	    return false;
	}
}
