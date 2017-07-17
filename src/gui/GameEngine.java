package gui;

import java.awt.Color;

import gameLogic.*;
import pattern.*;

/**
 * @author Hieu
 *
 * Contains all components for the game (ie jpanels, and the stack)
 */
public class GameEngine {
	private State STATE = State.START_MENU;
	// Stack containing a list of patterns that need to be sorted and matched with the panels
	private PatternStack stack;
	// Initial size of the stack for the level
	private int currentLoad = 25;
	
	/**
	 * Constructor : initializes the PatternGenerator, PatternStack, as well as the Panels
	 */
	public GameEngine() {
		STATE = State.GAME;
		stack = new PatternStack(4, currentLoad);
	}
	
	
	public PatternStack getPatternStack() {
		return stack;
	}
	
	public State getState() {
		return STATE;
	}
	
	public void setLevel(int level) {
		stack.reloadStack(level);
	}
}
