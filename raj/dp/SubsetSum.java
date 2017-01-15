/**
 * 
 */
package com.raj.dp;

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
		// CommonUtil.print2DArray(t, n + 1, k + 1);
		// System.out.println(Arrays.toString(t[n]));

		return t[n][k];
	}

}
