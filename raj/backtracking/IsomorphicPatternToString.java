package com.raj.backtracking;

import java.util.HashMap;
import java.util.HashSet;

/*
 * LeetCode – Word Pattern II (Java)
 * 
 * Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
 * 
 * 
 * Examples:
pattern = "abab", str = "redblueredblue" should return true.
pattern = "aaaa", str = "asdasdasdasd" should return true.
pattern = "aabb", str = "xyzabcxzyabc" should return false.
 * */
public class IsomorphicPatternToString {

	public boolean wordPatternMatch(String pattern, String str) {
		if (pattern.length() == 0 && str.length() == 0)
			return true;
		if (pattern.length() == 0)
			return false;

		HashMap<Character, String> map = new HashMap<Character, String>();
		HashSet<String> set = new HashSet<String>();
		return helper(pattern, str, 0, 0, map, set);
	}

	public boolean helper(String pattern, String str, int i, int j, HashMap<Character, String> map,
			HashSet<String> set) {
		if (i == pattern.length() && j == str.length()) {
			return true;
		}

		if (i >= pattern.length() || j >= str.length())
			return false;

		char c = pattern.charAt(i);
		for (int k = j + 1; k <= str.length(); k++) {
			String sub = str.substring(j, k);
			if (!map.containsKey(c) && !set.contains(sub)) {
				map.put(c, sub);
				set.add(sub);
				if (helper(pattern, str, i + 1, k, map, set))
					return true;
				map.remove(c);
				set.remove(sub);
			} else if (map.containsKey(c) && map.get(c).equals(sub)) {
				if (helper(pattern, str, i + 1, k, map, set))
					return true;
			}
		}

		return false;
	}

	public static void main(String args[]) {
		IsomorphicPatternToString obj = new IsomorphicPatternToString();
		String pattern = null, string = null;
		boolean result = false;
		pattern = "ab";
		string = "rarj";
		result = obj.wordPatternMatch(pattern, string);
		System.out.println(result);

	}

}