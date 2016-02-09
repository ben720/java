package ratio;

import java.text.DecimalFormat;

public class Ratio extends Number implements Comparable<Number>, Cloneable {

	private static final long serialVersionUID = -1527842096998899438L;

	private final long num;
	private final long den;

	private RatioType.Type type;

	public enum WhenToReduce {
		NONE, ALL, ON_CREATE, ON_OPERATE;
	}

	public final static RatioType.Type MIXED_NUMBER = RatioType.Type.MIXED_NUMBER;
	public final static RatioType.Type INTEGER = RatioType.Type.INTEGER;
	public final static RatioType.Type FRACTION = RatioType.Type.FRACTION;
	public final static RatioType.Type DECIMAL = RatioType.Type.DECIMAL;
	public final static RatioType.Type DOUBLE = RatioType.Type.DOUBLE;

	public final static WhenToReduce NONE = WhenToReduce.NONE;
	public final static WhenToReduce ALL = WhenToReduce.ALL;
	public final static WhenToReduce ON_CREATE = WhenToReduce.ON_CREATE;
	public final static WhenToReduce ON_OPERATE = WhenToReduce.ON_OPERATE;

	public static WhenToReduce whenToReduce = WhenToReduce.ALL;

	public final static Ratio ZERO = new Ratio(0, 1);
	public final static Ratio ONE = new Ratio(1, 1);

	/**
	 * Creates a ratio with given numerator and denominator as long values. If
	 * the given denominator is 1, the type is an integer, otherwise, it's a
	 * fraction.
	 * 
	 * @param numerator
	 *            The numerator of the fraction.
	 * @param denominator
	 *            The denominator of the fraction.
	 */
	public Ratio(long numerator, long denominator) {
		this.num = numerator;
		this.den = denominator;
		this.type = den == 1 ? INTEGER : FRACTION;
	}

	/**
	 * Creates a ratio with given numerator and denominator as long values, and
	 * a given type. If the type is integer, it will change the given numerator
	 * and denominator.
	 * 
	 * @param numerator
	 *            The numerator of the fraction.
	 * @param denominator
	 *            The denominator of the fraction.
	 * @param type
	 *            The type of the fraction.
	 */
	public Ratio(long numerator, long denominator, RatioType.Type type) {
		this.type = type;
		if (type == INTEGER && denominator != 1) {
			numerator /= denominator;
			denominator = 1;
		}
		this.num = numerator;
		this.den = denominator;
	}

	/**
	 * Clones the ratio. All fields are conserved.
	 * 
	 * @return The new ratio.
	 */
	public Ratio clone() {
		return new Ratio(num, den, type);
	}

	/**
	 * Creates a ratio from a given double value and a given type.
	 * 
	 * @param value
	 *            The value of the fraction.
	 * @param type
	 *            The type of the fraction.
	 */
	public Ratio(double value, RatioType.Type type) {
		long part1 = (long) Math.floor(value);
		String fractionalPartString = Double.toString(value - part1);
		String part2String = fractionalPartString.substring(fractionalPartString.indexOf('.') + 1);
		long part2 = Long.parseLong(part2String);
		long denominator = (long) Math.pow(10, Math.ceil(Math.log10(part2)));
		long numerator = part1 * denominator + part2 * (part1 < 0 ? -1 : 1);
		this.num = numerator;
		this.den = denominator;
		this.type = type;
	}

	/**
	 * Creates a ratio from a given double value. Guesses type: If it's
	 * divisible by one, it's an integer, otherwise, it's a double.
	 * 
	 * @param d
	 *            The value of the fraction.
	 */
	public Ratio(double d) {
		long part1 = (long) Math.floor(d);
		if (part1 == d) {
			this.num = part1;
			this.den = 1;
			this.type = INTEGER;
			return;
		}
		String fractionalPartString = Double.toString(d - part1);
		String part2String = fractionalPartString.substring(fractionalPartString.indexOf('.') + 1);
		long part2 = Long.parseLong(part2String);
		long denominator = (long) Math.pow(10, Math.ceil(Math.log10(part2)));
		long numerator = part1 * denominator + part2 * (part1 < 0 ? -1 : 1);
		this.num = numerator;
		this.den = denominator;
		this.type = den == 1 ? INTEGER : DOUBLE;
	}

	private static int gcf(double a, double b) {
		return (int) (b == 0 ? a : gcf(b, a % b));
	}

	/**
	 * Reduces the ratio.
	 * 
	 * @return The reduced fraction.
	 */
	public Ratio reduce() {
		if (num == 0) {
			return Ratio.ZERO;
		}
		if (den == 0) {
			throw new ArithmeticException("This fraction has a denominator of 0.");
		}
		int gcf = gcf(num, den);
		int whetherNegative = den < 0 ? -1 : 1;
		return new Ratio(num / gcf * whetherNegative, den / gcf * whetherNegative, type);
	}

	public static Ratio create(double numerator, double denominator) {
		if (denominator == (long) denominator && numerator == (long) numerator) {
			return new Ratio((long) numerator, (long) denominator);
		}
		boolean numeratorIsInteger = false, denominatorIsInteger = false;
		if (Math.abs(numerator - Math.round(numerator)) < 0.001) {
			numerator = Math.round(numerator);
			numeratorIsInteger = true;
		}
		if (Math.abs(denominator - Math.round(denominator)) < 0.001) {
			denominator = Math.round(denominator);
			denominatorIsInteger = true;
		}
		if (numeratorIsInteger && denominatorIsInteger) {
			Ratio technicalAnswer = new Ratio((long) numerator, (long) denominator);
			switch (Ratio.whenToReduce) {
			case ALL:
			case ON_CREATE:
				return technicalAnswer.reduce();
			default:
				return technicalAnswer;
			}
		}
		return new Ratio(numerator / denominator);

	}

	/**
	 * Parses a string into a ratio.If the static field WHEN_TO_REDUCE is set to
	 * ALL or ON_CREATE, the returned fraction is reduced.
	 * 
	 * @param input
	 *            The string to be deciphered.
	 * @return The created ratio
	 */
	public static Ratio create(String input) {
		Ratio output;
		input = input.replaceAll(",", "");
		if (input.charAt(0) == '.') {
			input = "0" + input;
		}
		if (input.matches("-?\\d+\\.\\d+") && input.length() > 0) {// Decimal of
																	// format
																	// xxx.yyy
			long part1 = Long.parseLong(input.substring(0, input.indexOf('.')));
			String part2String = input.substring(input.indexOf('.') + 1);
			long part2 = Long.parseLong(part2String);
			long denominator = (long) Math.pow(10, part2String.length());
			long numerator = part1 * denominator + part2 * (part1 < 0 ? -1 : 1);
			output = new Ratio(numerator, denominator, DECIMAL);
		} else if (input.matches("-?\\d+")) {// Long of format xxx
			output = new Ratio(Long.parseLong(input), 1, INTEGER);
		} else if (input.matches("-?\\d+/\\d+.*")) {// Fraction of format 3/9
			output = new Ratio(Long.parseLong(input.substring(0, input.indexOf('/'))),
					Long.parseLong(input.substring(input.indexOf('/') + 1)));
		} else if (input.matches("-?\\d+ \\d+/\\d+.*")) {// Fraction of format 1
															// 3/4
			long den = Long.parseLong(input.substring(input.indexOf('/') + 1));
			output = new Ratio(
					Long.parseLong(input.substring(0, input.indexOf(' '))) * den
							+ Long.parseLong(input.substring(input.indexOf(' ') + 1, input.indexOf('/'))),
					den, MIXED_NUMBER);
		} else {
			throw new NumberFormatException("'" + input + "' cannot be interpreted as a number.");
		}
		switch (whenToReduce) {
		case ALL:
		case ON_CREATE:
			return output.reduce();
		default:
			return output;
		}
	}

	/**
	 * Parses a string into a ratio. Choose whether or not to reduce. Note that
	 * if the static field WHEN_TO_REDUCE is ALL or ON_CREATE, this is ignored.
	 * 
	 * @param input
	 *            String to be parsed
	 * @param reduced
	 *            Set whether or not to reduce. Note that if WHEN_TO_REDUCE is
	 *            ALL or ON_CREATE, this is ignored.
	 * @return
	 */
	public static Ratio create(String input, boolean reduced) {
		Ratio toReturn = create(input);
		if (reduced) {
			toReturn.reduce();
		}
		return toReturn;
	}

	/**
	 * Shows this ratio as a string.
	 * 
	 * @return Human-readable format for this ratio. Shows:
	 *         <ul>
	 *         <li>Ratios of type MIXED_NUMBER as -2 1/2 when numerator is -5
	 *         and denominator is 2.</li>
	 *         <li>Ratios of type INTEGER as their value. If the ratio does not
	 *         have a denominator of 1, the returned value is the quotient of
	 *         the numerator and the denominator cast to a long.</li>
	 *         <li>FRACTION: 7/4 where 7 is numerator and 4 is denominator</li>
	 *         <li>DECIMAL: 0.3333333333333333. Performs double calculation to
	 *         16 digits.</li>
	 *         <li>DOUBLE: Prints the quotient as a double</li>
	 *         </ul>
	 */
	public String toString() {
		return showAs(type);
	}

	/**
	 * Returns toString() with a predetermined type. Not that this does not
	 * change the type of the ratio, merely reads it as the given type.
	 * 
	 * @param type
	 *            Type to show as.
	 * @return Human-readable string of type type.
	 */
	public String showAs(RatioType.Type type) {
		// TODO: interpret Decimals with more accuracy.
		if (type == MIXED_NUMBER) {
			return num / den + " " + (num % den) + "/" + den;
		} else if (type == INTEGER) {
			return Long.toString(num / den);
		} else if (type == FRACTION) {
			return num + "/" + den;
		} else if (type == DECIMAL) {
			return new DecimalFormat("0.################").format((double) num / (double) den);
		} else if (type == DOUBLE) {
			return Double.toString((double) num / (double) den);
		} else {
			throw new IllegalStateException("This Ratio does not have a recognized type.");
		}
	}

	/**
	 * Creates a new ratio with the same value of type type.
	 * 
	 * @param type
	 *            The new type
	 * @return The new Ratio.
	 */
	public Ratio as(RatioType.Type type) {
		Ratio r = clone();
		r.type = type;
		return r;
	}

	/**
	 * Sets the type of this to type, and returns this.
	 * 
	 * @param type
	 * @return this
	 */
	public Ratio thisAsA(RatioType.Type type) {
		this.type = type;
		return this;
	}

	/**
	 * Multiply this by a java.lang.Number object. Ratios will be calculated
	 * exactly, but non-integer returning numbers will not be exact. Uses the
	 * doubleValue() and the intValue() methods of the Number.
	 * 
	 * @param n
	 *            Other factor
	 * @return Product, as a Ratio.
	 */
	public Ratio times(Number n) {
		if (n instanceof Ratio) {
			Ratio other = (Ratio) n;
			Ratio product = new Ratio(num * other.num, den * other.den, DOUBLE);
			// Double is a placeholder, since an INTEGER being created
			// has its numerator and denominator fitted to integer type.
			product.type = guessTypeAgainst(type, other.type, product.intValue(), product.doubleValue());
			switch (whenToReduce) {
			case ALL:
			case ON_OPERATE:
				return product.reduce();
			default:
				if (product.type == INTEGER && product.den != 1) {
					product = product.reduce();
				}
				return product;
			}
		}
		if (n.intValue() == n.doubleValue()) {
			return times(new Ratio(n.intValue()));
		}
		return times(new Ratio(n.doubleValue(), DOUBLE));

	}

	private static RatioType.Type guessTypeAgainst(RatioType.Type type1, RatioType.Type type2, int intValue,
			double doubleValue) {
		if (compareTypes(type1, type2).priority < 2) {
			if (intValue == doubleValue) {
				return INTEGER;
			}
			return FRACTION;
		}
		if (intValue == doubleValue) {
			return INTEGER;
		}
		return compareTypes(type1, type2);
	}

	/**
	 * times() reciprocal of n. If n is a Ratio, exact calculation. Otherwise, 1
	 * over the doubleValue() property of n is used.
	 * 
	 * @param n
	 *            Dividend
	 * @return Quotient
	 */
	public Ratio dividedBy(Number n) {
		Ratio technicalAnswer;
		if (n instanceof Ratio) {
			Ratio other = (Ratio) n;
			technicalAnswer = times(new Ratio(other.den, other.num));
		} else {
			if (n.intValue() == n.doubleValue()) {
				technicalAnswer = times(new Ratio(1, n.intValue()));
			} else {
				technicalAnswer = times(1.0d / n.doubleValue());
			}
		}
		switch (whenToReduce) {
		case ALL:
		case ON_OPERATE:
			return technicalAnswer.reduce();
		default:
			return technicalAnswer;
		}
	}

	/**
	 * Alias for dividedBy.
	 * 
	 * @param n
	 *            java.lang.Number Dividend
	 * @return Ratio Quotient
	 */
	public Ratio over(Number n) {
		return dividedBy(n);
	}

	/**
	 * Add to Number n. If n is not a Ratio, a ratio is created out of its
	 * doubleValue().
	 * 
	 * @param n
	 *            Number to be added to
	 * @return Sum, as a Ratio
	 */
	public Ratio plus(Number n) {
		if (n instanceof Ratio) {
			Ratio other = (Ratio) n;
			Ratio technicalAnswer = new Ratio(num * other.den + other.num * den, other.den * den,
					compareTypes(type, other.type));
			switch (whenToReduce) {
			case ALL:
			case ON_OPERATE:
				return technicalAnswer.reduce();
			default:
				return technicalAnswer;
			}
		}
		return plus(new Ratio(n.doubleValue()));
	}

	/**
	 * If Ratio: return plus(other.times(-1)) Otherwise: return plus(other*-1)
	 * 
	 * @param n
	 * @return
	 */
	public Ratio minus(Number n) {
		if (n instanceof Ratio) {
			Ratio other = (Ratio) n;
			Ratio technicalAnswer = plus(other.times(-1));
			switch (whenToReduce) {
			case ALL:
			case ON_OPERATE:
				return technicalAnswer.reduce();
			default:
				return technicalAnswer;
			}
		}
		return plus(n.doubleValue() * -1);
	}

	/**
	 * Alias for RatioMath.pow(this, new Ratio(1,2))
	 * 
	 * @return sqrt, as a ratio.
	 */
	public Ratio sqrt() {
		return RatioMath.pow(this, new Ratio(1, 2));
	}

	/**
	 * Reciprocal of this number. If this is an INTEGER, type is switched to
	 * FRACTION, otherwise type is conserved.
	 * 
	 * @return Ratio reciprocal
	 */
	public Ratio reciprocal() {
		return new Ratio(den, num, type == INTEGER ? FRACTION : type);
	}

	/**
	 * More information on this Ratio.
	 * 
	 * @return toString(), numerator+"/"+denominator, and type priority on
	 *         different lines.
	 */
	public String dump() {
		return toString() + "\n" + num + "/" + den + "\n" + type.priority;
	}

	/**
	 * Compares this to another java.lang.Number.
	 * 
	 * @return If this is greater, 1, equal, 0, less, -1.
	 */
	public int compareTo(Number that) {
		double doubleValue = doubleValue();
		double thatDoubleValue = that.doubleValue();
		if (doubleValue > thatDoubleValue) {
			return 1;
		} else if (doubleValue == thatDoubleValue) {
			return 0;
		} else {
			return -1;
		}
	}

	/**
	 * Checks for doubleValue() equality to java.lang.Number, otherwise returns
	 * false.
	 * 
	 * @return boolean representing equality
	 */
	public boolean equals(Object anObject) {
		if (anObject instanceof Number) {
			if (doubleValue() == ((Number) anObject).doubleValue()) {
				return true;
			}
		}
		return false;
	}

	private static RatioType.Type compareTypes(RatioType.Type type1, RatioType.Type type2) {
		if (type1.priority > type2.priority) {
			if (type1.priority < 2) {
				return FRACTION;
			}
			return type1;
		}
		return type2;
	}

	/**
	 * Set type
	 * 
	 * @param t
	 *            type
	 */
	public void setType(RatioType.Type t) {
		type = t;
	}

	/**
	 * Returns type
	 * 
	 * @return type
	 */
	public RatioType.Type getType() {
		return type;
	}

	/**
	 * Returns numerator
	 * 
	 * @return numerator
	 * @return
	 */
	public long getNumerator() {
		return num;
	}

	/**
	 * Returns denominator
	 * 
	 * @return denominator
	 * @return
	 */
	public long getDenominator() {
		return den;
	}

	/**
	 * Returns numerator
	 * 
	 * @return numerator
	 * @return
	 */
	public long getNum() {
		return num;
	}

	/**
	 * Returns denominator
	 * 
	 * @return denominator
	 * @return
	 */
	public long getDen() {
		return den;
	}

	/**
	 * Double value
	 */
	public double doubleValue() {
		return (double) num / (double) den;
	}

	/**
	 * Long value
	 */
	public long longValue() {
		return num / den;
	}

	/**
	 * Int value
	 */
	public int intValue() {
		return ((int) num) / (int) den;
	}

	/**
	 * Short value
	 */
	public short shortValue() {
		return (short) ((short) num / (short) den);
	}

	/**
	 * Closest float value
	 */
	public float floatValue() {
		return (float) num / (float) den;
	}
}