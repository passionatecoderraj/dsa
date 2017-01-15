package com.raj.dp;

import com.interivew.graph.CommonUtil;

/**
 * 
 * @author Raj
 *
 *         There are a row of n houses, each house can be painted with one of
 *         the k colors. The cost of painting each house with a certain color is
 *         different. You have to paint all the houses such that no two adjacent
 *         houses have the same color.
 * 
 *         The cost of painting each house with a certain color is represented
 *         by a n x k cost matrix. For example, costs[0][0] is the cost of
 *         painting house 0 with color 0; costs[1][2] is the cost of painting
 *         house 1 with color 2, and so on... Find the minimum cost to paint all
 *         houses.
 * 
 *         Explanation here:
 *         http://buttercola.blogspot.com/2015/09/leetcode-paint-house-ii.html
 * 
 * 
 *         code here :
 *         http://www.programcreek.com/2014/05/leetcode-paint-house-ii-java/
 * 
 */
public class PaintNHousesWithKColors {
	// Time : O(n*k), Space : O(1)
	// same as above but with understandable logic
	public int minCostToPaintNHousesWithKColorsTimeOptimized(int[][] cost) {
		int n = cost.length;
		int k = cost[0].length;

		if (null == cost || n == 0)
			return Integer.MAX_VALUE;

		int prev1stMin = 0;
		int prev1stMinIndex = -1;
		int prev2ndMin = 0;

		for (int i = 0; i < n; i++) {
			int cur1stMin = Integer.MAX_VALUE;
			int cur1stMinIndex = -1;
			int cur2ndMin = Integer.MAX_VALUE;
			for (int j = 0; j < k; j++) {
				if (prev1stMinIndex == j) {
					cost[i][j] += prev2ndMin;
				} else {
					cost[i][j] += prev1stMin;
				}

				if (cost[i][j] < cur1stMin) {
					cur2ndMin = cur1stMin;
					cur1stMin = cost[i][j];
					cur1stMinIndex = j;
				} else if (cost[0][j] < cur2ndMin) {
					cur2ndMin = cost[i][j];
				}
			}
			prev1stMin = cur1stMin;
			prev1stMinIndex = cur1stMinIndex;
			prev2ndMin = cur2ndMin;
		}

		CommonUtil.print2DArray(cost, n, k);

		int minCost = Integer.MAX_VALUE;
		for (int j = 0; j < k; j++) {
			minCost = Math.min(minCost, cost[n - 1][j]);
		}
		return minCost;
	}

	// Time : O(n*k), Space : O(1)
	// same as above but with understandable logic
	public int minCostToPaintNHousesWithKColorsTimeOptimizedEasyUnderstanding(int[][] cost) {
		int n = cost.length;
		int k = cost[0].length;

		if (null == cost || n == 0)
			return Integer.MAX_VALUE;

		int prev1stMin = Integer.MAX_VALUE;
		int prev1stMinIndex = -1;
		int prev2ndMin = Integer.MAX_VALUE;
		for (int j = 0; j < k; j++) {
			if (cost[0][j] < prev1stMin) {
				prev2ndMin = prev1stMin;
				prev1stMin = cost[0][j];
				prev1stMinIndex = j;
			} else if (cost[0][j] < prev2ndMin) {
				prev2ndMin = cost[0][j];
			}
		}

		for (int i = 1; i < n; i++) {
			int cur1stMin = Integer.MAX_VALUE;
			int cur1stMinIndex = -1;
			int cur2ndMin = Integer.MAX_VALUE;
			for (int j = 0; j < k; j++) {
				if (prev1stMinIndex == j) {
					cost[i][j] += prev2ndMin;
				} else {
					cost[i][j] += prev1stMin;
				}

				if (cost[i][j] < cur1stMin) {
					cur2ndMin = cur1stMin;
					cur1stMin = cost[i][j];
					cur1stMinIndex = j;
				} else if (cost[0][j] < cur2ndMin) {
					cur2ndMin = cost[i][j];
				}
			}
			prev1stMin = cur1stMin;
			prev1stMinIndex = cur1stMinIndex;
			prev2ndMin = cur2ndMin;
		}

		CommonUtil.print2DArray(cost, n, k);

		int minCost = Integer.MAX_VALUE;
		for (int j = 0; j < k; j++) {
			minCost = Math.min(minCost, cost[n - 1][j]);
		}
		return minCost;
	}

	// Time : O(n*k*k), Space : O(1)
	public int minCostToPaintNHousesWithKColors(int[][] cost) {
		int n = cost.length;
		int k = cost[0].length;
		if (null == cost || n == 0)
			return Integer.MAX_VALUE;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < k; j++) {
				int min = Integer.MAX_VALUE;
				for (int m = 0; m < k; m++) {
					if (m != j) {
						min = Math.min(min, cost[i - 1][m]);
					}
				}
				cost[i][j] += min;
			}
		}
		// CommonUtil.print2DArray(cost, n, 3);

		int minCost = Integer.MAX_VALUE;
		for (int j = 0; j < k; j++) {
			minCost = Math.min(minCost, cost[n - 1][j]);
		}
		return minCost;
	}

	public static void main(String args[]) {
		PaintNHousesWithKColors obj = new PaintNHousesWithKColors();
		int cost[][] = { { 5, 8, 6 }, { 19, 14, 13 }, { 7, 5, 12 }, { 14, 15, 17 }, { 3, 20, 10 } };
		int result = obj.minCostToPaintNHousesWithKColors(cost);
		System.out.println(result);

		int cost1[][] = { { 5, 8, 6 }, { 19, 14, 13 }, { 7, 5, 12 }, { 14, 15, 17 }, { 3, 20, 10 } };
		result = obj.minCostToPaintNHousesWithKColorsTimeOptimized(cost1);
		System.out.println(result);
	}

}