package org.bwillard.ccsf.course.cs211s.assn5.instruments;

import java.awt.event.*;

import javax.swing.JOptionPane;

import org.bwillard.ccsf.course.cs211s.assn5.instruments.*;


public class InstrumentController {
	
	/**
	 * Instance data
	 */
	private InstrumentPanel theView;
	private InstrumentFactory theModel;
	
	/**
	 * Constructor
	 * 
	 * @param theView
	 * @param theModel
	 */
	public InstrumentController(InstrumentPanel theView, InstrumentFactory theModel) {
		this.theView = theView;
		this.theModel = theModel;
		theView.setButtonListener(new ButtonListener());
	}

	/**
	 * ActionListener
	 * 
	 * @author bradleywillard
	 *
	 */
	public class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			//Possible error message...
			String errMsg = null;
			
			//First, pull the info out of the view...
			InstrumentType type = theView.getType();
			String model = theView.getModel();
			String brand = theView.getBrand();			
			double price = 0;
			try {
				price = Double.parseDouble(theView.getPrice());
			} catch(NumberFormatException e) {
				System.out.println(e.getCause());
				errMsg = "Please enter a valid price";
			}
			
			//Then do some simple validation...
			if(type == null) {
				errMsg = "Please select a valid Instrument Type";
			} else if(brand.startsWith("--")) {
				errMsg = "Please enter a valid brand";
			} else if(model.startsWith("--")) {
				errMsg = "Please enter a valid model";
			}
			//If an error was found, show an error message dialog...
			if(errMsg != null) {
				JOptionPane.showMessageDialog(null, errMsg.toString());
			//Otherwise, proceed as expected...
			} else {
				//Create an instrument from the data obtained from the view....
				Instrument instrument = theModel.createInstrument(brand, model, type, price);
				
				//Update the model with the new instrument...
				theModel.addInstrument(instrument);
				
				//Finally, update the view...
				theView.clearInputs();
				theView.updateDisplay(theModel.toString());
			}
			
		}
	}
	
}
