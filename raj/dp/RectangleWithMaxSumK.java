package com.raj.dp;

import java.util.TreeSet;

public class RectangleWithMaxSumK {

	// Time : O(n*n*m*logm)
	public int findMaxSumRectangle(int[][] a, int k) {
		int m = a.length, n = a[0].length;

		int b[];
		int maxSum = Integer.MIN_VALUE;

		for (int l = 0; l < n; l++) {
			b = new int[m];
			for (int j = l; j < n; j++) {
				for (int i = 0; i < m; i++) {
					b[i] += a[i][j];
				}
				int kadaneSum = getLargestSumCloseToK(b, k);
				if (kadaneSum > k)
					continue;
				maxSum = Math.max(maxSum, kadaneSum);
			}
		}

		return maxSum;
	}

	// Time : O(nlogn)
	// https://www.quora.com/Given-an-array-of-integers-A-and-an-integer-k-find-a-subarray-that-contains-the-largest-sum-subject-to-a-constraint-that-the-sum-is-less-than-k
	public int getLargestSumCloseToK(int arr[], int k) {
		int sum = 0;
		TreeSet<Integer> set = new TreeSet<Integer>();
		int result = Integer.MIN_VALUE;
		set.add(0);

		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];

			Integer ceiling = set.ceiling(sum - k);
			if (ceiling != null) {
				result = Math.max(result, sum - ceiling);
			}

			set.add(sum);
		}

		return result;
	}

	public static void main(String[] args) {
		int a[][] = { { 1, 0, 1 }, { 0, -2, 3 } };

		int result = -1;
		RectangleWithMaxSumK obj = new RectangleWithMaxSumK();
		result = obj.findMaxSumRectangle(a, 2);
		System.out.println(result);

		int b[][] = { { 2, 2, -1 } };
		result = obj.findMaxSumRectangle(b, 0);
		System.out.println(result);

		int c[][] = { { 5, -4, -3, 4 }, { -3, -4, 4, 5 }, { 5, 1, 5, -4 } };
		result = obj.findMaxSumRectangle(c, 10);
		System.out.println(result);

	}

}
