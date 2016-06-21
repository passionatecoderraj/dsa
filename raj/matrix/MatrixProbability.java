package com.raj.matrix;

public class MatrixProbability {
	public static void main(String args[]) throws Exception {

		int m = 5, n = 5;
		MatrixProbability obj = new MatrixProbability();
		double result = -1;
		int N = 2;
		result = obj.probabilityThatMatrixWillNotCrossBoundaries(m, n, 1, 1, N);
		System.out.println(result);
	}

	public double probabilityThatMatrixWillNotCrossBoundaries(int m, int n, int x, int y, int N) {
		if (x < 0 || x >= m || y < 0 || y >= n) {
			return 0.0;
		}
		if (N == 0) {
			return 1.0;
		}
		double probability = 0.0;

		probability += probabilityThatMatrixWillNotCrossBoundaries(m, n, x, y - 1, N - 1) * 0.25;
		probability += probabilityThatMatrixWillNotCrossBoundaries(m, n, x - 1, y, N - 1) * 0.25;
		probability += probabilityThatMatrixWillNotCrossBoundaries(m, n, x + 1, y, N - 1) * 0.25;
		probability += probabilityThatMatrixWillNotCrossBoundaries(m, n, x, y + 1, N - 1) * 0.25;
		return probability;
	}
}
