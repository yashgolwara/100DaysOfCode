package day014;

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int i = 0;
		int j = 0;
		int sum = 0;

		int minLen = Integer.MAX_VALUE;

		while (j < nums.length) {
			if (sum < s) {
				sum += nums[j];
				j++;
			} else {
				minLen = Math.min(minLen, j - i);
				if (i == j - 1)
					return 1;

				sum -= nums[i];
				i++;
			}
		}

		while (sum >= s) {
			minLen = Math.min(minLen, j - i);

			sum -= nums[i++];
		}

		return minLen == Integer.MAX_VALUE ? 0 : minLen;

	}

	// Time complexity: O(n)
	// Space complexity: O(1) 
	public int minSubArrayLen2(int s, int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int left = 0;
		int sum = 0;
		int max = Integer.MAX_VALUE;
		for (int right = 0; right < nums.length; right++) {
			sum += nums[right];
			while (sum >= s) {
				max = Math.min(max, right - left + 1);
				sum -= nums[left++];
			}
		}

		return max == Integer.MAX_VALUE ? 0 : max;
	}
}
