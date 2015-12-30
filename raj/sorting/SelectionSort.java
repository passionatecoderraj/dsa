/**
 * 
 */
package com.raj.sorting;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 9, 6, 5, 0, 8, 2, 7, 1 };
		SelectionSort obj = new SelectionSort();
		obj.selectionSort(a, a.length);
		CommonUtil.printArray(a);
		obj.selectionSortDescending(a, a.length);
		CommonUtil.printArray(a);
	}

	public void selectionSortDescending(int[] a, int n) {
		int min_index = -1, temp;
		for (int i = n - 1; i >= 0; i--) {
			min_index = i;
			for (int j = i - 1; j >= 0; j--) {
				if (a[j] < a[min_index]) {
					min_index = j;
				}
			}
			if (min_index != i) {
				temp = a[min_index];
				a[min_index] = a[i];
				a[i] = temp;
			}
		}
	}

	public void selectionSort(int[] a, int n) {
		int min_index = -1, temp;
		for (int i = 0; i < n; i++) {
			min_index = i;
			for (int j = i + 1; j < n; j++) {
				if (a[min_index] > a[j]) {
					min_index = j;
				}
			}
			if (min_index != i) {
				temp = a[min_index];
				a[min_index] = a[i];
				a[i] = temp;
			}
		}
	}

}
