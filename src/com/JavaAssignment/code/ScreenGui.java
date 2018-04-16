/*
 * This is the ScreenGui class which contains the GUI for my Search Engine.
 */
package com.JavaAssignment.code;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
	File fileName =  new File("C:/Users/USE/eclipse-workspace/JavaAssignment/searchwords.txt");
	
	public ArrayList<String> Search = new ArrayList<String>(); //Array that will store search history (historyDisplay)
	public ArrayList<String> SearchWords = new ArrayList<String>(); //Text file content is stored into this array
	
	//constructors (screen)
	public ScreenGui(String title) throws FileNotFoundException
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
		
		FileReader fr = new FileReader(fileName);
		Scanner scan = new Scanner (fr);
		while(scan.hasNext())
		{
			SearchWords.add(scan.next());
		}
		
		for (String element : SearchWords)
		{
			System.out.println(element);
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) //different actions take place when user interacts with different elements(button, etc)
	{
		//SEARCH BUTTON
		if(event.getSource() == searchButton)
		{
			searchTerm = searchBar.getText(); //takes the input from searchBar, assigns it to variable searchTerm and put it into array Search
			Search.add(searchTerm);
			
			if(SearchWords.contains(searchTerm))
			{
				JOptionPane.showMessageDialog(this,searchTerm + "\nresults found: ");
		        Scanner in = null;
				try 
				{
					in = new Scanner(fileName);
				} 
				catch (FileNotFoundException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				while(in.hasNextLine())
				{
				    String line=in.next();
			    	searchResults.append(line + "\n");
				    if(line.contains(searchTerm))
				    { 
				    	searchResults.setText(line);
				    }
				}
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
}
