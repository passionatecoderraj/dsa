/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;

/**
 * @author Raj
 *
 */
public class MajorityElementInSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MajorityElementInSortedArray obj = new MajorityElementInSortedArray();
		boolean result = false;
		int a[] = { 1, 2, 2, 3, 3, 3, 3, 3, 10 };
		int x = 3;
		// Time :O(n), Space : O(1)
		result = obj.isMajorityInLinearWay(a, a.length, x);
		System.out.println(result);
		// Time :O(logn), Space : O(1)
		result = obj.isMajorityUsingBinarySearch(a, a.length, x);
		System.out.println(result);

	}

	public boolean isMajorityUsingBinarySearch(int[] a, int n, int x) {

		// return first occurrence of x using binary search
		int i = binarySearch(a, 0, n - 1, x);
		if (i >= 0) {
			int k = i + n / 2;
			if (k <= n && a[k] == x)
				return true;

		}
		return false;
	}

	public int binarySearch(int[] a, int l, int r, int x) {
		int m;
		while (l <= r) {
			m = (l + r) / 2;
			if ((a[m] == x && m == 0) || (a[m] == x && x > a[m - 1])) {
				return m;
			} else if (x > a[m]) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return -1;
	}

	public boolean isMajorityInLinearWay(int[] a, int n, int x) {
		if (n <= 0)
			return false;

		for (int i = 0; i < n; i++) {
			if (a[i] == x) {
				int k = i + n / 2;
				if (k <= n && a[k] == x)
					return true;
				else
					return false;
			}
		}
		return false;
	}

	public int findMajorityInLinearWay(int[] a, int n) {
		if (n <= 0)
			return -1;
		int curCount = 1, maxCount = 1, maxVal = a[0];
		for (int i = 1; i < n; i++) {
			if (a[i - 1] == a[i]) {
				curCount++;
				if (curCount > maxCount) {
					maxCount = curCount;
					maxVal = a[i];
				}
			} else {
				curCount = 1;
			}
		}
		return maxCount > n / 2 ? maxVal : -1;
	}

}
