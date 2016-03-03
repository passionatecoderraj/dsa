/**
 * 
 */
package com.raj.dp.ks;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class PascalTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 4, r = 2;

		int result = -1;
		PascalTriangle obj = new PascalTriangle();

		result = obj.binomialCoefficientBruteForce(n, r);
		System.out.println(result);
		// Time : O(n*r), Space : O(n*r)
		result = obj.binomialCoefficientUsingDp(n, r);
		System.out.println(result);
		// Time : O(n*r), Space : O(r)
		result = obj.binomialCoefficientUsingDpSpaceEfficient(n, r);
		System.out.println(result);
	}

	// Time : O(n*r), Space : O(r)
	public int binomialCoefficientUsingDpSpaceEfficient(int n, int r) {
		int t[] = new int[r + 1];
		t[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = Math.min(i, r); j > 0; j--) {
				t[j] = t[j] + t[j - 1];
			}
		}
		CommonUtil.printArray(t);
		return t[r];
	}

	// Time : O(n*r), Space : O(n*r)
	public int binomialCoefficientUsingDp(int n, int r) {
		int t[][] = new int[n + 1][r + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, r); j++) {
				if (j == 0 || j == i) {
					t[i][j] = 1;
				} else {
					t[i][j] = t[i - 1][j - 1] + t[i - 1][j];
				}
			}
		}
		CommonUtil.print2DArray(t, n + 1, r + 1);
		return t[n][r];
	}

	public int binomialCoefficientBruteForce(int n, int r) {
		if (r == 0 || n == r)
			return 1;
		return binomialCoefficientBruteForce(n - 1, r) + binomialCoefficientBruteForce(n - 1, r - 1);
	}

}
