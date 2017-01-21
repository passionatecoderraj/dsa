package com.raj.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author Raj
 *
 *         You have a number of envelopes with widths and heights given as a
 *         pair of integers (w, h). One envelope can fit into another if and
 *         only if both the width and height of one envelope is greater than the
 *         width and height of the other envelope.
 * 
 *         Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of
 *         envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 */
public class MaxEnvelopes {

	// Time :O(n2), Space : O(n)
	public static int maxEnvelopes(int[][] a) {
		if (null == a || a.length == 0)
			return 0;
		Arrays.sort(a, new Comparator<int[]>() {
			public int compare(int a1[], int a2[]) {
				return a1[0] * a1[1] - a2[0] * a2[1];
			}
		});

		int t[] = new int[a.length];
		int maxLen = 1;
		Arrays.fill(t, 1);
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i][0] > a[j][0] && a[i][1] > a[j][1]) {
					t[i] = Math.max(t[i], 1 + t[j]);
					maxLen = Math.max(t[i], maxLen);
				}
			}
		}
		return maxLen;
	}

	public static void main(String args[]) {
		int a[][] = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
		int res = maxEnvelopes(a);
		System.out.println(res);
		int b[][] = { { 17, 18 }, { 20, 4 }, { 4, 3 }, { 14, 6 }, { 16, 4 }, { 8, 11 }, { 17, 11 }, { 18, 7 },
				{ 20, 12 } };
		res = maxEnvelopes(b);
		System.out.println(res);
	}
}