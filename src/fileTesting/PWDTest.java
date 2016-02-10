package fileTesting;
import java.io.*;
public class PWDTest{
	public static void main(String[] args) throws IOException{
		//Throws, this is a simple test. Any exception should be traced.
		File pwd = new File(".");
		System.out.println(pwd.getCanonicalPath());
		File image = new File("./resources/images/pictureLabCopied/beach.jpg");
		System.out.println(image.getCanonicalPath());
	}
}