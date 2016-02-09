package questions;

interface Shape {
	public int isLargerThan(Shape other);
}

class Circle implements Shape{
	//I: No compilation error, interface satisfied. It has the required signature and access level.
	public int isLargerThan(Shape other){return 0;}
	
	//II: Does not satisfy interface. Circle is not general enough. The method must
	//be able to handle all shapes.
	//public int isLargerThan(Circle other){return 0;}
	
	//III: Does not satisfy interface. Another method must accept Shape and return an int.
	//public boolean isLargerThan(Object other){return false;}
}
//Answer: I only.