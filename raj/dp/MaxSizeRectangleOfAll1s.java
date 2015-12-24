package com.raj.dp;

import com.raj.stack.MaxAreaOfHistogram;

public class MaxSizeRectangleOfAll1s {

	public static void main(String[] args) {
		 int a[][] = {
		 { 0, 1, 1, 0, 1 },
		 { 1, 1, 1, 1, 0 },
		 { 0, 1, 1, 1, 0 },
		 { 1, 1, 1, 1, 0 },
		 { 1, 1, 1, 1, 1 },
		 { 0, 0, 0, 0, 0 } };

//		int a[][] = { { 1, 0, 0, 1, 1, 1 }, { 1, 0, 1, 1, 0, 1 }, { 0, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 1, 1 } };

		int result = -1, m = 6, n = 5;
		MaxSizeRectangleOfAll1s obj = new MaxSizeRectangleOfAll1s();
		result = obj.maxSubSquareMatrix(a, m, n);
		System.out.println(result);
	}

	public int maxSubSquareMatrix(int[][] a, int m, int n) {
		int t[] = new int[n];
		int maxArea = -1, curMax = -1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 0) {
					t[j] = 0;
				} else {
					t[j] += a[i][j];
				}
			}
			curMax = new MaxAreaOfHistogram().maxAreaOfHistogram(t);
			maxArea = Math.max(curMax, maxArea);
		}
		return maxArea;
	}
}
