package com.raj.leetcode.google;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Raj
 * 
Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

Example 1:
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

Output: 
"apple"
Example 2:
Input:
s = "abpcplea", d = ["a","b","c"]

Output: 
"a"
Note:
All the strings in the input will only contain lower-case letters.
The size of the dictionary won't exceed 1,000.
The length of all the strings in the input won't exceed 1,000.

 * 
 */
public class LongestWordinDictionarythroughDeleting {

	// https://leetcode.com/articles/longest-word-in-dictionary-through-deletion/
	// Time : O(n*x), Space: O(1)
	public String findLongestWord(String s, List<String> list) {
		String longest = "";
		for (String t : list) {
			if (isSubsequence(t, s)) {
				if (t.length() > longest.length() || (t.length() == longest.length() && t.compareTo(longest) < 0)) {
					longest = t;
				}
			}

		}
		return longest;
	}

	// Time : O(nlogn), Space : O(1); n=no.of words in dict
	public String findLongestWord2(String s, List<String> list) {
		Collections.sort(list, (s1, s2) -> s2.length() != s1.length() ? s2.length() - s1.length() : s1.compareTo(s2));

		for (String t : list) {
			if (isSubsequence(t, s))
				return t;

		}
		return "";
	}

	private boolean isSubsequence(String t, String s) {
		if (t.length() > s.length())
			return false;
		int i = 0, j = 0;
		while (i < t.length() && j < s.length()) {
			if (t.charAt(i) == s.charAt(j)) {
				i++;
				j++;
			} else {
				j++;
			}
		}
		return i == t.length();
	}

	public static void main(String[] args) {
		LongestWordinDictionarythroughDeleting obj = new LongestWordinDictionarythroughDeleting();
		String result = null;

		String d[] = { "ale", "apple", "monkey", "plea" };
		String s = "abpcplea";
		result = obj.findLongestWord(s, Arrays.asList(d));
		System.out.println(result);

		String d2[] = { "a", "b", "c" };
		String s2 = "abpcplea";
		result = obj.findLongestWord(s2, Arrays.asList(d2));
		System.out.println(result);

	}

}
