package day006;

import java.util.HashMap;

public class RomanToInteger {

	public int romanToIntHashMap(String s) {
		int intNum = 0;
		int prev = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			int temp = initHelper().get(s.charAt(i));
			if (temp < prev)
				intNum -= temp;
			else
				intNum += temp;
			prev = temp;
		}
		return intNum;
	}

	private static HashMap<Character, Integer> initHelper() {
		HashMap<Character, Integer> helper = new HashMap<>();
		helper.put('M', 1000);
		helper.put('D', 500);
		helper.put('C', 100);
		helper.put('L', 50);
		helper.put('X', 10);
		helper.put('V', 5);
		helper.put('I', 1);

		return helper;

	}

	public int romanToIntArray(String s) {
		int result = 0;
		int[] decimal = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

		for (int i = 0; i < decimal.length; i++) {
			while (s.indexOf(roman[i]) == 0) {
				result += decimal[i];
				s = s.substring(roman[i].length());
			}
		}
		return result;
	}

}
