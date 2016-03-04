package questions;
public class Point{
	private int x;
	private int y;
	public Point(){
		x=0;
		y=0;
	}
	public Point(int a, int b){
		x=a;
		y=b;
	}
	//Other methods not shown
}
public class NamedPoint extends Point{
	private String name;
}
/*
D I and III only
II, which includes x=d1; throws an error from trying to access a private
instance variable.
I works because not all instance variables need be initialized.
*/