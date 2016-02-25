/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */

/*
 * Given an unsorted array of nonnegative integers, find a continous subarray
 * which adds to a given number.
 */
public class FindSubarrayOfSumK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FindSubarrayOfSumK obj = new FindSubarrayOfSumK();
		int a[] = { 15, 2, 4, 8, 9, 5, 10, 8 };

		// int a[] = { 1, 4, 20, 3, 10, 5 };
		int n = a.length, k = 23;

		obj.subArraysOfSumK(a, n, k);
	}

	public void subArraysOfSumK(int[] a, int n, int k) {

		int sum = 0;
		int l = 0;

		for (int i = 0; i < n; i++) {
			if (a[i] == k) {
				printSubarray(a, i, i);
				l = i + 1;
				sum = 0;
				continue;
			}

			sum += a[i];

			while (l <= i && sum > k) {
				sum -= a[l++];
			}

			if (sum == k) {
				printSubarray(a, l, i);
				sum = 0;
				l = i + 1;
			}

		}
	}

	private void printSubarray(int[] a, int l, int r) {
		for (int i = l; i <= r; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

}
