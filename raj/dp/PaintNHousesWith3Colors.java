package com.raj.dp;

import com.interview.graph.CommonUtil;

/**
 * 
 * @author Raj
 *
 *         There are a row of n houses, each house can be painted with one of
 *         the three colors: red, blue or green. The cost of painting each house
 *         with a certain color is different. You have to paint all the houses
 *         such that no two adjacent houses have the same color.
 * 
 *         The cost of painting each house with a certain color is represented
 *         by a n x 3 cost matrix. For example, costs[0][0] is the cost of
 *         painting house 0 with color red; costs[1][2] is the cost of painting
 *         house 1 with color green, and so on... Find the minimum cost to paint
 *         all houses.
 * 
 * 
 */
public class PaintNHousesWith3Colors {

	// Time : O(n*k), Space : O(n)
	// if we cannot change array
	public int minCostToPaintNHousesWith3Colors(int[][] a) {
		int m = a.length;
		if (m == 0)
			return 0;
		int n = a[0].length;

		int prev[] = new int[n];

		System.arraycopy(a[0], 0, prev, 0, n);
		for (int i = 1; i < m; i++) {
			int cur[] = new int[n];
			cur[0] = Math.min(prev[1], prev[2]) + a[i][0];
			cur[1] = Math.min(prev[0], prev[2]) + a[i][1];
			cur[2] = Math.min(prev[0], prev[1]) + a[i][2];
			System.arraycopy(cur, 0, prev, 0, n);
		}
		return Math.min(prev[1], Math.min(prev[0], prev[2]));
	}

	// Time : O(n*k), Space : O(1)
	public int minCostToPaintNHousesWith3Colors2(int[][] cost) {
		int n = cost.length;

		if (null == cost || n == 0)
			return Integer.MAX_VALUE;

		for (int i = 1; i < n; i++) {
			cost[i][0] += Math.min(cost[i - 1][1], cost[i - 1][2]);
			cost[i][1] += Math.min(cost[i - 1][0], cost[i - 1][2]);
			cost[i][2] += Math.min(cost[i - 1][0], cost[i - 1][1]);
		}
		CommonUtil.print2DArray(cost, n, 3);

		return Math.min(cost[n - 1][0], Math.min(cost[n - 1][1], cost[n - 1][2]));
	}

	public static void main(String args[]) {
		PaintNHousesWith3Colors obj = new PaintNHousesWith3Colors();
		int cost[][] = { { 5, 8, 6 },
				{ 19, 14, 13 }, 
				{ 7, 5, 12 }, { 14, 15, 17 }, { 3, 20, 10 } };
		int result = obj.minCostToPaintNHousesWith3Colors(cost);
		System.out.println(result);
	}

}