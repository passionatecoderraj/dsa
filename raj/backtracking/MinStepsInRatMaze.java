
/**
 * 
 */
package com.raj.backtracking;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class MinStepsInRatMaze {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		int m = a.length, n = a[0].length;
	
		MinStepsInRatMaze obj = new MinStepsInRatMaze();
	//	obj.solveMaze(a, m, n);
		obj.solveMazel(a, m, n);
	}

	public void solveMazel(int[][] a, int m, int n) {

		boolean result = false;
		int sol[][] = new int[n][n];
		int[][] moves = { { 0, 1 }, { 1, 0 } };

		result = solveMazeUtill(a, sol, m, n, 0, 0, moves);
		if (result) {
			CommonUtil.print2DArray(sol, m, n);
		} else {
			System.out.println("No solution");
		}
	}

	public boolean solveMazeUtill(int[][] a, int[][] sol, int m, int n, int x, int y, int[][] moves) {
		if (x == m - 1 && y == n - 1) {
			sol[x][y] = 9;
			return true;
		}

		int next_x, next_y;
		for (int i = 0; i < moves.length; i++) {
			next_x = x + moves[i][0];
			next_y = y + moves[i][1];
			if (isSafe(a, m, n, next_x, next_y)) {
				sol[x][y] = 9;
				if (solveMazeUtill(a, sol, m, n, next_x, next_y, moves))
					return true;
				else
					sol[x][y] = 0;
			}

		}
		return false;
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
