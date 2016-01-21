/**
 * 
 */
package com.raj.arrays;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */

/*
 * You are given an unsorted array with both positive and negative elements. You
 * have to find the smallest positive number missing from the array in O(n) time
 * using constant extra space. You can modify the original array
 */
public class FindSmallestMissingPositiveNumberInUnsortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindSmallestMissingPositiveNumberInUnsortedArray obj = new FindSmallestMissingPositiveNumberInUnsortedArray();
		int a[] = { 2, 3, -7, 6, 8, 1, -10, 15 };
		// int a[] = {4, 5, 10, 11};
		// int a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 10 };
		// int a[] = { 0, 1, 2, 3 };
		int n = a.length, result = -1;
		// Time : O(n)
		result = obj.findSmallestMissingPositiveNumber(a, n);
		System.out.println(result);

	}

	public int findSmallestMissingPositiveNumber(int[] a, int n) {
		int l = 0, r = n - 1;
		while (l < r) {
			while (l < r && a[l] > 0) {
				l++;
			}
			while (l < r && a[r] < 0) {
				r--;
			}
			if (l < r) {
				CommonUtil.swap(a, l, r);
				l++;
				r--;
			}
		}
		CommonUtil.printArray(a);

		int index;
		for (int i = 0; i < l; i++) {
			index = Math.abs(a[i]) - 1;
			if (index < l && a[index] > 0) {
				a[index] = -a[index];
			}
		}

		for (int i = 0; i < n; i++) {
			if (a[i] > 0) {
				return i + 1;
			}
		}
		return l;
	}

}
