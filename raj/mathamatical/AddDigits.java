/**
 * 
 */
package com.raj.mathamatical;

/**
 * @author Raj
 *
 *         Given a non-negative integer num, repeatedly add all its digits until
 *         the result has only one digit.
 * 
 *         For example:
 * 
 *         Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2
 *         has only one digit, return it.
 * 
 *         Follow up: Could you do it without any loop/recursion in O(1)
 *         runtime?
 */
public class AddDigits {

	// Time :O(n)
	public static int addDigits(int n) {
		int res = n % 9;

		return (res != 0 || n == 0) ? res : 9;
	}

	// Time :O(n)
	public static int addDigits2(int n) {
		while (n / 10 > 0) {
			n = (n % 10) + (n / 10);
		}
		return n;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int res = -1;
		res = addDigits2(943);
		System.out.println(res);
		res = addDigits(943);
		System.out.println(res);

	}

}
