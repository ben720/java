public class GreetingWithStrings {

	public static void main(String[] args){
		java.util.Scanner in = new java.util.Scanner(System.in);
		System.out.println("Please enter your login (e.g. 19benjaminsi):");
		String login = in.nextLine();
		do{
			printName(login);
			login = in.nextLine();
		}while(!login.equals(""));
		in.close();
	}
	static void printName(String login){
		switch(login.substring(0,2)){
		case "19":
			System.out.print("Hello, freshman ");
			break;
		case "18":
			System.out.print("Hello, sophomore ");
			break;
		case "17":
			System.out.print("Hello, junior ");
			break;
		case "16":
			System.out.print("Hello, senior ");
			break;
		default:
			throw new IllegalArgumentException("I hate you.");
		}
		System.out.print(login.substring(2,3).toUpperCase()+login.substring(3,login.length()-2));
		System.out.println('!');
	}
}