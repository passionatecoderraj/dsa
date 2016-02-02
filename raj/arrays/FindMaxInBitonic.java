/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */
public class FindMaxInBitonic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 1, 3, 50, 10, 9, 7, 6 };
		int n = a.length, result = -1;
		FindMaxInBitonic obj = new FindMaxInBitonic();
		// Time : O(n)
		result = obj.findMaxInBitonic(a, n);
		System.out.println(result);

		// Time : O(logn)
		result = obj.findMaxInBitonicUsingBinarySearch(a, 0, n - 1);
		System.out.println(result);

	}

	public int findMaxInBitonic(int[] a, int n) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, a[i]);
		}
		return max;
	}

	public int findMaxInBitonicUsingBinarySearch(int[] a, int l, int r) {
		int mid;

		while (l <= r) {
			// if there is only one element
			if (l == r) {
				return a[l];
			}
			// if there are only two elements
			if (l + 1 == r) {
				return a[l] > a[r] ? a[l] : a[r];
			}

			mid = l + (r - l) / 2;
			if (a[mid] > a[mid + 1] && a[mid] > a[mid - 1]) {
				return a[mid];
			} else if (a[mid] > a[mid + 1]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

}
