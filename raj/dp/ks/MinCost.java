package com.raj.dp.ks;

import com.interivew.graph.CommonUtil;

public class MinCost {

	public static void main(String[] args) {
		MinCost obj = new MinCost();

		int c[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		int result = -1;
		result = obj.minCost(c, c.length, c[0].length, 2, 2);
		System.out.println(result);
	}

	public int minCost(int a[][], int m, int n, int x, int y) {
		if (x > m || y > n)
			return -1;
		int t[][] = new int[m][n];
		t[0][0] = a[0][0];

		for (int i = 1; i < n; i++) {
			t[0][i] = a[0][i] + t[0][i - 1];
		}

		for (int i = 1; i < m; i++) {
			t[i][0] = a[i][0] + t[i - 1][0];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				t[i][j] = a[i][j] + Math.min(t[i - 1][j - 1], Math.min(t[i][j - 1], t[i - 1][j]));
			}
		}
		CommonUtil.print2DArray(t, m, n);
		return t[x][y];
	}
}
