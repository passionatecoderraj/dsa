package com.raj.dp;

/**
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example, There is one obstacle in the middle of a 3x3 grid as illustrated
 * below.
 * 
 * [ [0,0,0], [0,1,0], [0,0,0] ] The total number of unique paths is 2.
 * 
 * @author Raj
 *
 */
public class UniquePaths2 {

	public static int uniquePathsWithObstacles(int a[][]) {
		int m = a.length, n = a[0].length;
		int t[][] = new int[m][n];

		for (int i = 0; i < m; i++) {
			if (a[i][0] == 1)
				break;
			t[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			if (a[0][i] == 1)
				break;
			t[0][i] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (a[i][j] != 1) {
					t[i][j] = t[i - 1][j] + t[i][j - 1];
				}
			}
		}

		return t[m - 1][n - 1];
	}

	public static void main(String[] args) {
		int result = -1;
		int a[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		result = uniquePathsWithObstacles(a);
		System.out.println(result);
	}
}
