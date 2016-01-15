/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 *
 */
/*
 * 
 * Rows are sorted
 */
public class FindRowWithMaxNumberOf1s {

	/**
	 * @param args
	 */

	/*
	 * Given a boolean 2D array, where each row is sorted. Find the row with the
	 * maximum number of 1s.
	 */
	/*
	 * Solution : Start at 1,1.
	 * 
	 * If the cell contains 1, you're on the longest row so far; write it down
	 * and go right. If the cell contains 0, go down. If the cell is out of
	 * bounds, you're done
	 */
	public static void main(String[] args) {
		int a[][] = { { 1, 1, 1, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 0, 0 }, { 1, 1, 1, 1, 1, 0 },
				{ 1, 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 0, 0 } };
		int m = a.length, n = a[0].length, result = -1;
		FindRowWithMaxNumberOf1s obj = new FindRowWithMaxNumberOf1s();
		// Time : O(m+n)
		result = obj.findRowWithMaxNumberOf1s(a, m, n);
		System.out.println(result);

		// Time : O(m+n)
		result = obj.findRowWithMaxNumberOf0s(a, m, n);
		System.out.println(result);

	}

	public int findRowWithMaxNumberOf0s(int[][] a, int m, int n) {
		int max = -1, j = n - 1;
		for (int i = 0; i < n; i++) {
			while (j >= 0 && a[i][j] == 0) {
				max = i;
				j--;
			}
		}
		return max;
	}

	public int findRowWithMaxNumberOf1s(int[][] a, int m, int n) {
		int max = -1, j = 0;
		for (int i = 0; i < m; i++) {
			while (j < n && a[i][j] == 1) {
				max = i;
				j++;
			}
		}
		return max;
	}

}
