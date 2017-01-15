/**
 * 
 */
package com.raj.dp;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */

public class MaximumSubSquareMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[][] = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 } };

		int result = -1, m = 6, n = 5;
		MaximumSubSquareMatrix obj = new MaximumSubSquareMatrix();
		result = obj.maxSubSquareMatrix(a, m, n);
		System.out.println(result);
	}

	public int maxSubSquareMatrix(int[][] a, int m, int n) {
		int t[][] = new int[m][n];

		for (int i = 0; i < m; i++) {
			t[i][0] = a[i][0];
		}

		for (int i = 0; i < n; i++) {
			t[0][i] = a[0][i];
		}
		int max = 0;

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (a[i][j] == 1) {
					t[i][j] = 1 + min(t[i - 1][j], t[i][j - 1], t[i - 1][j - 1]);
					max = Math.max(max, t[i][j]);
				}
			}
		}
		CommonUtil.print2DArray(t, m, n);
		return max;
	}

	public int min(int i, int j, int k) {
		return Math.min(Math.min(i, j), k);
	}

}
