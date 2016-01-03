/**
 * 
 */
package com.raj.arrays;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 *         Given an array of n integers, find the 3 elements such that a[i]
 *         <a[j] < a[k] and i < j < k in 0(n) time
 */
public class FindSortedSequenceOfSize3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindSortedSequenceOfSize3 obj = new FindSortedSequenceOfSize3();
		int a[] = { 12, 11, 10, 5, 6, 2, 30 };
		int n = a.length;

		// Time : O(n), Space:O(n)
		obj.findSortedSequenceOfSize3(a, n);

		// Find a subsequence of size 3 such that arr[i] < arr[j] > arr[k].
		// Time : O(n), Space:O(n)
		obj.findSortedSequence(a, n);

	}

	public void findSortedSequenceOfSize3(int[] a, int n) {

		if (n <= 0)
			return;

		int smaller[] = new int[n];
		int larger[] = new int[n];

		int min = 0;
		int max = n - 1;
		smaller[0] = 0;
		larger[n - 1] = n - 1;

		for (int i = 1; i < n; i++) {
			if (a[i] <= a[min]) {
				min = i;
				smaller[i] = -1;
			} else {
				smaller[i] = min;
			}
		}

		for (int i = n - 2; i >= 0; i--) {
			if (a[i] >= a[max]) {
				max = i;
				larger[i] = -1;
			} else {
				larger[i] = max;
			}
		}
		CommonUtil.printArray(smaller);
		CommonUtil.printArray(larger);

		for (int i = 1; i < n - 1; i++) {
			if (smaller[i] != -1 && larger[i] != -1) {
				System.out.println(a[smaller[i]] + " " + a[i] + " " + a[larger[i]]);
			}
		}
	}

	public void findSortedSequence(int[] a, int n) {

		if (n <= 0)
			return;

		int left[] = new int[n];
		int right[] = new int[n];

		int lmax = 0;
		int rmax = n - 1;
		left[0] = 0;
		right[n - 1] = n - 1;

		for (int i = 1; i < n; i++) {
			if (a[i] <= a[lmax]) {
				lmax = i;
				left[i] = -1;
			} else {
				left[i] = lmax;
			}
		}

		for (int i = n - 2; i >= 0; i--) {
			if (a[i] <= a[rmax]) {
				rmax = i;
				right[i] = -1;
			} else {
				right[i] = rmax;
			}
		}
		CommonUtil.printArray(left);
		CommonUtil.printArray(right);

		for (int i = 1; i < n - 1; i++) {
			if (left[i] != -1 && right[i] != -1) {
				System.out.println(a[left[i]] + " " + a[i] + " " + a[right[i]]);
			}
		}
	}

}
