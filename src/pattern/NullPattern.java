package pattern;

public class NullPattern extends Patterns{

	public NullPattern() {
		super("null", "null");
	}

	@Override
	public Patterns clone(Patterns pattern) {
		return new Green(pattern.getPatternID(), pattern.getPatternName());
	}
}
