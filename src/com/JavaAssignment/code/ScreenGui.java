
package com.JavaAssignment.code;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class ScreenGui extends JFrame implements ActionListener
{
	//attributes
	JButton searchButton, history, clearHistory; //buttons
	JTextField searchBar; //area where user inputs search term
	JTextArea searchResults, historyDisplay; //displays search results+history
	
	String searchTerm; //variable that will take input from searchBar and save it to searchResults+historyDisplay
	
	public ArrayList<String> Search = new ArrayList<String>();
	
	//constructors (screen)
	public ScreenGui(String title)
	{
		super(title);
		setSize(600,400);
		setLayout(new FlowLayout());
		
		searchBar = new JTextField();
		searchBar.setText("I'm looking for...");
		
		searchButton = new JButton("Search");
		history = new JButton("Search History");
		clearHistory = new JButton("Clear History");
		
		searchResults = new JTextArea(10,20);
		historyDisplay = new JTextArea(10,20);
		
		//Listeners
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
		
		//Make screen visible
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) //different actions take place when user interacts with different elements(button, etc)
	{
		if(event.getSource() == searchBar)
		{
			searchTerm = searchBar.getText();
		}
		
		else if(event.getSource() == searchButton)
		{
			Scanner myScanner = null;
			while(myScanner.hasNextLine())
			{
				if(searchTerm.equals(myScanner.nextLine().trim()))
				{
					System.out.println("Showing results for: " + this.searchTerm);
			        break;
			    }
				else
				{
					System.out.println("No results found");
			    }
			 }
		}
		
		else if(event.getSource() == history)
		{
			for(String element : Search)
				historyDisplay.append(element.toString());
		}
		
		else if(event.getSource() == clearHistory)
		{
			historyDisplay.setText(null);
			Search.clear();
		}
	}
}
