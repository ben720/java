public class Greeting {

	static char[] freshman = { 'f', 'r', 'e', 's', 'h', 'm', 'a', 'n', };
	static char[] sophomore = { 's', 'o', 'p', 'h', 'o', 'm', 'o', 'r', 'e', };
	static char[] junior = { 'j', 'u', 'n', 'i', 'o', 'r', };
	static char[] senior = { 's', 'e', 'n', 'i', 'o', 'r', };

	public static void main(String[] args) throws java.io.IOException, InterruptedException {

		while (System.in.available() == 0) {
			Thread.sleep(100);
		}

		int howManyInLine = 0;
		char[] line = new char[System.in.available()-2];

		do {
			line[howManyInLine] = (char) System.in.read();
			howManyInLine++;
		} while (howManyInLine < line.length-2);
		
		printName(line);

		char[] St1 = { '1', '9', 'b', 'e', 'n', 'j', 'a', 'm', 'i', 'n', 's', 'i', };
		char[] St2 = { '1', '8', 'i', 'm', 'a', 'g', 'i', 'n', 'a', 'r', 'y', 'f', 'r', };
		char[] St3 = { '1', '7', 'n', 'o', 't', 'R', 'e', 'a', 'l', 's', 't', };
		
		printName(St1);
		printName(St2);
		printName(St3);
	}

	static void printName(char[] name) {

		char[] hello = { 'H', 'e', 'l', 'l', 'o', ',', ' ', };
		System.out.print(hello);
		
		switch (name[1]) {

		case '9':
			System.out.print(freshman);
			break;
		case '8':
			System.out.print(sophomore);
			break;
		case '7':
			System.out.print(junior);
			break;
		case '6':
			System.out.print(senior);
			break;

		}
		System.out.print(' ');
		System.out.print(Character.toUpperCase(name[2]));
		for (int i = 3; i < name.length - 2; i++) {
			System.out.print(name[i]);
		}
		System.out.println('!');
	}
}
