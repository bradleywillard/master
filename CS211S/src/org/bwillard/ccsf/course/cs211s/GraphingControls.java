import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class GraphingControls extends JPanel { 

	private JLabel coordinateLabel, distanceLabel, midpointLabel, vertHorizLabel;
	private JButton distanceButton, midpointButton, vertHorizButton;
	
	private Point2D point1, point2;

	private Color color;

	public GraphingControls () {

		setLayout(new GridLayout(4,1));
		color = Color.CYAN;
		
		JPanel labelPanel = new JPanel();
		labelPanel.setBackground(color);
		coordinateLabel = new JLabel(" ");
		labelPanel.add(coordinateLabel);
		add(labelPanel);
		
		JPanel distancePanel = new JPanel();
		distancePanel.setBackground(color);
		distancePanel.setLayout(new GridLayout(1,2));
		distanceButton = new JButton("Find Distance");
		distanceLabel = new JLabel("");
		distancePanel.add(distanceButton);
		distancePanel.add(distanceLabel);
		// ??? DISTANCE BUTTON NEEDS A LISTENER
		add(distancePanel);
		
		
		JPanel midPointPanel = new JPanel();
		midPointPanel.setBackground(color);
		midPointPanel.setLayout(new GridLayout(1,2));
		midpointButton = new JButton("Find Midpoint");
		midpointLabel = new JLabel("");
		midPointPanel.add(midpointButton);
		midPointPanel.add(midpointLabel);
		// ??? MIDPOINT BUTTON NEEDS A LISTENER
		add(midPointPanel);
		
		JPanel vertHorizPanel = new JPanel();
		vertHorizPanel.setBackground(color);
		vertHorizPanel.setLayout(new GridLayout(1,2));
		vertHorizButton = new JButton("Vertical/Horizontal");
		vertHorizLabel = new JLabel("");
		vertHorizPanel.add(vertHorizButton);
		vertHorizPanel.add(vertHorizLabel);
		// ??? VERTHORIZ BUTTON NEEDS A LISTENER
		add(vertHorizPanel);
	
	}
	
	public void updatePoints(Point2D point1, Point2D point2) {
		this.point1 = point1;
		this.point2 = point2;
		updateLabels();
	}


	private void updateLabels() {
		if(point1!=null && point2!=null) {
			coordinateLabel.setText("("+((int)point1.getX())+", " 
				+ ((int)point1.getY())+") and " 
				+ "("+((int)point2.getX())+", " 
				+ ((int)point2.getY())+") "
				);
		} else {
			coordinateLabel.setText("");
		}
		distanceLabel.setText("");
		midpointLabel.setText("");
		vertHorizLabel.setText("");
	}

	
}