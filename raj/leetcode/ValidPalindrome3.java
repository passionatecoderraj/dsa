/**
 *
 */
package com.raj.leetcode;

import java.util.Arrays;

/**
 * @author Raj
 * 
 * Given a string s and an integer k, find out if the given string is a K-Palindrome or not.

A string is K-Palindrome if it can be transformed into a palindrome by removing at most k characters from it.

 

Example 1:

Input: s = "abcdeca", k = 2
Output: true
Explanation: Remove 'b' and 'e' characters.
 

Constraints:

1 <= s.length <= 1000
s has only lowercase English letters.
1 <= k <= s.length
 */

public class ValidPalindrome3 {

	/*
	 * The idea is to find the longest palindromic subsequence(lps) of the given string.
|lps - original string| <= k,
then the string is k-palindrome.

Eg:

One of the lps of string pqrstrp is prsrp.
Characters not contributing to lps of the
string should be removed in order to make the string palindrome. So on removing q and s (or t) from pqrstrp,
string will transform into a palindrome.
	 */
	public boolean isValidPalindrome(String s, int k) {
		int n = s.length();
		int t[] = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			t[i] = 1;
			int prev = 0;
			for (int j = i + 1; j < n; j++) {
				int temp = t[j];
				if (s.charAt(i) == s.charAt(j)) {
					t[j] = 2 + prev;
				} else {
					t[j] = Math.max(t[j], t[j - 1]);
				}
				prev = temp;
			}
		}
		return t[n - 1] + k >= n;
	}

	public boolean isValidPalindrome2(String s, int k) {
		int n = s.length();
		int t[] = new int[n];
		for (int i = 0; i < n; i++) {
			t[i] = 1;
			int prev = 0;
			for (int j = i - 1; j >= 0; j--) {
				int temp = t[j];
				if (s.charAt(i) == s.charAt(j)) {
					t[j] = 2 + prev;
				} else {
					t[j] = Math.max(t[j], t[j + 1]);
				}
				prev = temp;
			}
		}
		System.out.println(Arrays.toString(t));
		return t[0] + k >= n;
	}

	public boolean isValidPalindrome3(String s, int k) {
		int n = s.length();
		int t[][] = new int[n][n];
		for (int i = 0; i < n; i++)
			t[i][i] = 1;
		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				if (s.charAt(i) == s.charAt(j)) {
					if (l == 2) {
						t[i][j] = 2;
					} else {
						t[i][j] = 2 + t[i + 1][j - 1];
					}
				} else {
					t[i][j] = Math.max(t[i + 1][j], t[i][j - 1]);
				}
				if (t[i][j] + k >= n)
					return true;
			}
		}
		return t[0][n - 1] + k >= n;
	}

	public static void main(String[] args) {
		ValidPalindrome3 obj = new ValidPalindrome3();

		String str = "abcdeca";
		boolean result = false;

		// Time : O(n) Space :O(1)
		result = obj.isValidPalindrome(str, 2);
		System.out.println(result);
	}

}
