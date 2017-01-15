/**
 * 
 */
package com.raj.dp;

import java.util.HashMap;
import java.util.Map;

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
 *         A zero-indexed array A consisting of N numbers is given. A
 *         subsequence slice of that array is any sequence of integers (P0, P1,
 *         ..., Pk) such that 0 ≤ P0 < P1 < ... < Pk < N.
 * 
 *         A subsequence slice (P0, P1, ..., Pk) of array A is called arithmetic
 *         if the sequence A[P0], A[P1], ..., A[Pk-1], A[Pk] is arithmetic. In
 *         particular, this means that k ≥ 2.
 * 
 *         The function should return the number of arithmetic subsequence
 *         slices in the array A.
 * 
 *         The input contains N integers. Every integer is in the range of -231
 *         and 231-1 and 0 ≤ N ≤ 1000. The output is guaranteed to be less than
 *         231-1.
 * 
 * 
 *         Example:
 * 
 *         Input: [2, 4, 6, 8, 10]
 * 
 *         Output: 7
 * 
 *         Explanation: All arithmetic subsequence slices are: [2,4,6] [4,6,8]
 *         [6,8,10] [2,4,6,8] [4,6,8,10] [2,4,6,8,10] [2,6,10]
 * 
 */
public class ArthimaticSlicesSubsequence {

	// Time : O(n^2), Space :O(n^2)
	public static int numberOfArithmeticSlicesSubsequencex(int a[]) {
		if (null == a || a.length < 3)
			return 0;
		Map<Integer, Integer> map[] = new HashMap[a.length];
		int res = 0;
		for (int i = 0; i < a.length; i++) {
			map[i] = new HashMap<>();
			for (int j = 0; j < i; j++) {
				int diff = a[i] - a[j];
				if (diff < Integer.MIN_VALUE || diff > Integer.MAX_VALUE)
					continue;
				int count = map[j].getOrDefault(diff, 0);
				res += count;
				map[i].put(diff, count + 1);
			}

		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 2, 4, 6, 8, 10 };
		int res = -1;
		res = numberOfArithmeticSlicesSubsequencex(a);
		System.out.println(res);

	}

}
