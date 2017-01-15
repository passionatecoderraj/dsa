/**
* 
*/
package com.raj.dp;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class RodCut {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int len[] = { 1, 2, 3, 4 };
		// int profits[] = { 2, 5, 7, 8 };

		int len[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int profits[] = { 1, 5, 8, 9, 10, 17, 17, 20 };

		int result = -1, n = 8;
		RodCut obj = new RodCut();
		result = obj.maximumProfitFromCuttinRodOfLength(len, profits, profits.length, n);
		System.out.println(result);
	}

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
				if (j >= i) {
					t[i][j] = Math.max(t[i - 1][j], profits[i - 1] + t[i][j - i]);
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}

		CommonUtil.print2DArray(t, n + 1, len + 1);

		return t[n][len];
	}

	public int maximumProfitFromCuttinRodOfLength2(int size[], int profits[], int n, int len) {
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

		CommonUtil.print2DArray(t, n + 1, len + 1);

		return t[n][len];
	}
}
