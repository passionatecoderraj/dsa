/**
 * 
 */
package com.raj.dp.ks;

/**
 * @author Raj
 *
 */
public class Knapsack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int wt[] = { 10, 20, 30 };
		int profits[] = { 60, 100, 120 };

		int result = -1;
		Knapsack obj = new Knapsack();
		result = obj.knapSack(wt, profits, 50);
		System.out.println(result);
	}

	public int knapSack(int[] wts, int[] profits, int w) {
		int n = wts.length;
		int t[][] = new int[n + 1][w + 1];

		for (int i = 0; i < wts.length + 1; i++) {
			t[i][0] = 0;
		}

		for (int j = 0; j < n + 1; j++) {
			t[0][j] = 0;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < w + 1; j++) {
				if (j >= wts[i - 1]) {
					t[i][j] = max(t[i - 1][j], profits[i - 1] + t[i - 1][j - wts[i - 1]]);
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}

		// for (int i = 0; i < n + 1; i++) {
		// for (int j = 0; j < w + 1; j++) {
		// System.out.print(t[i][j] + " ");
		// }
		// System.out.println();
		// }

		return t[n][w];
	}

	public int max(int i, int j) {
		return i > j ? i : j;
	}

}
