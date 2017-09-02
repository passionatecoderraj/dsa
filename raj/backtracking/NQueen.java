/**
 * 
 */
package com.raj.backtracking;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class NQueen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NQueen obj = new NQueen();

		obj.solveNQueen(4);
	}

	public void solveNQueen(int n) {
		int a[][] = new int[n][n];

		int row = 0;
		if (solveNQueenUtil(a, n, row)) {
			CommonUtil.print2DArray(a, n, n);
		} else {
			System.out.println("no solution");
		}
	}

	public boolean solveNQueenUtil(int[][] a, int n, int row) {
		if (row == n) {
			return true;
		}
		for (int col = 0; col < n; col++) {
			if (isSafe(a, n, row, col)) {
				a[row][col] = 1;
				if (solveNQueenUtil(a, n, row + 1))
					return true;
				else
					a[row][col] = 0;
			}
		}

		return false;
	}

	public boolean isSafe(int[][] a, int n, int row, int col) {
		for (int i = 0; i <row; i++) {
			if (a[i][col] == 1)
				return false;
		}
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (a[i][j] == 1)
				return false;
		}

		for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
			if (a[i][j] == 1)
				return false;
		}

		return true;
	}

}
