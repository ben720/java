import java.util.Scanner;
import ratio.Ratio;

public class AverageOfNVectors {
	public static void main(String[] args) throws InterruptedException{
		Scanner input = new Scanner(System.in);
		System.out.println("How many numbers in each vector?");
		int numInEachVector = Integer.parseInt(input.nextLine());
		System.out.println("How many vectors?");
		int numVectors = Integer.parseInt(input.nextLine());
		
		Ratio[][] vectors = new Ratio[numVectors][numInEachVector];
		
		for(int i = 0; i < numVectors; i++){
			System.out.println("Vector "+(i+1)+":");
			for(int j = 0; j < numInEachVector; j++){
				System.out.print("\tValue "+(j+1)+": ");
				try{
					vectors[i][j] = Ratio.create(input.nextLine());					
				}catch(NumberFormatException e){
					System.err.println("Invalid number. Try again.");
					Thread.sleep(50);
					j--;
				}
			}
		}

		System.out.println("\nAverage Vector:");
		for(int i = 0; i < numInEachVector; i++){
			System.out.print("\tValue "+(i+1)+": ");
			Ratio total = Ratio.ZERO;
			for(int j = 0; j < numVectors; j++){
				total=total.plus(vectors[j][i]);
			}
			Ratio average = total.over(numInEachVector);
			System.out.println(average);
		}
		input.close();
	}
}
