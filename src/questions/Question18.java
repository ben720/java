package questions;
public class Question18{
	public void changer(String x, int y){
		x = x+"peace";
		y = y * 2;
	}
	public void test(){
		String s = "world";
		int n = 6;
		changer(s,n);
	}
}
/*
A: world, 6
The = operator does not change the original value.
*/