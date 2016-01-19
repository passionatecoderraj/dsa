/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */
public class MaxAverageOfSubarraySizeK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MaxAverageOfSubarraySizeK obj = new MaxAverageOfSubarraySizeK();
		int a[] = { 11, -8, 16, -7, 24, -2, 3 };

		// int a[] = { 1, 4, 20, 3, 10, 5 };
		int n = a.length, result = -1, k = 3;

		result = obj.maxAverageOfSubarraySizeK(a, n, k);
		System.out.println(result);
	}

	// finding max average is nothing but finding max sum
	public int maxAverageOfSubarraySizeK(int[] a, int n, int k) {
		int maxSum = Integer.MIN_VALUE, maxSumStart = -1, maxSumEnd = -1;
		int sum = 0;
		int start = 0, i;

		for (i = 0; i < k; i++)
			sum += a[i];

		maxSum = sum;
		maxSumStart = start;
		maxSumEnd = k - 1;

		for (i = k; i < n; i++) {
			sum += a[i] - a[start];
			if (sum > maxSum) {
				maxSumStart = start + 1;
				maxSumEnd = i;
				maxSum = sum;
			}
			start++;
		}
		printSubarray(a, maxSumStart, maxSumEnd);
		return maxSum;
	}

	private void printSubarray(int[] a, int l, int r) {
		if (l == -1 || r == -1)
			return;
		for (int i = l; i <= r; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

}
