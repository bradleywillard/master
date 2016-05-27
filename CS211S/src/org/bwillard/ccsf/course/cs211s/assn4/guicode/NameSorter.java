package org.bwillard.ccsf.course.cs211s.assn4.guicode;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class NameSorter extends JPanel {

	private JButton sortButton, clearButton;
	private JTextField nameInput;
	private JTextArea displayOutput;
	
	private ArrayList<String> nameList;
	
	public NameSorter() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//setLayout(new GridLayout(5,1));
		nameList = new ArrayList<String>();
		
		JLabel label = new JLabel("Enter a name:");
		add(label);
		
		JPanel textFieldPanel = new JPanel();
		
		nameInput = new JTextField(20);
		nameInput.addActionListener(new InputListener());
		textFieldPanel.add(nameInput);
		add(nameInput);
		
		sortButton = new JButton("Sort Names");
		
		// original approach to adding an action listener- create a
		// full class and create a new object of that class inside
		// the listener
	//	sortButton.addActionListener(new ButtonListener());

		// improved method- use an anonymous inner class s
		sortButton.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent event) {
				Collections.sort(nameList);
				displayOutput.setText("");
				for(String name : nameList) {
					displayOutput.append(name+"\n");
				}
			}
		});
		add(sortButton);
		
		clearButton = new JButton("Clear Names");
		//clearButton.addActionListener(new ButtonListener());
		
		// other improved method- use a lambda!
		clearButton.addActionListener(event -> {
				nameList.clear();
				displayOutput.setText("");
			});

		add(clearButton);
		
		displayOutput = new JTextArea(5, 10); // 5 rows, 10 cols
		JScrollPane scrollPane = new JScrollPane(displayOutput);
		displayOutput.setEditable(false);
		add(scrollPane);
		
		
	}
	
	// one listener can be used for multiple buttons;
	// not the best approach in this case, since there is no
	// shared code between the two buttons; if we had shared
	// code that happened when both buttons were clicked,
	// this would bea  good approach
	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object source = event.getSource();
			if(source==sortButton) {
				Collections.sort(nameList);
				displayOutput.setText("");
				for(String name : nameList) {
					displayOutput.append(name+"\n");
				}
			} else if(source==clearButton) {
				displayOutput.setText("");
				nameList.clear();
			}
			
		}
	}
	
	public class InputListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String userInput = nameInput.getText();
			nameInput.setText("");
			nameList.add(userInput);
			
			displayOutput.append(userInput+"\n");
		}
		
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(	new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setSize(250, 200);
				frame.setTitle("Name Sorter");
				frame.getContentPane().add(new NameSorter());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}});
		}
	}
