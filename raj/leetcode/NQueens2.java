/**
 * 
 */
package com.raj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Raj
 * 
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example:

Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 *
 */
public class NQueens2 {

	public int totalNQueens(int n) {
		Set<List<String>> res = new HashSet<>();
		String[][] a = new String[n][n];
		for (int i = 0; i < n; i++)
			Arrays.fill(a[i], ".");
		solve(0, n, a, res);
		return res.size();
	}

	private void solve(int i, int n, String[][] a, Set<List<String>> res) {
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
		NQueens2 obj = new NQueens2();
		int res = obj.totalNQueens(4);
		System.out.println(res);
	}

}
