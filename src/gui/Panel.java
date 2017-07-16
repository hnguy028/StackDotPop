package gui;

import javax.swing.JPanel;

import pattern.Patterns;

public class Panel {
	JPanel panel;
	Patterns pattern;
	CardinalLocation location;
	
	public Panel(CardinalLocation _location, Patterns _pattern) {
		panel = new JPanel();
		panel.setBackground(_pattern.getColor());
		location = _location;
		pattern = _pattern;
	}
	
	public boolean patternMatches(Patterns _pattern) {
		return pattern.matches(_pattern);
	}
	
	public JPanel getJPanel() {
		return panel;
	}
	
	public Patterns getPattern() {
		return pattern;
	}
}
