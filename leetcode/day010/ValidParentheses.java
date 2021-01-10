package day010;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		HashMap<Character, Character> match = new HashMap<>();
		match.put(')', '(');
		match.put('}', '{');
		match.put(']', '[');
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stack.push(s.charAt(i));
				continue;
			}
			if (stack.isEmpty() || match.get(s.charAt(i)) != stack.pop()) {
				return false;
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}
}
