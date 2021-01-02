package day001;

import java.util.HashMap;

public class TwoSum {

	// brute force two loops
	// Time complexity : O(n^2)
	// space complexity : O(1)
	public int[] twoSumBruteForce(int[] nums, int target) {
		// Consider all possible pairs
		// and check their sums
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	// hastable solution
	// Time complexity : O(n)
	// Space complexity : O(n)
	public int[] twoSumHashTable(int[] nums, int target) {

		// Store counts of all elements in map m
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		// Traverse through all elements
		for (int i = 0; i < nums.length; i++) {
			int rem = target - nums[i];
			if (map.containsKey(rem) && map.get(rem) != i) {
				return new int[] { i, map.get(rem) };
			}
		}

		throw new IllegalArgumentException("No two sum solution");
	}
}
