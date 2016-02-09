import ratio.Ratio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleMean {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Ratio total = Ratio.ZERO;
		List<Ratio> ratios = new ArrayList<Ratio>();
		boolean continuing=true;
		int count=0;
		
		System.out.println("Please enter a number in standard decimal format: 0.1. Or 3/4. Or 5. Or -9, 3/4. Or .954. I don't really care.");
		System.out.println("Note: this uses corrected sample - based standard deviation, because that's what Jakob seemed to be doing. ");
		
		while(continuing){
			String nextLine = input.nextLine();
			if(nextLine.startsWith("q")||nextLine.length()==0){
				continuing=false;
			}else{
				try{
					Ratio r = Ratio.create(nextLine);
					ratios.add(r);
					total=total.plus(r);
					count++;
				}catch(NumberFormatException e){
					System.err.println("Error: "+e.getMessage());
				}
			}
		}
		input.close();
		
		Ratio mean = total.over(count);
		System.out.println("Mean:");
		System.out.println(mean);
		
		System.out.println("Variances squared:");
		Ratio variance = Ratio.ZERO;
		for(Ratio r : ratios){
			variance=variance.plus(r.minus(mean).times(r.minus(mean)));
			System.out.println(r.minus(mean).times(r.minus(mean)));
		}
		System.out.println("Sum of (Variances squared):");
		System.out.println(variance);
		System.out.println("Number of Numbers - 1:");
		System.out.println(count-1);
		variance=variance.over(count-1);
		System.out.println("Standard Deviation: ");
		System.out.println("sqrt("+variance+")");
		variance=variance.sqrt();
		System.out.println(variance);
	}

}
