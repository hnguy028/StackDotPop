package gui;

import java.awt.Color;
import java.awt.Image;

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
		setImage(pattern.getPatternName());
	}
	
	public void setImage(String img) {
		label.setIcon(new ImageIcon(new ImageIcon("resources/" + img).getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT)));
	}
	
	public void rotate() {
		label
	}
}
