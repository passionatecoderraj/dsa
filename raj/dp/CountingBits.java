/**
 * 
 */
package com.raj.dp;

import java.util.Arrays;

/**
 * @author Raj
 *
 *         Given a non negative integer number num. For every numbers i in the
 *         range 0 ≤ i ≤ num calculate the number of 1's in their binary
 *         representation and return them as an array.
 * 
 *         Example: For num = 5 you should return [0,1,1,2,1,2]
 */
public class CountingBits {

	public static int[] countBits(int n) {
		int t[] = new int[n + 1];

		int powerOf2 = 1, p = 1;
		for (int i = 1; i <= n; i++) {
			if (i == powerOf2) {
				t[i] = 1;
				p = 1;
				powerOf2 <<= 1;
			} else {
				t[i] = t[p] + 1;
				p++;
			}
		}
		return t;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int res[] = countBits(9);
		System.out.println(Arrays.toString(res));
	}

}
