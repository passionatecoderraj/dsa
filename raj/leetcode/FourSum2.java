/**
 * 
 */
package com.raj.leetcode;

import java.util.HashMap;
import java.util.Map;;

/**
 * @author Raj
 *
Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0

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
