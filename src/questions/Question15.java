package questions;
public class Question15{
	public static void main(String[] args){
		Dog fido = new UnderDog();
		fido.act();
	}
}
public class Dog{
	public void act(){
		System.out.print("run ");
		eat();
	}
	public void eat(){
		System.out.print("eat ");
	}
}
public class UnderDog extends Dog{
	public void act(){
		super.act();
		System.out.print("sleep ");
	}
	public void eat(){
		super.eat();
		System.out.print("bark ");
	}
}
// run eat bark sleep
/* Chain of events:
act()
	super.act()
		print run
		eat
			super.eat
			print eat
		print bark
	print sleep
*/