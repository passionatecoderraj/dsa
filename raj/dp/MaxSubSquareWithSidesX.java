package com.raj.dp;

import com.interivew.graph.CommonUtil;

public class MaxSubSquareWithSidesX {

	public static void main(String[] args) {
		// char[][] a = { { 'X', 'O', 'O', 'O', 'O', 'O' }, { 'O', 'O', 'O',
		// 'O', 'O', 'O' },
		// { 'X', 'X', 'X', 'X', 'O', 'O' }, { 'X', 'X', 'X', 'X', 'X', 'O' }, {
		// 'X', 'O', 'O', 'X', 'X', 'O' },
		// { 'X', 'O', 'X', 'X', 'X', 'O' } };
//		char[][] a = { { 'O', 'O', 'O', 'O', 'X' }, { 'X', 'O', 'X', 'X', 'X' }, { 'X', 'O', 'X', 'O', 'X' },
//				{ 'X', 'X', 'X', 'X', 'X' }, { 'O', 'O', 'X', 'X', 'X' }, };

		char[][] a = { { 'O', 'O', 'O', 'O', 'O', 'X' }, { 'O', 'X', 'O', 'X', 'X', 'X' },
				{ 'O', 'X', 'O', 'X', 'O', 'X' }, { 'O', 'X', 'X', 'X', 'X', 'X' }, { 'O', 'O', 'O', 'O', 'O', 'O' }, };

		int result = -1, m = a.length, n = a[0].length;
		MaxSubSquareWithSidesX obj = new MaxSubSquareWithSidesX();
		// Time : O(n3)
		result = obj.maxSubSquareMatrixWithSidesX(a, m, n);
		System.out.println(result);
	}

	public int maxSubSquareMatrixWithSidesX(char[][] a, int m, int n) {
		Point t[][] = new Point[m][n];
		if (a[0][0] == 'X')
			t[0][0] = new Point(1, 1);

		else
			t[0][0] = new Point(0, 0);

		for (int i = 1; i < n; i++) {
			if (a[0][i] == 'X')
				t[0][i] = new Point(t[0][i - 1].x + 1, 1);
			else
				t[0][i] = new Point(0, 0);
		}

		for (int i = 1; i < m; i++) {
			if (a[i][0] == 'X')
				t[i][0] = new Point(1, t[i - 1][0].y + 1);
			else
				t[i][0] = new Point(0, 0);
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (a[i][j] == 'X')
					t[i][j] = new Point(t[i][j - 1].x + 1, t[i - 1][j].y + 1);
				else
					t[i][j] = new Point(0, 0);
			}
		}

		CommonUtil.print2DArray(t, m, n);

		int min, _i, _j;
		int maxSize = Integer.MIN_VALUE;
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				min = Math.min(t[i][j].x, t[i][j].y);
				for (int k = min; k >= 2; k--) {
					_i = i - k + 1;
					_j = j - k + 1;
					if (_i >= 0 && _j >= 0 && t[_i][j].x >= k && t[i][_j].y >= k) {
						maxSize = Integer.max(k, maxSize);
					}
				}
			}
		}

		return maxSize;
	}

}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(x=" + x + ", y=" + y + ")";
	}
}
