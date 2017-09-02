package com.raj.matrix;

import com.interview.graph.CommonUtil;

// http://www.geeksforgeeks.org/create-a-matrix-with-alternating-rectangles-of-0-and-x/
/*
 * Create a matrix with alternating rectangles of O and X
 */
public class CreateMatrixWithAlternateRectanglesOf0sAnd1s {
	public static void main(String args[]) throws Exception {

		CreateMatrixWithAlternateRectanglesOf0sAnd1s obj = new CreateMatrixWithAlternateRectanglesOf0sAnd1s();
		int m = 7, n = 7;
		obj.createMatrix(m, n);
	}

	public void createMatrix(int m, int n) {
		char t[][] = new char[m][n];
		int left = 0, right = n - 1, top = 0, bottom = m - 1;
		char ch = 'X';
		while (left <= right && top <= bottom) {
			for (int i = left; i <= right; i++) {
				t[top][i] = ch;
			}
			top++;
			for (int i = top; i <= bottom; i++) {
				t[i][right] = ch;
			}
			right--;
			if (top <= bottom) {
				for (int i = right; i >= left; i--) {
					t[bottom][i] = ch;
				}
			}
			bottom--;
			if (left <= right) {
				for (int i = bottom; i >= top; i--) {
					t[i][left] = ch;
				}
			}
			left++;
			ch = ch == 'X' ? 'O' : 'X';
		}

		CommonUtil.print2DArray(t, m, n);
	}

}
