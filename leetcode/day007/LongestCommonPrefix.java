package day007;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {

		if (strs.length == 0) {
			return "";
		}

		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			for (int j = 0; j < prefix.length(); j++) {
				if (j == strs[i].length() || prefix.charAt(j) != strs[i].charAt(j)) {
					prefix = prefix.substring(0, j);
					break;
				}
			}
		}
		return prefix;
	}

	static String longestCommonPrefix1(String arr[]) {
		if (arr.length == 0) {
			return "";
		}
		int n = arr.length;
		String prefix = arr[0];

		for (int i = 1; i <= n - 1; i++) {
			prefix = commonPrefixUtil(prefix, arr[i]);
		}

		return prefix;
	}

	static String commonPrefixUtil(String str1, String str2) {
		StringBuilder result = new StringBuilder("");
		int n1 = str1.length(), n2 = str2.length();

		// Compare str1 and str2
		for (int i = 0, j = 0; i <= n1 - 1 && j <= n2 - 1; i++, j++) {
			if (str1.charAt(i) != str2.charAt(j)) {
				break;
			}
			result.append(str1.charAt(i));
		}

		return result.toString();
	}
}
