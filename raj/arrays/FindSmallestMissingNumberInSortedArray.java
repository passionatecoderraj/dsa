/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */
public class FindSmallestMissingNumberInSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindSmallestMissingNumberInSortedArray obj = new FindSmallestMissingNumberInSortedArray();
		int a[] = { 0, 1, 2, 6, 9 };
		// int a[] = {4, 5, 10, 11};
		// int a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 10 };
		// int a[] = { 0, 1, 2, 3 };
		int n = a.length, result = -1;
		// Time : O(n)
		result = obj.findSmallestMissingNumber(a, n);
		System.out.println(result);

		result = obj.findSmallestMissingNumberUsingBinarySearch(a, 0, n - 1);
		System.out.println(result);

		result = obj.findSmallestMissingNumberUsingRecursiveBinarySearch(a, 0, n - 1);
		System.out.println(result);

	}

	public int findSmallestMissingNumberUsingRecursiveBinarySearch(int[] a, int l, int r) {
		if (l > r) {
			return r + 1;
		}
		if (a[l] != l) {
			return l;
		}

		int mid = l + (r - l) / 2;

		if (a[mid] > mid) {
			return findSmallestMissingNumberUsingRecursiveBinarySearch(a, l, mid);
		} else {
			return findSmallestMissingNumberUsingRecursiveBinarySearch(a, mid + 1, r);
		}
	}

	public int findSmallestMissingNumberUsingBinarySearch(int[] a, int l, int r) {
		int mid, n = r - l + 1;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if (a[mid] != mid && (mid == 0 || a[mid - 1] == mid - 1)) {
				return mid;
			} else if (a[mid] == mid) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return n;
	}

	public int findSmallestMissingNumber(int[] a, int n) {
		if (n <= 0) {
			return -1;
		}
		for (int i = 0; i < n; i++) {
			if (a[i] != i) {
				return i;
			}
		}

		return n;
	}

}
