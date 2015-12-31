/**
 * 
 */
package com.raj.arrays;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class RotateImageBy90degrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int m = a.length, n = a[0].length;
		RotateImageBy90degrees obj = new RotateImageBy90degrees();
		obj.rotateImageBy90degrees(a, m, n);
	}

	public void rotateImageBy90degrees(int[][] a, int m, int n) {
		int t[][] = new int[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				t[j][m-i-1] = a[i][j];
			}
		}
		CommonUtil.print2DArray(a, m, n);
		CommonUtil.print2DArray(t, n, m);
	}

}
