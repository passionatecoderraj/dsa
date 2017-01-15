package com.raj.dp;

/**
 * 
 * @author Raj
 *
 *         A sequence of numbers is called a wiggle sequence if the differences
 *         between successive numbers strictly alternate between positive and
 *         negative. The first difference (if one exists) may be either positive
 *         or negative. A sequence with fewer than two elements is trivially a
 *         wiggle sequence.
 * 
 *         Input: [1,17,5,10,13,15,10,5,16,8]
 * 
 *         Output: 7 There are several subsequences that achieve this length.
 * 
 * 
 *         One is [1,17,10,13,10,16,8].
 */
public class LongestBitonicSubsequence {

	// Time :O(n), Space : O(n)
	public static int longestWiggleSubsequence(int a[]) {
		int inc[] = new int[a.length];
		int dec[] = new int[a.length];
		inc[0] = dec[0] = 1;

		for (int i = 1; i < a.length; i++) {
			if (a[i] > a[i - 1]) {
				inc[i] = dec[i - 1] + 1;
				dec[i] = dec[i - 1];
			} else if (a[i] < a[i - 1]) {
				inc[i] = inc[i - 1];
				dec[i] = inc[i - 1] + 1;
			} else {
				inc[i] = inc[i - 1];
				dec[i] = dec[i - 1];
			}
		}
		return Math.max(inc[a.length - 1], dec[a.length - 1]);
	}

	public static void main(String[] args) {
		int result = -1;
		int[] a = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
		result = longestWiggleSubsequence(a);
		System.out.println(result);
	}
}
