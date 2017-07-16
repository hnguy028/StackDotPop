package pattern;

import java.awt.Color;

public class Red extends Patterns{

	public Red(String id, String name, Color color) {
		super(id, name, color);
	}

	@Override
	public Patterns clone(Patterns pattern) {
		return new Red(pattern.getPatternID(), pattern.getPatternName(), pattern.getColor());
	}
}
