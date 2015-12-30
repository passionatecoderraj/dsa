/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;

/**
 * @author Raj
 *
 */
public class FindSmallestandSecondSmallest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 12, 13, 1, 10, 34, 1 };
		int n = a.length;
		FindSmallestandSecondSmallest obj = new FindSmallestandSecondSmallest();
		// Time : O(nlogn) but two traversals
		obj.findSmallestandSecondSmallestUsingSorting(a, n);
		// Time : O(n) but two traversals
		obj.findSmallestandSecondSmallestInBruteForce(a, n);
		// Time : O(n) in single traversals
		obj.findSmallestandSecondSmallestInSingleTraversal(a, n);

	}

	public int findSmallestandSecondSmallestInSingleTraversal(int[] a, int n) {
		int min1, min2;
		if (n < 2)
			return -1;
		min1 = min2 = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (a[i] < min1) {
				min2 = min1;
				min1 = a[i];
			} else if (a[i] < min2 && a[i] != min1) {
				min2 = a[i];
			}
		}
		System.out.println("min2=" + min2);
		return min2;
	}

	public int findSmallestandSecondSmallestUsingSorting(int[] a, int n) {
		Arrays.sort(a);
		int min1 = a[0], min2 = Integer.MAX_VALUE;
		for (int i = 1; i < n; i++) {
			if (a[i] != min1) {
				min2 = a[i];
				break;
			}
		}
		System.out.println("min2=" + min2);
		return min2;
	}

	public int findSmallestandSecondSmallestInBruteForce(int[] a, int n) {
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			min1 = Math.min(min1, a[i]);
		}

		for (int i = 0; i < n; i++) {
			if (a[i] != min1) {
				min2 = Math.min(min2, a[i]);
			}
		}
		System.out.println("min2=" + min2);
		return min2;
	}

}
