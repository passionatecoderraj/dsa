/**
 * 
 */
package com.raj.dp;

/**
 * @author Raj
 *
 *         A sequence of number is called arithmetic if it consists of at least
 *         three elements and if the difference between any two consecutive
 *         elements is the same.
 * 
 *         For example, these are arithmetic sequence:
 * 
 *         1, 3, 5, 7, 9 7, 7, 7, 7 3, -1, -5, -9 The following sequence is not
 *         arithmetic.
 * 
 *         1, 1, 2, 5, 7
 * 
 *         A zero-indexed array A consisting of N numbers is given. A slice of
 *         that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 * 
 *         A slice (P, Q) of array A is called arithmetic if the sequence: A[P],
 *         A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this
 *         means that P + 1 < Q.
 * 
 *         The function should return the number of arithmetic slices in the
 *         array A.
 */
public class ArthimaticSlices {

	// Time : O(n), Space :O(1)
	public static int numberOfArithmeticSlices(int a[]) {
		if (null == a || a.length < 3)
			return 0;
		int total = 0, cur = 0;

		for (int i = 2; i < a.length; i++) {
			if (a[i] - a[i - 1] == a[i - 1] - a[i - 2]) {
				cur++;
				total += cur;
			} else {
				cur = 0;
			}
		}
		return total;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 6, 7, 8 };
		int res = -1;
		res = numberOfArithmeticSlices(a);
		System.out.println(res);

	}

}
