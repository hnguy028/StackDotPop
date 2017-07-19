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

public class JPanelImage extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image;
	
	private Panel[][] panelHolder;
	
	public JPanelImage(Image image, int rows, int cols) {
		this.image = image;
		init(rows, cols);
	}
	
	public JPanelImage(String filename, int rows, int cols) {
		try { this.image = ImageIO.read(new File(filename)); } catch (IOException e) { e.printStackTrace(); }
		init(rows, cols);
	}
	
	public void addPattern(int x, int y, Patterns _pattern) {
		panelHolder[x][y].setPattern(_pattern);
	}
	
	public boolean matches(int x, int y, Patterns _pattern) {
		return panelHolder[x][y].patternMatches(_pattern);
	}
	
	private void init(int panelRows, int panelColumns) {
		panelHolder = new Panel[panelRows][panelColumns];
		
		/* TODO : probably won't need cardinal location, to be removed */
		CardinalLocation counter = CardinalLocation.NORTH_WEST;
		
		// Initialize the panels to null
		for(int y=0; y<panelRows; y++) {
			for(int x=0; x<panelColumns; x++) {
				panelHolder[x][y] = new Panel(counter, new NullPattern());
				add(panelHolder[x][y]);
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
