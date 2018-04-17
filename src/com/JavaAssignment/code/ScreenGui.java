/*
 * This is the ScreenGui class which contains the GUI for my Search Engine.
 */
package com.JavaAssignment.code;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class ScreenGui extends JFrame implements ActionListener
{
	//attributes
	JLabel label1, label2, label3, col1, col2, col3, col4; //search engine title and blank labels to shift the title and other attributes
	JButton searchButton, history, clearHistory; //buttons
	JTextField searchBar; //area where user inputs search term
	JTextArea searchResults, historyDisplay; //displays search results+history
	
	String searchTerm; //variable that will take input from searchBar and save it to searchResults+historyDisplay
	File fileName =  new File("C:/Users/USE/eclipse-workspace/JavaAssignment/searchwords.txt"); //Object that will point to my existing text file
	
	public ArrayList<String> Search = new ArrayList<String>(); //Array that will store search history (historyDisplay)
	public ArrayList<String> SearchWords = new ArrayList<String>(); //Text file content is stored into this array
	
	//constructors (screen)
	public ScreenGui(String title) throws FileNotFoundException
	{
		super(title);
		setSize(700,400);
		setLayout(new FlowLayout());
		
		label1 = new JLabel();
		label1.setText("                                                                   ");
		
		col1 = new JLabel(); //Letter "L"
		col1.setText("L");
		//code ref: https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-the-maximum-size
		col1.setFont(new Font("Serif", Font.PLAIN, 90)); //Sets font and size for JLabel
		//end of code ref: https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-the-maximum-size
		col1.setForeground(Color.BLUE); //code ref: http://www.asjava.com/swing/set-jlabel-font-size-and-color/
		
		col2 = new JLabel(); //Letter "i"
		col2.setText("i");
		col2.setFont(new Font("Serif", Font.PLAIN, 90));
		col2.setForeground(Color.RED);
		
		col3 = new JLabel(); //Letter "n"
		col3.setText("n");
		col3.setFont(new Font("Serif", Font.PLAIN, 90));
		col3.setForeground(Color.YELLOW);
		
		col4 = new JLabel(); //Letter "g"
		col4.setText("g");
		col4.setFont(new Font("Serif", Font.PLAIN, 90));
		col4.setForeground(Color.BLUE);
		
		label2 = new JLabel();
		label2.setText("                                                                        "); //to shift the position of the searchBar, etc.
		
		label3 = new JLabel();
		label3.setText("                            ");
		
		searchBar = new JTextField();
		searchBar.setText("I'm looking for...            ");
		
		searchButton = new JButton("Search");
		history = new JButton("Search History");
		clearHistory = new JButton("Clear History");
		
		searchResults = new JTextArea(10,20);
		historyDisplay = new JTextArea(10,20);
		
		//Action Listeners
		add(label1);
		add(col1);
		add(col2);
		add(col3);
		add(col4);
		add(label2);
		add(label3);
		
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
		
		FileReader fr = new FileReader(fileName); //Stores the textfile contents into arrayList SearchWords
		Scanner scan = new Scanner (fr);
		while(scan.hasNext())
		{
			SearchWords.add(scan.next());
		}
		
		for (String element : SearchWords)
		{
			System.out.println(element); //prints contents to make sure it works
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) //different actions take place when user interacts with different elements(button, etc)
	{
		//SEARCH BUTTON
		if(event.getSource() == searchButton)
		{
			searchTerm = searchBar.getText(); //takes the input from searchBar, assigns it to variable searchTerm and put it into array Search
			searchTerm = searchTerm.toLowerCase();
			Search.add(searchTerm);
			
			if(SearchWords.contains(searchTerm))
			{
				JOptionPane.showMessageDialog(this,searchTerm + "\nresults found: ");
				
				//Using a scanner to read a file and print it to the text area (searchResults)
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
				
				searchResults.setText(" ");
				
				while(in.hasNext())
				{
				    String line = in.nextLine().toLowerCase();
				    
			    	if(line.contains(searchTerm))
				    {
				    	searchResults.append(line+"\n");
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
