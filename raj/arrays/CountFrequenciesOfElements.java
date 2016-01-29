/**
 * 
 */
package com.raj.arrays;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 */
/*
 * Given an unsorted array of n integers which can contain integers from 1 to n.
 * Some elements can be repeated multiple times and some other elements can be
 * absent from the array. Count frequency of all elements that are present and
 * print the missing elements.
 */
public class CountFrequenciesOfElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountFrequenciesOfElements obj = new CountFrequenciesOfElements();

		// range of value is 1 to n
		int a[] = { 1, 3, 5, 7, 9, 1, 3, 5, 7, 9, 1 };

		int n = a.length;
		// Time: O(n), Space : O(n)
		obj.countFrequenciesBruteForce(a, n);

		// Time: O(n), Space : O(1)
		obj.countFrequenciesUsingSignChange(a, n);

		int b[] = { 1, 3, 5, 7, 9, 1, 3, 5, 7, 9, 1 };
		// Time: O(n), Space : O(1)
		obj.countFrequenciesByCountingUsingModularOperator(b, b.length);

	}

	public void countFrequenciesByCountingUsingModularOperator(int[] a, int n) {
		for (int i = 0; i < n; i++) {
			a[i] = a[i] - 1;
		}
		CommonUtil.printArray(a);
		for (int i = 0; i < n; i++) {
			a[a[i] % n] = a[a[i] % n] + n;
		}

		CommonUtil.printArray(a);

		for (int i = 0; i < n; i++) {
			a[i] = a[i] / n;
		}
		CommonUtil.printArray(a);

	}

	public void countFrequenciesUsingSignChange(int[] a, int n) {
		int i = 0, index;
		while (i < n) {
			if (a[i] <= 0) {
				i++;
				continue;
			}
			index = a[i] - 1;
			if (a[index] > 0) {

				// saving the current value of a[index] to process next
				a[i] = a[index];

				// for first time count is set to 1
				a[index] = -1;
			} else {
				// count is incremented
				a[index]--;

				// setting current value to zero to skip to move next item
				a[i] = 0;
			}
		}

		CommonUtil.printArray(a);
	}

	public void countFrequenciesBruteForce(int[] a, int n) {
		int count[] = new int[n];
		for (int i = 0; i < n; i++) {
			count[a[i] - 1]++;
		}
		CommonUtil.printArray(count);
	}

}
