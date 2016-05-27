package org.bwillard.ccsf.course.cs211s.assn6.code_from_classes;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;

import javax.swing.*;
import javax.swing.filechooser.*;

import java.util.*;
import java.util.List;

public class TextInputOutput extends JPanel {

	private JTextArea inputOutputArea;
	private JButton saveButton, openButton;

	public TextInputOutput() {
		setLayout(new BorderLayout());

		inputOutputArea = new JTextArea(30, 30);
		JPanel panel = new JPanel();
		panel.add(inputOutputArea);
		add(panel);

		JPanel buttonPanel = new JPanel();
		saveButton = new JButton("Save Text");
		saveButton.addActionListener(new SaveListener(this));
		buttonPanel.add(saveButton);

		openButton = new JButton("Open Text");
		openButton.addActionListener(new OpenListener(this));
		buttonPanel.add(openButton);

		add(buttonPanel, BorderLayout.SOUTH);
	}

	private class SaveListener implements ActionListener {

		private JPanel panel;

		public SaveListener(JPanel panel) {
			this.panel = panel;
		}
		@Override
		public void actionPerformed(ActionEvent event) {
			String userText = inputOutputArea.getText();
			String[] textArray = userText.split("\\n");
			ArrayList<String> textList = new ArrayList<String>
				(Arrays.asList(textArray));
			
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new File("."));
			chooser.showSaveDialog(panel);
			String fileName = chooser.getSelectedFile().getPath();
			System.out.println(fileName);
			
			try {
				Path path = Paths.get(fileName);
				Files.write(path, textList);
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	private class OpenListener implements ActionListener {

		private JPanel panel;

		public OpenListener(JPanel panel) {
			this.panel = panel;
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new File("."));
			chooser.setFileFilter(new FileNameExtensionFilter("Image (png)", "png"));
			chooser.showOpenDialog(panel);
			String fileName = chooser.getSelectedFile().getPath();
			System.out.println(fileName);
			
			try {
				inputOutputArea.setText("");
			
				Path path = Paths.get(fileName);
				List<String> lines = Files.readAllLines(path);
				
				for(String s : lines) {
					inputOutputArea.append(s + "\n");
				}
				
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setSize(500, 500);
				frame.setTitle("File Input Output");
				frame.getContentPane().add(new TextInputOutput());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	}

}
