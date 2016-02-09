package questions;
import java.util.*;

public class Question2{
	public static void main(String[] args){
		//Question: What is the result of the following code?
		List<String> animals = new ArrayList<String>();
		animals.add("dog");
		//[dog]
		animals.add("cat");
		//[dog, cat]
		animals.add("snake");
		//[dog, cat, snake]
		animals.set(2, "lizard");
		//[dog, cat, lizard]
		animals.add(1, "fish");
		//[dog, fish, cat, lizard]
		animals.remove(3);
		//[dog, fish, cat]
		System.out.println(animals);
		//Prints [dog, fish, cat]
	}
}
/*
THIS ONE -->(A) [dog, fish, cat]
			(B) [dog, fish, lizard]
			(C) [dog, lizard, fish]
			(D) [fish, dog, cat]
			(E) ArrayIndexOutOfBoundsException
Confirmed by testing.
*/