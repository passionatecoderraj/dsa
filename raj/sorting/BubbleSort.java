/**
 * 
 */
package com.raj.sorting;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 1, 23, 12, 9, 30, 2, 50 };
		BubbleSort obj = new BubbleSort();
		obj.bubbleSort(a, a.length);
		CommonUtil.printArray(a);

		obj.bubbleSortDescending(a, a.length);
		CommonUtil.printArray(a);
	}

	public void bubbleSortDescending(int[] a, int n) {
		boolean isSwapped = false;
		for (int i = 1; i <= n; i++) {
			isSwapped = false;
			for (int j = n - 1; j >= i; j--) {
				if (a[j] > a[j - 1]) {
					CommonUtil.swap(a, j, j - 1);
					isSwapped = true;

				}
			}
			if (!isSwapped)
				break;
		}
	}

	public void bubbleSort(int[] a, int n) {
		boolean isSwapped = false;
		for (int i = 1; i <= n; i++) {
			isSwapped = false;
			for (int j = 0; j < n - i; j++) {
				if (a[j] > a[j + 1]) {
					CommonUtil.swap(a, j, j + 1);
					isSwapped = true;
				}
			}
			if (!isSwapped)
				break;
		}
	}

}
