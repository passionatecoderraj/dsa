/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */

/*
 * Given an array of integers and a number x, find the smallest subarray with
 * sum greater than the given value
 */
public class FindSmallestSubarraySumGreatherThanK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FindSmallestSubarraySumGreatherThanK obj = new FindSmallestSubarraySumGreatherThanK();
		int a[] = { 1, 4, 45, 6, 0, 19 };

		// int a[] = { 1, 4, 20, 3, 10, 5 };
		int n = a.length, k = 51, result = -1;

		result = obj.smallestSubArraysOfSumGreatherThanK(a, n, k);
		System.out.println(result);

		int a3[] = { 1, 11, 100, 1, 0, 200, 3, 2, 35, 250 };
		result = obj.smallestSubArraysOfSumGreatherThanK(a3, a3.length, 280);
		System.out.println(result);

	}

	public int smallestSubArraysOfSumGreatherThanK(int[] a, int n, int k) {

		int sum = 0;
		int l = 0;
		int minSize = Integer.MAX_VALUE;
		int minSizeLeft = Integer.MAX_VALUE;
		int minSizeRight = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			if (a[i] > k) {
				return 1;
			}
			sum += a[i];
			while (sum > k && l <= i) {
				if (i - l + 1 < minSize) {
					minSize = i - l + 1;
					minSizeLeft = l;
					minSizeRight = i;
				}
				sum -= a[l++];
			}
		}
		if (minSize != Integer.MAX_VALUE)
			printSubarray(a, minSizeLeft, minSizeRight);

		return minSize;
	}

	private void printSubarray(int[] a, int l, int r) {
		for (int i = l; i <= r; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

}
