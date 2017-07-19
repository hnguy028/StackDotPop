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
	Patterns pattern;
	CardinalLocation location;
	JLabel label;
	
	public Panel(CardinalLocation _location, Patterns _pattern) {
		// Set transparent background (alpha=0)
		setBackground(new Color(0,0,0,0));
		location = _location;
		pattern = _pattern;
		label = new JLabel(); 
		add(label);
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
		//setImage(pattern.getPatternName());
	}
	
	public void rotate() {
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		Image image = null;
		try { image = ImageIO.read(new File("resources/" + pattern.getPatternName())); } catch (IOException e) { image=null; }
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
}
