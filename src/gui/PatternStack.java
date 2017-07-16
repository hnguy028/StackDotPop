package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gamefunctions.PatternGenerator;
import pattern.Patterns;

public class PatternStack {
	
	JPanel panel;
	LinkedList<Patterns> stack;
	PatternGenerator pRNG;
	Patterns currentPattern;
	
	public PatternStack(int maxPatterns, int initialLoad) {
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		
		pRNG = new PatternGenerator(maxPatterns);
		stack = new LinkedList<Patterns>();
		reloadStack(initialLoad);
		currentPattern = stack.getFirst();
		loadColor();
	}
	
	public void reloadStack(int load) {
		for(int i=0; i < load; i++) {
			stack.add(pRNG.nextPattern());
		}
	}
	
	public void loadColor() {
		panel.setBackground(currentPattern.getColor());
	}
	
	public Patterns pop() {
		Patterns temp = currentPattern;
		currentPattern = stack.pop();
		loadColor();
		return temp;
	}
	
	public JPanel getJPanel() {
		return panel;
	}
}
