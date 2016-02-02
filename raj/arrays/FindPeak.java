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
		int a[] = { 5, 10, 15, 25, 80, 75, 65, 50, 30, 3 };
		int n = a.length, result = -1;

		// Time :O(n), Space : O(1)
		result = obj.findPeakBruteForce(a, n);
		System.out.println(result);

		// Time :O(logn), Space : O(1)
		result = obj.findPeak(a, 0, n - 1, n);
		System.out.println(result);

	}

	// Time :O(logn), Space : O(1)
	public int findPeak(int a[], int l, int r, int n) {
		int m;
		while (l <= r) {
			m = l + (r - l) / 2;
			if ((m == 0 || a[m] >= a[m - 1]) && (m == n - 1 || a[m] >= a[m + 1]))
				return a[m];
			if (m < n - 1 && a[m + 1] > a[m])
				l = m + 1;
			else
				r = m - 1;
		}
		return -1;
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
