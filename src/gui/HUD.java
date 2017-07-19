package gui;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author hinguyen
 *
 *	Container holding HUD components
 */
public class HUD {
	private JPanel north;
	private JLabel nPoints, nStack;
	
	public HUD() {
		
	}
	
	public void setNorth(boolean points, boolean stack) {
		north = new JPanel();
		
		if(points) {
			nPoints = new JLabel("Points: 0");
			north.add(nPoints);
		}
		
		if(stack) {
			nStack = new JLabel("Stack(25 / 25)");
			north.add(nStack);
		}
			
		
	}
	
	public void updateNorth(String points, String stack) {
		if(points != null)
			nPoints.setText(points);
		if(stack != null)
			nStack.setText(stack);
	}
	
	public JComponent getNorth() {
		return north;
	}
}
