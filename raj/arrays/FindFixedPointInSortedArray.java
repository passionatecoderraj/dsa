/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 *         Fixed Point in an array is an index i such that arr[i] is equal to i.
 *         Note that integers in array can be negative.
 */
public class FindFixedPointInSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindFixedPointInSortedArray obj = new FindFixedPointInSortedArray();
		int a[] = { -10, -5, 0, 3, 7 };
		int result = -1, n = a.length;
		// Time : O(n)
		result = obj.findFixedPointBruteForce(a, n);
		System.out.println(result);

		// Time : O(logn)
		result = obj.findFixedPointUsingBinarySearch(a, 0, n - 1);
		System.out.println(result);

	}

	public int findFixedPointUsingBinarySearch(int[] a, int l, int h) {
		int mid;
		while (l <= h) {
			mid = l + (h - l) / 2;
			if (a[mid] == mid) {
				return mid;
			} else if (a[mid] > mid) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

	public int findFixedPointBruteForce(int[] a, int n) {
		for (int i = 0; i < n; i++) {
			if (a[i] == i) {
				return i;
			}
		}
		return -1;
	}

}
