package questions;
public class Question19{
	public static void main(String[] meep){
		int[][] mat = new int[3][4];
		for(int row=0;row<mat.length;row++){
			for(int col=0; col < mat[0].length; col++){
				if(row < col){
					mat[row][col]=1;
				}else if(row == col){
					mat[row][col]=2;
				}else{
					mat[row][col]=3;
				}
			}
		}
	}
}
/*
D:
2 1 1 1
3 2 1 1 
3 3 2 1 
int[3][4] is 3 rows, 4 columns
right is high col index, so col will be larger, so 1s
*/