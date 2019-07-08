package com.raj.leetcode;

/**
 * 
 * @author Raj
 * 
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome {

	/*
	 * I count how many letters appear an odd number of times. Because we can use all letters, except for each odd-count letter we must leave one, except one of them we can use.
	 * https://leetcode.com/problems/longest-palindrome/discuss/89587/What-are-the-odds-(Python-and-C++)
	 */
	// Time : O(n), Space : O(1)
	public int longestPalindrome(String s) {
		int[] t = new int[256];
		for (char ch : s.toCharArray())
			t[ch]++;
		int noOfOdds = 0;
		for (int n : t)
			if (n % 2 != 0)
				noOfOdds++;
		return s.length() - noOfOdds + (noOfOdds > 0 ? 1 : 0);
	}

	public static void main(String[] args) {
		LongestPalindrome obj = new LongestPalindrome();
		int res = -1;
		res = obj.longestPalindrome("abccccdd");
		System.out.println(res);
	}

}
