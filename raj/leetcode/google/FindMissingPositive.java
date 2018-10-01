/**
 *
 */
package com.raj.leetcode.google;

/**
 * @author Raj
 * 
 *         Given an unsorted integer array, find the first missing positive
 *         integer.
 * 
 *         For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 *         Your algorithm should run in O(n) time and uses constant space.
 */

public class FindMissingPositive {

	// https://leetcode.com/problems/first-missing-positive/discuss/17083/O(1)-space-Java-Solution
	// Time : O(n)
	public int findSmallestMissingPositiveNumber(int[] a) {
		int i = 0;
		while (i < a.length) {
			if (a[i] == i + 1 || a[i] <= 0 || a[i] > a.length)
				i++;
			else if (a[i] != a[a[i] - 1]) {
				swap(a, i, a[i] - 1);
			} else
				i++;
		}
		i = 0;
		while (i < a.length) {
			if (a[i] != i + 1)
				return i + 1;
			i++;
		}
		return i + 1;
	}

	public static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// Time : O(n)
	public int findSmallestMissingPositiveNumber2(int[] a) {
		int l = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				a[l++] = a[i];
			}
		}
		
		int index;
		for (int i = 0; i < l; i++) {
			index = Math.abs(a[i]) - 1;
			if (index < l && a[index] > 0) {
				a[index] = -a[index];
			}
		}

		for (int i = 0; i < l; i++) {
			if (a[i] > 0) {
				return i + 1;
			}
		}
		return l + 1;
	}

	public static void main(String[] args) {
		FindMissingPositive obj = new FindMissingPositive();
		int a[] = { 2, 3, -7, 6, 8, 1, -10, 15 };
		int result = -1;

		result = obj.findSmallestMissingPositiveNumber(a);
		System.out.println(result);

		int b[] = { 1, 2, 3 };
		result = obj.findSmallestMissingPositiveNumber(b);
		System.out.println(result);

	}

}
