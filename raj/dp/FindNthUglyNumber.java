/**
 * 
 */
package com.raj.dp;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 * 
 *         Write a program to find the n-th ugly number.
 * 
 *         Ugly numbers are positive numbers whose prime factors only include 2,
 *         3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of
 *         the first 10 ugly numbers.
 * 
 *         Note that 1 is typically treated as an ugly number, and n does not
 *         exceed 1690.
 */
public class FindNthUglyNumber {

	public static int nthUglyNumber(int n) {
		int t[] = new int[n];
		t[0] = 1;
		int idx2, idx3, idx5;
		idx2 = idx3 = idx5 = 0;
		int factor2 = 2, factor3 = 3, factor5 = 5;

		for (int i = 1; i < n; i++) {
			int min = Math.min(Math.min(factor2, factor3), factor5);
			t[i] = min;
			if (min == factor2) {
				factor2 = 2 * t[++idx2];
			}

			if (min == factor3) {
				factor3 = 3 * t[++idx3];
			}

			if (min == factor5) {
				factor5 = 5 * t[++idx5];
			}
		}
		CommonUtil.printArray(t);
		
		return t[n - 1];
	}

	public static int nthUglyNumber2(int n) {
		if (n == 1)
			return 1;
		int count = 1, i = 2;
		while (true) {
			if (isUglyNumber(i)) {
				if (++count == n)
					return i;
			}
			i++;
		}
	}

	private static boolean isUglyNumber(int n) {
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int res = -1;
		res = nthUglyNumber2(11);
		System.out.println(res);
		res = nthUglyNumber(11);
		System.out.println(res);
	}

}
