/**
 * 
 */
package com.raj.leetcode.google;

/**
 * @author Raj
 *
 *Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4

 */

public class MaximalSquare {

	public int maximalSquare(char[][] a) {
		if (a.length == 0)
			return 0;
		int m = a.length, n = a[0].length;
		int t[] = new int[n + 1];
		int max = 0;
		for (int i = 1; i <= m; i++) {
			int prev = 0;
			for (int j = 1; j <= n; j++) {
				int temp = t[j];
				if (a[i - 1][j - 1] == '1') {
					t[j] = 1 + Math.min(prev, Math.min(t[j], t[j - 1]));
					max = Math.max(t[j], max);
				} else {
					t[j] = 0;
				}
				prev = temp;
			}
		}
		return max * max;
	}

	public int maximalSquare2(char[][] a) {
		if (a.length == 0)
			return 0;
		int m = a.length, n = a[0].length;
		int t[][] = new int[m + 1][n + 1];
		int max = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (a[i - 1][j - 1] == '1') {
					t[i][j] = 1 + Math.min(t[i - 1][j - 1], Math.min(t[i - 1][j], t[i][j - 1]));
					max = Math.max(t[i][j], max);
				}
			}
		}
		return max * max;
	}

	public static void main(String[] args) {
		char a[][] = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };

		int result = -1;
		MaximalSquare obj = new MaximalSquare();
		result = obj.maximalSquare(a);
		System.out.println(result);
	}

}
