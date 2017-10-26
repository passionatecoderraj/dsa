package com.raj.dp;

import java.util.Arrays;

import com.interview.graph.CommonUtil;

public class CoinsMinimumToMakeSum {

	public int minCoinsToMakeSum(int[] a, int sum) {
		int t[] = new int[sum + 1];
		Arrays.fill(t, Integer.MAX_VALUE - 1);
		t[0] = 0;

		for (int j = 1; j <= sum; j++) {
			for (int i = 0; i < a.length; i++) {
				if (j >= a[i]) {
					t[j] = Math.min(t[j], 1 + t[j - a[i]]);
				}
			}
		}
		CommonUtil.printArray(t);
		return t[sum];
	}

	public static void main(String[] args) {
		int a[] = { 1, 5, 6, 8 };
		CoinsMinimumToMakeSum obj = new CoinsMinimumToMakeSum();
		int result = -1, sum = 11;
		result = obj.minCoinsToMakeSum(a, sum);
		System.out.println(result);
		result = obj.minCoinsToMakeSum2(a, sum);
		System.out.println(result);
	}

	public int minCoinsToMakeSum2(int[] a, int m) {
		int n = a.length;

		int t[] = new int[m + 1];
		Arrays.fill(t, Integer.MAX_VALUE - 1);
		t[0] = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 0; j < n; j++) {
				if (i >= a[j]) {
					t[i] = Math.min(1 + t[i - a[j]], t[i]);
				}
			}
		}
		CommonUtil.printArray(t);
		return t[m];
	}

}
