/**
 * 
 */
package com.raj.leetcode;

import java.util.HashMap;
import java.util.Map;;

/**
 * @author Raj
 *
 *         Given a sorted array, two integers k and x, find the k closest
 *         elements to x in the array. The result should also be sorted in
 *         ascending order. If there is a tie, the smaller elements are always
 *         preferred.
 * 
 *         Example 1: Input: [1,2,3,4,5], k=4, x=3 Output: [1,2,3,4] Example 2:
 *         Input: [1,2,3,4,5], k=4, x=-1 Output: [1,2,3,4] Note: The value k is
 *         positive and will always be smaller than the length of the sorted
 *         array. Length of the given array is positive and will not exceed 104
 *         Absolute value of elements in the array and x will not exceed 104
 */

public class FourSum2 {

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int sum=0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int a : A) {
			for (int b : B) {
				map.put(a + b, map.getOrDefault(a + b, 0) + 1);
			}
		}

		int res = 0;
		for (int c : C) {
			for (int d : D) {
				res += map.getOrDefault(sum-(c + d), 0);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2 };
		int[] B = { -2, -1 };
		int[] C = { -1, 2 };
		int[] D = { 0, 2 };
		FourSum2 obj = new FourSum2();

		int res = -1;
		res = obj.fourSumCount(A, B, C, D);
		System.out.println(res);
	}

}
