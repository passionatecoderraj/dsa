/**
 * 
 */
package com.raj.matrix;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class RotateMatrixBy90degrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int m = a.length, n = a[0].length;
		RotateMatrixBy90degrees obj = new RotateMatrixBy90degrees();
		obj.rotateImageBy90degrees(a, m, n);
	}

	// Time : O(m*n), Space : O(mn)
	public void rotateImageBy90degrees(int[][] a, int m, int n) {
		int t[][] = new int[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				t[j][m - i - 1] = a[i][j];
			}
		}
		CommonUtil.print2DArray(a, m, n);
		CommonUtil.print2DArray(t, n, m);
	}

	// TODO : inplace algorithm -
	// https://www.shiftedup.com/2015/05/10/programming-challenge-rotating-a-matrix-90-degrees-in-place

}
