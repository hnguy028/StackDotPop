package gui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gameLogic.*;
import pattern.Patterns;

/**
 * @author Hieu
 * 
 */
public class GameEngine extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Current game state
	private State STATE = State.START_MENU;
	// Stack containing a list of patterns that need to be sorted and matched with the panels
	private PatternStack stack;
	// HUD components
	private HUD hud;
	// Initial size of the stack for the level
	private int levelLoad = 25;
	private int stackSize;
	private int points;
	
	/**
	 * Constructor : initializes 
	 */
	public GameEngine() {
		STATE = State.GAME;
		stack = new PatternStack(4, levelLoad);
		stackSize = levelLoad;
		points = 0;
		
		initHUD();
		loadHUD();
		setBackground(Color.black);
	}
	
	
	public State getState() {
		return STATE;
	}
	
	public void setState(State _state) {
		STATE = _state;
	}
	
	public void setLevel(int level) {
		
	}
	
	public void addPoints(int point) {
		points += point;
		hud.updateNorth("Points: " + points, null, null);
	}
	
	public void resetLevel() {
		stack.reloadStack(levelLoad);
	}
	
	/*
	 * Stack Methods 
	 */
	public Patterns popStack() {
		hud.updateNorth(null, "Stack("+ stackSize + " / " + levelLoad +")", null);
		stackSize--;
		return stack.pop();
	}
	
	public Patterns topStack() {
		return stack.top;
	}
	
	private void initHUD() {
		hud = new HUD();
		hud.setNorth(true, true, true);
	}
	
	private void loadHUD() {
		if(hud.getNorth() != null) {
			add(hud.getNorth());
		}
	}
}
