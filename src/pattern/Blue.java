package pattern;

public class Blue extends Patterns{

	public Blue(String id, String name) {
		super(id, name);
	}

	@Override
	public Patterns clone(Patterns pattern) {
		return new Blue(pattern.getPatternID(), pattern.getPatternName());
	}
}
