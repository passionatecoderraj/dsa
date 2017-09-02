package com.raj.dp;

import java.util.Arrays;

import com.interview.graph.CommonUtil;

public class CoinsMinimumToMakeSum {

	public static void main(String[] args) {
		int a[] = { 1, 5, 6, 8 };
		CoinsMinimumToMakeSum obj = new CoinsMinimumToMakeSum();
		int result = -1, sum = 11;
		result = obj.minCoinsToMakeSum(a, sum);
		System.out.println(result);
		result = obj.minCoinsToMakeSum2(a, sum);
		System.out.println(result);
	}

	public int minCoinsToMakeSum(int[] a, int n) {
		int m = a.length;
		if (m <= 0)
			return -1;

		int t[] = new int[n + 1];
		t[0] = 0;
		for (int i = 1; i < n + 1; i++) {
			t[i] = Integer.MAX_VALUE - 1;
		}

		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (j >= a[i]) {
					t[j] = Math.min(t[j], 1 + t[j - a[i]]);
				}
			}
		}
		CommonUtil.printArray(t);
		return t[n];
	}

	public int minCoinsToMakeSum2(int[] a, int m) {
		int n = a.length;

		int t[] = new int[m + 1];
		Arrays.fill(t, Integer.MAX_VALUE-1);
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
