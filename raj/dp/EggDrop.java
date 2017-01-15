/**
 * 
 */
package com.raj.dp;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class EggDrop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EggDrop obj = new EggDrop();
		// Find min no. of attemts to know whether egg break from nth floor
		// m = no.of eggs and n = number of floors
		int result = -1, m = 3, n = 36;
		result = obj.findMinAttemptsForStatusOfEggBreak(m, n);
		System.out.println(result);

	}

	public int findMinAttemptsForStatusOfEggBreak(int m, int n) {
		int t[][] = new int[m + 1][n + 1];

		for (int i = 0; i < n + 1; i++) {
			t[0][i] = 0;
			t[1][i] = i;
		}

		for (int i = 2; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (j >= i) {
					int val = Integer.MAX_VALUE;
					for (int k = 1; k <= j; k++) {
						int a, b;
						// if egg breaks at 'kth' floor
						a = (k == 1) ? 0 : t[i - 1][k - 1];
						// if egg doens't break at kth floor
						b = (k == j) ? 0 : t[i][j - k];
						int s = 1 + Math.max(a, b);
						val = Math.min(val, s);
					}

					t[i][j] = val;
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		CommonUtil.print2DArray(t, m, n, 1);
		return t[m][n];
	}

}
