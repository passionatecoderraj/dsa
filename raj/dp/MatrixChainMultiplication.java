package com.raj.dp;

import com.interview.graph.CommonUtil;

public class MatrixChainMultiplication {
	public static void main(String[] args) {
		MatrixChainMultiplication obj = new MatrixChainMultiplication();
		int result = -1;
		int[] a = { 10, 4, 5, 20, 2, 50 };
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
				System.out.print("(" + i + "," + j + ") : ");
				for (int k = i; k < j; k++) {
					int m = t[i][k] + t[k + 1][j] + a[i - 1] * a[k] * a[j];
					System.out.print(m + " ");
					t[i][j] = Math.min(t[i][j], m);
				}
				System.out.println();
			}
		}
		CommonUtil.print2DArray(t, n, n);
		return t[1][n - 1];
	}

}
