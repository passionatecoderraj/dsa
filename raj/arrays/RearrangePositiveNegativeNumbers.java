package com.raj.arrays;

import com.interivew.graph.CommonUtil;

/*
 * Rearrange the array elements so that positive and negative numbers are placed alternatively. Number of positive and negative numbers need not be equal. If there are more positive numbers they appear at the end of the array. If there are more negative numbers, they too appear in the end of the array.
 */
public class RearrangePositiveNegativeNumbers {

	public static void main(String[] args) {
		int a[] = { -1, -2, 3, 4, -5, 6, -7, -8, -9 };
		int n = a.length;
		RearrangePositiveNegativeNumbers obj = new RearrangePositiveNegativeNumbers();
		// Time : O(n), Space: O(1)
		CommonUtil.printArray(a);
		obj.rearrangePositiveNegativeNumbers(a, n);
		CommonUtil.printArray(a);
	}

	public void rearrangePositiveNegativeNumbers(int[] a, int n) {
		int j = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] > 0) {
				CommonUtil.swap(a, i, j++);
			}
		}
		// it breaks when l>r so, l is the starting point of negative numbers

		int len_1sthalf = 0, len_2ndhalf = 0;
		// length of first half
		len_1sthalf = j - 0 + 1;
		len_2ndhalf = n - j;

		if (len_1sthalf > len_2ndhalf) {
			int p = 1;
			for (int i = j; i < n; i++) {
				CommonUtil.swap(a, i, p);
				p += 2;
			}
		} else {
			int p = j;
			for (int i = 1; i < j; i = i + 2) {
				CommonUtil.swap(a, i, p);
				p++;
			}
		}
	}

}
