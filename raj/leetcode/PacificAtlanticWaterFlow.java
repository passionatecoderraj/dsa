package com.raj.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author Raj
 * 
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:
The order of returned grid coordinates does not matter.
Both m and n are less than 150.
Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */
public class PacificAtlanticWaterFlow {

	// https://leetcode.com/problems/pacific-atlantic-water-flow/discuss/90733/Java-BFS-and-DFS-from-Ocean
	
	// Time : O(m*n), Space : O(m*n)
	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new LinkedList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		int m = matrix.length, n = matrix[0].length;
		boolean[][] pacific = new boolean[m][n];
		boolean[][] atlantic = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
			dfs(matrix, atlantic, Integer.MIN_VALUE, i, n - 1);
		}
		for (int j = 0; j < n; j++) {
			dfs(matrix, pacific, Integer.MIN_VALUE, 0, j);
			dfs(matrix, atlantic, Integer.MIN_VALUE, m - 1, j);
		}
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (pacific[i][j] && atlantic[i][j])
					res.add(new int[] { i, j });
		return res;
	}

	int moves[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	private void dfs(int[][] matrix, boolean[][] pacific, int prev, int i, int j) {
		if (!(isSafe(matrix, i, j) && !pacific[i][j] && matrix[i][j] >= prev))
			return;
		pacific[i][j] = true;
		for (int move[] : moves) {
			dfs(matrix, pacific, matrix[i][j], i + move[0], j + move[1]);
		}

	}

	private boolean isSafe(int a[][], int x, int y) {
		return x >= 0 && x < a.length && y >= 0 && y < a[0].length;
	}

	public static void main(String[] args) {
		PacificAtlanticWaterFlow obj = new PacificAtlanticWaterFlow();
		List<int[]> result = null;
		int[][] a = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 }, { 5, 1, 1, 2, 4 } };
		result = obj.pacificAtlantic(a);
		for (int[] r : result)
			System.out.print(Arrays.toString(r) + ",");
	}

}
