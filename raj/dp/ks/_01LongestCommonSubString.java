package com.raj.dp.ks;

public class _01LongestCommonSubString {

	public static void main(String[] args) {
		String x = "abcdaf";
		String y = "zbcdf";
		_01LongestCommonSubString obj = new _01LongestCommonSubString();
		int result = -1;

		result = obj.lcsBottomUp(x.toCharArray(), y.toCharArray(), x.length(), y.length());
		System.out.println(result);

	}

	public int lcsBottomUp(char[] x, char[] y, int i, int j) {
		int[][] c = new int[i + 1][j + 1];

		for (int k = 0; k < i + 1; k++) {
			c[k][0] = 0;
		}

		for (int k = 0; k < j + 1; k++) {
			c[0][k] = 0;
		}
		int max = Integer.MIN_VALUE;
		for (int m = 1; m < i + 1; m++) {
			for (int n = 1; n < j + 1; n++) {
				if (x[m - 1] == y[n - 1]) {
					c[m][n] = 1 + c[m - 1][n - 1];
				} else {
					c[m][n] = 0;
				}
				max = Math.max(max, c[m][n]);
			}
		}

		/*
		 * for (int m = 0; m < i + 1; m++) { for (int n = 0; n < j + 1; n++) {
		 * System.out.print(c[m][n] + " "); } System.out.println(); }
		 */

		return max;
	}

	public int lcsBruteForce(char[] x, char[] y, int i, int j) {
		if (i == 0 || j == 0)
			return 0;
		else if (x[i - 1] == y[j - 1])
			return 1 + lcsBruteForce(x, y, i - 1, j - 1);
		else {
			return max(lcsBruteForce(x, y, i - 1, j), lcsBruteForce(x, y, i, j - 1));
		}
	}

	public int max(int a, int b) {
		return a > b ? a : b;
	}

}
