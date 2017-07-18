package pattern;

public class Orange extends Patterns{

	public Orange(String id, String name) {
		super(id, name);
	}

	@Override
	public Patterns clone(Patterns pattern) {
		return new Orange(pattern.getPatternID(), pattern.getPatternName());
	}
}
