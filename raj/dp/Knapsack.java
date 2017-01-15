/**
 * 
 */
package com.raj.dp;

import java.util.ArrayList;
import java.util.List;

import com.raj.sorting.SortArrayByAnotherArray;

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

		int w[] = { 7, 8, 9, 11, 12 };
		int p[] = { 13, 15, 16, 23, 24 };
		double res = obj.bruteFoce(w, p, 26);
		System.out.println(res);
	}

	public double bruteFoce(int[] wts, int[] profits, int ks) {
		List<ArrayList<Integer>> list = new ArrayList<>();
		int res[] = new int[wts.length];
		permute(list, res, 0, wts.length);
		double curProfit = 0, maxProfit = Double.MIN_VALUE;
		int curWt = 0;
		int a[] = { 3, 4, 1, 0, 2 };

		for (ArrayList<Integer> item : list) {
			curWt = ks;
			curProfit = 0;

			for (int j = 0, i = 0; j < item.size(); j++) {
				i = item.get(a[j]);
				if (i == 1)
					if (curWt > 0 && wts[a[j]] <= curWt) {
						curProfit += profits[a[j]];
						curWt -= wts[a[j]];
					} else {
						double p = ((curWt / wts[a[j]]) * profits[a[j]]);
						curWt = 0;
						curProfit += p;
					}
			}

			maxProfit = Math.max(maxProfit, curProfit);
			System.out.println(item + " = " + curProfit);
		}
		return maxProfit;

	}

	public void permute(List<ArrayList<Integer>> list, int a[], int l, int n) {
		if (l == n) {
			ArrayList<Integer> lst = new ArrayList<>();
			for (int i = 0; i < a.length; i++)
				lst.add(a[i]);
			list.add(lst);
			return;
		}
		for (int i = 0; i < 2; i++) {
			a[l] = i;
			permute(list, a, l + 1, n);
		}

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
