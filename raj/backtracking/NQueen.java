/**
 * 
 */
package com.raj.backtracking;

import com.interivew.graph.CommonUtil;

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

		// TODO: Not complete
		obj.solveNQueen(4);
	}

	public void solveNQueen(int n) {
		int a[][] = new int[n][n];
		if (solveNQueenUtil(a, n, 0, 1)) {
			CommonUtil.print2DArray(a, n, n);
		} else {
			System.out.println("no solution");
		}
	}

	public boolean solveNQueenUtil(int[][] a, int n, int x, int count) {
		if (count > n) {
			return true;
		}
		for (int i = 0; i < n; i++) {
			a[x][i] = count;
			if (isSafe(a, n, x + 1, count + 1)) {
				return true;
			}
			a[x][i] = 0;
		}

		return false;
	}

	public boolean isSafe(int a[][], int n, int x, int y) {
		for (int i = 0; i < n; i++) {
			if (a[i][y] > 0 || a[x][i] > 0) {
				return false;
			}
		}

		int reset = Math.min(x, y) - 1;

		for (int i = reset - x, j = reset - y; i < n && j < n; i++, j++) {
			if (a[i][j] > 0)
				return false;
		}

		for (int i = reset - x, j = reset + y; i < n && j >= 0; i++, j--) {
			if (a[i][j] > 0)
				return false;
		}

		return true;
	}

}
