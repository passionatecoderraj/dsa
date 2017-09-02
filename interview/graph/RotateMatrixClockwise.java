package com.interview.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RotateMatrixClockwise {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		N = 0;
		N = Integer.parseInt(br.readLine());

		int[][] matrix = new int[N][N];

		for (int i = 0; i < N; ++i) {

			String[] s = br.readLine().split("\\s+");
			int[] colValues = new int[s.length];

			for (int j = 0; j < colValues.length; ++j)
				colValues[j] = Integer.parseInt(s[j]);
			if (colValues.length > N || colValues.length < 0) {
				System.out.println("ERROR");
				return;
			}
			for (int j = 0; j < colValues.length; ++j)
				matrix[i][j] = colValues[j];
		}

		if (matrix.length != matrix[0].length)
			System.out.println("ERROR");

		// print2DArray(matrix, matrix.length, matrix[0].length);
		rotateMatrixByClockwise(matrix, matrix.length, matrix[0].length);
	}

	static void rotateMatrixByClockwise(int matrix[][], int m, int n) {

		int r = 0, c = 0;
		int pre, cur;

		while (r < m && c < n) {

			if (r + 1 == m || c + 1 == n)
				break;

			pre = matrix[r + 1][c];

			for (int i = c; i < n; i++) {
				cur = matrix[r][i];
				matrix[r][i] = pre;
				pre = cur;
			}
			r++;

			for (int i = r; i < m; i++) {
				cur = matrix[i][n - 1];
				matrix[i][n - 1] = pre;
				pre = cur;
			}
			n--;

			if (r < m) {
				for (int i = n - 1; i >= c; i--) {
					cur = matrix[m - 1][i];
					matrix[m - 1][i] = pre;
					pre = cur;
				}
			}
			m--;
			if (c < n) {
				for (int i = m - 1; i >= r; i--) {
					cur = matrix[i][c];
					matrix[i][c] = pre;
					pre = cur;
				}
			}
			c++;
		}

		print2DArray(matrix, matrix.length, matrix[0].length);

	}

	static void print2DArray(int[][] t, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
	}

}