package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import gameLogic.CardinalLocation;
import pattern.NullPattern;
import pattern.Patterns;

/**
 * @author hinguyen
 *
 * JPanel containing the core of the game (ie the sidePanels and the stack)
 */
public class JPanelImage extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Background Image of the game
	private Image image;
	
	// Matrix of the game components
	private Panel[][] panelHolder;
	
	/**
	 * Constructor
	 * @param image
	 * @param rows
	 * @param cols
	 */
	public JPanelImage(Image image, int rows, int cols) {
		this.image = image;
		init(rows, cols);
	}
	
	/**
	 * Constructor
	 * @param filename
	 * @param rows
	 * @param cols
	 */
	public JPanelImage(String filename, int rows, int cols) {
		try { this.image = ImageIO.read(new File(filename)); } catch (IOException e) { e.printStackTrace(); }
		init(rows, cols);
	}
	
	/**
	 * Updates the patterns at the given x,y coordinates
	 * @param x
	 * @param y
	 * @param _pattern
	 */
	public void addPattern(int x, int y, Patterns _pattern) {
		panelHolder[x][y].setPattern(_pattern);
	}
	
	/**
	 * Checks if the given pattern matches the existing one are the given coordinates
	 * @param x
	 * @param y
	 * @param _pattern
	 * @return
	 */
	public boolean matches(int x, int y, Patterns _pattern) {
		return panelHolder[x][y].patternMatches(_pattern);
	}
	
	/**
	 * Initializes all patterns to null and tranparent JPanels
	 * @param panelRows
	 * @param panelColumns
	 */
	private void init(int panelRows, int panelColumns) {
		panelHolder = new Panel[panelRows][panelColumns];
		
		/* TODO : probably won't need cardinal location, to be removed */
		CardinalLocation counter = CardinalLocation.NORTH_WEST;
		
		// Initialize the panels to null
		for(int y=0; y<panelRows; y++) {
			for(int x=0; x<panelColumns; x++) {
				panelHolder[x][y] = new Panel(counter, new NullPattern()); // generate null pattern object
				add(panelHolder[x][y]); // add to this JPanel
				counter.next();
			}
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}
}
