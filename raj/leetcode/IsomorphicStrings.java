package com.raj.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Isomorphic Strings
 * 
 * For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
 * 
 * */
public class IsomorphicStrings {

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

	public boolean isIsomorphic(String string1, String string2) {
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

}