/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */

/*
 * Given an unsorted array of nonnegative integers, find a continuous subarray
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

		obj.subArraysOfSum2(a, k);
	}

	public void subArraysOfSum2(int[] a, int k) {

		int l = 0, r = 0;
		int sum = a[r];

		while (true) {
			if (sum < k) {
				r++;
				if (r == a.length)
					return;
				sum += a[r];
			} else if (sum > k) {
				sum -= a[l++];
			} else {
				printSubarray(a, l, r);
				sum = 0;
				l = r + 1;
			}
		}

	}

	// assumption is k >=1
	public void subArraysOfSum(int[] a, int k) {

		int sum = 0;
		int l = 0;

		for (int r = 0; r < a.length; r++) {
			sum += a[r];
			while (sum > k && l <= r) {
				sum -= a[l++];
			}
			if (sum == k) {
				printSubarray(a, l, r);
				sum = 0;
				l = r + 1;
			}
		}
	}

	// assumption is k >=1
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
