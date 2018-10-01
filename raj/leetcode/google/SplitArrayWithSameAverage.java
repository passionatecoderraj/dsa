package com.raj.leetcode.google;

import java.util.Arrays;

/**
 * 
 * @author Raj
 * 
 *         In a given integer array A, we must move every element of A to either
 *         list B or list C. (B and C initially start empty.)
 * 
 *         Return true if and only if after such a move, it is possible that the
 *         average value of B is equal to the average value of C, and B and C
 *         are both non-empty.
 * 
 *         Example : Input: [1,2,3,4,5,6,7,8] Output: true Explanation: We can
 *         split the array into [1,4,5,8] and [2,3,6,7], and both of them have
 *         the average of 4.5. Note:
 * 
 *         The length of A will be in the range [1, 30]. A[i] will be in the
 *         range of [0, 10000].
 *
 * 
 */

public class SplitArrayWithSameAverage {
	/*
	 * totalSum/n = Asum/k = Bsum/(n-k), where k = A.size() and 1 <= k <= n/2;
	 * 
	 * Asum= totalSum*k/n, which is an integer. So we have totalSum*k%n == 0;
	 */

	public boolean splitArraySameAverage(int[] a) {
		int sum = 0;
		for (int n : a)
			sum += n;
		int n = a.length;
		boolean[][] t = new boolean[n / 2 + 1][sum + 1];
		t[0][0] = true;

		/*
		 * check for each element whether there exists sum with i elements
		 * 
		 * In other words, is there subset sum 'target' exists 'i' elements.
		 * 
		 * save all these values, for lookup later
		 */
		for (int num : a) {
			/*
			 * check whether there exists a sum with i elements
			 */
			for (int j = sum; j >= num; j--) {
				for (int i = 1; i <= n / 2; i++) {
					t[i][j] = t[i][j] || t[i - 1][j - num];
				}
			}
		}
		for (int i = 1; i <= n / 2; i++) {
			if (sum * i % n == 0 && t[i][sum * i / n]) {
				return true;
			}

		}
		return false;
	}

	public boolean splitArraySameAverage2(int[] a) {
		Arrays.sort(a);
		int sum = 0;
		for (int n : a)
			sum += n;
		int n = a.length;
		for (int i = 1; i <= n / 2; i++) {
			if (sum * i % n == 0 && hasSubsetSumWithKElements(a, sum * i / n, i)) {
				return true;
			}

		}
		return false;
	}

	private boolean hasSubsetSumWithKElements(int[] a, int target, int k) {
		return util(a, k, target, 0, 0, 0);
	}

	private boolean util(int[] a, int k, int target, int startIdx, int curSum, int curNoOfElements) {
		if (curNoOfElements == k) {
			if (curSum == target) {
				return true;
			}
		}
		for (int i = startIdx; i < a.length; i++) {
			if (curSum + a[i] > target) {
				return false;
			}
			if (util(a, k, target, i + 1, curSum + a[i], curNoOfElements + 1)) {
				return true;
			}
		}

		return false;
	}

	public static void main(String... args) {
		SplitArrayWithSameAverage obj = new SplitArrayWithSameAverage();
		boolean res = false;

		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		res = obj.splitArraySameAverage(a);
		System.out.println(res);

		res = obj.splitArraySameAverage(new int[] { 2, 12, 18, 16, 19, 3 });
		System.out.println(res);

	}
}
