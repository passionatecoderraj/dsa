package com.raj.dp.ks;

public class Edit {

	public static void main(String[] args) {
		String x = "banana";
		String y = "bananab";
		// String x = "AG";
		// String y = "GXX";
		Edit obj = new Edit();

		int result = -1;
		result = obj.editBruteForce(x.toCharArray(), y.toCharArray(), x.length(), y.length());
		System.out.println(result);
		result = obj.editBottomUp(x.toCharArray(), y.toCharArray(), x.length(), y.length());
		System.out.println(result);

	}

	public int editBottomUp(char[] x, char[] y, int m, int n) {
		int t[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			t[i][0] = i;
		}
		for (int i = 0; i <= n; i++) {
			t[0][i] = i;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x[i - 1] == y[j - 1]) {
					t[i][j] = t[i - 1][j - 1];
				} else {
					t[i][j] = 1 + Math.min(t[i - 1][j - 1], Math.min(t[i][j - 1], t[i - 1][j]));
				}
			}
		}
		// CommonUtil.print2DArray(t, m + 1, n + 1);
		return t[m][n];
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
