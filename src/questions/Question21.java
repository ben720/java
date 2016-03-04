package questions;
public class Question21{
	private int[] arr;
	public int[] partialSum(){
		int[] sum = new int[arr.length];
		for(int j = 0; j < sum.length; j++){
			sum[j] = 0
		}
		/* missing code */
		return sum;
	}
}
/*
for(int j = 0; j < arr.length; j++){
	sum[j] = sum[j-1]+arr[j];
}
cannot be correct; j, which could be 0, could lead to trying to access
a negative index

Therefore, D
*/