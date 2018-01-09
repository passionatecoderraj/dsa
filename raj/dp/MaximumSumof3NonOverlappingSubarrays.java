/**
 * 
 */
package com.raj.dp;

import java.util.Arrays;

/**
 * @author Raj
 *
 *        In a given array nums of positive integers, find three
 *         non-overlapping subarrays with maximum sum.
 * 
 *         Each subarray will be of size k, and we want to maximize the sum of
 *         all 3*k entries.
 * 
 *         Return the result as a list of indices representing the starting
 *         position of each interval (0-indexed). If there are multiple answers,
 *         return the lexicographically smallest one.
 * 
 *         Example: Input: [1,2,1,2,6,7,5,1], 2 Output: [0, 3, 5] Explanation:
 *         Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices
 *         [0, 3, 5]. We could have also taken [2, 1], but an answer of [1, 3,
 *         5] would be lexicographically larger. Note: nums.length will be
 *         between 1 and 20000. nums[i] will be between 1 and 65535. k will be
 *         between 1 and floor(nums.length / 3).
 * 
 */
public class MaximumSumof3NonOverlappingSubarrays {

	public int[] maxSumOfThreeSubarrays(int[] a, int k) {
		int[] res = new int[3];
		if (a == null || k <= 0 || a.length < 3 * k) {
			return res;
		}
		int n = a.length;
		int sum[] = new int[n + 1];

		// calculate range sum
		for (int i = 1; i <= n; i++) {
			sum[i] = a[i - 1] + sum[i - 1];
		}

		int t[][] = new int[4][n + 1];
		int idx[][] = new int[4][n + 1];

		for (int i = 1; i <= 3; i++) {
			for (int j = k * i; j <= n; j++) {
				int curSum = sum[j] - sum[j - k] + t[i - 1][j - k];
				if (curSum > t[i][j - 1]) {
					t[i][j] = curSum;
					idx[i][j] = j - k;
				} else {
					t[i][j] = t[i][j - 1];
					idx[i][j] = idx[i][j - 1];
				}
			}
		}

		// int index = n;
		// for (int i = res.length - 1; i >= 0; i--) {
		// res[i] = idx[i + 1][index];
		// index = res[i];
		// }

		int r=3,c = n;
		while (r > 0){
			res[r-1] = idx[r][c];
			c= idx[r][c];
			r--;
		}
		return res;
	}

	public static void main(String[] args) {
		int result[] = null;
		MaximumSumof3NonOverlappingSubarrays obj = new MaximumSumof3NonOverlappingSubarrays();
		result = obj.maxSumOfThreeSubarrays(new int[] { 1, 2, 1, 2, 6, 7, 5, 1 }, 2);
		System.out.println(Arrays.toString(result));

	}

}
