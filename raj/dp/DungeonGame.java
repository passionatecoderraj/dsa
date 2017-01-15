package com.raj.dp;

import com.interivew.graph.CommonUtil;

/**
 * 
 * @author Raj
 *
 */
public class DungeonGame {

	public static int dungeonGame(int a[][]) {
		int m = a.length, n = a[0].length;
		int t[][] = new int[m][n];

		t[m - 1][n - 1] = Math.max(1 - a[m - 1][n - 1], 1);

		for (int i = m - 2; i >= 0; i--) {
			t[i][n - 1] = Math.max(t[i + 1][n - 1] - a[i][n - 1], 1);
		}

		for (int j = n - 2; j >= 0; j--) {
			t[m - 1][j] = Math.max(t[m - 1][j + 1] - a[m - 1][j], 1);
		}

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				int down = Math.max(t[i + 1][j] - a[i][j], 1);
				int right = Math.max(t[i][j + 1] - a[i][j], 1);
				t[i][j] = Math.min(right, down);
			}
		}
		CommonUtil.print2DArray(t, m, n);
		return t[0][0];
	}

	public static void main(String[] args) {
		int result = -1;
		int a[][] = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		result = dungeonGame(a);
		System.out.println(result);
	}
}
