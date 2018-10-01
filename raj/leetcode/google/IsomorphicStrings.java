package com.raj.leetcode.google;

import java.util.HashMap;
import java.util.Map;

/*
 * Isomorphic Strings
 * 
 * For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
 * 
 * */
public class IsomorphicStrings {

	//https://leetcode.com/problems/isomorphic-strings/discuss/57796/My-6-lines-solution
	// Time : O(n), space: O(1)
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;
		int m1[] = new int[256];
		int m2[] = new int[256];

		for (int i = 0; i < s.length(); i++) {
			if (m1[s.charAt(i)] != m2[t.charAt(i)])
				return false;
			m1[s.charAt(i)] = m2[t.charAt(i)] = i + 1;
		}
		return true;
	}
	
	// Time : O(n), space: O(1)
	public boolean isIsomorphic2(String string1, String string2) {
		if (string1 == null && string2 == null)
			return true;
		if (string1 == null || string2 == null)
			return false;
		if (string1.length() != string2.length())
			return false;
		if (string1.length() == 0 && string2.length() == 0)
			return true;
		Map<Character, Character> map = new HashMap<>();
		char ch1, ch2;
		for (int i = 0, j = 0; i < string1.length() && j < string2.length(); i++, j++) {
			ch1 = string1.charAt(i);
			ch2 = string2.charAt(j);
			if (!map.containsKey(ch1)) {
				map.put(ch1, ch2);
			} else {
				if (map.get(ch1) != ch2)
					return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		IsomorphicStrings obj = new IsomorphicStrings();
		String string1 = null, string2 = null;
		boolean result = false;
		string1 = "egg";
		string2 = "add";
		result = obj.isIsomorphic(string1, string2);
		System.out.println(result);

		string1 = "foo";
		string2 = "bar";
		result = obj.isIsomorphic(string1, string2);
		System.out.println(result);
	}

}