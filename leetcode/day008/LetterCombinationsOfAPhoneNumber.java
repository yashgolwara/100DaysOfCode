package day008;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

	public List<String> letterCombinations2(String digits) {
		LinkedList<String> result = new LinkedList<>();
		if (digits.isEmpty())
			return result;
		String[] mappings = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		result.add("");
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			while (result.peek().length() == i) {
				String t = result.remove();
				for (char s : mappings[x].toCharArray()) {
					result.add(t + s);
				}
			}
		}
		return result;
	}

	public List<String> letterCombinations(String digits) {
		HashMap<Character, String> keyboard = new HashMap<>();
		initKeyboard(keyboard);

		List<String> result = new LinkedList<>();
		if (digits.length() == 0) {
			return result;
		}

		compile(digits, "", 0, keyboard, result);
		return result;
	}

	private static void compile(String digits, String prefix, int start, HashMap<Character, String> keyboard,
			List<String> result) {
		if (start == digits.length()) {
			result.add(prefix);
			return;
		}

		String letters = keyboard.get(digits.charAt(start));
		for (int j = 0; j < letters.length(); j++) {
			compile(digits, prefix + letters.charAt(j), start + 1, keyboard, result);
		}

	}

	private static void initKeyboard(HashMap<Character, String> keyboard) {
		keyboard.put('2', "abc");
		keyboard.put('3', "def");
		keyboard.put('4', "ghi");
		keyboard.put('5', "jkl");
		keyboard.put('6', "mno");
		keyboard.put('7', "pqrs");
		keyboard.put('8', "tuv");
		keyboard.put('9', "wxyz");
	}
}
