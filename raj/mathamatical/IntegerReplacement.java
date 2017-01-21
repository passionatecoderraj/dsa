/**
 * 
 */
package com.raj.mathamatical;

/**
 * @author Raj
 *
 *         Given a positive integer n and you can do operations as follow:
 * 
 *         If n is even, replace n with n/2. If n is odd, you can replace n with
 *         either n + 1 or n - 1. What is the minimum number of replacements
 *         needed for n to become 1?
 * 
 *         https://discuss.leetcode.com/topic/58334/a-couple-of-java-solutions-
 *         with-explanations/2
 */
public class IntegerReplacement {

	public static int integerReplacement(int n) {
		int count = 0;
		while (n > 1) {
			if (n % 2 == 0) {
				n >>>= 1;
			} else if (3 == n || Integer.bitCount(n - 1) < Integer.bitCount(n + 1)) {
				n--;
			} else {
				n++;
			}
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		int res = -1;
		res = integerReplacement(8);
		System.out.println(res);
		res = integerReplacement(7);
		System.out.println(res);
	}

}
