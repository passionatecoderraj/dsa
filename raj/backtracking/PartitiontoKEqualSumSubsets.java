package com.raj.backtracking;

import java.util.Arrays;

/**
 * 
 * @author Raj
 *Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.

Example 1:
Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
Note:

1 <= k <= len(nums) <= 16.
0 < nums[i] < 10000.
 * 
 */
public class PartitiontoKEqualSumSubsets {

	/*
	 * This is recursive solution. If interested, dp solution is available at
	 * https://leetcode.com/articles/partition-to-k-equal-sum-subsets/
	 */
	//https://discuss.leetcode.com/topic/107185/java-c-straightforward-dfs-solution
	public boolean canPartitionKSubsets(int[] a, int k) {
		if (k > a.length)
			return false;

		int sum = 0;
		for (int n : a)
			sum += n;
		if (sum % k != 0) {
			return false;
		}
		Arrays.sort(a);
		boolean[] visited = new boolean[a.length];
		return canPartitionUtil(a, k, visited, 0, 0, sum / k, 0);
	}

	private boolean canPartitionUtil(int[] a, int k, boolean[] visited, int index, int sum, int target, int count) {
		if (sum > target)
			return false;

		if (1 == k) {
			return true;
		}
		/*
		 * 'count' is added to address corner case when sum=0
		 *  if it's not added every time 'target' and 'sum' are zero and will fail.
		 */
		if (sum == target && count > 0) {
			return canPartitionUtil(a, k - 1, visited, 0, 0, target, 0);
		}

		for (int i = index; i < a.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				if (canPartitionUtil(a, k, visited, i + 1, sum + a[i], target, ++count))
					return true;
				visited[i] = false;
			}
		}
		return false;
	}

	public static void main(String args[]) {
		PartitiontoKEqualSumSubsets obj = new PartitiontoKEqualSumSubsets();
		int a[] = { 4, 3, 2, 3, 5, 2, 1 };
		boolean result = false;
		result = obj.canPartitionKSubsets(new int[] { 1,2,3,4 }, 2);
		System.out.println(result);

		result = obj.canPartitionKSubsets(a, 4);
		System.out.println(result);

		result = obj.canPartitionKSubsets(new int[] { 0, 0, 0, 0 }, 4);
		System.out.println(result);

	}
}