package pattern;

public class Green extends Patterns{

	public Green(String id, String name) {
		super(id, name);
	}

	@Override
	public Patterns clone(Patterns pattern) {
		return new Green(pattern.getPatternID(), pattern.getPatternName());
	}
}
