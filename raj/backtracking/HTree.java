package com.raj.backtracking;

import com.interview.graph.CommonUtil;

/*
 * @Author Raj
 * 
 * 
 */

public class HTree {

	public static void main(String[] args) {
		HTree obj = new HTree();

		int matrix[][] = new int[20][20];
		obj.drawHTree(matrix, matrix.length / 2, matrix[0].length / 2, 8, 3, 1);
		CommonUtil.print2DArray(matrix, matrix.length, matrix[0].length);
	}

	public void drawHTree(int[][] matrix, int x, int y, int n, int depth, int value) {
		if (depth <= 0)
			return;

		drawLine(matrix, x, y - n / 2, x, y + n / 2, value);
		drawLine(matrix, x - n / 2, y - n / 2, x + n / 2, y - n / 2, value);
		drawLine(matrix, x - n / 2, y + n / 2, x + n / 2, y + n / 2, value);

		int newN = n / 2;
		drawHTree(matrix, x - 1 - n / 2, y - 1 - n / 2, newN, depth - 1, value + 1);
		drawHTree(matrix, x - 1 - n / 2, y + 1 + n / 2, newN, depth - 1, value + 1);
		drawHTree(matrix, x + 1 + n / 2, y - 1 - n / 2, newN, depth - 1, value + 1);
		drawHTree(matrix, x + 1 + n / 2, y + 1 + n / 2, newN, depth - 1, value + 1);
	}

	void drawLine(int[][] matrix, int x1, int y1, int x2, int y2, int value) {
		for (int i = x1; i < x2; i++) {
			matrix[i][y1] = value;
		}
		for (int j = y1; j < y2; j++) {
			matrix[x1][j] = value;
		}

	}

}
