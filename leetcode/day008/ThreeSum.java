package day008;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int start = i + 1, end = nums.length - 1;
				while (start < end) {
					int sum = nums[i] + nums[start] + nums[end];
					if (sum == 0) {
						List<Integer> triplets = new LinkedList<>();
						triplets.add(nums[i]);
						triplets.add(nums[start]);
						triplets.add(nums[end]);
						result.add(triplets);
						int startVal = nums[start];
						int endVal = nums[end];
						while (start < end && startVal == nums[start]) {
							start++;
						}
						while (end > start && endVal == nums[end]) {
							end--;
						}
					} else if (sum < 0) {
						start++;
					} else {
						end--;
					}
				}
			}
		}

		return result;
	}

	
	public static void main(String[] args) {
		ThreeSum obj = new ThreeSum();
		System.out.println(obj.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
	}
}
