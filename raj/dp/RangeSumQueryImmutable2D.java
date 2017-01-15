/**
 * 
 */
package com.raj.dp;

/**
 * @author Raj
 *
 *         Given a 2D matrix matrix, find the sum of the elements inside the
 *         rectangle defined by its upper left corner (row1, col1) and lower
 *         right corner (row2, col2).
 * 
 *         Example: Given matrix = { {3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0,
 *         1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5} }
 * 
 *         sumRegion(2, 1, 4, 3) -> 8 sumRegion(1, 1, 2, 2) -> 11 sumRegion(1,
 *         2, 2, 4) -> 12 Note: You may assume that the matrix does not change.
 *         There are many calls to sumRegion function. You may assume that row1
 *         ≤ row2 and col1 ≤ col2.
 */
public class RangeSumQueryImmutable2D {

	static int t[][];

	public static void numMatrix(int[][] a) {
		t = new int[a.length + 1][a[0].length + 1];
		for (int i = 1; i <= a.length; i++) {
			for (int j = 1; j <= a[0].length; j++) {
				t[i][j] = t[i - 1][j] + t[i][j - 1] - t[i - 1][j - 1] + a[i - 1][j - 1];
			}
		}
	}

	public static int sumRegion(int row1, int col1, int row2, int col2) {
		int iMin, iMax, jMin, jMax;
		if (row1 > row2) {
			iMin = row2;
			iMax = row1;
		} else {
			iMin = row1;
			iMax = row2;
		}

		if (col1 > col2) {
			jMin = col2;
			jMax = col1;
		} else {
			jMin = col1;
			jMax = col2;
		}
		return t[iMax + 1][jMax + 1] - t[iMax + 1][jMin] - t[iMin][jMax + 1] + t[iMin][jMin];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)

	{
		int a[][] = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 }, { 1, 0, 3, 0, 5 } };
		numMatrix(a);
		int res = Integer.MIN_VALUE;
		res = sumRegion(2, 1, 4, 3);
		System.out.println(res);
		res = sumRegion(1, 1, 2, 2);
		System.out.println(res);
		res = sumRegion(1, 2, 2, 4);
		System.out.println(res);

	}

}
