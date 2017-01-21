/**
 * 
 */
package com.raj.mathamatical;

/**
 * @author Raj
 *
 *         Given an integer n, return the number of trailing zeroes in n!.
 * 
 *         Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeroes {

	public static int trailingZeroes(int n) {
		if (0 == n)
			return 0;

		return n / 5 + trailingZeroes(n / 5);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int res = -1;
		res = trailingZeroes(12);
		System.out.println(res);
		res = trailingZeroes(30);
		System.out.println(res);

	}

}
