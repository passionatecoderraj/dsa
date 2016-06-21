package com.raj.dp;

import com.interivew.graph.CommonUtil;

public class MaxSumRectangle {

	public static void main(String[] args) {
		// int a[][] = { { 2, 1, -3, -4, 5 }, { 0, 6, 3, 4, 1 }, { 2, -2, -1, 4,
		// -5 }, { -3, 3, 1, 0, 3 } };
		int a[][] = { 
				{ 1, 2, -1, -4, -20 }, 
				{ -8, -3, 4, 2, 1 }, 
				{ 3, 8, 10, 1, 3 },
				{ -4, -1, 1, 7, -6 } };

		int result = -1, m = 4, n = 5;
		MaxSumRectangle obj = new MaxSumRectangle();
		result = obj.findMaxSumRectangle(a, m, n);
		System.out.println(result);
	}

	public int findMaxSumRectangle(int[][] a, int m, int n) {

		int maxSum = 0, maxLeft = -1, maxRight = -1, maxUp = -1, maxDown = -1;

		int b[];

		for (int l = 0; l < n; l++) {
			b = new int[m];
			for (int j = l; j < n; j++) {
				for (int i = 0; i < m; i++) {
					b[i] = b[i] + a[i][j];
				}
				KadaneResult kadane = new MaxSubarraySumKadane().maxContiguousSumWithKadaneResult(b);
				if (kadane.max > maxSum) {
					maxSum = kadane.max;
					maxLeft = l;
					maxRight = j;
					maxUp = kadane.maxStart;
					maxDown = kadane.maxEnd;
				}

			}
		}
		CommonUtil.print2DArray(a, maxRight - maxLeft + 1, maxDown - maxUp + 1, maxLeft);
		System.out.println("maxSum=" + maxSum + ", maxLeft=" + maxLeft + ", maxRight=" + maxRight + ", maxUp=" + maxUp
				+ ", maxDown=" + maxDown);
		return maxSum;
	}

}
