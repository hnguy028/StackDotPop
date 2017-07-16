package pattern;

import java.awt.Color;

public class Orange extends Patterns{

	public Orange(String id, String name, Color color) {
		super(id, name, color);
	}

	@Override
	public Patterns clone(Patterns pattern) {
		return new Orange(pattern.getPatternID(), pattern.getPatternName(), pattern.getColor());
	}
}
