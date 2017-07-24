package pattern;

import java.awt.Image;

import definitions.Variables;

/**
 * @author Hieu
 *
 * Abstract class of all patterns
 */
public abstract class Patterns{

	// Directory containing pattern images
	private static final String imgDir = Variables.imageDirectory;
	// ID of pattern, used to compare 2 patterns
	private String patternID;
	// file name of the patter
	private String patternName;

	/**
	 * Constructor
	 * @param _id
	 * @param name
	 * @param _color
	 */
	public Patterns(String _id, String filename) {
		patternID = _id;
		patternName = filename;
	}

	/**
	 * 
	 * @param pattern
	 * @return true if given pattern id, matches this pattern's id
	 */
	public boolean matches(Patterns pattern) {
		return patternID.equalsIgnoreCase(pattern.getPatternID());
	}
	
	public String getPatternID() {
		return patternID;
	}
	
	public String getPatternName() {
		return patternName;
	}
	
	public String getFileName() {
		return imgDir + patternName + ".png";
	}
}
