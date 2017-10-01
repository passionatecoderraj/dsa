package com.raj.dp;

import com.interview.graph.CommonUtil;

/**
 * 
 * @author Raj
 *
 *         Say you have an array for which the ith element is the price of a
 *         given stock on day i.
 * 
 *         Design an algorithm to find the maximum profit. You may complete as
 *         many transactions as you like (ie, buy one and sell one share of the
 *         stock multiple times) with the following restrictions:
 * 
 *         You may not engage in multiple transactions at the same time (ie, you
 *         must sell the stock before you buy again). After you sell your stock,
 *         you cannot buy stock on next day. (ie, cooldown 1 day) Example:
 * 
 *         prices = [1, 2, 3, 0, 2] maxProfit = 3 transactions = [buy, sell,
 *         cooldown, buy, sell]
 * 
 * 
 */
public class MaxStockProfitWithRestDay {

	// https://discuss.leetcode.com/topic/30431/easiest-java-solution-with-explanations

	// Time :O(n), Space :O(1)
	public static int maxProfit(int[] a) {
		int s0, s1, s2, b0, b1;
		b0 = -a[0];
		// b1 is same as b0 because buying at only 0 is more than buying
		// at both 0 and 1
		b1 = b0;
		s0 = s1 = s2 = 0;

		for (int i = 1; i < a.length; i++) {
			b0 = Math.max(b1, s2 - a[i]);
			s0 = Math.max(s1, b1 + a[i]);
			b1 = b0;
			s2 = s1;
			s1 = s0;
		}

		return s0;
	}

	// Time :O(n), Space :O(n)
	public static int maxProfit2(int[] a) {
		int buy[] = new int[a.length];
		int sell[] = new int[a.length];
		// buy[1] is same as buy[0] because buying at only 0 is more than buying
		// at both 0 and 1
		buy[0] = buy[1] = -a[0];
		sell[1] = Math.max(sell[0], buy[0] + a[1]);

		for (int i = 2; i < a.length; i++) {
			buy[i] = Math.max(buy[i - 1], sell[i - 2] - a[i]);
			sell[i] = Math.max(sell[i - 1], buy[i - 1] + a[i]);
		}
		return sell[a.length - 1];
	}

	// https://discuss.leetcode.com/topic/30680/share-my-dp-solution-by-state-machine-thinking
	// Time :O(n), Space :O(1)
	public static int maxProfit3(int[] a) {
		if (null == a || a.length < 2) {
			return 0;
		}
		int preHold = 0;
		int preSold = Integer.MIN_VALUE;
		int preBuy = -a[0];
		for (int i = 1; i < a.length; i++) {

			int curHold = Math.max(preHold, preSold);
			int curBuy = Math.max(preBuy, preHold - a[i]);
			int curSold = preBuy + a[i];
			preHold = curHold;
			preBuy = curBuy;
			preSold = curSold;
		}

		return Math.max(preHold, preSold);
	}

	// https://discuss.leetcode.com/topic/30680/share-my-dp-solution-by-state-machine-thinking
	// Time :O(n), Space :O(n)
	public static int maxProfit4(int[] a) {
		if (null == a || a.length < 2) {
			return 0;
		}

		int hold[] = new int[a.length];
		int buy[] = new int[a.length];
		int sold[] = new int[a.length];
		hold[0] = 0;
		sold[0] = Integer.MIN_VALUE;
		buy[0] = -a[0];

		for (int i = 1; i < a.length; i++) {
			hold[i] = Math.max(hold[i - 1], sold[i - 1]);
			buy[i] = Math.max(buy[i - 1], hold[i - 1] - a[i]);
			sold[i] = buy[i - 1] + a[i];
		}

		CommonUtil.printArray(hold);
		CommonUtil.printArray(buy);
		CommonUtil.printArray(sold);

		return Math.max(sold[a.length - 1], hold[a.length - 1]);
	}

	public static void main(String args[]) {
		int prices[] = { 1, 2, 3, 0, 2 };
		int profit = -1;
		profit = maxProfit(prices);
		System.out.println(profit);
	}
}