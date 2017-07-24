package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gameLogic.CardinalLocation;
import pattern.Patterns;

public class Panel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Patterns pattern;
	private CardinalLocation location;
	
	public Panel(CardinalLocation _location, Patterns _pattern) {
		// Set transparent background - new Color(r,g,b,alpha)
		setBackground(new Color(0,0,0,0));
		location = _location;
		pattern = _pattern;
	}
	
	public boolean patternMatches(Patterns _pattern) {
		return pattern.matches(_pattern);
	}
	
	public Patterns getPattern() {
		return pattern;
	}
	
	public CardinalLocation getCardinalLocation() {
		return location;
	}
	
	public void setPattern(Patterns _pattern) {
		pattern = _pattern;
		this.repaint();
	}
	
	public void rotate() {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image image = null;
		try { image = ImageIO.read(new File(pattern.getFileName())); } catch (IOException e) { image=null; }
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
}
