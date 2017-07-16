package gui;

import java.awt.Color;

import gamefunctions.PatternGenerator;
import pattern.*;

/**
 * @author Hieu
 *
 * Contains all components for the game (ie jpanels, and the stack)
 */
public class GUI {
	// Panels defining the patterns that can be matched
	private Panel north, south, east, west, center;
	// Stack containing a list of patterns that need to be sorted and matched with the panels
	private PatternStack stack;
	// Maximum number of patterns
	private static final int maxPatterns = 4;
	// Initial size of the stack for the level
	private int currentLoad = 25;
	
	/**
	 * Constructor : initializes the PatternGenerator, PatternStack, as well as the Panels
	 */
	public GUI() {
		stack = new PatternStack(maxPatterns, currentLoad);
		
		//pRNG.nextPattern();
		north = new Panel(CardinalLocation.NORTH, new Blue("1","Blue", Color.BLUE));
		south = new Panel(CardinalLocation.SOUTH, new Yellow("3","Yellow", Color.YELLOW));
		east = new Panel(CardinalLocation.EAST, new Green("2","Green", Color.GREEN));
		west = new Panel(CardinalLocation.WEST, new Red("4","Red", Color.RED));
	}
	
	/**
	 * @param loc
	 * @return the corresponding panel given the cardinal location
	 */
	public Panel getPanel(CardinalLocation loc) {
		switch(loc) {
		case NORTH:
			return north;
		case SOUTH:
			return south;
		case EAST:
			return east;
		case WEST:
			return west;
		default:
			// Error
			return null;
		}
	}
	
	public PatternStack getPatternStack() {
		return stack;
	}
}
