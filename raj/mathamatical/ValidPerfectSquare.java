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
	private static boolean isPerfectSquare(int n) {
		int i = 1;
		while (n > 0) {
			n -= i;
			i += 2;
		}
		return 0 == n;
	}

	public static void main(String[] args) {
		boolean res = false;
		res = isPerfectSquare(19);
		System.out.println(res);
		res = isPerfectSquare(16);
		System.out.println(res);
	}

}
