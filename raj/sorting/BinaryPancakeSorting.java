/**
 * 
 */
package com.raj.sorting;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
/*
 * Imagine a hypothetical machine where flip(i) always takes O(1) time. Write an
 * efficient program for sorting a given array in O(nLogn) time on the given
 * machine
 */
public class BinaryPancakeSorting {

	public int findMaxIndex(int a[], int l, int r) {
		int max_index = -1;
		for (int i = l; i <= r; i++) {
			if (max_index == -1) {
				max_index = i;
				continue;
			}
			if (a[i] > a[max_index]) {
				max_index = i;
			}
		}
		return max_index;
	}

	public void flip(int a[], int l, int r) {
		while (l < r) {
			CommonUtil.swap(a, l++, r--);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 9, 6, 5, 0, 8, 2, 7, 1 };
		BinaryPancakeSorting obj = new BinaryPancakeSorting();

		// given assumption is flip(0,i) takes O(1)
		// Time : O(nlogn), Space : O(1)
		obj.pancakeSort(a, a.length);
		CommonUtil.printArray(a);

	}

	public void pancakeSort(int[] a, int n) {
		int index = -1;
		for (int i = 1; i < n; i++) {
			index = binarySearchIndex(a, 0, i - 1, a[i]);
			if (i != index) {
				flip(a, index, i - 1);
				flip(a, index, i);
			}

		}
	}

	public int binarySearchIndex(int[] a, int l, int r, int key) {
		if (key < a[l]) {
			return l;
		}
		if (key > a[r]) {
			return r + 1;
		}

		int mid;
		while (l <= r) {
			mid = l + (r - l) / 2;

			if (a[mid] == key) {
				return mid;
			}

			if (key > a[mid] && key < a[mid + 1]) {
				return mid + 1;
			}

			if (a[mid] > key) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

	public int binarySearchindex(int[] a, int l, int r, int key) {
		int mid;
		while (r - l > 1) {
			mid = l + (r - l) / 2;
			if (a[mid] >= key) {
				r = mid;
			} else {
				l = mid;
			}
		}
		return r;
	}

}
