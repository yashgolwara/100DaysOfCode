package day016;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs {
	public int maxOperations(int[] nums, int k) {
		if (k == 1) {
			return 0;
		}
		Map<Integer, Integer> count = new HashMap<>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int v = nums[i];
			if (v < k) {
				count.put(v, count.getOrDefault(v, 0) + 1);
			}
		}
		int res = 0;
		for (int key : count.keySet()) {
			res += Math.min(count.getOrDefault(key, 0), count.getOrDefault(k - key, 0));
		}
		return res / 2;
	}

}
