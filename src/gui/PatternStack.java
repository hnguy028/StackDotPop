package gui;

import java.awt.Color;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gameLogic.PatternGenerator;
import pattern.Patterns;

public class PatternStack extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel label;
	LinkedList<Patterns> stack;
	PatternGenerator pRNG;
	Patterns top;
	//Patterns currentPattern;
	
	public PatternStack(int maxPatterns, int initialLoad) {
		// set transparency
		setBackground(new Color(0,0,0,0));
		
		// create label to display pattern
		label = new JLabel();
		add(label);
		
		pRNG = new PatternGenerator(maxPatterns);
		stack = new LinkedList<Patterns>();
		reloadStack(initialLoad);
		top = stack.getFirst();
		loadImage();
	}
	
	public void reloadStack(int load) {
		for(int i=0; i < load; i++) {
			stack.add(pRNG.nextPattern());
		}
	}
	
	public void loadImage() {
		label.setIcon(new ImageIcon(new ImageIcon("resources/" + top.getPatternName()).getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT)));
	}
	
	public Patterns pop() {
		Patterns temp = top;
		top = stack.pop();
		loadImage();
		return temp;
	}
}
