package org.bwillard.ccsf.course.cs211s._6_serialization.code_from_classes;

import javax.swing.*;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.util.*;

public class ViewDataPanel extends JPanel {

	private ArrayList<Response> responseList;
	private JTable table;
	
	public ViewDataPanel() {
	}
		
	public void setList(ArrayList<Response> list) {
		responseList = list;
	}
	
	public void updateDisplay() {
		Collections.sort(responseList);
		String[] columnNames = { "Question", "Name", "Answer"};
		int numResponses = responseList.size();
		Object[][]cells = new Object[numResponses][3];
		for(int i=0; i<numResponses; i++) {
			Response r = responseList.get(i);
			String[] row = {r.getQuestion(), r.getName(), Integer.toString(r.getAnswer())};
			cells[i] = row;
		}
		
		table = new JTable(cells, columnNames);
		table.setAutoCreateRowSorter(true);		
		
		TableColumn column = null;
		for (int i = 0; i < 3; i++) {
		    column = table.getColumnModel().getColumn(i);
		    if (i == 0) {
		        column.setPreferredWidth(150); 
		    } else {
		        column.setPreferredWidth(50);
		    }
		}
		
		removeAll();
		JScrollPane scrollPane = new JScrollPane(table);
	    add(scrollPane);
	}
	
}
