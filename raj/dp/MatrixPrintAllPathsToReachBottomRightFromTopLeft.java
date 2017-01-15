package com.raj.dp;

/*
 * http://algorithms.tutorialhorizon.com/print-all-paths-from-top-left-to-bottom-right-in-two-dimensional-array/
 */
public class MatrixPrintAllPathsToReachBottomRightFromTopLeft {

	public static void main(String[] args) {
		MatrixPrintAllPathsToReachBottomRightFromTopLeft obj = new MatrixPrintAllPathsToReachBottomRightFromTopLeft();
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
		int m = a.length, n = a[0].length;
		obj.printAllPaths(a, m - 1, n - 1, "");
	}

	public void printAllPaths(int[][] a, int i, int j, String path) {
		if (i < 0 || j < 0)
			return;

		if (i == 0) {
			for (int k = j; k >= 0; k--)
				path = a[0][k] + "-" + path;
			System.out.println(path);
			return;
		}

		if (j == 0) {
			for (int k = i; k >= 0; k--)
				path = a[k][0] + "-" + path;
			System.out.println(path);
			return;
		}
		path = a[i][j] + "-" + path;
		printAllPaths(a, i, j - 1, path);
		printAllPaths(a, i - 1, j, path);
		printAllPaths(a, i - 1, j - 1, path);
	}

}
