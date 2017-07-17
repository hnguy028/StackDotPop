package gameLogic;

public enum CardinalLocation {
	NORTH_WEST, NORTH, NORTH_EAST, WEST, 
	CENTER, EAST, SOUTH_WEST, SOUTH, SOUTH_EAST;
	
	private static CardinalLocation[] enumTypes = values();
	
	public CardinalLocation next() {
		return enumTypes[(this.ordinal()+1) % enumTypes.length];
	}
}
