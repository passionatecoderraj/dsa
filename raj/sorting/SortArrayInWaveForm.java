/**
 * 
 */
package com.raj.sorting;

import java.util.Arrays;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 */

/*
 * An array ‘arr[0..n-1]’ is sorted in wave form if arr[0] >= arr[1] <= arr[2]
 * >= arr[3] <= arr[4] >= …...
 * 
 */

public class SortArrayInWaveForm {
	/*
	 * The idea is based on the fact that if we make sure that all even
	 * positioned (at index 0, 2, 4, ..) elements are greater than their
	 * adjacent odd elements, we don’t need to worry about odd positioned
	 * element.
	 */
	public void sortInWaveForm(int[] a, int n) {
		if (n <= 1)
			return;

		for (int i = 1; i < n; i++) {
			if (i % 2 == 1) {
				if (a[i] < a[i - 1])
					CommonUtil.swap(a, i, i - 1);
			} else {
				if (a[i] > a[i - 1])
					CommonUtil.swap(a, i, i - 1);
			}
		}
	}

	/*
	 * Input: arr[] = {10, 5, 6, 3, 2, 20, 100, 80} Output: arr[] = {10, 5, 6,
	 * 2, 20, 3, 100, 80} OR {20, 5, 10, 2, 80, 6, 100, 3} OR /**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		SortArrayInWaveForm obj = new SortArrayInWaveForm();

		int a[] = { 10, 90, 49, 2, 1, 5, 23 };
		int n = a.length;

		// Time : O(nlogn)
		obj.sortInWaveFormUsingSorting(a, n);
		CommonUtil.printArray(a);

		// Time : O(n)
		// for every even index keep max value of if it's left, right and itself
		int b[] = { 10, 90, 49, 2, 1, 5, 23 };
		obj.sortInWaveForm(b, b.length);
		CommonUtil.printArray(b);
	}

	public void sortInWaveFormUsingSorting(int[] a, int n) {
		Arrays.sort(a);
		for (int i = 0; i < n - 1; i = i + 2) {
			CommonUtil.swap(a, i, i + 1);
		}
	}

}
