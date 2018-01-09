package com.raj.dp;

/**
 * 
 * @author Raj
 *On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
Note:
cost will have a length in the range [2, 1000].
Every cost[i] will be an integer in the range [0, 999].
 */
public class MinCostClimbingStairs {

	// Time : O(n), Space : O(1)
	/*
	 * Cost to reach the top of the floor meaning, reach for stair after the array index.
	 * If there are 'n' elements reach for n+1th stair
	 */
	public int minCostClimbingStairs(int[] a) {
		int p = a[0], q = a[1], r;
		for (int i = 2; i < a.length; i++) {
			r = Math.min(p, q) + a[i];
			p = q;
			q = r;
		}
		return Math.min(p, q);
	}

	// Time : O(n), Space : O(1)
	public int minCostClimbingStairs2(int[] a) {
		int p = 0, q = 0, r;
		for (int i = 2; i <= a.length; i++) {
			r = Math.min(p + a[i - 2], q + a[i - 1]);
			p = q;
			q = r;
		}
		return q;
	}

	// Time : O(n), Space : O(n)
	public int minCostClimbingStairs3(int[] a) {
		int[] t = new int[a.length + 1];
		for (int i = 2; i <= a.length; i++) {
			int prev2 = t[i - 2] + a[i - 2];
			int prev1 = t[i - 1] + a[i - 1];
			t[i] = Math.min(prev1, prev2);
		}
		return t[a.length];
	}

	public static void main(String[] args) {
		MinCostClimbingStairs obj = new MinCostClimbingStairs();
		int result = -1;

		result = obj.minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 });
		System.out.println(result);

		result = obj.minCostClimbingStairs(new int[] { 5, 15, 20 });
		System.out.println(result);

	}

}
