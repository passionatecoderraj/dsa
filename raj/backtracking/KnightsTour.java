/**
 * 
 */
package com.raj.backtracking;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class KnightsTour {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KnightsTour obj = new KnightsTour();
		obj.solveKT();

	}

	public void solveKT() {
		int n = 6;
		int a[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = -1;
			}
		}
		int moves[][] = { { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }, { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 } };

		boolean result = false;
		a[0][0] = 0;
		result = solveKTUtil(a, n, 0, 0, 1, moves);
		if (result) {
			CommonUtil.print2DArray(a, n, n);
		} else {
			System.out.println("No solution");
		}
	}

	public boolean solveKTUtil(int[][] a, int n, int x, int y, int move_no, int[][] moves) {
		// if (isSolved(a, n)) {
		// return true;
		// }
		if (move_no == n * n)
			return true;

		for (int i = 0; i < moves.length; i++) {
			int next_x = x + moves[i][0];
			int next_y = y + moves[i][1];
			if (isSafeToMove(a, n, next_x, next_y)) {
				a[next_x][next_y] = move_no;
				if (solveKTUtil(a, n, next_x, next_y, move_no + 1, moves)) {
					return true;
				} else {
					// backtracking;
					a[next_x][next_y] = -1;
				}
			}
		}
		return false;
	}

	public boolean isSafeToMove(int a[][], int n, int x, int y) {
		if (x >= 0 && x < n && y >= 0 && y < n && a[x][y] == -1) {
			return true;
		}
		return false;
	}
}
