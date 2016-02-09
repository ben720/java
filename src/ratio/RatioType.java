package ratio;

public abstract class RatioType extends Number implements Cloneable, Comparable<Number> {

	private static final long serialVersionUID = 7667580429881151269L;

	protected final int den, num;
	protected Type type;

	protected RatioType(int den, int num) {
		this.den = den;
		this.num = num;
	}

	public abstract int intValue();

	public abstract long longValue();

	public abstract double doubleValue();

	public abstract float floatValue();

	public abstract byte byteValue();

	public abstract short shortValue();

	public static class Type {
		public static final Type MIXED_NUMBER = new Type(0);
		public static final Type INTEGER = new Type(1);
		public static final Type FRACTION = new Type(2);
		public static final Type DECIMAL = new Type(3);
		public static final Type DOUBLE = new Type(4);

		public final int priority;

		Type(int priority) {
			this.priority = priority;
		}
	}
}
