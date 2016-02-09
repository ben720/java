package ratio;

public final class RatioMath {
	
	public final static Ratio ZERO 			= Ratio.ZERO;
	
	public final static Ratio ONE 			= new Ratio(1);
	public final static Ratio NEGATIVE_ONE 	= new Ratio(-1);
	public final static Ratio M1 			= new Ratio(-1);
	public final static Ratio PI 			= new Ratio(Math.PI);
	public final static Ratio E  			= new Ratio(Math.E);
	
	public static Ratio pow(Ratio base, Number exponent){
		if(exponent.doubleValue()<0){
			return pow(base.reciprocal(),exponent.doubleValue()*-1);
		}
		if(exponent instanceof Ratio && ((Ratio) exponent).reduce().getDenominator()==1){
			Ratio other = (Ratio)exponent;
			Ratio total=Ratio.ONE;
			for(int i = 0; i < other.getNumerator(); i++){
				total=total.times(base);
			}
			return total;
		}
		return Ratio.create(
				Math.pow(base.getNumerator(),exponent.doubleValue()),
				Math.pow(base.getDenominator(),exponent.doubleValue())
		);
	}
	public static Ratio square(Ratio r){
		return r.times(r);
	}
	public static Ratio sqrt(Ratio r){
		return r.sqrt();
	}
	public static Ratio abs(Ratio r){
		long num = Math.abs(r.getNum());
		return new Ratio(
				num,
				r.getDen(),
				r.getType()
		);
	}
	public static Ratio sin(Ratio r){
		return new Ratio(Math.sin(r.doubleValue()));
	}
	public static Ratio cos(Ratio r){
		return new Ratio(Math.cos(r.doubleValue()));
	}
	public static Ratio tan(Ratio r){
		return new Ratio(Math.tan(r.doubleValue()));
	}
	public static Ratio asin(Ratio r){
		return new Ratio(Math.asin(r.doubleValue()));
	}
	public static Ratio acos(Ratio r){
		return new Ratio(Math.acos(r.doubleValue()));
	}
	public static Ratio atan(Ratio r){
		return new Ratio(Math.atan(r.doubleValue()));
	}
	public static Ratio ceil(Ratio r){
		return new Ratio(Math.ceil(r.doubleValue()));
	}
	public static Ratio floor(Ratio r){
		return new Ratio(Math.floor(r.doubleValue()));
	}
	public static Ratio log(Ratio r){
		return new Ratio(Math.log(r.doubleValue()));
	}
	public static Ratio log10(Ratio r){
		return new Ratio(Math.log10(r.doubleValue()));
	}
	public static Ratio max(Ratio r1, Ratio r2){
		if(r1.compareTo(r2)>0){
			return r1;
		}
		return r2;
	}
	public static Ratio min(Ratio r1, Ratio r2){
		if(r1.compareTo(r2)>0){
			return r2;
		}
		return r1;
	}
	public static Ratio toDeg(Ratio r){
		return r.times(new Ratio(180).over(PI));
	}
}
