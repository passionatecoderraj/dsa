/**
 * 
 */
package com.raj.dp;

/**
 * @author Raj
 *
 *         Given a non-negative integer n, count all numbers with unique digits,
 *         x, where 0 ≤ x < 10n.
 * 
 *         Example: Given n = 2, return 91. (The answer should be the total
 *         numbers in the range of 0 ≤ x < 100, excluding
 *         [11,22,33,44,55,66,77,88,99])
 */
public class CountNumbersWithUniqueDigits {

	// Time : O(n), Space : O(1)
	public static int countNumbersWithUniqueDigits(int n) {
		if (n < 1)
			return 1;

		if (n == 1)
			return 10;

		if (n == 2)
			return 91;

		int total = 91;

		int prev = 81;
		int k = 8;
		for (int i = 3; i <= n; i++) {
			int cur = prev * k--;
			total += cur;
			prev = cur;
		}
		return total;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int res = countNumbersWithUniqueDigits(5);
		System.out.println(res);
	}

}
