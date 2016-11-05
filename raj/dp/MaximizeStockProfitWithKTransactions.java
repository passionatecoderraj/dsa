package com.raj.dp;

import java.util.Deque;
import java.util.LinkedList;

import com.interivew.graph.CommonUtil;

public class MaximizeStockProfitWithKTransactions {

	public static void main(String[] args) {
		int a[] = { 2, 5, 7, 1, 4, 3, 1, 3 };
		// int a[] = { 100, 80, 120, 130, 70, 60, 100, 125 };

		MaximizeStockProfitWithKTransactions obj = new MaximizeStockProfitWithKTransactions();
		int result = -1, n = a.length, k = 3;
		// buy and sell utmost once
		// Time : O(n), Space : O(1)
		result = obj.maxProfitWithAtMost1Transaction(a, n);
		System.out.println(result);

		// buy and sell utmost once
		// Time : O(n), Space : O(1)
		result = obj.maxProfitWithAtMost2Transactions(a, n);
		System.out.println(result);

		// Time : O(n*n*k), Space : O(n*k)
		result = obj.maxProfitWithKTransactions(a, n, k);
		System.out.println(result);

		// Time : O(n*k), Space : O(n*k)
		result = obj.maxProfitWithKTransactionsWithMaxDiff(a, n, k);
		System.out.println(result);

		// buy and sell many times
		// Time : O(n), Space : O(1)
		result = obj.maxProfitWithAnyNumberOfTransactions(a, n);
		System.out.println(result);

		// TODO: print solution, for buy and sell multiple times
		// obj.maxProfitWithAnyNumberOfTransactionsPrintTransationDays(a, n);

	}

	// buy and sell utmost once
	public int maxProfitWithAtMost1Transaction(int[] a, int n) {
		if (n <= 1)
			return -1;
		int min_so_far = a[0];
		int maxProfit = Integer.MIN_VALUE;

		for (int i = 1; i < n; i++) {
			maxProfit = Math.max(maxProfit, a[i] - min_so_far);
			min_so_far = Math.min(a[i], min_so_far);
		}
		return maxProfit;
	}

	// buy and sell utmost twice
	public int maxProfitWithAtMost2Transactions(int[] a, int n) {
		int profit[] = new int[n];

		int max_so_far = a[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			profit[i] = Math.max(profit[i + 1], a[i] - max_so_far);
			max_so_far = Math.max(a[i], max_so_far);
		}
		CommonUtil.printArray(profit);
		int min_so_far = a[0];
		for (int i = 1; i < n; i++) {
			profit[i] = Math.max(profit[i - 1], profit[i] + a[i] - min_so_far);
			min_so_far = Math.min(a[i], min_so_far);
		}
		CommonUtil.printArray(profit);
			return profit[n - 1];
	}

	// MaxProfit With K Transactions : Slow Solution
	// Time : O(n*n*k), Space : O(n*k)
	public int maxProfitWithKTransactions(int[] a, int n, int k) {
		int t[][] = new int[k + 1][n];

		for (int i = 0; i < n; i++) {
			t[0][i] = 0;
		}

		for (int i = 0; i <= k; i++) {
			t[i][0] = 0;
		}

		int val;
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j < n; j++) {
				val = Integer.MIN_VALUE;
				for (int m = 0; m < j; m++) {
					val = Math.max(val, a[j] - a[m] + t[i - 1][m]);
				}
				t[i][j] = Math.max(t[i][j - 1], val);
			}
		}
		return t[k][n - 1];
	}

	// buy and sell k times
	// Time : O(n*k), Space : O(n*k)
	public int maxProfitWithKTransactionsWithMaxDiff(int[] a, int n, int k) {
		int t[][] = new int[k + 1][n];

		for (int i = 0; i < n; i++) {
			t[0][i] = 0;
		}

		for (int i = 0; i <= k; i++) {
			t[i][0] = 0;
		}

		int maxDiff = 0;
		for (int i = 1; i <= k; i++) {
			maxDiff = t[i - 1][0] - a[0];
			for (int j = 1; j < n; j++) {
				t[i][j] = Math.max(t[i][j - 1], maxDiff + a[j]);
				maxDiff = Math.max(maxDiff, t[i - 1][j] - a[j]);
			}
		}

		// printSolution(a, t);
		return t[k][n - 1];
	}

	public void printSolution(int[] a, int[][] t) {
		Deque<Integer> stack = new LinkedList<Integer>();
		int i = t.length - 1, j = t[0].length - 1;
		int diff;
		while (true) {
			if (i == 0 || j == 0) {
				break;
			}
			if (t[i][j] == t[i][j - 1]) {
				j = j - 1;
			} else {
				stack.push(j);
				diff = t[i][j] - a[j];
				for (int k = j - 1; k >= 0; k--) {
					if (t[i - 1][k] - a[k] == diff) {
						stack.push(k);
						i = i - 1;
						j = k;
						break;
					}
				}
			}
		}

		while (!stack.isEmpty()) {
			System.out.println("Buy at : " + stack.pop() + ", Sell at : " + stack.pop());
		}
	}

	// buy and sell many times
	public int maxProfitWithAnyNumberOfTransactions(int[] a, int n) {
		int profit = 0;
		for (int i = 1; i < n; i++) {
			if (a[i] > a[i - 1]) {
				profit += (a[i] - a[i - 1]);
			}
		}
		return profit;
	}

	public void maxProfitWithAnyNumberOfTransactionsPrintTransationDays(int[] a, int n) {
		if (n <= 0)
			return;
		int buyDate = 0, i;
		for (i = 1; i < n; i++) {
			if (a[i] <= a[i - 1]) {
				System.out.println("Buy Date : " + buyDate + ", Sell Date : " + (i - 1));
				buyDate = i;
			} else if (i == n - 1) {
				System.out.println("Buy Date : " + buyDate + ", Sell Date : " + i);
			}
		}

	}
}
