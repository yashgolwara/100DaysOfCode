package day007;

public class PalindromeNumber {

	public static final int MOD = 10;

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}

		int left = 1;
		while (x / left >= MOD) {
			left = left * MOD;
		}

		int right = 1;
		while (left > right) {
			if ((x / left) % MOD != (x / right) % MOD) {
				return false;
			}
			left = left / MOD;
			right = right * MOD;
		}
		return true;

	}

	public boolean isPalindrome2(int x) {
		if (x < 0 || (x % MOD == 0 && x != 0)) {
			return false;
		}

		int reversedNumber = 0;
		while (x > reversedNumber) {
			reversedNumber = reversedNumber * MOD + x % MOD;
			x /= MOD;
		}

		return x == reversedNumber || x == reversedNumber / MOD;
	}

}
