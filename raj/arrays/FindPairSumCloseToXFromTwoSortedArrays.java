/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */
/*
 * 
 * Given two sorted arrays and a number x, find the pair whose sum is closest to
 * x and the pair has an element from each array
 */

public class FindPairSumCloseToXFromTwoSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a1[] = { 1, 4, 5, 7 };
		int a2[] = { 10, 20, 30, 40 };
		FindPairSumCloseToXFromTwoSortedArrays obj = new FindPairSumCloseToXFromTwoSortedArrays();

		int m = a1.length, n = a2.length;
		int x = 31;

		// Time : O(m+n), Space : O(1)
		obj.findPairFromTwoArraysWhoseSumIsCloseToX(a1, a2, m, n, x);
		x = 50;
		obj.findPairFromTwoArraysWhoseSumIsCloseToX(a1, a2, m, n, x);
	}

	public void findPairFromTwoArraysWhoseSumIsCloseToX(int[] a1, int[] a2, int m, int n, int x) {
		int x1 = Integer.MAX_VALUE, x2 = Integer.MAX_VALUE;
		int l1 = 0;// left of 1st array
		int r2 = n - 1; // right of 2nd array
		int minDiff = Integer.MAX_VALUE;
		int curDiff;
		while (l1 < m && r2 >= 0) {
			curDiff = a1[l1] + a2[r2] - x;
			if (Math.abs(curDiff) < Math.abs(minDiff)) {
				minDiff = curDiff;
				x1 = a1[l1];
				x2 = a2[r2];
			}
			if (curDiff < 0) {
				l1++;
			} else if (curDiff > 0) {
				r2--;
			} else {
				break;
			}

		}
		System.out.println("x1=" + x1 + ", x2=" + x2 + ", close To : " + x);
	}
}
