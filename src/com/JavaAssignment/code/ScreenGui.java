/*
 * This is the ScreenGui class which is responsible for displaying the GUI for the Search Engine
 */

package com.JavaAssignment.code;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ScreenGui extends JFrame implements ActionListener
{
	//attributes
	JButton searchButton;
	JTextField searchBox;
	
	//constructors
	public ScreenGui(String title)
	{
		super(title);
		setSize(500,500);
		setLayout(new FlowLayout());
		
		searchBox = new JTextField();
		searchBox.setText("Enter search here");
		
		searchButton = new JButton("Search");
		
		//Listeners
		add(searchBox);
		searchBox.addActionListener(this);
		
		add(searchButton);
		searchButton.addActionListener(this);
		
		//Make screen visible
		setVisible(true);
	}

	//ActionListener method
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		
	}
}
