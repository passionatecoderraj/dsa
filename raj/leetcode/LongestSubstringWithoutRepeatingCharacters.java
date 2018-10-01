package com.raj.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 * Longest Substring Without Repeating Characters
 * 
 * Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", which the length is 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {

	// Time : O(n), Space : O(1)
	public int lengthOfLongestSubstring(String s) {
		int res = 0;
		Set<Character> set = new HashSet<>();

		for (int l = 0, r = 0; r < s.length(); r++) {
			char ch = s.charAt(r);
			if (!set.contains(ch)) {
				res = Math.max(res, r - l + 1);
			} else {
				while (l < r && set.contains(ch)) {
					set.remove(s.charAt(l++));
				}
			}
			set.add(ch);
		}
		return res;
	}

	public static void main(String args[]) {
		LongestSubstringWithoutRepeatingCharacters s = new LongestSubstringWithoutRepeatingCharacters();
		String str = "abcabcdebb";
		int result = 0;

		result = s.longestSubstringWithoutRepeatingCharacters(str);
		System.out.println(result);

		str = "bbbbb";
		result = s.longestSubstringWithoutRepeatingCharacters(str);
		System.out.println(result);

		str = "pwwkew";
		result = s.longestSubstringWithoutRepeatingCharacters(str);
		System.out.println(result);

		result = s.lengthOfLongestSubstring(str);
		System.out.println(result);
	}

	public int longestSubstringWithoutRepeatingCharacters(String str) {
		if (null == str || str.length() <= 0)
			return 0;

		boolean a[] = new boolean[256];
		char ch;

		int left = 0, i;
		int maxLen = 1;

		for (i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (a[ch]) {
				maxLen = Math.max(i - left, maxLen);
				for (int j = left; j < i; j++) {
					if (str.charAt(j) == ch) {
						left = j + 1;
						break;
					}
					a[str.charAt(j)] = false;
				}
				a[ch] = true;
			} else {
				a[ch] = true;
			}

		}
		maxLen = Math.max(i - left, maxLen);
		return maxLen;
	}

	public int longestSubstringWithoutRepeatingCharactersUsingHashSet(String str) {
		if (str.length() <= 0)
			return 0;
		Set<Character> set = new HashSet<Character>();
		set.add(str.charAt(0));
		int curLen = 1;
		int maxLen = 1;

		for (int i = 1; i < str.length(); i++) {
			if (set.contains(str.charAt(i))) {
				set.remove(str.charAt(i));
				maxLen = Math.max(curLen, maxLen);

				set.add(str.charAt(i));
				curLen = 1;
			} else {
				set.add(str.charAt(i));
				curLen++;
			}
		}
		maxLen = Math.max(curLen, maxLen);
		return maxLen;
	}

	public void longestSubstringWithUniqueCharactersUsingTwoIndices(String a) {
		if (null == a || a.length() == 0)
			return;
		Set<Character> visited = new HashSet<>();
		int l = 0, r = 0;
		String substring = "";
		char ch;
		while (r < a.length()) {
			ch = a.charAt(r);
			if (!visited.contains(ch)) {
				visited.add(ch);
				if (r - l + 1 > substring.length()) {
					substring = a.substring(l, r + 1);
				}
				r++;
			} else {
				visited.remove(a.charAt(l++));
			}
		}
		System.out.println(substring);
	}
}