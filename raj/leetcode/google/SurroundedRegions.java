/**
 * 
 */
package com.raj.leetcode.google;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class SurroundedRegions {

	int moves[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public void solve(char[][] a) {
		if (a == null || a.length == 0) {
			return;
		}

		// first column and last column
		for (int i = 0; i < a.length; i++) {
			dfs(a, i, 0);
			dfs(a, i, a[0].length - 1);
		}

		// first row and last row
		for (int j = 1; j < a[0].length - 1; j++) {
			dfs(a, 0, j);
			dfs(a, a.length - 1, j);

		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] == 'O') {
					a[i][j] = 'X';
				}
			}
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] == '*') {
					a[i][j] = 'O';
				}
			}
		}
	}

	private void dfs(char[][] a, int i, int j) {
		if (!isSafe(a, i, j) || a[i][j] != 'O')
			return;
		a[i][j] = '*';
		for (int move[] : moves) {
			int x = move[0] + i;
			int y = move[1] + j;
			dfs(a, x, y);
		}
	}

	private boolean isSafe(char[][] a, int x, int y) {
		return x >= 0 && x < a.length && y >= 0 && y < a[0].length;
	}

	public static void main(String[] args) {
		SurroundedRegions obj = new SurroundedRegions();

		char a[][] = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'X' } };
		obj.solve(a);
		CommonUtil.print2DArray(a, a.length, a[0].length);
	}

}
