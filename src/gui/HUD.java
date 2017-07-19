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
	private JLabel nPoints, nStack, nLevel;
	
	public HUD() {
		
	}
	
	public void setNorth(boolean points, boolean stack, boolean level) {
		north = new JPanel();
		
		if(points) {
			nPoints = new JLabel("Points: 0");
			north.add(nPoints);
		}
		
		if(stack) {
			nStack = new JLabel("Stack(25 / 25)");
			north.add(nStack);
		}
		
		if(level) {
			nLevel = new JLabel("Level 1");
			north.add(nLevel);
		}
		
		
			
		
	}
	
	public void updateNorth(String points, String stack, String level) {
		if(points != null)
			nPoints.setText(points);
		if(stack != null)
			nStack.setText(stack);
		if(level != null)
			nLevel.setText(level);
	}
	
	public JComponent getNorth() {
		return north;
	}
}
