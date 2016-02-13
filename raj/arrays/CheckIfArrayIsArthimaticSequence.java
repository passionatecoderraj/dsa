/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;

/**
 * @author Raj
 *
 *
 */
public class CheckIfArrayIsArthimaticSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CheckIfArrayIsArthimaticSequence obj = new CheckIfArrayIsArthimaticSequence();
		int a[] = { 9, 1, 3, 7, 5, 11 };
		int n = a.length;

		boolean result = false;
		// Time :O(nlogn), Space : O(1)
		result = obj.checkArrayIsArthimaticSequenceUsingSorting(a, n);
		System.out.println(result);

		int b[] = { 9, 1, 3, 7, 5, 11 };

		result = obj.checkArrayIsArthimaticSequence(b, b.length);
		System.out.println(result);
		int c[] = { 9, 1, 3, 15, 5, 11 };

		result = obj.checkArrayIsArthimaticSequence(c, c.length);
		System.out.println(result);

	}

	public boolean checkArrayIsArthimaticSequence(int[] a, int n) {
		if (n < 3)
			return false;
	
		Pair minmax = getMinMax(a, 0, n - 1);

		int common_diff = (minmax.max - minmax.min) / (n - 1);

		// check for allowed maximum
		// for nth term
		int possible_max = minmax.min + (n - 1) * common_diff;
		if (possible_max != minmax.max)
			return false;

		// check for difference between any elements
		for (int i = 0; i < n - 1; i++) {
			if (Math.abs(a[i] - a[i + 1]) % common_diff != 0)
				return false;
		}

		return true;
	}

	public Pair getMinMax(int a[], int l, int r) {
		int n = r - l + 1;
		if (n == 1)
			return new Pair(a[l], a[l]);
		else if (n == 2) {
			if (a[l] > a[r]) {
				return new Pair(a[l], a[r]);
			} else {
				return new Pair(a[r], a[l]);
			}
		}
		int m = l + (r - l) / 2;
		Pair left = getMinMax(a, l, m);
		Pair right = getMinMax(a, m + 1, r);
		int max, min;
		max = left.max > right.max ? left.max : right.max;
		min = left.min < right.min ? left.min : right.min;
		return new Pair(max, min);
	}

	public boolean checkArrayIsArthimaticSequenceUsingSorting(int[] a, int n) {
		if (n < 3)
			return false;
		Arrays.sort(a);
		int common_diff = a[1] - a[0];

		for (int i = 0; i < n - 1; i++) {
			if (a[i + 1] - a[i] != common_diff)
				return false;
		}
		return true;
	}

}
