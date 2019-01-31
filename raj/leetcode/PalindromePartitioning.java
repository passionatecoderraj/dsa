package com.raj.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Raj
 * 
 * 
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
 *
 */
public class PalindromePartitioning {

	// https://leetcode.com/problems/palindrome-partitioning/discuss/41963/Java:-Backtracking-solution.
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		dfs(s, 0, new ArrayList<>(), res);
		return res;
	}

	private void dfs(String s, int start, List<String> cur, List<List<String>> res) {
		if (start == s.length()) {
			res.add(new ArrayList<>(cur));
			return;
		}
		for (int end = start; end < s.length(); end++) {
			String st = s.substring(start, end + 1);
			if (isPalindrome(st)) {
				cur.add(st);
				dfs(s, end + 1, cur, res);
				cur.remove(cur.size() - 1);
			}
		}

	}

	private boolean isPalindrome(String st) {
		int l = 0, r = st.length() - 1;
		while (l < r) {
			if (st.charAt(l++) != st.charAt(r--))
				return false;
		}
		return true;
	}

	public static void main(String... args) {
		PalindromePartitioning obj = new PalindromePartitioning();

		String s = "aab";
		List<List<String>> res = null;
		res = obj.partition(s);
		System.out.println(res);

	}
}