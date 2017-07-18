package gameLogic;

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
				return new Blue(patternID, "BlueOrb.png");
			case 1:
				return new Green(patternID, "GreenOrb.png");
			case 2: 
				return new Yellow(patternID, "YellowOrb.png");
			case 3:
				return new Red(patternID, "RedOrb.png");
			case 4:
				return new Orange(patternID, "OrangeOrb.png");
			default:
				return new NullPattern();
		}
	}
}
