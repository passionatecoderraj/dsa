/**
 * 
 */
package com.raj.leetcode;

/**
 * @author Raj
 * 
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:

[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.

Accepted
53,914
Submissions
100,051
 *
 */
public class MaxAreaOfIsland {

	int moves[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };;

	// Time : O(m*n), Space : O(1)
	public int maxAreaOfIsland(int[][] a) {
		if (null == a || a.length == 0)
			return 0;
		int m = a.length;
		int n = a[0].length;
		int area = 0, maxArea = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1) {
					area = dfs(a, i, j, 1, m, n);
				}
				maxArea = Math.max(area, maxArea);
			}
		}
		return maxArea;
	}

	private int dfs(int[][] a, int i, int j, int area, int m, int n) {
		a[i][j] = 0;
		for (int[] move : moves) {
			int x = move[0] + i;
			int y = move[1] + j;
			if (isSafe(a, m, n, x, y)) {
				area += dfs(a, x, y, 1, m, n);
			}
		}
		return area;
	}

	private boolean isSafe(int[][] a, int m, int n, int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n && a[x][y] == 1;
	}

	public static void main(String[] args) {
		MaxAreaOfIsland obj = new MaxAreaOfIsland();
		int result = -1;
		int a[][] = 
					{{0,0,1,0,0,0,0,1,0,0,0,0,0},
					 {0,0,0,0,0,0,0,1,1,1,0,0,0},
					 {0,1,1,0,1,0,0,0,0,0,0,0,0},
					 {0,1,0,0,1,1,0,0,1,0,1,0,0},
					 {0,1,0,0,1,1,0,0,1,1,1,0,0},
					 {0,0,0,0,0,0,0,0,0,0,1,0,0},
					 {0,0,0,0,0,0,0,1,1,1,0,0,0},
					 {0,0,0,0,0,0,0,1,1,0,0,0,0}};

		// Time :O(rows*cols), Space : O(rows*cols)
		result = obj.maxAreaOfIsland(a);
		System.out.println(result);

	}
}
