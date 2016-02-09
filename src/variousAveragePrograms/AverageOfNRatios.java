import java.util.ArrayList;
import java.util.Scanner;

import ratio.Ratio;
public class AverageOfNRatios {

	public static void main(String[] args){
		ArrayList<Ratio> allRatios = new ArrayList<Ratio>();
		Scanner input = new Scanner(System.in);
		System.out.println("Meep! Enter numbers. To quit, enter 'q.'");
		String nextLine=input.nextLine();
		while(!nextLine.startsWith("q")){
			if(nextLine.trim().equalsIgnoreCase("help")){
				System.out.println("\nAcceptable Formats:\n");
				System.out.println("7777");
				System.out.println("-7,777");
				System.out.println("7777.7777");
				System.out.println("-7777.7777");
				
				System.out.println("1/7777");
				System.out.println("-1/7777");
				System.out.println("7777 1/7777");
				System.out.println("-7777 1/7777");
				
				System.out.println("\nUnacceptable Formats:\n");
				System.out.println("7+3");
				System.out.println("sqrt(7)");
				System.out.println("1+3/4");
				System.out.println("1 and 3/4");
				continue;
			}
			try{
				allRatios.add(Ratio.create(nextLine));
			}catch(NumberFormatException e){
				String errorMessage = e.getMessage();
				if(errorMessage.endsWith("' cannot be interpreted as a number.")){
					System.out.println(errorMessage);
				}else{
					e.printStackTrace();
				}
			}
			nextLine=input.nextLine();
		}
		Ratio total = Ratio.ZERO;
		for(Ratio r : allRatios){
			total=total.plus(r);
		}
		System.out.println("\nResult:");
		System.out.println(total.over(allRatios.size()));
		input.close();
	}

}
