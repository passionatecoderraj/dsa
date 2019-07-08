package com.raj.leetcode;

/**
 * 
 * @author Raj
 *
 *Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0

 */
public class FindMinimumInSortedRotatedArray {

	// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/discuss/48808/My-pretty-simple-code-to-solve-it
	// Time : O(logn), Space : O(1)
	public int findMin(int[] a) {
		if (a.length == 0)
			return -1;
		int l = 0, r = a.length - 1;
		while (l < r) {
			int m = l + (r - l) / 2;
			if (a[m] > a[r])
				l = m + 1;
			else if (a[m] < a[r])
				r = m;
		}
		return a[l];
	}

	public int findMin2(int[] a) {
		if (a.length == 0)
			return -1;

		int l = 0, r = a.length - 1;
		if (a[l] <= a[r])
			return a[l];
		while (l <= r) {
			int m = (l + r) >> 1;
			if (a[m] > a[m + 1])
				return a[m + 1];
			if (a[m] > a[l])
				l = m;
			else
				r = m;
		}
		return -1;
	}

	public static void main(String[] args) {
		int a[] = { 5, 1, 2, 3, 4 };
		// int a[] = { 5,5,5,0,1,2,5};
		int result = -1;
		FindMinimumInSortedRotatedArray obj = new FindMinimumInSortedRotatedArray();
		result = obj.findMin(a);
		System.out.println(result);

	}

	public int findMinInSortedRotatedArray(int[] a, int n) {
		int pivot = findPivot(a, 0, n - 1);

		return pivot != -1 ? a[pivot] : -1;
	}

	int findPivot(int a[], int l, int r) {
		if (l > r)
			return -1;
		if (a[l] <= a[r])
			return l;
		int m;
		while (l <= r) {
			m = l + (r - l) / 2;
			if (a[m] > a[m + 1])
				return m + 1;
			if (a[m] > a[l]) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return -1;
	}
}
