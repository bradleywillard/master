package org.bwillard.ccsf.course.cs211s.assn5.guicode2.employee_mvc;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/* the view */
public class EmployeeFrame extends JFrame {
	
	private JTextField idField, nameField;
	private JTextArea outputArea;
	private JRadioButton salaryButton, hourlyButton;
	private JButton addButton, payButton;
		
	public EmployeeFrame() {
		setTitle("Employee Processing");
		setSize(300,375);
		
		JPanel middlePanel = new JPanel();
		middlePanel.setLayout(new GridLayout(2,1));
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(4,1));
		JPanel idPanel = new JPanel();
		idField = new JTextField(10);
		idPanel.add(new JLabel("Enter ID:"));
		idPanel.add(idField);
		inputPanel.add(idPanel);
		
		nameField = new JTextField(10);
		JPanel namePanel = new JPanel();
		namePanel.add(new JLabel("Enter Name:"));
		namePanel.add(nameField);
		inputPanel.add(namePanel);
		
		JPanel tuitionPanel = new JPanel();
		tuitionPanel.add(new JLabel("Pay Type"));
		salaryButton = new JRadioButton("Salary", true);
		hourlyButton = new JRadioButton("Hourly");
		tuitionPanel.add(salaryButton);
		tuitionPanel.add(hourlyButton);
		ButtonGroup group = new ButtonGroup();
		group.add(salaryButton);
		group.add(hourlyButton);
		inputPanel.add(tuitionPanel);
	
		middlePanel.add(inputPanel);
		
		JPanel buttonPanel = new JPanel();
		addButton = new JButton("Add Employee");
		buttonPanel.add(addButton);	
		
		payButton = new JButton("Run Payroll");
		buttonPanel.add(payButton);	
		inputPanel.add(buttonPanel);
		
		outputArea = new JTextArea(10,1);
		JScrollPane scrollPane = new JScrollPane(outputArea);
		middlePanel.add(scrollPane);
		
		getContentPane().add(middlePanel);
		
		
	}
	
	public String getID() {
		return idField.getText();
	}
	public String getName() {
		return nameField.getText();
	}
	
	public void addAddEmployeeListener(ActionListener listener) {
		addButton.addActionListener(listener);
	}
	public void addRunPayrollListener(ActionListener listener) {
		payButton.addActionListener(listener);
	}
	
	public void clearInputs() {
		nameField.setText("");
		idField.setText("");
	}
	
	public void updateDisplayOutput(String output) {
		outputArea.setText("");
		outputArea.setText(output);
	}
	


	public Employee.PayType getPayType() {
		if(salaryButton.isSelected()) {
			return Employee.PayType.SALARY;
		} else {
			return Employee.PayType.HOURLY;
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				
				EmployeeFrame theView  = new EmployeeFrame();
				Department theModel = new Department();
				
				EmployeeProcessor theController = new EmployeeProcessor(theView, theModel); 
				theView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				theView.setVisible(true);
			}
		});

	}
}
