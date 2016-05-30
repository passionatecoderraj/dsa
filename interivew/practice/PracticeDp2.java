package com.interivew.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;

import com.interivew.graph.CommonUtil;

public class PracticeDp2 {



	public int minCutsForPalindromePartition(char a[], int n) {
		boolean p[][] = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			p[i][i] = true;
		}
		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				if (a[i] == a[j]) {
					if (l == 2)
						p[i][j] = true;
					else
						p[i][j] = p[i + 1][j - 1];
				} else {
					p[i][j] = false;
				}
			}
		}

		int t[] = new int[n];

		for (int i = 0; i < n; i++) {
			t[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < n; i++) {
			if (p[0][i] == true) {
				t[i] = 0;
			} else {
				for (int j = 0; j < i; j++) {
					if (p[j + 1][i] == true) {
						t[i] = Math.min(1 + t[j], t[i]);
					}
				}
			}
		}
		return t[n - 1];
	}

	// len is the length of the line
	// a = array of words sized, n : size of a
	public int wordWrap(int[] a, int n, int len) {
		int c[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			c[i][i] = len - a[i];
			for (int j = i + 1; j < n; j++) {
				c[i][j] = c[i][j - 1] - 1 - a[j];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (c[i][j] < 0) {
					c[i][j] = Integer.MAX_VALUE;
				} else {
					c[i][j] = c[i][j] * c[i][j];
				}
			}
		}

		int t[] = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			t[i] = c[i][n - 1];
			for (int j = n - 1; j > i; j--) {
				if (c[i][j - 1] == Integer.MAX_VALUE)
					continue;
				t[i] = Math.min(t[i], c[i][j - 1] + t[j]);
			}
		}
		// CommonUtil.printArray(t);
		return t[0];
	}

	public boolean wordBreak(String str, int n, Set<String> dictionary) {
		boolean t[][] = new boolean[n][n];

		for (int l = 1; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				if (dictionary.contains(str.substring(i, j + 1))) {
					t[i][j] = true;
				} else {
					for (int k = i; k <= j; k++) {
						t[i][j] = t[i][j] || (t[i][k] && t[k + 1][j]);
					}
				}
			}
		}
		return t[0][n - 1];
	}

	/*
	 * Given a sorted array keys[0.. n-1] of search keys and an array freq[0..
	 * n-1] of frequency counts, where freq[i] is the number of searches to
	 * keys[i]. Construct a binary search tree of all keys such that the total
	 * cost of all the searches is as small as possible.
	 */
	// to minimize search cost in bst, we do not use keys and we only use
	// frequencies
	public int optmalBSTs(int keys[], int freqs[], int n) {
		int t[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			t[i][i] = freqs[i];
		}

		int sum = 0, m, cur;
		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				sum = 0;
				m = Integer.MAX_VALUE;

				for (int k = i; k <= j; k++) {
					sum += freqs[k];
					if (k == i) {
						cur = t[k + 1][j];
					} else if (k == j) {
						cur = t[i][k - 1];
					} else {
						cur = t[i][k - 1] + t[k + 1][j];
					}
					m = Math.min(m, cur);
				}
				t[i][j] = sum + m;
			}
		}
		CommonUtil.print2DArray(t, n, n);
		return t[0][n - 1];
	}

	public int optimalGamePickingToMaximizeFirstPlayerSum(int a[], int n) {
		Cell t[][] = new Cell[n][n];
		for (int i = 0; i < n; i++) {
			t[i][i] = new Cell(a[i], 0);
		}

		int p1, p2;
		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				p1 = Math.max(t[i][i].player1 + t[i + 1][j].player2, t[j][j].player1 + t[i][j - 1].player2);
				p2 = Math.min(t[i][i].player2 + t[i + 1][j].player1, t[j][j].player2 + t[i][j - 1].player1);
				t[i][j] = new Cell(p1, p2);
			}
		}

		return t[0][n - 1].player1;
	}

	// m = number of floors, n = no. of eggs
	public int minAttemptsToKnowWhetherEggBreak(int m, int n) {
		int t[][] = new int[m + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			t[1][i] = i;
		}
		for (int i = 2; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (j >= i) {
					t[i][j] = Integer.MAX_VALUE;
					for (int k = 1; k <= j; k++) {
						int a = (k == 1) ? 0 : t[i - 1][k];
						int b = (k == j) ? 0 : t[i][j - k];
						int val = 1 + Math.max(a, b);
						t[i][j] = Math.min(t[i][j], val);
					}
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}

		return t[m][n];
	}

	public int maxSumRectangle(int a[][], int m, int n) {
		int maxLeft = -1;
		int maxRight = -1;
		int maxUp = -1;
		int maxDown = -1;
		int max = Integer.MIN_VALUE;
		int t[] = new int[m];

		for (int l = 0; l < n; l++) {
			for (int j = l; j < n; j++) {
				for (int i = 0; i < m; i++) {
					t[i] += a[i][j];
				}

				KadaneResult kadane = new PracticeArrays().largestContiguousSumUsingKadane(t, t.length);
				if (kadane.maxSum > max) {
					maxLeft = l;
					maxRight = j;
					maxUp = kadane.maxStart;
					maxDown = kadane.maxEnd;
				}
			}
		}
		return max;
	}

	public int maxSubRectangeSizeWithAll1s(int a[][], int m, int n) {
		int t[] = new int[n];
		int curSize, maxSize = Integer.MIN_VALUE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 0)
					t[j] = 0;
				else
					t[j] += a[i][j];
			}
			curSize = maxRectangularAreaForHistograms(t, n);
			maxSize = Math.max(maxSize, curSize);
		}
		return maxSize;
	}

	public int maxRectangularAreaForHistograms(int a[], int n) {
		int maxArea = Integer.MIN_VALUE;
		Deque<Integer> stack = new LinkedList<Integer>();
		int area, top, i;
		for (i = 0; i < n;) {
			if (stack.isEmpty() || a[i] >= a[stack.peekFirst()]) {
				stack.addFirst(i);
				i++;
			} else {
				top = stack.removeFirst();
				if (stack.isEmpty()) {
					area = a[top] * i;
				} else {
					area = a[top] * (i - stack.peekFirst() - 1);
				}
				maxArea = Math.max(area, maxArea);
			}
		}

		while (!stack.isEmpty()) {
			top = stack.removeFirst();
			if (stack.isEmpty()) {
				area = a[top] * i;
			} else {
				area = a[top] * (i - stack.peekFirst() - 1);
			}
			maxArea = Math.max(area, maxArea);
		}

		return maxArea;
	}

	public int maxSubSquareMatrixWithSidesX(char[][] a, int m, int n) {
		Point t[][] = new Point[m][n];
		if (a[0][0] == 'X')
			t[0][0] = new Point(1, 1);

		else
			t[0][0] = new Point(0, 0);

		for (int i = 1; i < n; i++) {
			if (a[0][i] == 'X')
				t[0][i] = new Point(t[0][i - 1].x + 1, 1);
			else
				t[0][i] = new Point(0, 0);
		}

		for (int i = 1; i < m; i++) {
			if (a[i][0] == 'X')
				t[i][0] = new Point(1, t[i - 1][0].y + 1);
			else
				t[i][0] = new Point(0, 0);
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (a[i][j] == 'X')
					t[i][j] = new Point(t[i][j - 1].x + 1, t[i - 1][j].y + 1);
				else
					t[i][j] = new Point(0, 0);
			}
		}

		CommonUtil.print2DArray(t, m, n);

		int min, _i, _j;
		int maxSize = Integer.MIN_VALUE;
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				min = Math.min(t[i][j].x, t[i][j].y);
				for (int k = min; k >= 2; k--) {
					_i = i - k + 1;
					_j = j - k + 1;
					if (_i >= 0 && _j >= 0 && t[_i][j].x >= k && t[i][_j].y >= k) {
						maxSize = Integer.max(k, maxSize);
					}
				}
			}
		}

		return maxSize;
	}

	



	// buy and sell utmost once
	// Time : O(n), Space : O(1)
	public int maxProfitWithAtMost1Transaction(int[] a, int n) {
		if (n <= 0)
			return -1;
		int min_so_far = Integer.MAX_VALUE;
		int maxProfit = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			min_so_far = Math.min(a[i], min_so_far);
			maxProfit = Math.max(maxProfit, a[i] - min_so_far);
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

	// buy and sell many times
	// Time : O(n), Space : O(1)
	public int maxProfitWithAnyNumberOfTransactions(int[] a, int n) {
		int profit = 0;
		for (int i = 1; i < n; i++) {
			if (a[i] > a[i - 1]) {
				profit += (a[i] - a[i - 1]);
			}
		}
		return profit;
	}

	// buy and sell many times : Print solutions
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

	// not important
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

	class Box {
		int w;
		int l;
		int h;

		public Box(int w, int l, int h) {
			super();
			this.w = w;
			this.l = l;
			this.h = h;
		}

	}

	class Pair {
		int a;
		int b;
	}

	class Cell {
		int player1;
		int player2;

		public Cell(int player1, int player2) {
			super();
			this.player1 = player1;
			this.player2 = player2;
		}

		@Override
		public String toString() {
			return "[p1=" + player1 + ", p2=" + player2 + "]";
		}

	}

	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}
}
