/**
 * 
 */
package com.raj.sorting;

/**
 * @author Raj
 *
 */

public class Count1sInBinarySortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 1, 0, 0, 0, 0 };
		Count1sInBinarySortedArray obj = new Count1sInBinarySortedArray();

		int n = a.length, result = -1;

		// Time : O(n+k), Space : O(1)
		// array is sorted in decreasing order
		result = obj.count1sInSortedArray(a, n);
		System.out.println(result);

	}

	public int count1sInSortedArray(int[] a, int n) {
		if (n <= 0)
			return -1;
		if (a[0] != 1)
			return 0;

		int firstOccurenceof1 = 0;
		int lastOccurenceOf1 = last(a, 0, n - 1, 1);

		return lastOccurenceOf1 - firstOccurenceof1 + 1;
	}

	public int last(int a[], int l, int h, int x) {
		int mid, n = h - l + 1;
		while (l <= h) {
			mid = l + (h - l) / 2;
			if (a[mid] == 1 && (mid == n - 1 || a[mid + 1] == 0)) {
				return mid;
			} else if (a[mid] == 1) {
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}
		return -1;
	}

	public int first(int a[], int l, int h, int x) {
		int mid, n = h - l + 1;
		while (l <= h) {
			mid = l + (h - l) / 2;
			if (a[mid] == 1 && (mid == 0 || a[mid - 1] == 0)) {
				return mid;
			} else if (a[mid] == 1) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return n;
	}
}
