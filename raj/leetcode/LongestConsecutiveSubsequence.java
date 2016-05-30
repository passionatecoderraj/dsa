package com.raj.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 *
 * Longest Consecutive Subsequence
 * 
 *http://www.geeksforgeeks.org/longest-consecutive-subsequence/
 *
 *Given an array of integers, find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.
 */
public class LongestConsecutiveSubsequence {

	public static void main(String args[]) {
		LongestConsecutiveSubsequence s = new LongestConsecutiveSubsequence();
		int a[] = { 9, 3, 1, 10, 4, 20, 2 };
		int result = -1;
		result = s.longestConsecutiveSubsequence(a);
		System.out.println(result);

	}

	// Time : O(n), Space : O(n)
	public int longestConsecutiveSubsequence(int[] a) {
		Set<Integer> set = new HashSet<>();
		int maxLen = 0, curLen = 0;
		for (int i : a)
			set.add(i);
		for (int i = 0; i < a.length; i++) {
			if (!set.contains(a[i] - 1)) {
				int element = a[i];
				curLen = 0;
				while (set.contains(element)) {
					curLen++;
					element++;
				}
				maxLen = Math.max(maxLen, curLen);
			}
		}
		return maxLen;
	}
}