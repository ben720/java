package questions;
public class Question13{
	private int[] numbers = {1,-54,123,32767,-32768};
	public int mystery(int num){
		for(int k = numbers.length - 1; k >=0; k--){
			if(numbers[k] < num){
				return k;
			}
		}
		return -1;
	}
}
//C: All values in positions m+1 through numbers.length-1 are greater or equal to n
//where int m = mystery(n);
//If something is not greater than or equal to n, the method returns.