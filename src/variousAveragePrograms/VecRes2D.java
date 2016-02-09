import java.io.IOException;
import java.util.Arrays;

public class VecRes2D {
	public static void main(String[] args) throws IOException, InterruptedException{
		//X values
		double[][] VecComps;
		double[] VeN;
		//Number of vectors
		int size, eachSize;
		
		do{
			System.out.println("Enter a whole number less than 10 to be the number of vectors.");
			size=getWholeNumber();
		}while(size>10 || size<0);
		
		do{
			System.out.println("Enter a whole number less than 10 to be the size of each vector.");
			eachSize=getWholeNumber();
		}while(eachSize>10 || eachSize<0);
		
		VecComps=new double[size][eachSize];
		VeN=new double[eachSize];
		
		for(int i = 0; i < size; i++){
			VeN[i]=0;
			for(int j = 0; j < eachSize; j++){
				VeN[i]+=VecComps[i][j];
			}
		}
		
		for(int i = 0; i < size; i++){
			System.out.println("Vector "+(i+1)+":");
			for(int j = 0; j < eachSize; j++){
				System.out.print("\tValue "+(j+1)+": ");
				VecComps[i][j]=getWholeNumber();
				VeN[j]+=VecComps[i][j];
			}
		}
		System.out.println(Arrays.toString(VeN));
	}
	static int getWholeNumber() throws IOException, InterruptedException{
		while(System.in.available()==0){
			Thread.sleep(100);
		}
		char[] nextLine = new char[System.in.available()];
		while(System.in.available()>0){
			nextLine[nextLine.length-System.in.available()]=(char) System.in.read();
		}
		int value=0;
		//nextLine.length-2 to ignore \r\n at end.
		for(int i = 0; i < nextLine.length-2; i++){
			if(nextLine[i]<'0'||nextLine[i]>'9'){
				throw new NumberFormatException(nextLine[i]+" is not a number.");
			}else{
				value*=10;
				value+=(int)(nextLine[i]-'0');
			}
		}
		return value;
	}
}
