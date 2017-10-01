/**
 * 
 */
package com.raj.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Raj
 *
 *
 *         Given a string S and a string T, find the minimum window in S which
 *         will contain all the characters in T in complexity O(n).
 * 
 *         For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 */
public class MinimumWindowSubstring {

	private String minimumWindowSubstring(String s, String t) {
		String minSubString = "";

		Map<Character, Integer> map = new HashMap<>();
		for (char ch : t.toCharArray()) {
			map.compute(ch, (key, value) -> {
				if (null == value) {
					value = 0;
				}
				return 1 + value;
			});
		}

		int l = 0, minLen = Integer.MAX_VALUE;
		int counter = t.length();
		for (int r = 0; r < s.length(); r++) {
			char cur = s.charAt(r);
			if (map.containsKey(cur)) {
				if (map.get(cur) > 0)
					counter--;
				map.put(cur, map.get(cur) - 1);
			}

			while (counter == 0) {
				if (r - l < minLen) {
					minLen = r - l;
					minSubString = s.substring(l, r + 1);
				}
				char left = s.charAt(l++);
				if (map.containsKey(left)) {
					map.put(left, map.get(left) + 1);
					if (map.get(left) == 1)
						counter++;
				}
			}
		}
		return minSubString;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinimumWindowSubstring obj = new MinimumWindowSubstring();
		String result = null;
		char[] a = { 'x', 'y', 'z' };
		String s = "ADOBECODEBANC", t = "ABC";
		result = obj.minimumWindowSubstring(s, t);
		System.out.println(result);

	}

}
