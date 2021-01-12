package day012;

public class ValidPalindrome {

	public boolean isPalindrome(String s) {

		// Use two pointer from left and right
		int left = 0;
		int right = s.length() - 1;
		char leftChar;
		char rightChar;

		// Scan from left and right to the middle
		while (left <= right) {
			// Update left and right char
			leftChar = s.charAt(left);
			rightChar = s.charAt(right);
			// Skip non-alphanumeric character
			if (!Character.isLetterOrDigit(leftChar)) {
				left++;
			} else if (!Character.isLetterOrDigit(rightChar)) {
				right--;
			} else {
				// Check if same char (ignoring cases)
				if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
					return false;
				}
				left++;
				right--;
			}
		}
		return true;
	}

}
