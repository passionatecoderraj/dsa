/**
 * 
 */
package com.raj.dp;

/**
 * @author Raj
 *
 */
public class Knapsack {

	public int knapSack2(int[] wts, int[] profits, int w) {
		int t[] = new int[w + 1];
		for (int i = 0; i < wts.length; i++) {
			for (int j = w; j >= wts[i]; j--) {
				t[j] = Math.max(t[j], profits[i] + t[j - wts[i]]);
			}
		}
		return t[w];
	}

	public static void main(String[] args) {
		int wt[] = { 10, 20, 30 };
		int profits[] = { 60, 100, 120 };

		int result = -1;
		Knapsack obj = new Knapsack();
		result = obj.knapSack(wt, profits, 50);
		System.out.println(result);

		int res = obj.knapSack2(wt, profits, 50);
		System.out.println(res);

	}

	public int knapSack(int[] wts, int[] profits, int w) {
		int n = wts.length;
		int t[][] = new int[n + 1][w + 1];

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < w + 1; j++) {
				if (j >= wts[i - 1]) {
					t[i][j] = max(t[i - 1][j], profits[i - 1] + t[i - 1][j - wts[i - 1]]);
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}

		return t[n][w];
	}

	public int max(int i, int j) {
		return i > j ? i : j;
	}

}
