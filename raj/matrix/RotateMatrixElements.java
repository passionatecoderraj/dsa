package com.raj.matrix;

import com.interivew.graph.CommonUtil;

public class RotateMatrixElements {
	public static void main(String args[]) throws Exception {

		int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int m = a.length, n = a[0].length;
		CommonUtil.print2DArray(a, m, n);
		// Time : O(m+n)
		rotateMatrix(a, m, n);
		CommonUtil.print2DArray(a, m, n);
	}

	private static void rotateMatrix(int[][] a, int m, int n) {
		int top, bottom, left, right;
		top = 0;
		bottom = m - 1;
		left = 0;
		right = n - 1;
		int prev, cur;
		while (top <= bottom && left <= right) {
			prev = a[top + 1][left];
			for (int i = left; i <= right; i++) {
				cur = a[top][i];
				a[top][i] = prev;
				prev = cur;
			}
			top++;

			for (int i = top; i <= bottom; i++) {
				cur = a[i][right];
				a[i][right] = prev;
				prev = cur;
			}
			right--;

			for (int i = right; i >= left; i--) {
				cur = a[bottom][i];
				a[bottom][i] = prev;
				prev = cur;
			}
			bottom--;

			for (int i = bottom; i >= top; i--) {
				cur = a[i][left];
				a[i][left] = prev;
				prev = cur;
			}
			left++;
		}
	}

}
