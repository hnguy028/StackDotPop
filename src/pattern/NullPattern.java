package pattern;

import java.awt.Color;

public class NullPattern extends Patterns{

	public NullPattern() {
		super("null", "null", new Color(0,0,0,0));
	}

	@Override
	public Patterns clone(Patterns pattern) {
		return new Green(pattern.getPatternID(), pattern.getPatternName(), pattern.getColor());
	}
}
