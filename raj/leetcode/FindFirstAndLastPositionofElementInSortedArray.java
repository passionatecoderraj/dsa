package com.raj.leetcode;

import java.util.Arrays;

/**
 * 
 * @author Raj
 *
 *         Given an array of integers nums sorted in ascending order, find the
 *         starting and ending position of a given target value.
 * 
 *         Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 *         If the target is not found in the array, return [-1, -1].
 * 
 *         Example 1:
 * 
 *         Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:
 * 
 *         Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]
 * 
 */
public class FindFirstAndLastPositionofElementInSortedArray {

	// Time ; O(logn)
	public int[] searchRange(int[] a, int key) {
		int res[] = { -1, -1 };
		int l = 0, r = a.length - 1;
		int first = -1;
		// search for insertion index for key, array has 0 to n positions to insert
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (a[m] == key && (m == 0 || a[m - 1] < key)) {
				first = m;
				break;
			}
			if (a[m] < key) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}

		if (first == -1) {
			return res;
		}
		res[0] = first;
		// We don't have to set l to 0 the second time.
		l = first;
		r = a.length - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (a[m] == key && (m == a.length - 1 || a[m + 1] > key)) {
				res[1] = m;
				break;
			}
			if (a[m] > key) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {

		FindFirstAndLastPositionofElementInSortedArray obj = new FindFirstAndLastPositionofElementInSortedArray();
		int[] res = null;

		res = obj.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 7);
		System.out.println(Arrays.toString(res));
		res = obj.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 10);
		System.out.println(Arrays.toString(res));

	}

}
