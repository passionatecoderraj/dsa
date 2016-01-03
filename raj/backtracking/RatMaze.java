/**
 * 
 */
package com.raj.backtracking;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class RatMaze {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		int m = a.length, n = a[0].length;
		;

		RatMaze obj = new RatMaze();
		obj.solveMaze(a, m, n);
	}

	public void solveMaze(int[][] a, int m, int n) {

		boolean result = false;
		int sol[][] = new int[n][n];

		result = solveMazeUtil(a, sol, m, n, 0, 0);
		if (result) {
			CommonUtil.print2DArray(sol, m, n);
		} else {
			System.out.println("No solution");
		}
	}

	public boolean solveMazeUtil(int[][] a, int[][] sol, int m, int n, int x, int y) {
		if (x == m - 1 && y == n - 1) {
			sol[x][y] = 9;
			return true;
		}

		if (isSafe(a, m, n, x, y)) {
			sol[x][y] = 9;
			if (solveMazeUtil(a, sol, m, n, x + 1, y)) {
				return true;
			}
			if (solveMazeUtil(a, sol, m, n, x, y + 1)) {
				return true;
			}
			sol[x][y] = 0;
		}

		return false;
	}

	public boolean isSafe(int[][] a, int m, int n, int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n && a[x][y] == 1;
	}

}
