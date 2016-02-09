import java.util.Scanner;

import ratio.Ratio;
public class AverageOf3Vectors {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.println("How many numbers in each vector?");
		int numInEachVector = Integer.parseInt(input.nextLine());
		
		Ratio[] vector1 = new Ratio[numInEachVector];
		Ratio[] vector2 = new Ratio[numInEachVector];
		Ratio[] vector3 = new Ratio[numInEachVector];
		
		System.out.println("Vector 1: ");
		
		for(int i = 1; i <= numInEachVector; i++){
			System.out.print("\tValue "+i+": ");
			vector1[i-1]=Ratio.create(input.nextLine());
			System.out.println();
		}
		
		System.out.println("Vector 2: ");
		
		for(int i = 1; i <= numInEachVector; i++){
			System.out.print("\tValue "+i+": ");
			vector2[i-1]=Ratio.create(input.nextLine());
			System.out.println();
		}
		
		System.out.println("Vector 3: ");
		
		for(int i = 1; i <= numInEachVector; i++){
			System.out.print("\tValue "+i+": ");
			vector3[i-1]=Ratio.create(input.nextLine());
			System.out.println();
		}
		
		System.out.println("Average Vector:");
		for(int i = 1; i <= numInEachVector; i++){
			System.out.print("\tValue "+i+": ");
			System.out.println(vector1[i-1].plus(vector2[i-1]).plus(vector3[i-1]).over(3));
		}
		input.close();
	}
}
