package com.raj.leetcode.google;

import java.util.LinkedHashMap;

/**
 * 
 * @author Raj
 * 
 S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.

Example :
Input: 
S = "cba"
T = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
 

Note:

S has length at most 26, and no character is repeated in S.
T has length at most 200.
S and T consist of lowercase letters only.
 * 
 */
public class CustomSortString {

	// Time : O(m+n), Space: O(1)
	// https://leetcode.com/problems/custom-sort-string/discuss/116615/Java-5-ms-10-line-counting-solution-with-comment
	public String customSortString(String S, String T) {
		int[] t = new int[26];

		StringBuilder sb = new StringBuilder();
		for (char ch : T.toCharArray()) {
			t[ch - 'a']++;
		}
		for (char ch : S.toCharArray()) {
			while (t[ch - 'a']-- > 0) {
				sb.append(ch);
			}
		}
		for (char ch = 'a'; ch <= 'z'; ch++) {
			while (t[ch - 'a']-- > 0) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	public String customSortString2(String S, String T) {
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		StringBuilder sb = new StringBuilder();
		for (char ch : T.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		for (char ch : S.toCharArray()) {
			if (map.containsKey(ch)) {
				for (int i = 0; i < map.get(ch); i++) {
					sb.append(ch);
				}
				map.remove(ch);
			}
		}
		for (char ch : map.keySet()) {
			for (int i = 0; i < map.get(ch); i++) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		CustomSortString obj = new CustomSortString();
		String result = null;

		String s = "cba", t = "abcd";
		result = obj.customSortString(s, t);
		System.out.println(result);
	}

}
