package day006;

public class KthMissingPositiveNumber {

	public int findKthPositive(int[] arr, int k) {

		int missing = 0;
		int expected = 1;

		for (int i = 0; i < arr.length;) {
			if (arr[i] == expected) {
				expected++;
				i++;
			} else {
				missing++;
				if (missing == k) {
					break;
				}
				expected++;
			}

		}

		if (missing < k) {
			expected += k - missing - 1;
		}
		return expected;
	}

	public int findKthPositiveUsingBinarySearch(int[] arr, int k) {
		int l = 0, r = arr.length, m;
		while (l < r) {
			m = (l + r + 1) / 2;
			if (m == 0 || arr[m - 1] - m < k) {
				l = m;
			} else {
				r = m - 1;
			}
		}
		return l + k;
	}
}
