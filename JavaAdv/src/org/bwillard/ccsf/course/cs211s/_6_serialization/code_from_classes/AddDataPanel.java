package org.bwillard.ccsf.course.cs211s._6_serialization.code_from_classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Hashtable;

public class AddDataPanel extends JPanel {

	private JTextField nameField;
	private JComboBox<String> questionList;
	private JSlider answerSlider;
	private final static int DEFAULT_SLIDER_VALUE = 6;
	private JButton addButton;
	
	private ArrayList<Response> responseList;
	
	
	public AddDataPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1));
		
		JPanel namePanel = new JPanel();
		JLabel nameLabel = new JLabel("Name:");
		nameField = new JTextField(10);
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		panel.add(namePanel);
		
		JPanel listPanel = new JPanel();
		questionList = new JComboBox<String>();
		questionList.addItem("Java is my favorite language.");
		questionList.addItem("Java is easy to use.");
		questionList.addItem("Java is logically designed.");
		questionList.addItem("Java is fun.");
		questionList.setSelectedIndex(-1);
		listPanel.add(questionList);
		panel.add(listPanel);
		
		JPanel answerPanel = new JPanel();
		answerSlider = new JSlider(0, 11, DEFAULT_SLIDER_VALUE); // min, max, initial value
		answerSlider.setMajorTickSpacing(DEFAULT_SLIDER_VALUE);
		answerSlider.setMinorTickSpacing(1);
		answerSlider.setPaintTicks(true);
		answerSlider.setPaintLabels(true);
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(0,  new JLabel("SD"));
		labelTable.put(11,  new JLabel("SA"));
		answerSlider.setLabelTable(labelTable);
		answerPanel.add(answerSlider);
		panel.add(answerPanel);
		
		
		JPanel addPanel = new JPanel();
		addButton = new JButton("Add Response");
		addButton.addActionListener(new ButtonListener());
		addPanel.add(addButton);
		panel.add(addPanel);
		
		add(panel);
		
	}
	
	public void setList(ArrayList<Response> list) {
		responseList = list;
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String name = nameField.getText();
			
			int selectedIndex = questionList.getSelectedIndex();
			String question  = questionList.getItemAt(selectedIndex);
			
			int answer = answerSlider.getValue();
			answerSlider.setValue(DEFAULT_SLIDER_VALUE);
						
			Response r = new Response(name, question, answer);
			responseList.add(r);
			
			nameField.setText("");
			questionList.setSelectedIndex(-1);
	
		}
	}
	
	
}
