/**
 * 
 */
package com.raj.arrays;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 *
 */
public class FindDuplicatesInOn {

	// Given an array of n elements which contains elements from 0 to n-1

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindDuplicatesInOn obj = new FindDuplicatesInOn();
		int a[] = { 0, 3, 5, 5, 1, 0, 3, 6,0 };
		// int b[] = { 1, 6, 2, 0, 1, 0, 6, 6 };
		int n = a.length;

		// Time : O(n), Space : O(1)
		// it's allowed only if we are allowed to modify existing values
		// with out zeroes
		obj.findDuplicates(a, n);
		// with zeroes
		// obj.findRepeatElements(b, b.length);
	}

	public void findRepeatElements(int[] a, int n) {
		int index;
		for (int i = 0; i < n; i++) {
			index = a[i] % n;
			a[index] += n;
		}
		for (int i = 0; i < n; i++) {
			if (a[i] / n > 1) {
				System.out.println("Repeated : " + i);
			}
		}
		CommonUtil.printArray(a);
	}

	public void findDuplicates(int[] a, int n) {

		for (int i = 0; i < n; i++) {
			int j = Math.abs(a[i]);

			if (j == n) {
				System.out.println("Repeated : " + 0);
			} else if (a[j] < 0) {
				System.out.println("Repeated : " + j);
			} else if (a[j] > 0) {
				a[j] = -a[j];
			} else if (a[j] == 0) {
				a[j] = -n;
			}

		}
		CommonUtil.printArray(a);
	}

}
