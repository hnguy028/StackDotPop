package pattern;

import java.awt.Color;

public class Blue extends Patterns{

	public Blue(String id, String name, Color color) {
		super(id, name, color);
	}

	@Override
	public Patterns clone(Patterns pattern) {
		return new Blue(pattern.getPatternID(), pattern.getPatternName(), pattern.getColor());
	}
}
