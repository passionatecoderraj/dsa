package com.raj.leetcode.google;

import com.interview.graph.CommonUtil;

/**
 * 
 * @author Raj
 *We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

Example:

n = 10, I pick 8.

First round:  You guess 5, I tell you that it's higher. You pay $5.
Second round: You guess 7, I tell you that it's higher. You pay $7.
Third round:  You guess 9, I tell you that it's lower. You pay $9.

Game over. 8 is the number I picked.

You end up paying $5 + $7 + $9 = $21.
Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 */
public class GuessNumberHigherorLower2 {

	//https://leetcode.com/problems/guess-number-higher-or-lower-ii/solution/
	// Time : O(n3), Space :O(n2)
	public int getMoneyAmount(int n) {
		int t[][] = new int[n + 1][n + 1];

		for (int l = 2; l <= n; l++) {
			for (int i = 1; i <= n - l + 1; i++) {
				int j = i + l - 1;
				int min = Integer.MAX_VALUE;
				/*
				 * Note that it's not k<=j because guessing highest value never result less value
				 * also, k!=i because of explanation in link
				 */
				for (int k = i + (j - i) / 2; k < j; k++) {
					int cur = k + Math.max(t[i][k - 1], t[k + 1][j]);
					min = Math.min(cur, min);
				}
				t[i][j] = min;
			}
		}
		 CommonUtil.print2DArray(t, n+1, n+1);
		return t[1][n];
	}

	public int getMoneyAmount2(int n) {
		int t[][] = new int[n + 1][n + 1];

		for (int l = 2; l <= n; l++) {
			for (int i = 1; i <= n - l + 1; i++) {
				int j = i + l - 1;
				int min = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					int cur = k + Math.max(t[i][k - 1], t[k + 1][j]);
					min = Math.min(cur, min);
				}
				t[i][j] = min;
			}
		}
		// CommonUtil.print2DArray(t, n+1, n+1);
		return t[1][n];
	}

	public int calculate3(int low, int high) {
		if (low >= high)
			return 0;
		int minres = Integer.MAX_VALUE;
		for (int i = (low + high) / 2; i <= high; i++) {
			int res = i + Math.max(calculate3(i + 1, high), calculate3(low, i - 1));
			minres = Math.min(res, minres);
		}
		return minres;
	}

	public int getMoneyAmount3(int n) {
		return calculate3(1, n);
	}

	public int calculate4(int low, int high) {
		if (low >= high)
			return 0;
		int minres = Integer.MAX_VALUE;
		for (int i = low; i <= high; i++) {
			int res = i + Math.max(calculate4(i + 1, high), calculate4(low, i - 1));
			minres = Math.min(res, minres);
		}

		return minres;
	}

	public int getMoneyAmount4(int n) {
		return calculate4(1, n);
	}

	public static void main(String[] args) {
		GuessNumberHigherorLower2 obj = new GuessNumberHigherorLower2();
		int result = -1;
		result = obj.getMoneyAmount(3);
		System.out.println(result);

	}

}
