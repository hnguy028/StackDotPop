package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author hinguyen
 *
 * Container holding HUD components
 * TODO : create separate setter and getters 
 */
public class HUD {
	private JPanel north;
	private JLabel nPoints, nStack, nLevel, nTimer;
	
	public HUD() {
		
	}
	
	/**
	 * Determines which hud components to load
	 * @param points
	 * @param stack
	 * @param level
	 * @param timer
	 */
	public void setNorth(boolean level, boolean stack, boolean points, boolean timer) {
		north = new JPanel();
		
		if(level) {
			nLevel = new JLabel("Level 1");
			north.add(nLevel);
		}
		
		if(stack) {
			nStack = new JLabel("Stack(25 / 25)");
			north.add(nStack);
		}
		
		if(points) {
			nPoints = new JLabel("Points: 0");
			north.add(nPoints);
		}
		
		if(timer) {
			nTimer = new JLabel("Time: 600");
			north.add(nTimer);
		}

	}
	
	//public void updateNorth(String level, String stack, String points, String timer) {
	public void updateNorth(String points, String stack, String level, String timer) {
		if(points != null)
			nPoints.setText(points);
		if(stack != null)
			nStack.setText(stack);
		if(level != null)
			nLevel.setText(level);
		if(timer != null)
			nTimer.setText(timer);
	}
	
	public JComponent getNorth() {
		return north;
	}
}
