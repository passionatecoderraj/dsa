/**
 * 
 */
package com.raj.sorting;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 9, 6, 5, 0, 8, 2, 7, 1 };
		QuickSort obj = new QuickSort();
		// obj.quickSort(a, 0, a.length - 1);
		// CommonUtil.printArray(a);
		obj.quickSortDescending(a, 0, a.length - 1);
		CommonUtil.printArray(a);
	}

	public void quickSort(int[] a, int p, int r) {
		if (p < r) {
			int q = partition(a, p, r);
			quickSort(a, p, q - 1);
			quickSort(a, q + 1, r);
		}
	}

	public void quickSortDescending(int[] a, int p, int r) {
		if (p < r) {
			int q = partitionDescending(a, p, r);
			quickSortDescending(a, p, q - 1);
			quickSortDescending(a, q + 1, r);
		}
	}

	public int partition(int a[], int p, int r) {
		int key = a[r], j = p;
		for (int i = p; i < r; i++) {
			if (a[i] <= key) {
				CommonUtil.swap(a, i, j++);
			}
		}
		CommonUtil.swap(a, r, j);
		return j;
	}

	public int partitionDescending(int a[], int p, int r) {
		int j = p, key = a[r];
		for (int i = p; i < r; i++) {
			if (a[i] >= key) {
				CommonUtil.swap(a, i, j++);
			}
		}
		CommonUtil.swap(a, r, j);
		return j;
	}

}
