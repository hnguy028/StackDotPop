package pattern;

import java.awt.Color;

public class Green extends Patterns{

	public Green(String id, String name, Color color) {
		super(id, name, color);
	}

	@Override
	public Patterns clone(Patterns pattern) {
		return new Green(pattern.getPatternID(), pattern.getPatternName(), pattern.getColor());
	}
}
