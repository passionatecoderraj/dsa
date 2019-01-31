/**
 * 
 */
package com.raj.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Raj
 * 
 * Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

Example 1:

Input: pattern = "abab", str = "redblueredblue"
Output: true
Example 2:

Input: pattern = pattern = "aaaa", str = "asdasdasdasd"
Output: true
Example 3:

Input: pattern = "aabb", str = "xyzabcxzyabc"
Output: false
Notes:
You may assume both pattern and str contains only lowercase letters.
 */
public class WordPattern2 {

	
	// https://leetcode.com/problems/word-pattern-ii/discuss/73664/Share-my-Java-backtracking-solution
	public boolean wordPatternMatch(String pattern, String str) {
		return util(0, pattern, 0, str, new HashMap<>(), new HashSet<>());
	}

	private boolean util(int patIdx, String pattern, int strIdx, String str, Map<Character, String> map,
			Set<String> set) {
		if (patIdx == pattern.length() && strIdx == str.length())
			return true;
		if (patIdx == pattern.length() || strIdx == str.length())
			return false;
		char pat = pattern.charAt(patIdx);
		// if the pattern character exists
		if (map.containsKey(pat)) {
			// then check if we can use it to match str from cur index(strIdx)
			if (!str.startsWith(map.get(pat), strIdx)) {
				return false;
			}
			// if it can match, great, continue to match the rest
			return util(patIdx + 1, pattern, strIdx + map.get(pat).length(), str, map, set);
		}
		for (int k = strIdx; k < str.length(); k++) {
			String word = str.substring(strIdx, k + 1);
			// cur word is mapped to some 'pattern' so can't use it map 'other pattern'
			if (set.contains(word)) {
				continue;
			}
			map.put(pat, word);
			set.add(word);
			if (util(patIdx + 1, pattern, k + 1, str, map, set)) {
				return true;
			}
			map.remove(pat);
			set.remove(word);
		}
		return false;
	}

	public static void main(String[] args) {
		WordPattern2 obj = new WordPattern2();

		boolean res = false;

		String pattern = "abba", str = "dogcatcatdog";
		res = obj.wordPatternMatch(pattern, str);
		System.out.println(res);

		pattern = "abba";
		str = "dogdogdogdog";
		res = obj.wordPatternMatch(pattern, str);
		System.out.println(res);

	}
}
