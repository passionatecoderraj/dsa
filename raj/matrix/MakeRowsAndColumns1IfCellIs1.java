package com.raj.matrix;

import com.interivew.graph.CommonUtil;

public class MakeRowsAndColumns1IfCellIs1 {
	public static void main(String args[]) throws Exception {

		int a[][] = { { 1, 0, 0, 1 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, };
		int m = a.length, n = a[0].length;
		CommonUtil.print2DArray(a, m, n);

		// Time : O(m*n) , Space : O(m+n)
		makeRowsAndColumns1IfCellIs1(a, m, n);
		System.out.println("After");
		CommonUtil.print2DArray(a, m, n);

		int b[][] = { { 1, 0, 0, 1 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, };
		int m1 = b.length, n1 = b[0].length;
		System.out.println("Before");
		CommonUtil.print2DArray(b, m1, n1);

		// Time : O(m*n) , Space : O(1)
		makeRowsAndColumns1IfCellIs1WithSpaceOptimized(b, m1, n1);
		System.out.println("After");
		CommonUtil.print2DArray(b, m1, n1);
	}

	// Time : O(m*n) , Space : O(1)
	public static void makeRowsAndColumns1IfCellIs1WithSpaceOptimized(int[][] a, int m, int n) {
		boolean rowFlag = false, colFlag = false;
		for (int i = 0; i < m; i++) {
			if (a[i][0] == 1)
				rowFlag = true;
		}

		for (int i = 0; i < n; i++) {
			if (a[0][i] == 1)
				colFlag = true;
		}
		// using the first row and column as temporary arrays
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (a[i][j] == 1) {
					a[i][0] = 1;
					a[0][j] = 1;
				}
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (a[i][0] == 1 || a[0][j] == 1) {
					a[i][j] = 1;
				}
			}
		}

		if (rowFlag) {
			for (int i = 0; i < m; i++)
				a[i][0] = 1;
		}
		if (colFlag) {
			for (int i = 0; i < n; i++)
				a[0][i] = 1;
		}
	}

	// Time : O(m*n) , Space : O(m+n)
	public static void makeRowsAndColumns1IfCellIs1(int[][] a, int m, int n) {
		int r[] = new int[m];
		int c[] = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1) {
					r[i] = 1;
					c[j] = 1;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (r[i] == 1 || c[j] == 1) {
					a[i][j] = 1;
				}
			}
		}
	}
}
