package com.interivew.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;

public class PracticeDp {

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

	// m is size of array, n is the sum
	// Space : O(mn)
	public int minCoinsToMakeChangeN(int a[], int m, int n) {
		int[][] t = new int[m + 1][n + 1];

		t[0][0] = 0;
		for (int i = 1; i <= n; i++) {
			t[0][i] = 0;
		}

		for (int i = 1; i <= m; i++) {
			t[i][0] = 1;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (j >= a[i - 1]) {
					t[i][j] = t[i - 1][j] + t[i][j - a[i - 1]];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[m][n];
	}

	// m is size of array, n is the sum
	// Space : O(n)
	public int minCoinsToMakeChangeNWithOptimizedSpace(int a[], int m, int n) {
		int[] t = new int[n + 1];
		t[0] = 1;

		for (int i = 0; i < m; i++) {
			for (int j = a[i]; j <= n; j++) {
				if (j >= a[i]) {
					t[j] += t[j - a[i]];
				}
			}
		}
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

	private Box[] getBoxesOfAllPossibleSizes(Box[] b, int n) {
		Box[] a = new Box[n * 3];
		int j = 0;
		for (int i = 0; i < n; i++) {
			a[j++] = new Box(b[i].w, b[i].l, b[i].h);
			a[j++] = new Box(b[i].w, b[i].h, b[i].l);
			a[j++] = new Box(b[i].h, b[i].l, b[i].w);
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
	// result = t[3]*t[0] + t[2]*t[1] + t[1]*t[2] + t[0]*t[3]
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

	public int maxSubSquareMatringWithAll1s(int a[][], int m, int n) {
		int t[][] = new int[m + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			t[0][i] = 0;
		}
		for (int i = 0; i <= m; i++) {
			t[i][0] = 0;
		}
		int max = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= m; j++) {
				if (a[i - 1][j - 1] == 1) {
					t[i][j] = 1 + Math.min(t[i - 1][j - 1], Math.min(t[i][j - 1], t[i - 1][j]));
					max = Integer.max(max, t[i][j]);
				} else {
					t[i][j] = 0;
				}
			}
		}
		return max;
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

				KadaneResult kadane = new Practice().largestContiguousSumUsingKadane(t, t.length);
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
