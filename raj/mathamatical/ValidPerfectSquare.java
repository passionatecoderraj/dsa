/**
 * 
 */
package com.raj.mathamatical;

/**
 * @author Raj
 *
 *         Given a positive integer num, write a function which returns True if
 *         num is a perfect square else False.
 * 
 *         Note: Do not use any built-in library function such as sqrt.
 * 
 *         Example 1:
 * 
 *         Input: 16 Returns: True Example 2:
 * 
 *         Input: 14 Returns: False
 * 
 */
public class ValidPerfectSquare {

	// https://leetcode.com/problems/valid-perfect-square/discuss/269396/Binary-Search-beats-double-100
	// Time : O(logn), Space : O(1)
	public boolean isPerfectSquare(int n) {
		int l = 1, r = n;
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (m * m == n) {
				return true;
			}
			if (m > n / m)
				r = m - 1;
			else
				l = m + 1;
		}
		return false;
	}

	public static boolean isPerfectSquareUsingNewtonRaphson(int n) {
		long x = n;
		while (x * x > n) {
			x = (x + n / x) >> 1;
		}
		return x * x == n;
	}

	/*
	 * A square number is 1+3+5+7+..., JAVA code
	 * 
	 * 1 =1
	 * 
	 * 1+3 = sqr(2)
	 * 
	 * 1+3+5=sqr(3)
	 * 
	 * 1+3+5+7=sqr(4)
	 */
	// Time :O(Sqrt(n))
	private static boolean isPerfectSquare2(int n) {
		int i = 1;
		while (n > 0) {
			n -= i;
			i += 2;
		}
		return 0 == n;
	}

	public static void main(String[] args) {
		boolean res = false;
		ValidPerfectSquare obj = new ValidPerfectSquare();
		res = obj.isPerfectSquare(19);
		System.out.println(res);
		res = obj.isPerfectSquare(16);
		System.out.println(res);
	}

}
