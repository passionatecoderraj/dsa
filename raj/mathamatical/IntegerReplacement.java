/**
 *
 */
package com.raj.mathamatical;

import static java.lang.Integer.bitCount;

/**
 * @author Raj
 * 
 *         Given a positive integer n and you can do operations as follow: If n
 *         is even, replace n with n/2. If n is odd, you can replace n with
 *         either n + 1 or n - 1. What is the minimum number of replacements
 *         needed for n to become 1?
 * 
 * 
 *         https://discuss.leetcode.com/topic/58334/a-couple-of-java-solutions-
 *         with-explanations/2
 */
public class IntegerReplacement {

	/*
	 * say bit count of 'n-1' as a, bit count of 'n+1' as b
	 *
	 * if a<b, do n-1, else if a>b do n+1
	 *
	 * when a=b , do n+1 because consider 111 -> 1000->100->10->1 is better than
	 * 111-> 110-> 11-> 100->10->1;
	 *
	 * one exception to the rule is when number is 3 11 -> 10 -> 1 is better
	 * than 11 -> 100 -> 10 -> 1. So when number is 3 do n-1
	 *
	 * combining all these when num==3 or a<b do n-1, else n+1
	 */
	public static int integerReplacement(int n) {
		int count = 0;
		while (n != 1) {
			if (n % 2 == 0) {
				n >>>= 1;
			} else if (3 == n || bitCount(n - 1) < bitCount(n + 1)) {
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
