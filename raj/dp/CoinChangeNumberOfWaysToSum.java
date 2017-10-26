package com.raj.dp;

import com.interview.graph.CommonUtil;

public class CoinChangeNumberOfWaysToSum {

	public int coinChangeNumberOfWaysToSumWithSCOn(int[] a, int sum) {
		int t[] = new int[sum + 1];
		t[0] = 1;

		for (int i = 0; i < a.length; i++) {
			for (int j = a[i]; j <= sum; j++) {
				t[j] = t[j] + t[j - a[i]];
			}
		}
		CommonUtil.printArray(t);
		return t[sum];
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3 };
		CoinChangeNumberOfWaysToSum obj = new CoinChangeNumberOfWaysToSum();
		int result = -1, sum = 4;
		result = obj.coinChangeNumberOfWaysToSum(a, sum);
		System.out.println(result);
		// with space complexity of O(n)
		result = obj.coinChangeNumberOfWaysToSumWithSCOn(a, sum);
		System.out.println(result);
	}

	private int coinChangeNumberOfWaysToSum(int[] a, int n) {
		int m = a.length;
		int t[][] = new int[m + 1][n + 1];

		for (int i = 1; i < n + 1; i++) {
			t[0][i] = 0;
		}

		for (int i = 0; i < m + 1; i++) {
			t[i][0] = 1;
		}

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (j >= a[i - 1]) {
					t[i][j] = t[i - 1][j] + t[i][j - a[i - 1]];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}

		CommonUtil.print2DArray(t, m + 1, n + 1);
		return t[m][n];
	}

}
