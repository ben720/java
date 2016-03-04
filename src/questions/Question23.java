package questions;
public class Question23{
	public static int[] shuffle(int[] names){
		int n = nums.length;
		int[] result = new int[n];
		
		for(int j = 0; j < n / 2; j++){
			result[j*2]=nums[j];
			result[j*2+1] = nums[j+ n/2];
		}
		
		return result;
	}
}
/*
C: The last element may not have the correct value

if n is odd, the last j*2+1 is not the last element.
*/