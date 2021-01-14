package day014;

public class MinimumOperationsToReduceXToZero {
	public int minOperations(int[] nums, int x) {
		int max = Integer.MAX_VALUE;

		int start = 0;
		int end = nums.length - 1;
		int sum = 0;
		int cnt = 0;

		while (end >= 0 && sum < x) {
			sum += nums[end];
			end--;
			cnt++;
		}
		if (sum == x && cnt < max)
			max = cnt;
		if (end > -1) {
			while (end < nums.length - 1) {
				end++;
				sum -= nums[end];
				cnt--;
				while (start < end && sum < x) {
					sum += nums[start];
					start++;
					cnt++;
				}
				if (start == nums.length)
					break;
				if (sum == x && cnt < max)
					max = cnt;
			}
		}

		return max == Integer.MAX_VALUE ? -1 : max;
	}
	
	public static void main(String[] args) {
		MinimumOperationsToReduceXToZero obj = new MinimumOperationsToReduceXToZero();
		obj.minOperations(new int[] {3,2,20,1,1,3},10);
	}
}
