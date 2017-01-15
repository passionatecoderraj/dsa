/**
 * 
 */
package com.raj.dp;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 *         Given n balloons, indexed from 0 to n-1. Each balloon is painted with
 *         a number on it represented by array nums. You are asked to burst all
 *         the balloons. If the you burst balloon i you will get nums[left] *
 *         nums[i] * nums[right] coins. Here left and right are adjacent indices
 *         of i. After the burst, the left and right then becomes adjacent.
 * 
 *         Find the maximum coins you can collect by bursting the balloons
 *         wisely.
 * 
 *         Note: (1) You may imagine nums[-1] = nums[n] = 1. They are not real
 *         therefore you can not burst them. (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 
 *         Example:
 * 
 *         Given [3, 1, 5, 8]
 * 
 *         Return 167
 * 
 *         nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> [] coins = 3*1*5 +
 *         3*5*8 + 1*3*8 + 1*8*1 = 167
 */
public class BalloonBurst {

	// Time :O(n3), Space :O(n2)
	public static int maxCoins(int a[]) {
		if (null == a || a.length == 0)
			return 0;
		int n = a.length;

		int t[][] = new int[n][n];

		for (int l = 1; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				for (int k = i; k <= j; k++) {
					int left = 0, right = 0;
					int lvalue = 1, rvalue = 1;

					if (i != 0) {
						lvalue = a[i - 1];
					}

					if (j != n - 1) {
						rvalue = a[j + 1];
					}
					if (i != k) {
						left = t[i][k - 1];
					}

					if (j != k) {
						right = t[k + 1][j];
					}
					t[i][j] = Math.max(t[i][j], left + right + (lvalue * rvalue * a[k]));
				}
			}
		}
		CommonUtil.print2DArray(t, n, n);
		return t[0][n - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 3, 1, 5, 8 };
		int res = -1;
		res = maxCoins(a);
		System.out.println(res);
	}

}
