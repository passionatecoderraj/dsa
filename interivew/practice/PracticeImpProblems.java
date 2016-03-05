package com.interivew.practice;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.interivew.graph.CommonUtil;

public class PracticeImpProblems {

	// Time :O(n), Space : O(1)
	// space of array = no. of ascii characters = 256
	public char findFirstNonRepeatingCharacter(char[] a, int n) {
		int count[] = new int[256];
		for (int i = 0; i < n; i++) {
			count[a[i]]++;
		}

		CommonUtil.printArray(count);
		for (int i = 0; i < 256; i++) {
			if (count[i] == 1)
				return (char) i;
		}

		return 0;
	}

	// Time :O(n), Space : O(n)
	public int findFirstRepeatingNumberUsingHashSet(int a[], int n) {
		int repeated = Integer.MIN_VALUE;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = n - 1; i >= 0; i--) {
			if (!set.add(a[i])) {
				repeated = a[i];
			}
		}
		return repeated;
	}

	// Time :O(n), Space : O(n)
	public int findFirstRepeatingNumberUsingHashMap(int[] a, int n) {
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			if (map.containsKey(a[i]))
				map.put(a[i], map.get(a[i]) + 1);
			else
				map.put(a[i], 1);
		}

		for (int i = 0; i < n; i++) {
			if (map.get(a[i]) > 1)
				return a[i];
		}
		return -1;
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

		int min_so_far = a[0];
		for (int i = 1; i < n; i++) {
			profit[i] = Math.max(profit[i - 1], profit[i] + a[i] - min_so_far);
			min_so_far = Math.min(a[i], min_so_far);
		}
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

		return t[k][n - 1];
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

	public void makePrefixArray(int a[], int n, int t[]) {
		int i = 1, j = 0;
		while (i < n) {
			if (a[i] == a[j]) {
				t[i] = j + 1;
				j++;
				i++;
			} else if (j > 0) {
				j = t[j - 1];
			} else {
				t[i] = 0;
				i++;
			}
		}
	}

}
