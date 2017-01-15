/**
 * 
 */
package com.raj.dp;

/**
 * @author Raj
 *
 *         Given a positive integer n, break it into the sum of at least two
 *         positive integers and maximize the product of those integers. Return
 *         the maximum product you can get.
 * 
 *         For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return
 *         36 (10 = 3 + 3 + 4).
 * 
 *         Note: You may assume that n is not less than 2 and not larger than
 *         58.
 * 
 *         http://buttercola.blogspot.com/2016/06/leetcode-343-integer-break.
 *         html
 * 
 *         n = 0, => 0 n = 1, => 0
 * 
 *         n = 2, 1 + 1 => 1
 * 
 *         n = 3, 1 + 2 => 2
 * 
 *         n = 4, 2 + 2 => 4
 * 
 *         n = 5, 3 + 2 => 3 * 2 = 6
 * 
 *         n = 6, 3 + 3 => 3 * 3 = 9
 * 
 *         n = 7, 3 + 4 => 3 * 4 = 12
 * 
 *         n = 8, 3 + 3 + 2 => 3 * 3 * 2 = 18
 * 
 *         n = 9, 3 + 3 + 3 => 3 * 3 * 3 = 27
 * 
 *         n = 10, 3 + 3 + 4 => 3 * 3 * 4 = 36
 * 
 *         n = 11, 3 + 3 + 3 + 2 => 3 * 3 * 3 * 2 = 54
 * 
 *         n = 12, 3 + 3 + 3 + 3 => 3 * 3 * 3 * 3 = 81
 * 
 *         https://discuss.leetcode.com/topic/43055/why-factor-2-or-3-the-math-
 *         behind-this-problem/5
 * 
 */

public class IntegerBreak {

	// Time :O(n), Space :O(1)
	public static int integerBreak(int n) {
		if (n == 2 || n == 3)
			return n - 1;
		if (n == 4)
			return 4;
		int res = 1;
		while (n > 4) {
			res = res * 3;
			n -= 3;
		}

		res *= n;
		return res;
	}

	// Time :O(n), Space :O(n)
	public static int integerBreak2(int n) {
		if (n < 2)
			return 0;

		int t[] = new int[n + 1];
		t[0] = t[1] = 0;
		t[2] = 1;
		t[3] = 2;
		t[4] = 4;
		t[5] = 6;
		t[6] = 9;
		for (int i = 7; i <= n; i++) {
			t[i] = t[i - 3] * 3;
		}
		return t[n];
	}

	public static void main(String[] args) {
		int res = integerBreak(6);
		System.out.println(res);
	}

}
