package pattern;

public class Red extends Patterns{

	public Red(String id, String name) {
		super(id, name);
	}

	@Override
	public Patterns clone(Patterns pattern) {
		return new Red(pattern.getPatternID(), pattern.getPatternName());
	}
}
