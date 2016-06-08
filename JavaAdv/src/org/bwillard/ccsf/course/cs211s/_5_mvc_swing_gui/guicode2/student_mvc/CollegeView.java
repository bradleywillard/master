package org.bwillard.ccsf.course.cs211s._5_mvc_swing_gui.guicode2.student_mvc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/* the view class */
public class CollegeView extends JPanel{
	
	private JTextField nameField, idField;
	private JCheckBox tuitionBox;
	
	private JButton addStudentButton;
	
	private JTextArea outputArea;
	
	public CollegeView() {
		
		JLabel nameLabel = new JLabel("Enter the name:");
		nameField = new JTextField(10);
		JPanel namePanel = new JPanel();
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		add(namePanel);
		
		JLabel idLabel = new JLabel("Enter the id:");
		idField = new JTextField(10);
		JPanel idPanel = new JPanel();
		idPanel.add(idLabel);
		idPanel.add(idField);
		add(idPanel);
		
		tuitionBox = new JCheckBox("Tuition Paid", true);
		add(tuitionBox);
		
		addStudentButton = new JButton("Add Student");
		add(addStudentButton);
		
		outputArea = new JTextArea(10, 20);
		add(outputArea);
		
	}

	public String getName() {
		return nameField.getText();
	}
	public String getID() {
		return idField.getText();
	}
	public boolean isTuitionPaid() {
		return tuitionBox.isSelected();
	}
	
	public void clearInputs() {
		nameField.setText("");
		idField.setText("");
		tuitionBox.setSelected(true);
	}
	
	public void updateDisplay(String display) {
		outputArea.setText("");
		outputArea.setText(display);
	}
	
	public void setButtonListener(ActionListener listener) {
		addStudentButton.addActionListener(listener);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(	new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setSize(250, 200);
				frame.setTitle("College Enrollment");
				
				CollegeView theView = new CollegeView();
				College college = new College();
				CollegeController theController = 
						new CollegeController(theView, college);
				
				frame.getContentPane().add(theView);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}});
		}
	}

