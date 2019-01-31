package com.raj.leetcode;

/**
 * 
 * @author Raj
 * 
 * 
 *         Given a string s, partition s such that every substring of the
 *         partition is a palindrome.
 * 
 *         Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 *         Example:
 * 
 *         Input: "aab" Output: 1 Explanation: The palindrome partitioning
 *         ["aa","b"] could be produced using 1 cut.
 * 
 */
public class PalindromePartitioning2 {

	// https://leetcode.com/problems/palindrome-partitioning-ii/discuss/42198/My-solution-does-not-need-a-table-for-palindrome-is-it-right-It-uses-only-O(n)-space.
	// look for this solution in comments
	/*
	 * if a substring (l,r) is a palindrom
	 *  if l==0, then no cuts needed so t[r] is 0 
	 *  if l!=0, then no. of cuts = min(t[r], no. of cuts until (l-1) + 1)) => +1 is for obvious cut that we need to make since entire string is not palindrome
	 */
	// Time : O(n2), Space : O(n)
	public int minCut(String s) {
		int t[] = new int[s.length()];
		
		for (int i = 0; i < s.length(); i++)
			t[i] = i;
		for (int i = 0; i < s.length(); i++) {
			util(s, t, i, i);
			util(s, t, i, i + 1);
		}
		return t[s.length() - 1];
	}

	private void util(String s, int[] t, int l, int r) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			if (l == 0) {
				t[r] = 0;
			} else {
				t[r] = Math.min(t[r], 1 + t[l - 1]);
			}
			l--;
			r++;
		}
	}

	public static void main(String... args) {
		PalindromePartitioning2 obj = new PalindromePartitioning2();

		int res = -1;
		res = obj.minCut("abacc");
		System.out.println(res);

		res = obj.minCut("cbab");
		System.out.println(res);

	}
}