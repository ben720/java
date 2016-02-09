package questions;

public class Question1{
	public static void main(String[] args){
		for(int k = 0; k < 20; k = k + 2){
			if(k%3==1){
				System.out.print(k + " ");
			}
		}
	}
}
/*
Start program: k=0

k=0:  k%3=0, do nothing
k=2:  k%3=2, do nothing
k=4:  k%3=1, print 4+" "     Total output is now "4 "
k=6:  k%3=0, do nothing
k=8:  k%3=2, do nothing
k=10: k%3=1, print 10+" "    Total output is now "4 10 "
k=12: k%3=0, do nothing
k=14: k%3=2, do nothing
k=16: k%3=1, print 16+" "    Total output is now "4 10 16 "
k=18: k%3=0, do nothing
k=20: k is not less than 20. Exit loop.

Result: "4 10 16 "

Question asks: "What is printed as a result of executing the code segment?"
			(A) 4 16 
THIS ONE -->(B) 4 10 16
			(C) 0 6 12 18
			(D) 1 4 7 10 13 16 19
			(E) 0 2 4 6 8 10 12 14 16 18 
			
Testing confirms.
*/