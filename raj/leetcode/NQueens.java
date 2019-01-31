/**
 * 
 */
package com.raj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 *
 *The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class NQueens {

	// https://leetcode.com/problems/n-queens/discuss/19805/My-easy-understanding-Java-Solution
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		String[][] a = new String[n][n];
		for (int i = 0; i < n; i++)
			Arrays.fill(a[i], ".");
		solve(0, n, a, res);
		return res;
	}

	private void solve(int i, int n, String[][] a, List<List<String>> res) {
		if (i == n) {
			List<String> list = new ArrayList<>();
			for (String r[] : a)
				list.add(String.join("", r));
			res.add(list);
			return;
		}
		for (int j = 0; j < n; j++) {
			if (canPlace(i, j, n, a)) {
				a[i][j] = "Q";
				solve(i + 1, n, a, res);
				a[i][j] = ".";
			}
		}

	}

	private boolean canPlace(int i, int j, int n, String[][] a) {
		for (int x = 0; x <= i; x++) {
			for (int y = 0; y < n; y++) {
				if (a[x][y].equals("Q") && (y == j || x + y == i + j || i - x == j - y)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		NQueens obj = new NQueens();

		// obj.solveNQueen(4);
		List<List<String>> res = obj.solveNQueens(4);
		System.out.println(res);
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
		for (int i = 0; i < row; i++) {
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
