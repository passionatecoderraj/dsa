/**
 * 
 */
package com.raj.sorting;

/**
 * @author Raj
 *
 */

/*
 * Given an array which is sorted, but after sorting some elements are moved to
 * either of the adjacent positions, i.e., arr[i] may be present at arr[i+1] or
 * arr[i-1]. Write an efficient function to search an element in this array.
 * Basically the element arr[i] can only be swapped with either arr[i+1] or
 * arr[i-1].
 */

public class SearchInAlmostSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SearchInAlmostSortedArray obj = new SearchInAlmostSortedArray();

		int a[] = { 10, 3, 40, 20, 50, 80, 70 };
		// 3 and 40 are not in correct position
		int n = a.length, result = -1;
		int key = 40;

		// Time : O(logn), Space : O(1)
		key = 40;
		result = obj.search(a, 0, n - 1, key);
		System.out.println(result);
		key = 90;
		result = obj.search(a, 0, n - 1, key);
		System.out.println(result);

		key = 40;
		result = obj.searchRecursive(a, 0, n - 1, key);
		System.out.println(result);
		key = 90;
		result = obj.searchRecursive(a, 0, n - 1, key);
		System.out.println(result);
	}

	public int search(int[] a, int l, int h, int key) {
		int mid;
		while (l <= h) {
			mid = l + (h - l) / 2;
			if (a[mid] == key)
				return mid;
			if (mid > l && a[mid - 1] == key)
				return mid - 1;
			if (mid < h && a[mid + 1] == key)
				return mid + 1;
			if (a[mid] > key)
				h = mid - 2;
			else
				l = mid + 2;
		}
		return -1;
	}

	public int searchRecursive(int[] a, int l, int h, int key) {
		int mid;
		if (l <= h) {
			mid = l + (h - l) / 2;
			if (a[mid] == key)
				return mid;
			if (mid > l && a[mid - 1] == key)
				return mid - 1;
			if (mid < h && a[mid + 1] == key)
				return mid + 1;
			if (a[mid] > key)
				return search(a, l, mid - 2, key);
			else
				return search(a, mid + 2, h, key);
		}
		return -1;
	}

}
