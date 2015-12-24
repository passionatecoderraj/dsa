package com.raj.dp.ks;

public class _06Edit {

	public static void main(String[] args) {
		String x = "saturday";
		String y = "sunday";
		// String x = "AG";
		// String y = "GXX";
		_06Edit obj = new _06Edit();

		int result = -1;
		result = obj.editBruteForce(x.toCharArray(), y.toCharArray(), x.length(), y.length());
		System.out.println(result);
		result = obj.editBottomUp(x.toCharArray(), y.toCharArray(), x.length(), y.length());
		System.out.println(result);

	}

	public int editBottomUp(char[] x, char[] y, int i, int j) {
		int[][] c = new int[i + 1][j + 1];
		for (int k = 0; k < i + 1; k++) {
			c[k][0] = k;
		}

		for (int k = 0; k < j + 1; k++) {
			c[0][k] = k;
		}

		for (int m = 1; m < i + 1; m++) {
			for (int n = 1; n < j + 1; n++) {
				if (x[m - 1] == y[n - 1]) {
					c[m][n] = c[m - 1][n - 1];
				} else {
					c[m][n] = 1 + min(c[m - 1][n - 1], c[m][n - 1], c[m - 1][n]);
				}
			}
		}

		for (int m = 0; m < i + 1; m++) {
			for (int n = 0; n < j + 1; n++) {
				System.out.print(c[m][n] + " ");
			}
			System.out.println();
		}

		return c[i][j];
	}

	public int editBruteForce(char[] x, char[] y, int i, int j) {
		if (i == 0 && j == 0)
			return 0;
		else if (i == 0 && j > 0) {
			return j;
		} else if (i > 0 && j == 0) {
			return i;
		} else if (x[i - 1] == y[j - 1])
			return editBruteForce(x, y, i - 1, j - 1);
		else {
			return 1 + min(editBruteForce(x, y, i - 1, j - 1), editBruteForce(x, y, i - 1, j),
					editBruteForce(x, y, i, j - 1));
		}
	}

	private int min(int a, int b, int c) {
		int min = a;
		if (b < min)
			min = b;
		if (c < min)
			min = c;
		return min;
	}

}
