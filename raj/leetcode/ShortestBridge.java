/**
 * 
 */
package com.raj.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Raj
 * In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)

Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.

Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)

 

Example 1:

Input: [[0,1],[1,0]]
Output: 1
Example 2:

Input: [[0,1,0],[0,0,0],[0,0,1]]
Output: 2
Example 3:

Input: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1
 

Note:

1 <= A.length = A[0].length <= 100
A[i][j] == 0 or A[i][j] == 1
 *
 */
public class ShortestBridge {

	int moves[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };;

	// https://leetcode.com/problems/shortest-bridge/discuss/189321/Java-DFS-find-the-island-greater-BFS-expand-the-island
	// Time : O(m*n), Space : O(m*n)
	public int shortestBridge(int[][] a) {
		if (a.length == 0)
			return 0;
		int m = a.length, n = a[0].length;
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[m][n];

		outer: for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1) {
					color(a, m, n, i, j, q, visited);
					break outer;
				}
			}
		}

		// bfs
		int steps = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				for (int move[] : moves) {
					int x = cur[0] + move[0];
					int y = cur[1] + move[1];
					if (isSafe(a, m, n, x, y) && !visited[x][y]) {
						if (a[x][y] == 1) {
							// since we are finding the no. of cells between starting and ending
							return steps;
						} else if (a[x][y] == 0) {
							visited[x][y] = true;
							q.offer(new int[] { x, y });
						}

					}
				}
			}
			steps++;
		}
		return Integer.MAX_VALUE;
	}

	private void color(int[][] a, int m, int n, int i, int j, Queue<int[]> q, boolean[][] visited) {
		if (!isSafe(a, m, n, i, j) || a[i][j] != 1 || visited[i][j])
			return;
		visited[i][j] = true;
		q.offer(new int[] { i, j });
		for (int move[] : moves) {
			color(a, m, n, i + move[0], j + move[1], q, visited);
		}
	}
	
	
	// Time : O(m*n), Space : O(1)
	public int shortestBridge2(int[][] a) {
		if (a.length == 0)
			return 0;
		int m = a.length, n = a[0].length;
		Queue<int[]> q = new LinkedList<>();

		outer: for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1) {
					color(a, m, n, i, j, 2, q);
					break outer;
				}
			}
		}
		// bfs without additional space
		int color = 3;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				for (int move[] : moves) {
					int x = cur[0] + move[0];
					int y = cur[1] + move[1];
					if (isSafe(a, m, n, x, y)) {
						if (a[x][y] == 1) {
							// since we are finding the no. of cells between starting and ending
							return color - 2 - 1;
						} else if (a[x][y] == 0) {
							a[x][y] = color;
							q.offer(new int[] { x, y });
						}

					}
				}
			}
			color++;
		}
		return Integer.MAX_VALUE;
	}

	private void color(int[][] a, int m, int n, int i, int j, int color, Queue<int[]> q) {
		if (!isSafe(a, m, n, i, j) || a[i][j] != 1)
			return;
		a[i][j] = color;
		q.offer(new int[] { i, j });
		for (int move[] : moves) {
			color(a, m, n, i + move[0], j + move[1], color, q);
		}
	}

	public int shortestBridge_using_manhattan_distance(int[][] a) {
		if (a.length == 0)
			return 0;
		int m = a.length, n = a[0].length;
		List<int[]> first_island = new ArrayList<>();
		outer: for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1) {
					color(a, m, n, i, j, 2, first_island);
					break outer;
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1) {
					for (int[] p : first_island) {
						min = Math.min(min, Math.abs(p[0] - i) + Math.abs(p[1] - j) - 1);
					}
				}
			}
		}
		return min;
	}

	private void color(int[][] a, int m, int n, int i, int j, int color, List<int[]> first_island) {
		if (!isSafe(a, m, n, i, j) || a[i][j] != 1)
			return;
		a[i][j] = color;
		first_island.add(new int[] { i, j });
		for (int move[] : moves) {
			color(a, m, n, i + move[0], j + move[1], color, first_island);
		}
	}

	private boolean isSafe(int[][] a, int m, int n, int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n;
	}

	public static void main(String[] args) {
		ShortestBridge obj = new ShortestBridge();
		int result = -1;
		int a[][] = { 
				{ 1, 1, 1, 1, 1 }, 
				{ 1, 0, 0, 0, 1 }, 
				{ 1, 0, 1, 0, 1 }, 
				{ 1, 0, 0, 0, 1 }, 
				{ 1, 1, 1, 1, 1 } };

		result = obj.shortestBridge(a);
		System.out.println(result);

	}
}
