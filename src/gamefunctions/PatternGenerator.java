package gamefunctions;

import java.awt.Color;
import java.util.Random;

import pattern.*;

public class PatternGenerator {
	
	Random rng;
	int maxPatterns;
	
	public PatternGenerator(int _maxPatterns) {
		maxPatterns = _maxPatterns;
		rng = new Random();
	}
	
	public Patterns nextPattern() {
		Integer id = rng.nextInt(maxPatterns);
		String patternID = id.toString();
		
		switch(id) {
			case 0:
				return new Blue(patternID, "Blue", Color.BLUE);
			case 1:
				return new Green(patternID, "Green", Color.GREEN);
			case 2: 
				return new Yellow(patternID, "Yellow", Color.YELLOW);
			case 3:
				return new Red(patternID, "Red", Color.RED);
			case 4:
				return new Orange(patternID, "Orange", Color.ORANGE);
			default:
				// Error
				return null;
		}
	}
}
