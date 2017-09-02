package com.raj.matrix;

import com.interview.graph.CommonUtil;

public class SpiralTraversal {
	public static void main(String args[]) throws Exception {

		int a[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 }, };

		int m = a.length, n = a[0].length;
		CommonUtil.print2DArray(a, m, n);
		// Time : O(m+n)
		printSprial(a, m, n);
	}

	private static void printSprial(int[][] a, int m, int n) {
		int top, bottom, left, right;
		top = 0;
		bottom = m - 1;
		left = 0;
		right = n - 1;
		while (top <= bottom && left <= right) {

			for (int i = left; i <= right; i++) {
				System.out.print(a[top][i] + " ");
			}
			top++;
			for (int i = top; i <= bottom; i++) {
				System.out.print(a[i][right] + " ");
			}
			right--;

			if (top <= bottom) {
				for (int i = right; i >= left; i--) {
					System.out.print(a[bottom][i] + " ");
				}
				bottom--;
			}

			if (left <= right) {
				for (int i = bottom; i >= top; i--) {
					System.out.print(a[i][left] + " ");
				}
				left++;
			}
		}
	}

}
