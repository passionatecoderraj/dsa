package com.raj.dp.matrix;

public class _16MatrixChainMultiplication {
	public static void main(String[] args) {
		_16MatrixChainMultiplication obj = new _16MatrixChainMultiplication();
		int result = -1;
		int[] a = { 1, 2, 3, 4, 3 };
		result = obj.multiplyDp(a);
		System.out.println(result);

	}

	public int multiplyDp(int[] a) {
		int n = a.length;
		if (n <= 0)
			return -1;
		int t[][] = new int[n][n];

		for (int i = 1; i < n; i++) {
			t[i][i] = 0;
		}

		for (int l = 2; l < n; l++) {
			for (int i = 1; i < n - l + 1; i++) {
				int j = i + l - 1;
				t[i][j] = Integer.MAX_VALUE;
				for (int k = i; k <= j - 1; k++) {
					int m = t[i][k] + t[k + 1][j] + a[i - 1] * a[k] * a[j];
					if (t[i][j] > m) {
						t[i][j] = m;
					}
				}
			}
		}

		// for (int i = 0; i < n; i++) {
		// for (int j = 0; j < n; j++) {
		// System.out.print(t[i][j] + " ");
		// }
		// System.out.println();
		// }

		return t[1][n - 1];
	}

}
