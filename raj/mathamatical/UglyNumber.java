/**
 * 
 */
package com.raj.mathamatical;

/**
 * @author Raj
 *
 *
 *         Write a program to check whether a given number is an ugly number.
 *         Ugly numbers are positive numbers whose prime factors only include 2,
 *         3, 5. For example, 6, 8 are ugly while 14 is not ugly since it
 *         includes another prime factor 7. Note that 1 is typically treated as
 *         an ugly number.
 * 
 *         http://www.programcreek.com/2014/05/leetcode-ugly-number-java/
 */
public class UglyNumber {

	public static boolean isUglyNumber(int n) {
		if (0 == n)
			return false;

		if (1 == n)
			return true;

		if (n % 2 == 0) {
			return isUglyNumber(n / 2);
		}

		if (n % 3 == 0) {
			return isUglyNumber(n / 3);
		}

		if (n % 5 == 0) {
			return isUglyNumber(n / 5);
		}

		return false;
	}

	public static boolean isUglyNumber2(int n) {

		for (int i = 2; i < 6; i++) {
			while (n % i == 0) {
				n = n / i;
			}
		}

		return n == 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean res = false;
		res = isUglyNumber2(12);
		System.out.println(res);
		res = isUglyNumber2(14);
		System.out.println(res);

	}

}
