/**
 *
 */
package com.raj.leetcode;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
 */

public class LongestPalindromeSubString {

	// https://www.programcreek.com/2013/12/leetcode-solution-of-longest-palindromic-substring-java/ , There is O(n) solution but don't waste time on that
	int left=0,right=0;
	// https://discuss.leetcode.com/topic/23498/very-simple-clean-java-solution
	// Time : O(n2), Space : O(1)
	public String longestPalindrome(String s) {
    	for (int i = 0; i < s.length() - 1; i++) {
			isPalindrome(s, i, i);
			isPalindrome(s, i, i + 1);
		}
		return s.isEmpty()?s:s.substring(left,right+1);
    }
    
	private void isPalindrome(String s, int l, int r) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		if (r - l - 1 > right-left+1) {
			left=l+1;
			right=r-1;
		}
	}
	// Time : O(n2), Space : O(n2)
	public String longest2(String s) {
		boolean[][] t = new boolean[s.length()][s.length()];
		String longest = "";
		for (int i = 0; i < s.length(); i++) {
			t[i][i] = true;
		}

		for (int l = 2; l <= s.length(); l++) {
			for (int i = 0; i < s.length() - l + 1; i++) {
				int j = i + l - 1;
				if (l == 2) {
					t[i][j] = s.charAt(i) == s.charAt(j);
				} else {
					t[i][j] = s.charAt(i) == s.charAt(j) && t[i + 1][j - 1];
				}
				if (t[i][j] && l > longest.length()) {
					longest = s.substring(i, j + 1);
				}
			}
		}

		return longest;

	}

	public int longestPalindormeDpOn2(char[] str, int s, int n) {
		int t[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			t[i][i] = 1;
		}
		int max = Integer.MIN_VALUE;
		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				if (str[i] == str[j]) {
					if (l == 2) {
						t[i][j] = 2;
					} else {
						t[i][j] = 2 + t[i + 1][j - 1];
					}
				} else {
					t[i][j] = 0;
				}
				max = Math.max(max, t[i][j]);
			}
		}

		CommonUtil.print2DArray(t, n, n);
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "a";

		int result = -1, n = str.length();

		LongestPalindromeSubString obj = new LongestPalindromeSubString();
//		result = obj.longestPalindormeDpOn2(str.toCharArray(), 0, n);
//		System.out.println(result);
		System.out.println(obj.longestPalindrome(str));
	}

}
