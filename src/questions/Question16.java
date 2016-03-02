package questions;
public class Question16{
	public static int mystery(int n){
		if(n<=1){
			return 0;
		}else{
			return 1 + mystery(n/2);
		}
	}
	public static void main(String[] meep){
		int k = 6;
		int m = 64;
		System.out.println(mystery(m));
	}
}
/*
B: returns k, in this case 6
Everything returns 1+ half of it, 1 returns 0.
So 2*1 returns 1, 2*2*1 returns 2, etc. Powers of 2, so the exponent is returned.*/