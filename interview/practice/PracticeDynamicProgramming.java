package com.interview.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;

import com.interview.graph.CommonUtil;
import com.interview.practice.PracticeDp.Pair;

public class PracticeDynamicProgramming {

	// lis model
	public int longestIncreasingSumSubSequence(int a[], int n) {
		int t[] = new int[n];
		for (int i = 0; i < n; i++) {
			t[i] = 1;
		}
		int maxLen = Integer.MIN_VALUE;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j]) {
					t[i] = Math.max(t[i], 1 + t[j]);
					maxLen = Math.max(t[i], maxLen);
				}
			}
		}

		return maxLen;
	}

	public int maxIncreasingSumSubSequence(int a[], int n) {
		int t[] = new int[n];
		int maxSum = Integer.MIN_VALUE;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j]) {
					t[i] = Math.max(t[i], a[i] + t[j]);
					maxSum = Math.max(t[i], maxSum);
				}
			}
		}

		return maxSum;
	}

	public int longestBitonicSubSequence(int a[], int n) {
		int lis[] = new int[n];
		int lds[] = new int[n];

		for (int i = 0; i < n; i++) {
			lis[i] = 1;
			lds[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j]) {
					lis[i] = Math.max(lis[i], 1 + lis[j]);
				}
			}
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = n - 1; j > i; j--) {
				if (a[i] > a[j]) {
					lds[i] = Math.max(lds[i], 1 + lds[j]);
				}
			}
		}

		int maxLen = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			maxLen = Math.max(maxLen, lis[i] + lds[i] - 1);
		}
		return maxLen;
	}

	public int maxLengthOfChainPairs(Pair[] a) {
		Arrays.sort(a, new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				return p1.a - p2.a;
			}
		});
		int n = a.length;
		int t[] = new int[n];
		for (int i = 0; i < n; i++) {
			t[i] = 1;
		}
		int max = t[0];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i].a > a[j].b) {
					t[i] = Math.max(t[i], t[j] + 1);
					max = Math.max(max, t[i]);
				}
			}
		}
		return max;
	}

	// did not execute
	public int maxHeightFromBoxStacking(Box[] b, int n) {
		Box[] a = getBoxesOfAllPossibleSizes(b, n);
		Arrays.sort(a, new Comparator<Box>() {
			public int compare(Box b1, Box b2) {
				return (b2.l * b2.w) - (b1.l * b1.w);
			}
		});
		int m = a.length;
		int t[] = new int[m];
		for (int i = 0; i < m; i++) {
			t[i] = a[i].h;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i].l > a[j].l && a[i].w > a[j].w) {
					t[i] = Math.max(t[j] + a[i].h, t[i]);
				}
			}
		}
		return t[n - 1];
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

	private Box[] getBoxesOfAllPossibleSizes(Box[] b, int n) {
		Box[] a = new Box[n * 3];
		int j = 0;
		int max, min, other;
		for (int i = 0; i < n; i++) {
			max = Math.max(b[i].l, Math.max(b[i].w, b[i].h));
			min = Math.min(b[i].l, Math.min(b[i].w, b[i].h));
			if (b[i].l != max && b[i].l != min)
				other = b[i].l;
			else if (b[i].w != max && b[i].w != min)
				other = b[i].w;
			else
				other = b[i].h;
			a[j++] = new Box(max, min, other);
			a[j++] = new Box(max, other, min);
			a[j++] = new Box(other, min, max);
		}
		return a;
	}

	public int minJumpsToReachEnd(int a[], int n) {
		int t[] = new int[n];
		for (int i = 1; i < n; i++) {
			t[i] = Integer.MAX_VALUE;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j + a[j] >= i) {
					t[i] = Math.min(t[i], 1 + t[j]);
				}
			}
		}
		return t[n - 1];
	}

	class ActivityJob {
		int id;
		int start;
		int finish;
		int profit;

		public ActivityJob(int id, int start, int finish, int profit) {
			super();
			this.id = id;
			this.start = start;
			this.finish = finish;
			this.profit = profit;
		}

		public ActivityJob(int id, int start, int finish) {
			super();
			this.id = id;
			this.start = start;
			this.finish = finish;
		}

		@Override
		public String toString() {
			return "ActivityJob [id=" + id + ", start=" + start + ", finish=" + finish + ", profit=" + profit + "]";
		}
	}

	public int maxProfitFromWeightedJobScheduling(ActivityJob[] a, int n) {
		Arrays.sort(a, new Comparator<ActivityJob>() {
			public int compare(ActivityJob j1, ActivityJob j2) {
				return j1.finish - j2.finish;
			}
		});
		int maxProfit = Integer.MIN_VALUE;

		int t[] = new int[n];
		for (int i = 0; i < n; i++) {
			t[i] = a[i].profit;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i].start >= a[j].finish) {
					t[i] = Math.max(t[i], a[i].profit + t[j]);
					maxProfit = Math.max(maxProfit, t[i]);
				}
			}
		}
		return maxProfit;
	}

	// it's catalan number
	// it means when we need for 'n' then calculate all possible sums for 'n-1'
	// and multiply them
	// for example, n=4 then for n=3 possible sums are{(3,0),(2,1),(1,2),(0,3)}
	// result = t[0]*t[3] + t[1]*t[2] + t[2]*t[1] + t[3]*t[0]
	public int countBinaryTreeswithPreorderLength(int n) {
		int t[] = new int[n + 1];
		t[0] = 1;
		t[1] = 1;

		int sum = 0;
		for (int i = 2; i <= n; i++) {
			sum = 0;
			for (int j = 0; j < i; j++) {
				sum += t[j] * t[i - 1 - j];
			}
			t[i] = sum;
		}
		return t[n];
	}

	// it's also catalan number
	public int countBinarySearchTreeswithNumberOfKeys(int n) {
		int t[] = new int[n + 1];
		t[0] = 1;
		t[1] = 1;

		int sum = 0;
		for (int i = 2; i <= n; i++) {
			sum = 0;
			for (int j = 0; j < i; j++) {
				sum += t[j] * t[i - 1 - j];
			}
			t[i] = sum;
		}
		return t[n];
	}

	public int minCoinsToMakeSum(int[] a, int m) {
		int n = a.length;
		int t[] = new int[m + 1];
		Arrays.fill(t, Integer.MAX_VALUE);
		t[0] = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 0; j < n; j++) {
				if (i >= a[j]) {
					t[i] = Math.min(1 + t[a[j] - i], t[i]);
				}
			}
		}
		return t[n];
	}

	// Knapsack model

	// Time : O(nw)
	public int knapsack(int weights[], int profits[], int n, int w) {
		int t[][] = new int[n + 1][w + 1];
		for (int i = 0; i <= n; i++) {
			t[i][0] = 0;
		}
		for (int i = 0; i <= w; i++) {
			t[0][i] = 0;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				if (j >= weights[i - 1]) {
					t[i][j] = Math.max(profits[i - 1] + t[i - 1][j - weights[i - 1]], t[i - 1][j]);
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[n][w];
	}

	public int longestCommonSubSequence(char[] x, char[] y, int m, int n) {
		int t[][] = new int[m + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			t[0][i] = 0;
		}
		for (int i = 0; i <= m; i++) {
			t[i][0] = 0;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x[i - 1] == y[j - 1]) {
					t[i][j] = 1 + t[i - 1][j - 1];
				} else {
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
				}
			}
		}
		return t[m][n];
	}

	public int longestCommonSubString(char[] x, char[] y, int m, int n) {
		int[][] t = new int[m + 1][n + 1];

		for (int i = 0; i < n; i++) {
			t[0][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			t[i][0] = 0;
		}
		int maxLen = 0;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x[i - 1] == y[j - 1]) {
					t[i][j] = 1 + t[i - 1][j - 1];
					maxLen = Integer.max(maxLen, t[i][j]);
				} else {
					t[i][j] = 0;
				}
			}
		}
		return maxLen;
	}

	public int editDistance(char x[], char y[], int m, int n) {
		int t[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			t[i][0] = i;
		}
		for (int i = 0; i <= n; i++) {
			t[0][i] = i;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x[i - 1] == y[j - 1]) {
					t[i][j] = t[i - 1][j - 1];
				} else {
					t[i][j] = 1 + Math.min(t[i - 1][j - 1], Math.min(t[i][j - 1], t[i - 1][j]));
				}
			}
		}
		return t[m][n];
	}

	public boolean isSubsetSum(int a[], int n, int k) {
		boolean t[][] = new boolean[n + 1][k + 1];
		for (int i = 0; i <= n; i++) {
			t[i][0] = true;
		}
		for (int i = 1; i <= k; i++) {
			t[0][i] = false;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (j >= a[i - 1]) {
					t[i][j] = t[i - 1][j] || t[i - 1][j - a[i - 1]];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[n][k];
	}

	/*
	 * Partition problem is to determine whether a given set can be partitioned
	 * into two subsets such that the sum of elements in both subsets is same
	 */
	public boolean is2PartitionsPossible(int[] a) {
		int l = a.length;
		int sum = 0;
		for (int i = 0; i < l; i++) {
			sum += a[i];
		}
		if (sum % 2 != 0)
			return false;
		return isSubsetSum(a, a.length, sum / 2);
	}

	public int coinChangeNumberOfWaysToSum(int[] a, int n) {
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

	public int coinChangeNumberOfWaysToSumWithSCOn(int[] a, int n) {
		if (n <= 0)
			return -1;
		int m = a.length;
		int t[] = new int[n + 1];
		t[0] = 1;

		for (int i = 0; i < m; i++) {
			for (int j = a[i]; j < n + 1; j++) {
				t[j] = t[j] + t[j - a[i]];
			}
		}
		CommonUtil.printArray(t);
		return t[n];
	}

	// n : size of profits and size array
	// len : length of desired rod
	public int maximumProfitFromCuttinRodOfLength(int size[], int profits[], int n, int len) {
		int t[][] = new int[n + 1][len + 1];
		for (int i = 0; i <= len; i++) {
			t[0][i] = 0;
		}
		for (int i = 0; i <= n; i++) {
			t[i][0] = 0;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (j >= size[i - 1]) {
					t[i][j] = Math.max(t[i - 1][j], profits[i - 1] + t[i][j - size[i - 1]]);
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[n][len];
	}

	public void printPascalTriangleNthRow(int n) {
		int t[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					t[i][j] = 1;
				} else {
					t[i][j] = t[i - 1][j] + t[i - 1][j - 1];
				}
			}
		}
	}

	public void printPascalTriangleNthRowSpaceOptimized(int n) {
		int t[] = new int[n];
		t[0] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0; j--) {
				t[j] = t[j] + t[j - 1];
			}
		}
	}

	// Time : O(n*r), Space : O(n*r)
	public int binomialCoefficientUsingDp(int n, int r) {
		int t[][] = new int[n + 1][r + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, r); j++) {
				if (j == 0 || j == i) {
					t[i][j] = 1;
				} else {
					t[i][j] = t[i - 1][j - 1] + t[i - 1][j];
				}
			}
		}
		CommonUtil.print2DArray(t, n + 1, r + 1);
		return t[n][r];
	}

	// Time : O(n*r), Space : O(r)
	public int binomialCoefficientUsingDpSpaceEfficient(int n, int r) {
		int t[] = new int[r + 1];
		t[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = Math.min(i, r); j > 0; j--) {
				t[j] = t[j] + t[j - 1];
			}
		}
		CommonUtil.printArray(t);
		return t[r];
	}

	public int numberOfPathsToReachFromTopLeftToBottomRight(int m, int n) {
		int t[][] = new int[m][n];
		t[0][0] = 0;
		for (int i = 1; i < m; i++) {
			t[i][0] = 1;
		}
		for (int i = 1; i < n; i++) {
			t[0][i] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				t[i][j] = t[i - 1][j] + t[i][j - 1];
			}
		}
		return t[m - 1][n - 1];
	}

	/*
	 * Given a cost matrix cost[][] and a position (m, n) in cost[][], write a
	 * function that returns cost of minimum cost path to reach (m, n) from (0,
	 * 0)
	 */
	// x and y are position to reach destination
	public int minCost(int a[][], int m, int n, int x, int y) {
		if (x > m || y > n)
			return -1;
		int t[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			t[0][i] = 0;
		}
		for (int i = 0; i <= m; i++) {
			t[i][0] = 0;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				t[i][j] = a[i - 1][j - 1] + Math.min(t[i - 1][j - 1], Math.min(t[i][j - 1], t[i - 1][j]));
			}
		}
		return t[x][y];
	}

	public int maxSubSquareMatrix(int[][] a, int m, int n) {
		int t[][] = new int[m][n];

		for (int i = 0; i < m; i++) {
			t[i][0] = a[i][0];
		}

		for (int i = 0; i < n; i++) {
			t[0][i] = a[0][i];
		}
		int max = 0;

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (a[i][j] == 1) {
					t[i][j] = 1 + Math.min(t[i - 1][j], Math.min(t[i][j - 1], t[i - 1][j - 1]));
					max = Math.max(max, t[i][j]);
				}
			}
		}
		return max;
	}

	/*
	 * Given three strings A, B and C. Write a function that checks whether C is
	 * an interleaving of A and B. C is said to be interleaving A and B, if it
	 * contains all characters of A and B and order of all characters in
	 * individual strings is preserved.
	 */
	public boolean stringInterLeaving(char a[], char b[], char c[]) {
		int m = a.length, n = b.length;
		if (m + n != c.length)
			return false;
		boolean t[][] = new boolean[m + 1][n + 1];

		t[0][0] = true;
		for (int i = 1; i <= n; i++) {
			if (c[i - 1] == a[i - 1]) {
				t[0][i] = t[0][i - 1];
			}
		}

		for (int i = 1; i <= m; i++) {
			if (c[i - 1] == b[i - 1]) {
				t[i][0] = t[i - 1][0];
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (c[i + j - 1] == a[j - 1]) {
					t[i][j] = t[i][j - 1];
				} else if (c[i + j - 1] == b[i - 1]) {
					t[i][j] = t[i - 1][j];
				} else {
					t[i][j] = false;
				}

			}
		}
		return t[m][n];
	}

	// Matrix multiplication related
	public int longestPalindromeSubSequence(char a[], int n) {

		int t[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			t[i][i] = 1;
		}

		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;

				if (a[i] == a[j]) {
					if (l == 2)
						t[i][j] = 2;
					else
						t[i][j] = 2 + t[i + 1][j - 1];
				} else {
					t[i][j] = Math.max(t[i][j - 1], t[i + 1][j]);
				}
			}
		}
		return t[0][n - 1];
	}

	public int longestPalindromeSubString(char[] a, int n) {
		int t[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			t[i][i] = 1;
		}
		int max = Integer.MIN_VALUE;
		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				if (a[i] == a[j]) {
					if (l == 2)
						t[i][j] = 2;
					else
						t[i][j] = 2 + t[i + 1][j - 1];
					max = Math.max(max, t[i][j]);
				} else {
					t[i][j] = 0;
				}
			}
		}
		return max;
	}

	public boolean wordBreak(String str, int n, Set<String> dictionary) {
		boolean t[][] = new boolean[n][n];

		for (int l = 1; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				if (dictionary.contains(str.substring(i, j + 1))) {
					t[i][j] = true;
				} else {
					for (int k = i; k < j; k++) {
						t[i][j] = t[i][j] || (t[i][k] && t[k + 1][j]);
					}
				}
			}
		}
		CommonUtil.print2DArray(t, n, n);
		return t[0][n - 1];
	}

	public int minCutsForPalindromePartitionsDpOn3(char[] str) {
		int n = str.length;
		if (n <= 0)
			return -1;
		int[][] t = new int[n][n];
		boolean[][] p = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			t[i][i] = 0;
			p[i][i] = true;
		}

		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				if (l == 2) {
					p[i][j] = str[i] == str[j];
				} else {
					p[i][j] = str[i] == str[j] && p[i + 1][j - 1];
				}

				if (p[i][j]) {
					t[i][j] = 0;
					// System.out.println(i + "-" + j);

				} else {
					t[i][j] = Integer.MAX_VALUE;
					for (int k = i; k <= j - 1; k++) {
						int m = 1 + t[i][k] + t[k + 1][j];
						if (m < t[i][j]) {
							t[i][j] = m;
						}
					}
				}
			}
		}

		return t[0][n - 1];
	}

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

	public int optimalGamePickingToMaximizeFirstPlayerSum(int a[], int n) {
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

	// Mathematical
	public int fibonacci(int n) {
		int t[] = new int[n + 1];

		t[0] = 0;
		t[1] = 1;
		for (int i = 2; i <= n; i++) {
			t[i] = t[i - 1] + t[i - 2];
		}
		return t[n];
	}

	public int fibonacciWithoutStoring(int n) {
		int sum, a, b;
		a = 0;
		b = 1;
		sum = 1;
		for (int i = 2; i <= n; i++) {
			sum = a + b;
			a = b;
			b = sum;
		}
		return sum;
	}

	/*
	 * Given a positive integer N, count all possible distinct binary strings of
	 * length N such that there are no consecutive 1’s.
	 */
	// this is of the fibonacci form
	public int countNumberOfBinaryStringWithoutConsecutive1s(int n) {

		int a[] = new int[n];
		int b[] = new int[n];
		a[0] = 1;
		b[0] = 1;

		for (int i = 1; i < n; i++) {
			a[i] = a[i - 1] + b[i - 1];
			b[i] = a[i - 1];
		}
		return a[n - 1] + b[n - 1];
	}

	public int countNumberOfBinaryStringWithoutConsecutive1sWithoutStoring(int n) {
		int a, b, sum;
		a = 1;
		b = 1;
		sum = 2;
		for (int i = 1; i <= n; i++) {
			sum = a + b;
			a = b;
			b = sum;
		}
		return sum;
	}

	/*
	 * There are n stairs, a person standing at the bottom wants to reach the
	 * top. The person can climb either 1 stair or 2 stairs at a time. Count the
	 * number of ways, the person can reach the top.
	 */
	public int numberOfWaysToReachNthStairWithMaxTwoSteps(int n) {
		int t[] = new int[n];
		t[0] = 1;
		t[1] = 2;
		for (int i = 3; i < n; i++) {
			t[i] = t[i - 1] + t[i - 2];
		}
		return t[n - 1];
	}

	public int numberOfWaysToReachNthStairWithoutStoring(int n) {
		int a, b, sum;
		a = 1;
		b = 2;
		sum = a + b;
		for (int i = 3; i <= n; i++) {
			sum = a + b;
			a = b;
			b = sum;
		}
		return sum;
	}

	public int waysToReachNthStepWithMaxThreeSteps(int n) {
		int t[] = new int[n];
		// 1 way to reach step '1' (power of 2)
		t[0] = 1;
		// 2 way to reach step '2' - (1,1) (2)(power of 2)
		t[1] = 2;
		// 3 way to reach step '3' - (1,1,1) (2,1) (1,2) (3)(power of 2)
		t[2] = 4;

		for (int i = 3; i < n; i++) {
			t[i] = t[i - 1] + t[i - 2] + t[i - 3];
		}

		return t[n - 1];
	}

	public int waysToReachNthStepWithMaxNSteps(int n, int maxSteps) {
		if (n < maxSteps)
			return -1;
		int t[] = new int[n];

		for (int i = 0; i < maxSteps; i++) {
			t[i] = (int) Math.pow(2, i);
		}

		for (int i = maxSteps; i < n; i++) {
			t[i] = 0;
			for (int j = 1; j <= maxSteps; j++) {
				t[i] += t[i - j];
			}
		}
		return t[n - 1];
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
}
