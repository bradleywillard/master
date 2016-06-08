package org.bwillard.ccsf.course.cs211s.assn5.guicode2.student_mvc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/* the controller */
public class CollegeController {
	
	private CollegeView theView;
	private College college;
	
	public CollegeController(CollegeView theView, College college) {
		this.theView = theView;
		this.college = college;
		
		theView.setButtonListener(new ButtonListener());
	}

	public class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			// getting information from the view
			String sName = theView.getName();
			String sID = theView.getID();
			boolean tuitionPaid = theView.isTuitionPaid();
			
			Student s = new Student(sName, sID, tuitionPaid);
			college.addStudent(s); // update the model
			
			// updating the view
			theView.clearInputs();
			theView.updateDisplay(college.toString());
			
		}
	}
	
}
