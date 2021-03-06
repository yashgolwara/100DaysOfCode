package day003;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringtoInteger {

	public static void main(String[] args) {
		StringtoInteger obj = new StringtoInteger();
		String s = "   -487";
		System.out.println(obj.myAtoi(s));
		
		String str = "she sells sea shells";
		String rex = "SsS";
		String replace = "x";
		Pattern p = Pattern.compile(rex);
		Matcher m = p.matcher(str);
		String val = m.replaceAll(replace);
		System.out.println(val);
	}

	public int myAtoi(String s) {

		s = s.trim();

		if (s.length() == 0)
			return 0;

		int i = 0, flag = 1;
		long result = 0;
		if (s.charAt(0) == '-') {
			flag = -1;
			i = 1;
		} else if (s.charAt(0) == '+') {
			i = 1;
		}

		while (i < s.length()) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				int digit = s.charAt(i) - '0';
				result = result * 10 + digit;
				if (result > Integer.MAX_VALUE) {
					break;
				}
			} else {
				break;
			}
			i++;
		}
		if (result * flag > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		if (result * flag < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		return (int) result * flag;
	}
	
	
	
}
