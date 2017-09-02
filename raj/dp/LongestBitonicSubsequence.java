package com.raj.dp;

import com.interview.graph.CommonUtil;

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

	// Time :O(n2), Space : O(n)
	public int bitonicDpOn2(int[] a) {

		int n = a.length;

		if (n <= 0)
			return -1;

		int lis[] = new int[n];
		int lds[] = new int[n];

		for (int i = 0; i < n; i++) {
			lis[i] = 1;
			lds[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j]) {
					if (lis[j] + 1 > lis[i]) {
						lis[i] = lis[j] + 1;
					}
				}
			}
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = n - 1; j > i; j--) {
				if (a[i] > a[j]) {
					if (lds[j] + 1 > lds[i]) {
						lds[i] = lds[j] + 1;
					}
				}
			}
		}

		CommonUtil.printArray(lis);
		CommonUtil.printArray(lds);
		int max = 1;
		for (int i = 0; i < n; i++) {
			System.out.print(lis[i] + "-" + lds[i] + ", ");
			if (lis[i] + lds[i] - 1 > max)
				max = lis[i] + lds[i] - 1;
		}
		System.out.println();
		return max;
	}

	public static void main(String[] args) {
		int result = -1;
		int[] a = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
		result = longestWiggleSubsequence(a);
		System.out.println(result);
	}
}
