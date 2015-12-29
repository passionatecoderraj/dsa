/**
 * 
 */
package com.raj.sorting;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 1, 20, 6, 4, 5 };
		MergeSort obj = new MergeSort();
		obj.mergeSort(a, 0, a.length - 1);
		CommonUtil.printArray(a);
	}

	public void mergeSort(int[] a, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(a, p, q);
			mergeSort(a, q + 1, r);
			merge(a, p, q, r);
		}
	}

	public void merge(int a[], int p, int q, int r) {

		int i = 0, j = 0, k;
		int m = q - p + 1, n = r - q;
		int[] left = new int[m];
		int[] right = new int[n];

		for (i = 0; i < m; i++) {
			left[i] = a[p + i];
		}

		for (i = 0; i < n; i++) {
			right[i] = a[q + 1 + i];
		}

		i = 0;
		j = 0;
		k = p;
		while (i < m && j < n) {
			if (left[i] <= right[j]) {
				a[k++] = left[i++];
			} else {
				a[k++] = right[j++];
			}
		}
		while (i < m) {
			a[k++] = left[i++];
		}
		while (j < n) {
			a[k++] = right[j++];
		}
	}

}
