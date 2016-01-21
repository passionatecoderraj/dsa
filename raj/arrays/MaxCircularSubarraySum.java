/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */
public class MaxCircularSubarraySum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaxCircularSubarraySum obj = new MaxCircularSubarraySum();
		int result = -1;
		int a[] = { 11, 10, -20, 5, -3, -5, 8, -13, 10 };
		// Time :O(n)
		result = obj.findMaxCirclarSubarraySum(a);
		System.out.println(result);
	}

	public int findMaxCirclarSubarraySum(int[] a) {
		int n = a.length;
		KadaneResult actual_kadane = findContiguousMaxUsingKadane(a, n);
		System.out.println(actual_kadane);
		int flipped_total = 0;
		for (int i = 0; i < n; i++) {
			a[i] = -a[i];
			flipped_total += a[i];
		}

		KadaneResult flipped_kadane = findContiguousMaxUsingKadane(a, n);
		System.out.println(flipped_kadane);
		System.out.println(flipped_total);
		// max_wrap = actual_total - (-flipped_kadane.max)
		int max_wrap = -(flipped_total - flipped_kadane.max);
		int max_actual = actual_kadane.max;

		return max_wrap > max_actual ? max_wrap : max_actual;
	}

	public int findMaxCircularSubarraySum(int[] a) {
		int n = a.length;
		KadaneResult actual_kadane = findContiguousMaxUsingKadane(a, n);
		System.out.println(actual_kadane);
		int actual_total = 0;
		for (int i = 0; i < n; i++) {
			actual_total += a[i];
			a[i] = -a[i];
		}

		KadaneResult flipped_kadane = findContiguousMaxUsingKadane(a, n);
		System.out.println(flipped_kadane);
		System.out.println(actual_total);
		// max_wrap = actual_total - (-flipped_kadane.max)
		int max_wrap = actual_total + flipped_kadane.max;
		int max_actual = actual_kadane.max;

		return max_wrap > max_actual ? max_wrap : max_actual;
	}

	public KadaneResult findContiguousMaxUsingKadane(int a[], int n) {
		int maxStart = -1;
		int maxEnd = -1;
		int maxSum = Integer.MIN_VALUE;

		int sum = 0;
		int curStart = 0;
		for (int i = 0; i < n; i++) {
			sum += a[i];
			if (sum < 0) {
				sum = 0;
				curStart = i + 1;
			}
			if (sum > maxSum) {
				maxSum = sum;
				maxStart = curStart;
				maxEnd = i;
			}
		}
		return new KadaneResult(maxSum, maxStart, maxEnd);
	}

}
