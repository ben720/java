import java.util.Scanner;
public class QuadraticFormula{
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) throws InterruptedException{
		double a, b, c;
		short descriminantType;//0: Positive, 1: Negative, 2: 0
		
		System.out.println("This program uses the standard quadratic form: 0 = ax^2 + bx + c. If your polynomial is not in this form, please change it now.");
		Thread.sleep(1000);
		System.out.println("Please identify a, b, and c.\nFor example, with the polynomial 3.97x^2 + x, a would be 3, b would be 1, and c would be 0.");
		Thread.sleep(1000);
		System.out.println("All numbers must be in decimal form.\n");
		
		a=readPart('a');
		b=readPart('b');
		c=readPart('c');
		
		double descriminant = b*b-4*a*c;
	}
	public static double readPart(char name) throws InterruptedException{
		while(true){
			Thread.sleep(1000);
			System.out.print(name+": ");
			try{
				return input.nextDouble();
			}catch(Exception e){
				System.out.println("This is not a valid decimal. Please try again.");
				input.nextLine();
			}
		}
	}
}