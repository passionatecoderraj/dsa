package com.raj.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 *
 * Longest Consecutive Subsequence
 * 
 * http://www.programcreek.com/2013/01/leetcode-longest-consecutive-sequence-java/
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
		int maxLen = 0;
		for (int i : a)
			set.add(i);
		for (int i = 0; i < a.length; i++) {
			int left = a[i] - 1;
			int right = a[i] + 1;
			int count = 1;
			while (set.contains(left)) {
				set.remove(left++);
				count++;
			}

			while (set.contains(right)) {
				set.remove(right++);
				count++;
			}
			maxLen = Math.max(maxLen, count);

		}
		return maxLen;
	}
}