package gameLogic;

/**
 * @author hinguyen
 *
 *	TODO : may not be needed
 */
public enum CardinalLocation {
	NORTH_WEST, NORTH, NORTH_EAST, WEST, 
	CENTER, EAST, SOUTH_WEST, SOUTH, SOUTH_EAST;
	
	private static CardinalLocation[] enumTypes = values();
	
	// Increment the enum to next value as defined above
	public CardinalLocation next() {
		return enumTypes[(this.ordinal()+1) % enumTypes.length];
	}

	// Decrement the enum to next value as defined above
	public CardinalLocation previous() {
		return enumTypes[(this.ordinal()-1) % enumTypes.length];
	}
}
