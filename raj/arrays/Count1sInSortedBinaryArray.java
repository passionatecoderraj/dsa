/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 *
 */
/*
 * Given a binary array sorted in non-increasing order, count the number of 1’s
 * in it.
 */
public class Count1sInSortedBinaryArray {

	// Given a binary array sorted in non-increasing order, count the number of
	// 1’s in it.
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Count1sInSortedBinaryArray obj = new Count1sInSortedBinaryArray();
		int a[] = { 1, 1, 1, 0, 0, 0, 0 };
		// int a[] = { 1, 1, 1, 1, 1, 1, 1 };
		// int a[] = { 0, 0, 0, 0, 0, 0 };
		int n = a.length, result = -1;

		// Time : O(logn), Space : O(1)
		result = obj.count1sInSortedBinaryArray(a, n);
		System.out.println(result);
	}

	public int count1sInSortedBinaryArray(int[] a, int n) {
		if (n <= 0) {
			return 0;
		}
		if (a[0] == 0)
			return 0;
		else if (a[n - 1] == 1)
			return n;
		else {
			int k = lastOccurenceOf1(a, 0, n - 1);
			if (k != -1)
				return k - 0 + 1;
		}
		return 0;
	}

	public int lastOccurenceOf1(int a[], int l, int r) {
		int m;
		int n = r - l + 1;
		while (l <= r) {
			m = l + (r - l) / 2;
			if (a[m] == 1 && (m == n - 1 || a[m + 1] == 0))
				return m;
			if (a[m] == 1)
				l = m + 1;
			else
				r = m - 1;
		}

		return -1;
	}

}
