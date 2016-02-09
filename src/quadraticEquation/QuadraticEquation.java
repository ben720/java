import java.util.Scanner;
import ratio.Ratio;

public class QuadraticEquation {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) throws InterruptedException{
		Ratio a,b,c;
		System.out.println("Please ensure that your equation is"+
		" in the format 0=ax^2+bx+c");

		a=readPart('a');
		b=readPart('b');
		c=readPart('c');

		System.out.println();
		
		Ratio descriminant = b.times(b).minus(a.times(c.times(4)));
		if(descriminant.equals(0)){
			System.out.println(b.times(-1).over(a.times(2)));
		}else if(descriminant.compareTo(0)==1){
			String descriminantSqrt = Double.toString(Math.sqrt(descriminant.doubleValue()));
			int digitsPastDecimal = descriminantSqrt.substring(descriminantSqrt.indexOf('.')).length();
			boolean tooLong;
			
			if(digitsPastDecimal > 10){
				tooLong=true;
			}else{
				tooLong=false;
			}
			
			if(tooLong){
				System.out.println(""+b.times(-1)+" +- sqrt("+descriminant+")");
				System.out.println("------------------");
				System.out.println(a.times(2));
				System.out.println("\nApproximate values:");
				System.out.println(b.times(-1).//-b
						plus(descriminant.sqrt()).//+sqrt(descriminant)
						over(a.times(2)));//divided by 2a
				System.out.println(b.times(-1).//-b
						minus(descriminant.sqrt()).//-sqrt(descriminant)
						over(a.times(2)));//divided by 2a
			}else{
				System.out.println(b.times(-1).//-b
						plus(descriminant.sqrt()).//+sqrt(descriminant)
						over(a.times(2)));//divided by 2a
				System.out.println(b.times(-1).//-b
						minus(descriminant.sqrt()).//-sqrt(descriminant)
						over(a.times(2)));//divided by 2a
			}
		}else{
			Ratio descriminantSqrt = descriminant.times(-1).sqrt();
			int digitsPastDecimal = descriminantSqrt.toString().substring(descriminantSqrt.toString().indexOf('.')).length();
			boolean tooLong;
			
			if(digitsPastDecimal > 10){
				tooLong=true;
			}else{
				tooLong=false;
			}
			
			if(tooLong){
				System.out.println(b.times(-1)+"+-sqrt("+descriminant+")");
				System.out.println("------------");
				System.out.println(a.times(2));
				System.out.println("\nApproximate values:");
				System.out.print(b.times(-1).//-b
						plus(descriminantSqrt).//+sqrt(descriminant)
						over(a.times(2)));//divided by 2a
				System.out.println('i');
				System.out.print(b.times(-1).//-b
						minus(descriminantSqrt).//-sqrt(descriminant)
						over(a.times(2)));//divided by 2a
				System.out.println('i');
			}else{
				System.out.print(b.times(-1).//-b
						plus(descriminantSqrt).//+sqrt(descriminant)
						over(a.times(2)));//divided by 2a
				System.out.println('i');
				System.out.print(b.times(-1).//-b
						minus(descriminantSqrt).//-sqrt(descriminant)
						over(a.times(2)));//divided by 2a
				System.out.println('i');
			}
		}
		
		System.out.println("\nContinue? <y/n>");
		if(input.nextLine().startsWith("y"))
			main(args);
	}
	public static Ratio readPart(char name) throws InterruptedException{
		while(true){
			System.out.print(name+": ");
			String inString = input.nextLine();
			if(inString.trim().equalsIgnoreCase("help")){
				System.out.println("\nAcceptable Formats:\n");
				System.out.println("7777");
				System.out.println("-7,777");
				System.out.println("7777.7777");
				System.out.println("-7777.7777");
				Thread.sleep(1000);
				System.out.println("1/7777");
				System.out.println("-1/7777");
				System.out.println("7777 1/7777");
				System.out.println("-7777 1/7777");
				Thread.sleep(1000);
				System.out.println("\nUnacceptable Formats:\n");
				System.out.println("7+3");
				System.out.println("sqrt(7)");
				System.out.println("1+3/4");
				System.out.println("1 and 3/4");
				continue;
			}
			try{
				return Ratio.create(inString);
			}catch(NumberFormatException e){
				String errorMessage = e.getMessage();
				if(errorMessage.endsWith("' cannot be interpreted as a number. Enter \"help\" for more information.")){
					System.out.println(errorMessage);
				}else{
					e.printStackTrace();
				}
			}
		}
	}

}