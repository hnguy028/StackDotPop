package pattern;

import java.awt.Color;

public class Yellow extends Patterns{

	public Yellow(String id, String name, Color color) {
		super(id, name, color);
	}

	@Override
	public Patterns clone(Patterns pattern) {
		return new Yellow(pattern.getPatternID(), pattern.getPatternName(), pattern.getColor());
	}
}
