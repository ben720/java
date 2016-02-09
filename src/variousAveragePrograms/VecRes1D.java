import java.io.IOException;
import java.util.Arrays;

public class VecRes1D {
	public static void main(String[] args) throws IOException, InterruptedException{
		//X values
		double[] VeX;
		double[] VeY;
		double[] VeN;
		//Number of vectors
		int size;
		do{
			System.out.println("Enter a whole number less than 10 to be the number of vectors.");
			while(System.in.available()==0){
				Thread.sleep(100);
			}
			char[] nextLine = new char[System.in.available()];
			while(System.in.available()>0){
				nextLine[nextLine.length-System.in.available()]=(char) System.in.read();
			}
			size=0;
			//nextLine.length-2 to ignore \r\n at end.
			for(int i = 0; i < nextLine.length-2; i++){
				if(nextLine[i]<'0'||nextLine[i]>'9'){
					throw new NumberFormatException(nextLine[i]+" is not a number.");
				}else{
					size*=10;
					size+=(int)(nextLine[i]-'0');
				}
			}
		}while(size>10 || size<0);
		
		VeX=new double[size];
		for(int i = 0; i < size; i++){
			System.out.println("Vector "+(i+1)+" X value: (whole number)");
			while(System.in.available()==0){
				Thread.sleep(100);
			}
			char[] nextLine = new char[System.in.available()];
			while(System.in.available()>0){
				nextLine[nextLine.length-System.in.available()]=(char) System.in.read();
			}
			int value=0;
			//nextLine.length-2 to ignore \r\n at end.
			for(int j = 0; j < nextLine.length-2; j++){
				if(nextLine[j]<'0'||nextLine[j]>'9'){
					throw new NumberFormatException(nextLine[i]+" is not 0-10, which it must be.");
				}else{
					value*=10;
					value+=(int)(nextLine[j]-'0');
				}
			}
			VeX[i]=value;
		}

		VeY=new double[size];
		for(int i = 0; i < size; i++){
			System.out.println("Vector "+(i+1)+" Y value: (whole number)");
			while(System.in.available()==0){
				Thread.sleep(100);
			}
			char[] nextLine = new char[System.in.available()];
			while(System.in.available()>0){
				nextLine[nextLine.length-System.in.available()]=(char) System.in.read();
			}
			int value=0;
			//nextLine.length-2 to ignore \r\n at end.
			for(int j = 0; j < nextLine.length-2; j++){
				if(nextLine[j]<'0'||nextLine[j]>'9'){
					throw new NumberFormatException(nextLine[i]+" is not 0-10, which it must be.");
				}else{
					value*=10;
					value+=(int)(nextLine[j]-'0');
				}
			}
			VeY[i]=value;
		}
		
		VeN=new double[size];
		for(int i = 0; i < size; i++){
			VeN[i]=VeX[i]+VeY[i];
		}
		System.out.println(Arrays.toString(VeN));
	}
}
