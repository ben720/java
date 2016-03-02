package questions;
public class Question14{
	public void mystery(int x){
		System.out.print(x%10);
		if ((x/10) != 0){
			mystery(x/10);
		}
		System.out.print(x%10);
	}
	public static void main(String[] meep){
		mystery(1234);
	}
}
//D: 43211234
//The first print is to print 1234%10, which is 4, so it must start with 4.
//The last print is 1234%10, so it must end in 4. D is the only possibility.