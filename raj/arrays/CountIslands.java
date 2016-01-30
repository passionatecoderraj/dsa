/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */
public class CountIslands {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountIslands obj = new CountIslands();
		int result = -1;
		int a[][] = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 } };

		// Time :O(rows*cols), Space : O(rows*cols)
		result = obj.countIslands(a, a.length, a[0].length);
		System.out.println(result);

	}

	public int countIslands(int[][] a, int m, int n) {
		boolean visited[][] = new boolean[m][n];
		int count = 0;
		int moves[][] = { { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 }, { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1 && visited[i][j] == false) {
					count++;
					dfsForNeighbours(a, m, n, visited, i, j, moves);
				}
			}
		}
		return count;
	}

	public void dfsForNeighbours(int[][] a, int m, int n, boolean[][] visited, int x, int y, int[][] moves) {
		int x1 = 0, y1 = 0;
		visited[x][y] = true;
		for (int i = 0; i < moves.length; i++) {
			x1 = x + moves[i][0];
			y1 = y + moves[i][1];
			if (isSafe(a, m, n, x1, y1)) {
				visited[x1][y1] = true;
			}
		}
	}

	public boolean isSafe(int[][] a, int m, int n, int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n && a[x][y] == 1;
	}

}
