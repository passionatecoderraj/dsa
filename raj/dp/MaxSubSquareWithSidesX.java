package com.raj.dp;

import com.interivew.graph.CommonUtil;

public class MaxSubSquareWithSidesX {

	public static void main(String[] args) {
		// char[][] a = { { 'X', 'O', 'O', 'O', 'O', 'O' }, { 'O', 'O', 'O',
		// 'O', 'O', 'O' },
		// { 'X', 'X', 'X', 'X', 'O', 'O' }, { 'X', 'X', 'X', 'X', 'X', 'O' }, {
		// 'X', 'O', 'O', 'X', 'X', 'O' },
		// { 'X', 'O', 'X', 'X', 'X', 'O' } };
		// char[][] a = { { 'O', 'O', 'O', 'O', 'X' }, { 'X', 'O', 'X', 'X', 'X'
		// }, { 'X', 'O', 'X', 'O', 'X' },
		// { 'X', 'X', 'X', 'X', 'X' }, { 'O', 'O', 'X', 'X', 'X' }, };

		char[][] a = { { 'O', 'O', 'O', 'O', 'O', 'X' }, { 'O', 'X', 'O', 'X', 'X', 'X' },
				{ 'O', 'X', 'O', 'X', 'O', 'X' }, { 'O', 'X', 'X', 'X', 'X', 'X' }, { 'O', 'O', 'O', 'O', 'O', 'O' }, };

		int result = -1, m = 5, n = 6;
		MaxSubSquareWithSidesX obj = new MaxSubSquareWithSidesX();
		result = obj.maxSubSquareWithSidesX(a, m, n);
		System.out.println(result);
	}

	public int maxSubSquareWithSidesX(char[][] a, int m, int n) {
		int max = 1;
		Cell maxCell = null;
		if (m < 0 && n < 0)
			return max;
		Cell[][] t = new Cell[m][n];
		if (a[0][0] == 'O') {
			t[0][0] = new Cell(0, 0);
		} else {
			t[0][0] = new Cell(1, 1);
		}

		for (int i = 1; i < n; i++) {
			if (a[0][i] == 'O') {
				t[0][i] = new Cell(0, 0);
			} else {
				t[0][i] = new Cell(1 + t[0][i - 1].x, 1);
			}
		}

		for (int i = 1; i < m; i++) {
			if (a[i][0] == 'O') {
				t[i][0] = new Cell(0, 0);
			} else {
				t[i][0] = new Cell(1, 1 + t[i - 1][0].y);
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (a[i][j] == 'O') {
					t[i][j] = new Cell(0, 0);
				} else {
					t[i][j] = new Cell(1 + t[i][j - 1].x, 1 + t[i - 1][j].y);
				}
			}
		}
		CommonUtil.print2DArray(t, m, n);

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int min = Math.min(t[i][j].x, t[i][j].y);
				for (int k = min; k >= 2; k--) {
					int p = i - k + 1;
					int q = j - k + 1;
					if (p >= 0 && q >= 0 && t[i][p].y >= k && t[q][j].x >= k) {
						max = Math.max(max, k);
						maxCell = t[i][j];
					}

				}
			}
		}

		System.out.println(maxCell);
		return max;
	}

}

class Cell {
	int x;
	int y;

	public Cell(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(x=" + x + ", y=" + y + ")";
	}
}
