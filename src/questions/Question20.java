package questions;
public class Question20{
	public static void doSome(int[] arr, int lim){
		int v = 0;
		int k = 0;
		while( k < arr.length && arr[k] < lim){
			if(arr[k] > v){
				v = arr[k]; /*Statement S */
			}
			k++; /*Statement T */
		}
	}
}
/*
B: II only
I cannot be true; there are not 5 positive integers less than 5
III cannot be true; statement S cannot be executed more than statement T
*/