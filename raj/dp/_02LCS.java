package com.raj.dp;


public class _02LCS {

	public static void main(String[] args) {
		String x = "AGGTAB";
		String y = "GXTXAYB";
		// String x = "AG";
		// String y = "GXX";
		_02LCS obj = new _02LCS();
		x = "baab";
		y = "abb";
		int result = -1;

		result = obj.lcsBruteForce(x.toCharArray(), y.toCharArray(), x.length(), y.length());
		System.out.println(result);
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

		for (int m = 1; m < i + 1; m++) {
			for (int n = 1; n < j + 1; n++) {
				if (x[m - 1] == y[n - 1]) {
					c[m][n] = 1 + c[m - 1][n - 1];
				} else {
					c[m][n] = max(c[m][n - 1], c[m - 1][n]);
				}
			}
		}

	/*	for (int m = 0; m < i + 1; m++) {
			for (int n = 0; n < j + 1; n++) {
				System.out.print(c[m][n] + " ");
			}
			System.out.println();
		}
		*/

		return c[i][j];
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
