package com.raj.matrix;

import com.interivew.graph.CommonUtil;

public class SimpleMatrixMultiplication {
	public static void main(String args[]) throws Exception {

		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
		int b[][] = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		SimpleMatrixMultiplication obj = new SimpleMatrixMultiplication();
		int c[][] = obj.multiply(a, b);

		CommonUtil.print2DArray(c, c.length, c[0].length);

	}

	public int[][] multiply(int[][] a, int[][] b) {
		if (a[0].length != b.length)
			return null;
		int c[][] = new int[a.length][b[0].length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				for (int k = 0; k < a[0].length; k++) {
					c[i][j] += (a[i][k] * b[k][j]);
				}
			}
		}
		return c;
	}

}
