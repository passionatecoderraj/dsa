package com.raj.dp;

import com.raj.stack.MaxAreaOfHistogram;

/**
 * 
 * @author Raj
 *
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6

 */
public class MaximalRectangle {

	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0) {
			return 0;
		}
		int m = matrix.length, n = matrix[0].length;
		int t[] = new int[matrix[0].length];
		int maxArea = -1, curMax = -1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '0') {
					t[j] = 0;
				} else {
					t[j]++;
				}
			}
			curMax = new MaxAreaOfHistogram().largestRectangleArea(t);
			maxArea = Math.max(curMax, maxArea);
		}
		return maxArea;
	}

	public static void main(String[] args) {
		char a[][] = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };

		int result = -1;
		MaximalRectangle obj = new MaximalRectangle();
		result = obj.maximalRectangle(a);
		System.out.println(result);
	}
}
