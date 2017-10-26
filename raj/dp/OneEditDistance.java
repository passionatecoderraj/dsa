package com.raj.dp;

/**
 * @author Raj 
 * 
 * Given two strings S and T, determine if they are both one edit
 *         distance apart.
 */
public class OneEditDistance {

	// Time : O(s+t), Space : O(1)
	public boolean isOneEditDistance(String s, String t) {
		if (Math.abs(s.length() - t.length()) > 1) {
			return false;
		}
		if (s.length() == t.length()) {
			return oneEditModify(s, t);
		}
		return s.length() > t.length() ? oneEditDelete(s, t) : oneEditDelete(t, s);
	}

	private boolean oneEditDelete(String s, String t) {	
		for (int i = 0; i < t.length(); i++) {
			if (s.charAt(i) != t.charAt(i)) {
				return s.substring(i + 1).equals(t.substring(i));
			}
		}
		return true;
	}

	private boolean oneEditModify(String s, String t) {
		int diff = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(i)) {
				diff++;
			}
		}
		return 1 == diff;
	}

	public static void main(String[] args) {
		String s = "abc";
		String t = "abd";
		OneEditDistance obj = new OneEditDistance();

		boolean result = false;
		s = "abc";
		t = "abd";
		result = obj.isOneEditDistance(s, t);
		System.out.println(result);

		s = "abcd";
		t = "abd";
		result = obj.isOneEditDistance(s, t);
		System.out.println(result);

		s = "abc";
		t = "abcd";
		result = obj.isOneEditDistance(s, t);
		System.out.println(result);

	}

}
