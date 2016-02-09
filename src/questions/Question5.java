package questions;

public class Question5{
	public static void main(String[] args){
		//D
		for(int j = 1; j <=5; j++){
			for(int k = 5; k >=j; k--){
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}
/*
Answer: (D)
Output Explanation:
j=1
k=5, so k>=j. Output 1 
k=4, so k>=j. Output 1 1
...
k=1, so k>=j. Output 1 1 1 1 1
k=0, so k>=j is false. println.

j=2
k=5, so k>=j. This line: 2
...
k=2, so k>=j. This line: 2 2 2 2 
k=1, so k>=j is false. println

j=3

k=5, this line: 3
...
k=2, so k>=j is false. this line: 3 3 3. println.

...

Final output: 
1 1 1 1 1
2 2 2 2
3 3 3
4 4
5

*/