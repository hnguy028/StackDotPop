package gui;

import java.awt.Color;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gameLogic.PatternGenerator;
import pattern.Patterns;

public class PatternStack {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LinkedList<Patterns> stack;
	PatternGenerator pRNG;
	Patterns top;
	
	public PatternStack(int maxPatterns, int initialLoad) {
		pRNG = new PatternGenerator(maxPatterns);
		stack = new LinkedList<Patterns>();
		reloadStack(initialLoad);
		top = stack.getFirst();
	}
	
	public void reloadStack(int load) {
		for(int i=0; i < load; i++) {
			stack.add(pRNG.nextPattern());
		}
	}
	
	public Patterns pop() {
		Patterns temp = top;
		top = stack.pop();
		return temp;
	}
}
