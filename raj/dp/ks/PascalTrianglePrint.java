/**
 * 
 */
package com.raj.dp.ks;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class PascalTrianglePrint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 4;
		PascalTrianglePrint obj = new PascalTrianglePrint();
		// Time : O(n*n), Space:O(n*n)
		obj.printPascalTriangle(n);

		// Time : O(n*n), Space:O(n)
		obj.printPascalTriangleSpaceOptimized(n);

	}

	public void printPascalTriangleSpaceOptimized(int n) {
		int t[] = new int[n];
		t[0] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0; j--) {
				t[j] = t[j] + t[j - 1];
			}
		}
		CommonUtil.printArray(t);
	}

	public void printPascalTriangle(int n) {
		int t[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					t[i][j] = 1;
				} else {
					t[i][j] = t[i - 1][j] + t[i - 1][j - 1];
				}
			}
		}
		CommonUtil.print2DArray(t, n, n);
	}

}
