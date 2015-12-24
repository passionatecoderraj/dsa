/**
 * 
 */
package com.raj.dp.ks;

/**
 * @author Raj
 *
 */
public class _02SubsetSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 6, 3, 2, 1 };

		boolean result = false;
		int n = 5;
		_02SubsetSum obj = new _02SubsetSum();
		result = obj.isSubsetSumPresent(a, n);
		System.out.println(result);
	}

	public boolean isSubsetSumPresent(int[] a, int n) {
		int m = a.length;
		boolean t[][] = new boolean[m + 1][n + 1];
		for (int i = 0; i < m + 1; i++)
			t[i][0] = true;
		for (int i = 0; i < n + 1; i++)
			t[0][i] = false;

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (j >= a[i - 1]) {
					t[i][j] = t[i - 1][j - a[i - 1]] || t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[m][n];
	}

}
