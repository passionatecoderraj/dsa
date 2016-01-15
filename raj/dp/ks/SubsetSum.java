/**
 * 
 */
package com.raj.dp.ks;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class SubsetSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 3, 34, 4, 12, 5, 2 };

		boolean result = false;
		int n = 9;
		SubsetSum obj = new SubsetSum();
		result = obj.isSubsetSumPresent(a, n);
		System.out.println(result);
		result = obj.isSubsetSum(a, a.length, n);
		System.out.println(result);

	}

	public boolean isSubsetSum(int a[], int n, int k) {
		boolean t[][] = new boolean[n + 1][k + 1];
		for (int i = 0; i <= n; i++) {
			t[i][0] = true;
		}
		for (int i = 1; i <= k; i++) {
			t[0][i] = false;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (j >= a[i - 1]) {
					t[i][j] = t[i - 1][j] || t[i - 1][j - a[i - 1]];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		CommonUtil.print2DArray(t, n + 1, k + 1);
		return t[n][k];
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
		CommonUtil.print2DArray(t, m + 1, n + 1);

		return t[m][n];
	}

}
