package questions;

public class Question10{
	private static int[] arr = new int[]{-1000,0,2,3,4,1000};
	public static void main(String[] args){
		System.out.println(mystery(0,arr.length-1, -5));
	}
	public static int mystery(int low, int high, int num){
		int mid = (low+high)/2;
		if(low>high){
			return low;
		}else if(arr[mid] < num){
			return mystery(mid + 1, high, num);
		}else if(arr[mid] > num){
			return mystery(low,mid-1, num);
		}else{//arr[mid]==num
			return mid;
		}
	}
}