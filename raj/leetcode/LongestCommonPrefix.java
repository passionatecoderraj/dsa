/**
 * 
 */
package com.raj.leetcode;

import java.util.Arrays;

/**
 * @author Raj
 * 
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
 * 
 */
public class LongestCommonPrefix {

	// https://leetcode.com/problems/longest-common-prefix/discuss/6940/Java-We-Love-Clear-Code!
	// Time : O(n), Space : O(1)
	public String longestCommonPrefix(String[] a) {
		if (a.length == 0)
			return "";
		String first = a[0], last = a[0];
		for (String s : a) {
			if (first.compareTo(s) < 0) {
				first = s;
			}
			if (last.compareTo(s) > 0) {
				last = s;
			}
		}
		int i = 0;
		while (i < Math.min(first.length(), last.length()) && first.charAt(i) == last.charAt(i))
			i++;

		return first.substring(0, i);
	}

	// Time : O(nlogn), Space : O(1)
	public String longestCommonPrefix2(String[] a) {
		if (a.length == 0)
			return "";
		Arrays.sort(a);
		String first = a[0], last = a[a.length - 1];
		int i = 0;
		while (i < Math.min(first.length(), last.length()) && first.charAt(i) == last.charAt(i))
			i++;

		return first.substring(0, i);
	}

	public static void main(String[] args) {
		LongestCommonPrefix obj = new LongestCommonPrefix();
		String result = "";
		String a[] = { "flower", "flow", "flight" };

		result = obj.longestCommonPrefix(a);
		System.out.println(result);

	}
}
