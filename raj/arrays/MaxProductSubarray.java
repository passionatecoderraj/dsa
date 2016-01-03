/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */
public class MaxProductSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MaxProductSubarray obj = new MaxProductSubarray();
		// int a[] = { 1, -2, -3, 0, 7, -8, -2 };
		// int a[] = { 12, 2, -3, -5, -6, -2 };
		int a[] = { 0, 0, -3, 0, 0 };

		int n = a.length, result = -1;
		result = obj.maxProductSubarray(a, n);
		System.out.println(result);
	}

	public int maxProductSubarray(int[] a, int n) {
		int maxProduct = Integer.MIN_VALUE;
		if (n <= 0)
			return maxProduct;

		int maxEndingHere = a[0];
		int minEndingHere = a[0];

		int tempMax, tempMin;
		for (int i = 1; i < n; i++) {
			tempMax = maxEndingHere;
			tempMin = minEndingHere;
			maxEndingHere = Math.max(a[i], Math.max(tempMax * a[i], tempMin * a[i]));
			minEndingHere = Math.min(a[i], Math.min(tempMax * a[i], tempMin * a[i]));
			maxProduct = Math.max(maxEndingHere, maxProduct);
		}
		return maxProduct;
	}

}
