/*
 * This is the ScreenGui class which is responsible for displaying the GUI for the Search Engine
 */

package com.JavaAssignment.code;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;

public class ScreenGui extends JFrame implements ActionListener
{
	//attributes
	JButton searchButton, historyButton, clearHistoryButton;
	JTextField searchBox; //this is where the text will be entered
	JTextArea searchResults; //this area will display search results
	
	public ArrayList<SearchEngine> Search = new ArrayList<SearchEngine>(10);
	
	//constructors
	public ScreenGui(String title)
	{
		super(title);
		setSize(500,500);
		setLayout(new FlowLayout());
		
		searchBox = new JTextField();
		searchBox.setText("Enter search here");
		
		searchButton = new JButton("Search");
		historyButton = new JButton("Search History");
		clearHistoryButton = new JButton("Clear History");
		
		//Listeners
		add(searchBox);
		searchBox.addActionListener(this);
		
		add(searchButton);
		searchButton.addActionListener(this);
		
		add(historyButton);
		historyButton.addActionListener(this);
		
		add(clearHistoryButton);
		clearHistoryButton.addActionListener(this);
		
		add(searchResults);
		
		//Make screen visible
		setVisible(true);
	}

	//ActionListener method
	@Override
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == searchButton) //this button will display search results
		{
			//PART NOT FINISHED YET
			Search.add(searchTerm);
			JOptionPane.showMessageDialog(this, "You searched for: " + searchTerm);
			//display search results
		}
		else if(event.getSource() == historyButton) //this button will display search history
		{
			//display history button
			for(SearchEngine element : Search)
			{
				searchResults.append(element.toString());
			}
		}
		else if(event.getSource() == clearHistoryButton)
		{
			searchResults.setText(null);
			Search.clear();
		}
	}
}
