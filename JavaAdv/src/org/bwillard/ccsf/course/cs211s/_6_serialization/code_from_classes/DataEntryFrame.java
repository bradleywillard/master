package org.bwillard.ccsf.course.cs211s._6_serialization.code_from_classes;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class DataEntryFrame extends JFrame {

	public static final int DEFAULT_WIDTH = 500;
	public static final int DEFAULT_HEIGHT = 500;

	private JMenuItem addData, viewData;

	private ArrayList<Response> responses;

	private AddDataPanel addPanel;
	private ViewDataPanel viewPanel;
	private Container contentPane;

	public DataEntryFrame(AddDataPanel aPanel, ViewDataPanel vPanel) {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		responses = new ArrayList<Response>();
		this.addPanel = aPanel;
		this.viewPanel = vPanel;
		addPanel.setList(responses);
		viewPanel.setList(responses);

		contentPane = getContentPane();
		contentPane.add(addPanel);

		// menus: 1. create a menu bar and set the menu bar of the frame
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// menus: 2. create a menu and add it to the menu bar
		JMenu menu = new JMenu("Data Menu");
		menuBar.add(menu);

		// menus: 3. create a menu item and add it to the menu
		// add a listener to the menu item to take the action
		addData = new JMenuItem("Add Data");
		menu.add(addData);
		addData.addActionListener(event -> {
			contentPane.removeAll();
			contentPane.add(addPanel);
			revalidate();
			repaint();
		});

		viewData = new JMenuItem("View Data");
		viewData.addActionListener(event -> {
			contentPane.removeAll();
			contentPane.add(viewPanel);
			viewPanel.updateDisplay();
			revalidate();
			repaint();
		});
		menu.add(viewData);

		this.addWindowListener(new WindowCloseListener(this));

	}

	private class WindowCloseListener extends WindowAdapter {
		
		private JFrame frame;
		
		private WindowCloseListener(JFrame frame) {
			this.frame = frame;
		}
		
		@Override
		public void windowClosing(WindowEvent e) {
			int option = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?");
			if (option == JOptionPane.YES_OPTION) {
				//frame.dispose();
				
				try {
					ObjectOutputStream out =  new ObjectOutputStream(
						new FileOutputStream("responseList.ser"));
					out.writeObject(responses);
					out.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				AddDataPanel addPanel = new AddDataPanel();
				ViewDataPanel viewPanel = new ViewDataPanel();
				DataEntryFrame frame = new DataEntryFrame(addPanel, viewPanel);

				frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	}

}
