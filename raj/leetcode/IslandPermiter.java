/**
 * 
 */
package com.raj.leetcode;

/**
 * @author Raj
 * 
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 

Example:

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16

Explanation: The perimeter is the 16 yellow stripes in the image below:

 *
 */
public class IslandPermiter {

	/*
	 * 
	 loop over the matrix and count the number of islands;
	 if the current dot is an island, count if it has any right neighbour or down neighbour;
	 the result is islands * 4 - neighbours * 2
	 */
	// Time : O(m*n), Space : O(1)
	// https://leetcode.com/problems/island-perimeter/discuss/95001/clear-and-easy-java-solution
	public int islandPerimeter(int[][] a) {
		if (null == a || a.length == 0)
			return 0;
		int m = a.length;
		int n = a[0].length;
		int islands = 0, neighbours = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1) {
					islands++;
					if (i + 1 < m && a[i + 1][j] == 1)
						neighbours++;
					if (j + 1 < n && a[i][j + 1] == 1)
						neighbours++;
				}
			}
		}

		return islands * 4 - neighbours * 2;
	}

	int moves[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };;
	int res = 0;

	// Time : O(m*n), Space : O(m*n)
	public int islandPerimeter2(int[][] a) {
		if (null == a || a.length == 0)
			return 0;
		int m = a.length;
		int n = a[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1 && !visited[i][j]) {
					dfs(a, i, j, m, n, visited);
				}
			}
		}
		return res;
	}

	private void dfs(int[][] a, int i, int j, int m, int n, boolean[][] visited) {
		visited[i][j] = true;
		int neighbour_islands = 0;
		for (int[] move : moves) {
			int x = move[0] + i;
			int y = move[1] + j;
			if (isSafe(a, m, n, x, y) && a[x][y] == 1) {
				neighbour_islands++;
				if (!visited[x][y])
					dfs(a, x, y, m, n, visited);
			}
		}
		res += (4 - neighbour_islands);
	}

	private boolean isSafe(int[][] a, int m, int n, int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n;
	}

	public static void main(String[] args) {
		IslandPermiter obj = new IslandPermiter();
		int result = -1;
		int a[][] = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 }, };

		// Time :O(rows*cols), Space : O(rows*cols)
		result = obj.islandPerimeter(a);
		System.out.println(result);

	}
}
