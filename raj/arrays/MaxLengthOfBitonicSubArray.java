/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class MaxLengthOfBitonicSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 12, 4, 78, 90, 45, 23 };
		int n = a.length, result = -1;
		MaxLengthOfBitonicSubArray obj = new MaxLengthOfBitonicSubArray();
		// Time : O(n)
		result = obj.maxLengthOfBitonicSubArray(a, n);
		System.out.println(result);
	}

	public int maxLengthOfBitonicSubArray(int[] a, int n) {
		if (n <= 0)
			return -1;

		int lis[] = new int[n];
		int lds[] = new int[n];

		Arrays.fill(lis, 1);
		Arrays.fill(lds, 1);

		for (int i = 1; i < n; i++) {
			if (a[i] > a[i - 1]) {
				lis[i] = lis[i - 1] + 1;
			}
		}

		for (int i = n - 2; i >= 0; i--) {
			if (a[i] > a[i + 1]) {
				lds[i] = lds[i + 1] + 1;
			}
		}

		CommonUtil.printArray(lis);
		CommonUtil.printArray(lds);

		int maxLength = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			maxLength = Math.max(maxLength, lis[i] + lds[i] - 1);
		}

		return maxLength;
	}

}
