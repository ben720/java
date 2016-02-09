package questions;

public class Question4{
	public static void main(String[] args){
		//Precondition setup
		int score = 94; 
		String grade="";
		//I 
		if(score>=93)
			grade="A";
		if(score>=84 && score<=92)
			grade="B";
		if(score>=75 && score<=83)
			grade="C";
		if(score<75)
			grade="F";
		//II
		/* THIS ONE CAUSES COMPILATION ERROR
		...
		if(84<=score<=92)
		...
	    Causes compilation problem: 84<=score returns a boolean, which
		can't be compared to 92.
		*/
		//The only answer that has I work but not II is (D). Therefore, (D) is correct.
		//See result, which is A in this case
		System.out.println(grade);
	}
}
/*
Question:

int score:		Grade
93 or above		A 
84-92 inclusive B 
75-83 inclusive C 
below 75 		F 

Answer:
			(A) II only
			(B) III only 
			(C) I and II only
THIS ONE -->(D) I and III only
			(E) I, II, III
*/