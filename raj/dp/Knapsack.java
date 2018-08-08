/**
 * 
 */
package com.raj.dp;

import java.util.Arrays;

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
		System.out.println(Arrays.toString(t));
		return t[w];
	}

	public static void main(String[] args) {
		int wt[] = { 3,8,6 };
		int profits[] = {  7,8,4 };

		int result = -1;
		Knapsack obj = new Knapsack();
		result = obj.knapSack(wt, profits, 10);
		System.out.println(result);

		int res = obj.knapSack2(wt, profits, 10);
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
