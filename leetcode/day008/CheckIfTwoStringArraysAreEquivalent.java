package day008;

public class CheckIfTwoStringArraysAreEquivalent {

	public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		
		return helper(word1).equals(helper(word2));
	}
	
	private String helper(String[] word) {
		StringBuilder sb = new StringBuilder();
		for (String input : word) {
			sb.append(input);
		}
		return sb.toString();
	}
	
	public boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
		
		return String.join("", word1).equals(String.join("",word2));
	}

	public static void main(String[] args) {
		CheckIfTwoStringArraysAreEquivalent obj = new  CheckIfTwoStringArraysAreEquivalent();
		obj.arrayStringsAreEqual(new String[] {"ab", "c"},new String[] {"a", "bc"});
	}
}
