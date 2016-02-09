package questions;
import java.util.*;

public class Question3{
	
	//Test solution
	public static void main(String[] args){
		//Establish precondition
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.addAll(Arrays.asList(new Integer[]{0,0,4,2,5,0,3,0}));
		//Finished establishing precondition
		//Evaluate
		mystery(numbers);
		//Test value
		System.out.println(numbers); // Prints [0, 4, 2, 5, 3]
	}
	public static void mystery(List<Integer> nums){
		for(int k = 0; k < nums.size(); k++){
			if(nums.get(k).intValue()==0){
				nums.remove(k);
			}
		}
	}
}
/*
Precondition:
0 0 4 2 5 0 3 0
k=0: Remove 0
0 4 2 5 0 3 0
k=1: Element.intValue()==4, don't remove
...
k=4: Remove 0 
0 4 2 5 3 0
k=5: Remove 0
0 4 2 5 3
k=6: 6 < nums.size() evaluates to false; size is 5

Final value: [0,4,2,5,3]

			A [0,0,4,2,5,0,3,0]
			B [4,2,5,3]
			C [0,0,0,0,4,2,5,3]
THIS ONE-->	D [0,4,2,5,3] 						
			E ArrayIndexOutOfBoundsException
*/