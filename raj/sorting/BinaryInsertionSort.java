/**
 * 
 */
package com.raj.sorting;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class BinaryInsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 9, 6, 5, 0, 8, 2, 7, 1 };
		BinaryInsertionSort obj = new BinaryInsertionSort();
		obj.binaryInsertionSort(a, a.length);
		CommonUtil.printArray(a);
	}

	public void binaryInsertionSort(int[] a, int n) {
		int key, j;
		int k;
		for (int i = 1; i < n; i++) {
			key = a[i];
			j = i - 1;
			k = (key < a[0]) ? 0 : binarySearchindex(a, -1, j, key);
			while (j >= k) {
				a[j + 1] = a[j];
				j--;
			}
			a[k] = key;
		}
	}

	// we can use ceil search using binary search to find
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
