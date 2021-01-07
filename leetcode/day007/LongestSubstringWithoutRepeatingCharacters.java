package day007;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

	static final int NO_OF_CHARS = 256;

	// to get length
	public int lengthOfLongestSubstring(String s) {

		int n = s.length();

		int res = 0;

		// last index of all characters is initialized as -1
		int[] lastIndex = new int[NO_OF_CHARS];
		Arrays.fill(lastIndex, -1);

		// starting index
		int i = 0;

		// ending index
		for (int j = 0; j < n; j++) {

			// Find the last index of s[j]
			// Update i as maximum of current value of i and lastIndex plus 1
			i = Math.max(i, lastIndex[s.charAt(j)] + 1);

			// Update result if we get a larger window
			res = Math.max(res, j - i + 1);

			// Update last index of j.
			lastIndex[s.charAt(j)] = j;

		}

		return res;

	}

	// to get the string as output

	String getUniqueCharacterSubstring(String input) {
		Map<Character, Integer> visited = new HashMap<>();
		String output = "";
		for (int start = 0, end = 0; end < input.length(); end++) {
			char currChar = input.charAt(end);
			if (visited.containsKey(currChar)) {
				start = Math.max(visited.get(currChar) + 1, start);
			}
			if (output.length() < end - start + 1) {
				output = input.substring(start, end + 1);
			}
			visited.put(currChar, end);
		}
		return output;
	}

	public static void main(String[] args) {
		String s = "GEEKSFORGEEKS";
		LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
		System.out.print(obj.getUniqueCharacterSubstring(s));
	}

}
