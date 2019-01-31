/**
 * 
 */
package com.raj.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Raj
 * 
 * Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class WordPattern {

	// Time : O(n), Space O(n)
	/*
	 * ab => dog cat -> true aa => dog cat - false ; because 'a' is already mapped
	 * to 'dog' ab => dog dog -> false ; because 'dog' is already mapped to 'a' so
	 * cannot be mapped to 'b'
	 * 
	 */
	public boolean wordPattern(String pattern, String str) {
		String a[] = str.split(" ");
		if (a.length != pattern.length())
			return false;
		Map map = new HashMap();
		for (Integer i = 0; i < pattern.length(); i++) {
			if(map.put(pattern.charAt(i), i)  != map.put(a[i],i)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean wordPattern2(String pattern, String str) {
		Map<Character, String> map1 = new HashMap<>();
		Map<String, Character> map2 = new HashMap<>();

		String a[] = str.split(" ");
		if (a.length != pattern.length())
			return false;
		for (int i = 0; i < pattern.length(); i++) {
			char pat = pattern.charAt(i);
			String w = a[i];
			if (map1.containsKey(pat) && !map1.get(pat).equals(w)) {
				return false;
			} else if (map2.containsKey(w) && !map2.get(w).equals(pat))
				return false;
			map1.put(pat, w);
			map2.put(w, pat);
		}
		return true;
	}

	public boolean wordPattern3(String pattern, String str) {
		Map<Character, String> map = new HashMap<>();

		String a[] = str.split(" ");
		if (a.length != pattern.length())
			return false;
		for (int i = 0; i < pattern.length(); i++) {
			char pat = pattern.charAt(i);
			String w = a[i];
			if (map.containsKey(pat)) {
				if (!map.get(pat).equals(w))
					return false;
			} else if (map.containsValue(w))
				return false;
			map.put(pat, w);
		}
		return true;
	}

	public static void main(String[] args) {
		WordPattern obj = new WordPattern();

		boolean res = false;

		String pattern = "abba", str = "dog cat cat dog";
		res = obj.wordPattern(pattern, str);
		System.out.println(res);

		pattern = "abba";
		str = "dog dog dog dog";
		res = obj.wordPattern(pattern, str);
		System.out.println(res);

	}
}
