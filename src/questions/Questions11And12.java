package questions;

public class Questions11And12{
	private int[] nums;
	public int findLongest(int target){
		int lenCount = 0;
		int maxLen = 0;
		
		for(int val : nums){
			if(val == target){
				lenCount++;
			}else{
				if(lenCount > maxLen){
					maxLen = lenCount;
				}
			}
		}
		if(lenCount > maxLen){
			maxLen = lenCount;
		}
		return maxLen;
	}
}
/*
Question 11: What does findLongest return?
            A: It is the length of the shortest consecutive block of the value target in nums.
		    B: It is the length of the array nums.
THIS ONE -->C: It is the number of occurrences of target in nums.
		    D: It is the length of the first consecutive block of the value target in nums.
		    E: It is the length of the last consecutive block of the value target in nums.
The method works perfectly except that the length of the current block is never set back to 0.

Question 12: How should it be changed by adding lenCount=0?
            A: between lines 9 and 10
			B: between 12 and 13
			C: between 13 and 14
			D: between 14 and 15
THIS ONE -->E: between 15 and 16
AFTER max is set if necessary, the block is reset.
*/