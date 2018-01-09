/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;

/**
 * @author Raj
 * 
 *         Given an array of integers, we need to find out whether it is
 *         possible to construct at least one non-degenerate triangle using
 *         array values as its sides. In other words, we need to find out 3 such
 *         array indices which can become sides of a non-degenerate triangle.
 *
 */
public class PossibleToFormATriangle {

	// Time : O(nlogn)
	public boolean isPossibleTriangle(int[] a) {
		Arrays.sort(a);
		for (int i = 0; i < a.length - 2; i++) {
			if (a[i] + a[i + 1] > a[i + 2]) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		PossibleToFormATriangle obj = new PossibleToFormATriangle();
		boolean result = false;
		int a[] = { 5, 4, 1, 3, 2 };
		result = obj.isPossibleTriangle(a);
		System.out.println(result);

		int b[] = { 2, 2, 4 };
		// Time :O(n2), Space : O(1)
		result = obj.isPossibleTriangle(b);
		System.out.println(result);

	}

}
