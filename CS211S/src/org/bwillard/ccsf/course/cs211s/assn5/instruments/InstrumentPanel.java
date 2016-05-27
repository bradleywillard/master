package org.bwillard.ccsf.course.cs211s.assn5.instruments;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class InstrumentPanel extends JPanel{

	private static final String SELECT_INSTRUMENT_TYPE = "-- Select Instrument Type --";
	private static final String ENTER_THE_PRICE = "-- Enter the Price...";
	private static final String ENTER_THE_MODEL = "-- Enter the Model...";
	private static final String ENTER_THE_BRAND = "-- Enter the Brand...";
	
	private static final Color PANEL_COLOR = Color.WHITE;
	private static final Color DARK_TEXT_COLOR = Color.BLACK;
	private static final Color LIGHT_TEXT_COLOR = Color.GRAY;
	private static final Font TEXTFIELD_FONT = new Font("Arial", Font.ITALIC, 12);
	private static final Font DROPDOWN_FONT = new Font("Arial", Font.PLAIN, 12);
	
	private JTextField brand, model, price;
	private JButton button;
	private JTextArea outputArea;
	private final JComboBox<String> types;
	
	private static String imagePath = "src/org/bwillard/ccsf/course/cs211s/assn5/instruments/images/";
	private static String imageFileName = "instruments.png";
	private Image image;
	
	private Instrument instrument;
	
	public InstrumentPanel() {
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		setBackground(PANEL_COLOR);
		
		image = new ImageIcon(imageFileName).getImage();
		
		//Select dropdown for type
		types = new JComboBox<String>(getInstrumentTypes());
		types.setFont(DROPDOWN_FONT);
		types.setForeground(LIGHT_TEXT_COLOR);
		types.addItemListener(new ItemListener() {
	        public void itemStateChanged(ItemEvent arg0) {
	        	String item = (String)types.getSelectedItem();
	        	InstrumentType type = InstrumentType.getByDisplayName(item);
	        	types.setForeground(DARK_TEXT_COLOR);
	        	if(InstrumentType.ELECTRIC == type) {
	        		imageFileName = "electric.png";
	        	} else if(InstrumentType.STEEL_STRING == type) {
	        		imageFileName = "steel_string.png";
	        	} else if(InstrumentType.NYLON_STRING == type) {
	        		imageFileName = "nylon_string.png";
	        	} else if(InstrumentType.ACOUSTIC_BASS == type) {
	        		imageFileName = "acoustic_bass.png";
	        	} else if(InstrumentType.BASS == type) {
	        		imageFileName = "bass_guitar.png";
	        	} else if(InstrumentType.VIOLA == type) {
	        		imageFileName = "viola_playing.png";
	        	} else if(InstrumentType.VIOLIN == type) {
	        		imageFileName = "violin_playing.png";
	        	} else if(InstrumentType.CELLO == type) {
	        		imageFileName = "cello_yoyoma.png";
	        	} else if(InstrumentType.UPRIGHT_BASS == type) {
	        		imageFileName = "upright_bass_playing.png";
	        	} else if(InstrumentType.DRUMS == type) {
	        		imageFileName = "drums.png";
	        	} else if(InstrumentType.GRAND == type) {
	        		imageFileName = "grand_piano.png";
	        	} else if(InstrumentType.UPRIGHT == type) {
	        		imageFileName = "upright_piano.png";
	        	} else if(InstrumentType.SQUARE == type) {
	        		imageFileName = "square_piano.png";
	        		setBackground(Color.BLACK);
	        	} else if(InstrumentType.ORGAN == type) {
	        		imageFileName = "organ.png";
	        	} else if(SELECT_INSTRUMENT_TYPE.equals(item)) {
	        		imageFileName = "instruments.png";
	        		types.setForeground(LIGHT_TEXT_COLOR);
	        	}
	            repaint();
	        }
	    });
		JPanel typePanel = new JPanel(new BorderLayout());
		typePanel.add(types);
		typePanel.setBackground(PANEL_COLOR);
		add(typePanel, BorderLayout.WEST);
		

		//Brand 
		brand = new JTextField(ENTER_THE_BRAND, 10);
		brand.setFont(TEXTFIELD_FONT);
		brand.setForeground(LIGHT_TEXT_COLOR);
		brand.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	if(ENTER_THE_BRAND.equals(brand.getText())) {
		    		brand.setText("");
		    		brand.setForeground(DARK_TEXT_COLOR);
		    	}
		    }
		    public void focusLost(FocusEvent e) {
		    	if("".equals(brand.getText())) {
		    		brand.setText(ENTER_THE_BRAND);
		    		brand.setForeground(LIGHT_TEXT_COLOR);
		    	}
		    }
		});
		JPanel brandPanel = new JPanel(new BorderLayout());
		brandPanel.add(typePanel, BorderLayout.NORTH);
		brandPanel.add(brand);
		brandPanel.setBackground(PANEL_COLOR);
		add(brandPanel);
		
		//Model
		model = new JTextField(ENTER_THE_MODEL, 10);
		model.setFont(TEXTFIELD_FONT);
		model.setForeground(LIGHT_TEXT_COLOR);
		model.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
		    	if(ENTER_THE_MODEL.equals(model.getText())) {
		    		model.setText("");
		    		model.setForeground(DARK_TEXT_COLOR);
		    	}
		    }
		    public void focusLost(FocusEvent e) {
		    	if("".equals(model.getText())) {
		    		model.setText(ENTER_THE_MODEL);
		    		model.setForeground(LIGHT_TEXT_COLOR);
		    	}
		    	
		    }
		});
		JPanel modelPanel = new JPanel(new BorderLayout());
		modelPanel.add(brandPanel, BorderLayout.NORTH);
		modelPanel.add(model);
		modelPanel.setBackground(PANEL_COLOR);
		add(modelPanel);
		
		
		//Price
		price = new JTextField(ENTER_THE_PRICE, 10);
		price.setFont(TEXTFIELD_FONT);
		price.setForeground(LIGHT_TEXT_COLOR);
		price.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
		    	if(ENTER_THE_PRICE.equals(price.getText())) {
		    		price.setText("");
		    		price.setForeground(DARK_TEXT_COLOR);
		    	}
		    }
		    public void focusLost(FocusEvent e) {
		    	if("".equals(price.getText())) {
		    		price.setText(ENTER_THE_PRICE);
		    		price.setForeground(LIGHT_TEXT_COLOR);
		    	}
		    	
		    }
		});
		JPanel pricePanel = new JPanel(new BorderLayout());
		pricePanel.add(modelPanel, BorderLayout.NORTH);
		pricePanel.add(price);
		pricePanel.setBackground(PANEL_COLOR);
		add(pricePanel);
		
		//Add Instrument Button
		button = new JButton("Click to Add Instrument");
		JPanel buttonPanel = new JPanel(new BorderLayout());
		buttonPanel.add(pricePanel, BorderLayout.NORTH);
		buttonPanel.add(button);
		buttonPanel.setBackground(PANEL_COLOR);
		buttonPanel.setOpaque(true);
		add(buttonPanel);
		
		
		//Output text area where instruments go once they've been entered...
		outputArea = new JTextArea(10, 50);
		outputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JPanel outputPanel = new JPanel(new BorderLayout());
		outputPanel.add(buttonPanel, BorderLayout.NORTH);
		outputArea.setEditable(false);
		outputPanel.add(outputArea);
		outputPanel.setBackground(PANEL_COLOR);
		add(outputPanel);

	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		image = new ImageIcon(imagePath + imageFileName).getImage();
		g2d.drawImage(image, 50, 320, null);
	}
	
	/**
	 * Get instrument type String[] to populate drop down's and such
	 * @return
	 */
	private String[] getInstrumentTypes() {
		String[] typeArr = new String[InstrumentType.values().length + 1];
		typeArr[0] = SELECT_INSTRUMENT_TYPE;
		int index = 1;
		for(InstrumentType type : InstrumentType.values()) {
			typeArr[index] = type.getDisplayName();
			index++;
		}
		return typeArr;
	}
	
	public String getBrand() {
		return brand.getText();
	}
	
	public String getModel() {
		return model.getText();
	}

	public String getPrice() {
		return price.getText();
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public InstrumentType getType() {
		String item = (String)types.getSelectedItem();
		return InstrumentType.getByDisplayName(item);
	}

	public void clearInputs() {
		types.setSelectedIndex(0);
		types.setForeground(LIGHT_TEXT_COLOR);
		brand.setText(ENTER_THE_BRAND);
		brand.setForeground(LIGHT_TEXT_COLOR);
		model.setText(ENTER_THE_MODEL);
		model.setForeground(LIGHT_TEXT_COLOR);
		price.setText(ENTER_THE_PRICE);
		price.setForeground(LIGHT_TEXT_COLOR);
	}
	
	public void updateDisplay(String display) {
		outputArea.setText("");
		outputArea.setText(display);
	}
	
	public void setButtonListener(ActionListener listener) {
		button.addActionListener(listener);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(	new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setSize(650, 600);
				frame.setTitle("Sell Instruments");
				
				InstrumentPanel theView = new InstrumentPanel();
				InstrumentFactory theModel = new InstrumentFactory();
				InstrumentController theController = new InstrumentController(theView, theModel);
				
				frame.getContentPane().add(theView);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}});
		}
	}


