package com.raj.dp;

public class MinCost {

	public static void main(String[] args) {
		MinCost obj = new MinCost();

		int c[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		int result = -1;
		result = obj.minCostDp(c, 3, 3);
		System.out.println(result);
	}

	public int minCostDp(int[][] c, int i, int j) {
		int t[][] = new int[i][j];
		t[0][0] = c[0][0];

		for (int k = 1; k < i; k++) {
			t[k][0] = t[k - 1][0] + c[k][0];
		}

		for (int k = 1; k < j; k++) {
			t[0][k] = t[0][k - 1] + c[0][k];
		}
		for (int m = 1; m < i; m++) {
			for (int n = 1; n < j; n++) {
				t[m][n] = c[m][n] + min(t[m - 1][n], t[m][n - 1]);
			}
		}
		return t[i - 1][j - 1];
	}

	public int min(int a, int b) {
		return a < b ? a : b;
	}

}
