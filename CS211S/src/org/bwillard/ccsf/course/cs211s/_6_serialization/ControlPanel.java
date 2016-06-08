package org.bwillard.ccsf.course.cs211s.assn6;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.bwillard.ccsf.course.cs211s.assn6.Car;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class ControlPanel extends JPanel {
	
	private static final String FILE_EXT = "ser";
	
	private JButton raceButton, replayButton, saveButton, loadButton;
	private JLabel winnerLabel;
	private RacePanel racePanel;

	public ControlPanel() {
		setLayout(new GridLayout(2,1));
		
		JPanel buttonPanel = new JPanel();
		raceButton = new JButton("Race!");
		buttonPanel.add(raceButton);
		raceButton.addActionListener(new RaceListener());
		
		replayButton = new JButton("Replay");
		replayButton.setEnabled(false);
		buttonPanel.add(replayButton);
		replayButton.addActionListener(new ReplayListener());
		
		saveButton = new JButton("Save");
		saveButton.setEnabled(false);
		buttonPanel.add(saveButton);
		saveButton.addActionListener(new SaveListener(this));
		
		loadButton = new JButton("Load");
		loadButton.setEnabled(true);
		buttonPanel.add(loadButton);
		loadButton.addActionListener(new LoadListener(this));
		
		add(buttonPanel);
		
		JPanel labelPanel = new JPanel();
		winnerLabel = new JLabel("");
		labelPanel.add(winnerLabel);
		add(labelPanel);
		
	}
	
	public JButton getSaveButton() {
		return saveButton;
	}

	public void setWinnerLabel(String text) {
		winnerLabel.setText(text);
	}
	
	public void setRacePanel(RacePanel racePanel) {
		this.racePanel = racePanel;
	}
		
	/**
	 * RaceListener
	 *     ActionListener
	 *
	 * Performs a brand new Race with no baggage from the past
	 */
	public class RaceListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			setWinnerLabel("");
			racePanel.startRace(false);
			replayButton.setEnabled(true);
			saveButton.setEnabled(false);
			loadButton.setEnabled(true);
		}
	}
	
	/**
	 * ReplayListener
	 *     ActionListener
	 *
	 * Replays the currently started or loaded race
	 */
	public class ReplayListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			setWinnerLabel("");
			racePanel.replayRace();
			raceButton.setEnabled(true);
			saveButton.setEnabled(false);
			loadButton.setEnabled(true);
		}
	}
	
	/**
	 * SaveListener
	 *     ActionListener
	 *     
	 * Saves the serialized file to disk
	 */
	public class SaveListener implements ActionListener {
		
		private ControlPanel cPanel;
		private JFileChooser fc = new JFileChooser(){
		    @Override
		    public void approveSelection(){
		        File f = new File(getSelectedFile() + "." + FILE_EXT);
		        if(f.exists() && getDialogType() == SAVE_DIALOG){
		            int result = JOptionPane.showConfirmDialog(this,"The file exists, overwrite?","Existing file",JOptionPane.YES_NO_CANCEL_OPTION);
		            switch(result){
		                case JOptionPane.YES_OPTION:
		                    super.approveSelection();
		                    return;
		                case JOptionPane.NO_OPTION:
		                    return;
		                case JOptionPane.CLOSED_OPTION:
		                    return;
		                case JOptionPane.CANCEL_OPTION:
		                    cancelSelection();
		                    return;
		            }
		        } 
		        super.approveSelection();
		       
		    }        
		};

		public SaveListener(ControlPanel cPanel) {
			this.cPanel = cPanel;
		}
		
		public void actionPerformed(ActionEvent evt) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter(".ser (serialized files)", FILE_EXT);
        	fc.setFileFilter(filter);
        	fc.setDialogType(JFileChooser.SAVE_DIALOG);
        	File saveDir = new File(RacePanel.FILE_PATH);
            fc.setCurrentDirectory(saveDir);
            String suggestedFileName = racePanel.getWinner() != null ? racePanel.getWinner().getName().replaceAll(" ", "") + "Won": "";
            fc.setSelectedFile(new File(suggestedFileName));
            fc.showSaveDialog(racePanel);
            String fileName = fc.getSelectedFile().getPath() + "." + FILE_EXT;
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));) {
                oos.writeObject(racePanel.getCarList());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
            saveButton.setEnabled(false);
		}
		
		
	}
	
	/**
	 * LoadListener
	 * 		ActionListener
	 * 
	 * Loads the serialized file back into the program
	 */
	public class LoadListener implements ActionListener {
		
		private ControlPanel cPanel;
		
		public LoadListener(ControlPanel cPanel) {
			this.cPanel = cPanel;
		}
		
		public void actionPerformed(ActionEvent evt) {
            JFileChooser fc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("serialized files", FILE_EXT);
        	fc.setFileFilter(filter);
        	fc.setDialogType(JFileChooser.OPEN_DIALOG);
            fc.setCurrentDirectory(new File(RacePanel.FILE_PATH));
            fc.showOpenDialog(racePanel);
            if(fc.getSelectedFile() != null) {
	            String fileName = fc.getSelectedFile().getPath();
	            try (ObjectInputStream os = new ObjectInputStream(new FileInputStream(fileName));){
	            	Object o = os.readObject();
	                if(o instanceof List<?> && ((List<?>) o).get(0) instanceof Car) {
	                	@SuppressWarnings("unchecked")
						List<Car> carList = (ArrayList<Car>)o;
	                    racePanel.setCarList(carList);
	                } else {
	                	throw new ClassCastException(o.toString() + " was not of type List<Car>");
	                }
	            } catch (ClassNotFoundException | IOException ex) {
	            	ex.printStackTrace();
	            }
	            
	            setWinnerLabel(fc.getSelectedFile().getName() + " loaded! Hit Replay");
	            raceButton.setEnabled(false);
	            replayButton.setEnabled(true);
	            saveButton.setEnabled(false);
	            loadButton.setEnabled(true);
            }
        }
	}
}
