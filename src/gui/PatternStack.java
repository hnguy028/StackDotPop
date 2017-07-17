package gui;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JPanel;

import gamefunctions.PatternGenerator;
import pattern.Patterns;

public class PatternStack {
	
	JPanel panel;
	LinkedList<Patterns> stack;
	PatternGenerator pRNG;
	Patterns top;
	//Patterns currentPattern;
	
	public PatternStack(int maxPatterns, int initialLoad) {
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		
		pRNG = new PatternGenerator(maxPatterns);
		stack = new LinkedList<Patterns>();
		reloadStack(initialLoad);
		top = stack.getFirst();
		loadColor();
	}
	
	public void reloadStack(int load) {
		for(int i=0; i < load; i++) {
			stack.add(pRNG.nextPattern());
		}
	}
	
	public void loadColor() {
		panel.setBackground(top.getColor());
	}
	
	public Patterns pop() {
		Patterns temp = top;
		top = stack.pop();
		if(top == null) { System.out.println("top is null");}
		else if (temp == null) { System.out.println("temp is null");}
		loadColor();
		return temp;
	}
	
	public JPanel getJPanel() {
		return panel;
	}
}
