package day010;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int curr = nums[0];
		int toFill = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != curr) {
				curr = nums[i];
				nums[toFill] = curr;
				toFill++;
			}
		} 
		return toFill;
	}

}
