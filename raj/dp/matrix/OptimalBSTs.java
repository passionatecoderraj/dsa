/**
 * 
 */
package com.raj.dp.matrix;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class OptimalBSTs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int keys[] = { 10, 12, 16, 21 };
		int freq[] = { 4, 2, 6, 3 };

		int result = -1;

		OptimalBSTs obj = new OptimalBSTs();

		result = obj.minSearchForOptimalBSTs(keys, freq);

		System.out.println(result);
	}

	public int minSearchForOptimalBSTs(int[] keys, int[] freq) {
		int n = keys.length;

		int t[][] = new int[n][n];
		int result[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			t[i][i] = freq[i];
			result[i][i] = i;
		}

		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				int min = Integer.MAX_VALUE;
				int sum = 0, rootForResultTable = -1;
				for (int k = i; k <= j; k++) {
					int val;
					int root = k;
					if (root == i) {
						val = t[root + 1][j];
					} else if (root == j) {
						val = t[i][root - 1];
					} else {
						val = t[i][root - 1] + t[root + 1][j];
					}
					if (val < min) {
						min = val;
						rootForResultTable = root;
					}
					sum += freq[k];
				}

				t[i][j] = min + sum;
				result[i][j] = rootForResultTable;
			}
		}

		CommonUtil.print2DArray(result, n, n);
		CommonUtil.print2DArray(t, n, n);
		return t[0][n - 1];
	}
}
