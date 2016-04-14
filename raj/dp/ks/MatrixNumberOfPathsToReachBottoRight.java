package com.raj.dp.ks;

public class MatrixNumberOfPathsToReachBottoRight {

	public static void main(String[] args) {
		MatrixNumberOfPathsToReachBottoRight obj = new MatrixNumberOfPathsToReachBottoRight();
		int result = -1, m = 4, n = 4;
		result = obj.numberofPathsToReachBottomRightFromTopLeftBruteForce(m, n);
		System.out.println(result);

		result = obj.numberofPathsToReachBottomRightFromTopLeft(m, n);
		System.out.println(result);
	}

	public int numberofPathsToReachBottomRightFromTopLeftBruteForce(int m, int n) {
		if (m == 1 || n == 1)
			return 1;
		return numberofPathsToReachBottomRightFromTopLeftBruteForce(m - 1, n)
				+ numberofPathsToReachBottomRightFromTopLeftBruteForce(m, n - 1);
	}

	public int numberofPathsToReachBottomRightFromTopLeft(int m, int n) {
		if (m <= 0 || n <= 0)
			return -1;
		if (m == 1 && n == 1)
			return 1;

		int t[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			t[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			t[0][i] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				t[i][j] = t[i - 1][j] + t[i][j - 1];
			}
		}

		return t[m - 1][n - 1];
	}

}
