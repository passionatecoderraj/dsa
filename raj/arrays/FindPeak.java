/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */
public class FindPeak {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindPeak obj = new FindPeak();
		int a[] = { 5, 10, 15, 25, 30, 45, 65, 50, 30, 1 };
		int n = a.length, result = -1;

		// Time :O(n), Space : O(1)
		result = obj.findPeakBruteForce(a, n);
		System.out.println(result);

		// Time :O(logn), Space : O(1)
		result = obj.findPeak(a, n);
		System.out.println(result);

	}

	// Time :O(logn), Space : O(1)
	public int findPeak(int[] a, int n) {
		if (n <= 0)
			return Integer.MIN_VALUE;
		int l = 0, r = n - 1, mid;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if ((mid == 0 || a[mid] >= a[mid - 1]) && (mid == n - 1 || a[mid] >= a[mid + 1])) {
				return a[mid];
			}
			if (a[mid] > a[mid - 1]) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return Integer.MIN_VALUE;
	}

	// Time :O(n), Space : O(1)
	public int findPeakBruteForce(int[] a, int n) {
		if (n <= 0)
			return Integer.MIN_VALUE;
		if (n == 1)
			return a[0];
		if (a[0] > a[1]) {
			return a[0];
		}
		if (a[n - 1] > a[n - 2]) {
			return a[n - 1];
		}

		for (int i = 1; i < n - 1; i++) {
			if (a[i] >= a[i - 1] && a[i] >= a[i + 1])
				return a[i];
		}
		return Integer.MIN_VALUE;
	}

}
