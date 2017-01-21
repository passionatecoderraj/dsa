/**
 * 
 */
package com.raj.mathamatical;

/**
 * @author Raj
 *
 *         Given an integer n, count the total number of digit 1 appearing in
 *         all non-negative integers less than or equal to n.
 * 
 *         For example: Given n = 13,
 *
 *         https://discuss.leetcode.com/topic/27565/java-python-one-pass-
 *         solution-easy-to-understand
 */
public class NumberOfDigitOne {

	/**
	 * The idea is to calculate occurrence of 1 on every digit. There are 3
	 * scenarios, for example
	 * 
	 * if n = xyzdabc and we are considering the occurrence of one on thousand,
	 * it should be:
	 * 
	 * (1) xyz * 1000 if d == 0
	 * 
	 * (2) xyz * 1000 + abc + 1 if d == 1
	 * 
	 * (3) (xyz+1) * 1000 if d > 1
	 * 
	 * @param n
	 * @return
	 */
	public static int countDigitOne(int n) {
		int count = 0;
		int powerOf10 = 1;
		int q = n;
		while (q > 0) {
			int ithDigit = q % 10;
			q = q / 10;

			count += q * powerOf10;

			if (ithDigit == 1) {
				count += n % powerOf10 + 1;
			} else if (ithDigit > 1) {
				count += powerOf10;
			}
			powerOf10 *= 10;

		}
		return count;
	}

	public static int countDigitOneEasyToUnderstand(int n) {
		int count = 0;
		int powerOf10 = 1;
		int q = n;
		while (q > 0) {
			int ithDigit = q % 10;
			q = q / 10;

			if (ithDigit == 0) {
				count += q * powerOf10;
			} else if (ithDigit == 1) {
				count += (q * powerOf10) + n % powerOf10 + 1;
			} else if (ithDigit > 1) {
				count += ((q + 1) * powerOf10);
			}
			powerOf10 *= 10;

		}
		return count;
	}

	public static void main(String[] args) {
		int res = -1;
		res = countDigitOne(10);
		System.out.println(res);
		res = countDigitOne(293);
		System.out.println(res);
	}

}
