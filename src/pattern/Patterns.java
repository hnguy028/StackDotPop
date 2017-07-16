package pattern;

import java.awt.Color;

/**
 * @author Hieu
 *
 * Super Class of all patterns
 */
public abstract class Patterns{

	private String patternID;
	private String patternName;
	private Color color;

	/**
	 * @param _id
	 * @param name
	 * @param _color
	 */
	public Patterns(String _id, String name, Color _color) {
		patternID = _id;
		patternName = name;
		color = _color;
	}
	
	public String getPatternID() {
		return patternID;
	}
	
	public String getPatternName() {
		return patternName;
	}
	
	public Color getColor() {
		return color;
	}

	public boolean matches(Patterns pattern) {
		//return (patternID.equalsIgnoreCase(pattern.getPatternID()) && color.equals(pattern.getColor()));
		return patternName.equalsIgnoreCase(pattern.getPatternName());
	}

	// All child classes must override this method
	abstract Patterns clone(Patterns pattern);
}
