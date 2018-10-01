package com.raj.leetcode.google;

import com.interview.graph.CommonUtil;

/**
 * 
 * @author Raj
 * 
 * Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * 
 */
public class LongestIncreasingPathInMatrix {

	int moves[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/discuss/78308/15ms-Concise-Java-Solution
	// Time : O(m*n), Space : O(m*n)
	public int longestIncreasingPath(int[][] matrix) {
		int cache[][] = new int[matrix.length][matrix[0].length];
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int res = dfs(matrix, i, j, cache);
				max = Math.max(max, res);
			}
		}
		CommonUtil.print2DArray(cache, matrix.length, matrix[0].length);
		return max;
	}

	private int dfs(int[][] matrix, int i, int j, int[][] cache) {
		if (cache[i][j] != 0)
			return cache[i][j];
		int max = 1;
		for (int move[] : moves) {
			int x = i + move[0], y = j + move[1];
			if (isSafe(matrix, x, y) && matrix[i][j] > matrix[x][y]) {
				int cur = 1 + dfs(matrix, x, y, cache);
				max = Math.max(cur, max);
			}
		}

		cache[i][j] = max;
		return max;
	}

	private boolean isSafe(int a[][], int x, int y) {
		return x >= 0 && x < a.length && y >= 0 && y < a[0].length;
	}

	public static void main(String[] args) {
		LongestIncreasingPathInMatrix obj = new LongestIncreasingPathInMatrix();
		int result = -1;
		int[][] a = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1, } };
		result = obj.longestIncreasingPath(a);
		System.out.println(result);

		int[][] b = { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 2, 1 } };
		result = obj.longestIncreasingPath(b);
		System.out.println(result);
	}

}
