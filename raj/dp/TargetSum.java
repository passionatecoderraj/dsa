/**
 * 
 */
package com.raj.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Raj
 *
 */
public class TargetSum {

	public int findTargetSumWays(int[] a, int S) {
		int sum = Arrays.stream(a).sum();
		if (S > sum || S < -sum) {
			return 0;
		}
		int t[][] = new int[a.length][2001];
		t[0][a[0] + 1000] += 1;
		t[0][-a[0] + 1000] += 1;

	}

	public int findTargetSumWays2(int[] nums, int S) {
		Map<String, Integer> map = new HashMap<>();
		return findTargetSumWaysUtilDp(nums, 0, S, map);
	}

	public int findTargetSumWaysUtilDp(int a[], int i, int S, Map<String, Integer> map) {
		// looking for same overlapping subproblems from starting from index i,
		//

		/*
		 *
		 * for example, {1,1,1,1,1}, S=4, looking for sum starting at index 2
		 * {3} when first two indices are {1,-1},{-1,1}
		 * 
		 */
		String key = Integer.toString(i) + "->" + Integer.toString(S);
		if (map.containsKey(key)) {
			return map.get(key);
		}
		if (i == a.length) {
			return 0 == S ? 1 : 0;
		}
		int n = a[i];
		int add = findTargetSumWaysUtilDp(a, i + 1, S + n, map);
		int minus = findTargetSumWaysUtilDp(a, i + 1, S - n, map);
		map.put(key, add + minus);
		return add + minus;
	}

	public int findTargetSumWays3(int[] nums, int S) {
		return findTargetSumWaysUtil3(nums, 0, S);
	}

	public int findTargetSumWaysUtil3(int a[], int i, int S) {
		if (i == a.length) {
			return 0 == S ? 1 : 0;
		}
		int n = a[i];
		int add = findTargetSumWaysUtil3(a, i + 1, S - n);
		int minus = findTargetSumWaysUtil3(a, i + 1, S + n);
		return add + minus;
	}

	public static void main(String[] args) {
		int a[] = { 1, 1, 1, 1, 1 };

		TargetSum obj = new TargetSum();
		int result = -1;
		result = obj.findTargetSumWays(a, 3);

		System.out.println(result);

	}

}
