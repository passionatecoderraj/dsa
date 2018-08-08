package com.raj.arrays;

/**
 * @author Raj
 *
 */
public class FindPeak {

	public int findPeakElement(int[] a) {
		int l = 0;
		int r = a.length - 1;

		while (l <= r) {
			if (r - l < 2)
				return a[l] > a[r] ? l : r;

			int m = (l + r) >> 1;
			if (a[m] > a[m - 1] && a[m] > a[m + 1])
				return m;
			if (a[m + 1] > a[m])
				l = m;
			else
				r = m;
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindPeak obj = new FindPeak();
		int a[] = { 5, 10, 15, 25, 80, 75, 65, 50, 30, 3 };
		int n = a.length, result = -1;

		// Time :O(logn), Space : O(1)
		result = obj.findPeakElement(a);
		System.out.println(result);
	}

}
