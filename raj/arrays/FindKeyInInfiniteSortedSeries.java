/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 */
public class FindKeyInInfiniteSortedSeries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a[] = { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170 };

		int result = -1, key = 10;

		FindKeyInInfiniteSortedSeries obj = new FindKeyInInfiniteSortedSeries();
		// Time : O(logn)
		result = obj.findKeyInInfiniteSeries(a, key);
		System.out.println(result);
	}

	public int findKeyInInfiniteSeries(int[] a, int key) {
		int l, r;
		l = 0;
		r = 1;
		int val = a[0];
		while (val < key) {
			l = r;
			r = 2 * r;
			val = a[r];
		}
		return binarySearch(a, l, r, key);
	}

	public int binarySearch(int[] a, int l, int r, int key) {
		int m;
		while (l <= r) {
			m = l + (r - l) / 2;
			if (a[m] > key) {
				r = m - 1;
			} else if (a[m] < key) {
				l = m + 1;
			} else {
				return m;
			}
		}
		return -1;
	}

}
