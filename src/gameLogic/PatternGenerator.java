package gameLogic;

import java.util.Random;

import definitions.Variables;
import pattern.*;

/**
 * @author hinguyen
 *
 * This class generates random patterns
 */
public class PatternGenerator {
	
	Random rng;
	int maxPatterns = Variables.maxPatterns;
	
	/**
	 * Constructor
	 * @param _maxPatterns
	 */
	public PatternGenerator() {
		// initialize random number generator
		rng = new Random();
	}
	
	public Patterns nextPattern() {
		// Generate a random integer between 0 (inclusive) and maxPatterns (exclusive)
		Integer id = rng.nextInt(maxPatterns);
		// Set pattern id as the generated integer
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
