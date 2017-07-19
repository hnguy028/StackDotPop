package pattern;

import java.awt.Image;

/**
 * @author Hieu
 *
 * Super Class of all patterns
 */
public abstract class Patterns{

	private static final String imgDir = "resources/";
	private String patternID;
	private String patternName;
	private Image[] images;
	private int imageIndex = 0;
	//private Color color;

	/**
	 * @param _id
	 * @param name
	 * @param _color
	 */
	public Patterns(String _id, String filename) {
		patternID = _id;
		patternName = filename;
		//color = _color;
	}

	public boolean matches(Patterns pattern) {
		//return (patternID.equalsIgnoreCase(pattern.getPatternID()) && color.equals(pattern.getColor()));
		return patternName.equalsIgnoreCase(pattern.getPatternName());
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
	
	public Image getNextImage() {
		if(images[0] != null) {
			int returnIndex = imageIndex;
			imageIndex = (imageIndex + 1) % images.length;
			return images[returnIndex];
		}
		return null;
	}

	// All child classes must override this method
	abstract Patterns clone(Patterns pattern);
}
