package questions;
public class Question25{
	public static void sort(int[] elements){
		for(int j = 0; j < elements.length - 1; j++){
			int index=j
			
			for(int k = j+1; k < elements.length; k++){
				if(elements[k] < elements[index]){
					index=k;
				}
			}
			int temp = elements[j];
			elements[j]=elements[index];
			elements[index] = temp;
		}
	}
}
/*
How to make it sort in descending order?
D: I, III
I switches < to > in elements[k] < elements[index]
This is the only way the program knows which is before which, so everything necessary has been changed.
III goes through the elements in reverse order, so it's ascending in reverse, which is descending.