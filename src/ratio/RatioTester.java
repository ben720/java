package ratio;
public class RatioTester {
	public static void main(String[] args){
		System.out.println(
			new Ratio(1).over(10).plus(new Ratio(1).over(3))
				.plus(12341234).as(RatioType.Type.INTEGER).dump()
		);
	}
}
