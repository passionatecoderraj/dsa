package com.raj.arrays;

import com.interivew.graph.CommonUtil;

/*
 * Rearrange the array elements so that positive and negative numbers are placed alternatively. Number of positive and negative numbers need not be equal. If there are more positive numbers they appear at the end of the array. If there are more negative numbers, they too appear in the end of the array.
 */
public class RearrangePositiveNegativeNumbers {

	public static void main(String[] args) {
		int a[] = { -1, -2, 3, 4, 5, 6, 7, -8, 9 };
		int n = a.length;
		RearrangePositiveNegativeNumbers obj = new RearrangePositiveNegativeNumbers();
		// Time : O(n), Space: O(1)
		CommonUtil.printArray(a);
		obj.rearrangePositiveNegativeNumbers(a, n);
		CommonUtil.printArray(a);
		// obj.rearrangePostiveNegative(a, n);
		// CommonUtil.printArray(a);
	}

	public void rearrangePositiveNegativeNumbers(int[] a, int n) {
		int left = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] > 0) {
				CommonUtil.swap(a, i, left++);
			}
		}
		CommonUtil.printArray(a);

		// it breaks when l>r so, l is the starting point of negative numbers

		int len_1sthalf = 0, len_2ndhalf = 0;
		// length of first half
		len_1sthalf = left - 0 + 1;
		len_2ndhalf = n - left;

		int index_1st_half = 1;
		int index_2nd_half = left;

		if (len_1sthalf > len_2ndhalf) {
			int i = 0;
			while (i < len_2ndhalf) {
				CommonUtil.swap(a, index_1st_half, index_2nd_half);
				index_1st_half += 2;
				index_2nd_half++;
				i++;
			}
		} else {
			int i = 0;
			while (i < len_1sthalf) {
				CommonUtil.swap(a, index_1st_half, index_2nd_half);
				index_1st_half += 2;
				index_2nd_half++;
				i++;
			}
		}
	}

}
