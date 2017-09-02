/**
* 
 */
package com.raj.sorting;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 *
 *         Merge Two SortedArrays
 * 
 *         http://www.geeksforgeeks.org/merge-two-sorted-arrays-o1- extra-space/
 * 
 */

public class MergeTwoArraysWithoutExtraSpace {

	// Time : O(m*n) , Space : O(1)
	public void merge(int[] a, int[] b) {
		int m = a.length - 1, n = b.length - 1;
		// always arranging the last value
		while (m >= 0 && n >= 0) {
			if (a[m] > b[n]) {
				// swap a[m] and b[n]
				int temp = a[m];
				a[m] = b[n];
				b[n] = temp;

				int j = m - 1;
				int key = a[m];
				while (j >= 0 && a[j] > key) {
					a[j + 1] = a[j];
					j--;
				}
				a[j + 1] = key;
			}
			n--;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MergeTwoArraysWithoutExtraSpace obj = new MergeTwoArraysWithoutExtraSpace();
		int a[] = { 1, 5, 9, 10, 15, 20 };
		int b[] = { 2, 3, 8, 13 };

		CommonUtil.printArray(a);
		CommonUtil.printArray(b);
		obj.merge(a, b);
		CommonUtil.printArray(a);
		CommonUtil.printArray(b);
	}

}