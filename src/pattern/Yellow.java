package pattern;

public class Yellow extends Patterns{

	public Yellow(String id, String name) {
		super(id, name);
	}

	@Override
	public Patterns clone(Patterns pattern) {
		return new Yellow(pattern.getPatternID(), pattern.getPatternName());
	}
}
