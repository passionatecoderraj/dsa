/**
 * 
 */
package com.raj.dp.ks;

/**
 * @author Raj
 *
 */

public class _07MaximumSubSquareMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[][] = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 } };

		int result = -1, m = 6, n = 5;
		_07MaximumSubSquareMatrix obj = new _07MaximumSubSquareMatrix();
		result = obj.maxSubSquareMatrix(a, m, n);
		System.out.println(result);
	}

	public int maxSubSquareMatrix(int[][] a, int m, int n) {
		int t[][] = new int[m + 1][n + 1];

		for (int i = 0; i < m + 1; i++) {
			t[i][0] = 0;
		}

		for (int i = 0; i < n + 1; i++) {
			t[0][i] = 0;
		}
		int max = 0;

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (a[i - 1][j - 1] == 1) {
					t[i][j] = 1 + min(t[i - 1][j], t[i][j - 1], t[i - 1][j - 1]);
					max = Math.max(max, t[i][j]);
				} else {
					t[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
		return max;
	}

	public int min(int i, int j, int k) {
		return Math.min(Math.min(i, j), k);
	}

}
