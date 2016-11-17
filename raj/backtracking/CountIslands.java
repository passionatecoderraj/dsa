/**
 * 
 */
package com.raj.backtracking;

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
		result = obj.countIslands(a);
		System.out.println(result);

	}

	public int countIslands(int a[][]) {
		int count = 0, m = a.length, n = a[0].length;
		boolean visited[][] = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1 && !visited[i][j]) {
					count++;
					dfs(a, i, j, visited);
				}
			}
		}
		return count;
	}

	private void dfs(int[][] a, int i, int j, boolean[][] visited) {
		if (!isSafe(a, a.length, a[0].length, i, j, visited))
			return;
		visited[i][j] = true;
		dfs(a, i + 1, j + 1, visited);
		dfs(a, i + 1, j - 1, visited);
		dfs(a, i + 1, j, visited);
		dfs(a, i, j - 1, visited);
		dfs(a, i, j + 1, visited);
		dfs(a, i - 1, j + 1, visited);
		dfs(a, i - 1, j - 1, visited);
		dfs(a, i - 1, j, visited);
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
			if (isSafe(a, m, n, x1, y1, visited)) {
				dfsForNeighbours(a, m, n, visited, x1, y1, moves);
			}
		}
	}

	public boolean isSafe(int[][] a, int m, int n, int x, int y, boolean[][] visited) {
		return x >= 0 && x < m && y >= 0 && y < n && a[x][y] == 1 && !visited[x][y];
	}

}
