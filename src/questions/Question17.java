package questions;
public class Question17{
	private int[] array;
	/**<b>Precondition:</b> array.length > 0 */
	public int checkArray(){
		int loc = array.length /2;
		for(int k = 0; k < array.length; k++){
			if(array[k] > array[loc]){
				loc=k;
			}
		}
		return loc;
	}
}
//D: Returns the index of the largest value in array. It goes through every element, and if there
//is a larger one, its index is stored in loc.