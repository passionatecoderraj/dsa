/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;

/**
 * @author Raj
 *
 */
public class FindWhetherSubsetOfArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindWhetherSubsetOfArray obj = new FindWhetherSubsetOfArray();

		int a[] = { 11, 1, 13, 21, 3, 7 };
		int b[] = { 11, 3, 7, 1 };
		int m = a.length, n = b.length;

		boolean result = false;

		// Time : O(n2)
		result = obj.findWhehterSubsetofArrayBruteForce(a, m, b, n);
		System.out.println(result);

		// Time : O(mlogm+nlogm), Using Sorting
		result = obj.findWhehterSubsetofArrayUsingSorting(a, m, b, n);
		System.out.println(result);

		// Time : O(mlogm+nlogn), Using Sorting and merging
		// this complexity is better than above
		result = obj.findWhehterSubsetofArrayUsingSortingAndMerging(a, m, b, n);
		System.out.println(result);
	}

	public boolean findWhehterSubsetofArrayUsingSortingAndMerging(int[] a, int m, int[] b, int n) {
		if (m < n)
			return false;

		Arrays.sort(a);
		Arrays.sort(b);

		int i, j;
		i = j = 0;

		while (i < m && j < n) {
			if (a[i] < b[j]) {
				i++;
			} else if (a[i] > b[j]) {
				return false;
			} else {
				i++;
				j++;

			}
		}
		if (j < n)
			return false;
		return true;
	}

	public boolean findWhehterSubsetofArrayUsingSorting(int[] a, int m, int[] b, int n) {
		boolean isFound = false;
		Arrays.sort(a);
		for (int i = 0; i < n; i++) {
			isFound = binarySearch(a, 0, m - 1, b[i]);
			if (!isFound)
				return false;
		}
		return true;
	}

	public boolean binarySearch(int[] a, int l, int h, int key) {
		int mid;
		while (l <= h) {
			mid = l + (h - l) / 2;
			if (a[mid] == key)
				return true;
			else if (a[mid] > key) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return false;
	}

	public boolean findWhehterSubsetofArrayBruteForce(int[] a, int m, int[] b, int n) {
		boolean isFound = false;
		for (int i = 0; i < n; i++) {
			isFound = linearSearch(a, m, b[i]);
			if (!isFound)
				return false;
		}
		return true;
	}

	public boolean linearSearch(int a[], int n, int key) {
		for (int i = 0; i < n; i++) {
			if (a[i] == key) {
				return true;
			}
		}
		return false;
	}

}
