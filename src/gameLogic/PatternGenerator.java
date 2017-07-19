package gameLogic;

import java.util.Random;

import pattern.*;

/**
 * @author hinguyen
 *
 */
public class PatternGenerator {
	
	Random rng;
	int maxPatterns;
	
	/**
	 * Constructor
	 * @param _maxPatterns
	 */
	public PatternGenerator(int _maxPatterns) {
		maxPatterns = _maxPatterns;
		rng = new Random();
	}
	
	public Patterns nextPattern() {
		// Generate a random int between 0 and maxPatterns
		Integer id = rng.nextInt(maxPatterns);
		String patternID = id.toString();
		
		// Return a pattern depending on the random id
		switch(id) {
			case 0:
				return new Blue(patternID, "BlueOrb");
			case 1:
				return new Green(patternID, "GreenOrb");
			case 2: 
				return new Yellow(patternID, "YellowOrb");
			case 3:
				return new Red(patternID, "RedOrb");
			case 4:
				return new Orange(patternID, "OrangeOrb");
			default:
				return new NullPattern();
		}
	}
}
