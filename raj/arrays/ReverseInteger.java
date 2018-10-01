/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */
public class ReverseInteger {

	// https://leetcode.com/problems/reverse-integer/discuss/4056/Very-Short-(7-lines)-and-Elegant-Solution
	public int reverse(int x) {
		long res = 0;
		while (x != 0) {
			res = (res * 10) + (x % 10);
			x /= 10;
			if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
				return 0;
			}
		}
		return (int) res;
	}

	public static void main(String[] args) {
		ReverseInteger obj = new ReverseInteger();
		int result = -1;
		int n = 4;

		result = obj.reverse(n);
		System.out.println(result);

	}
}
