/**
 * 
 */
package com.raj.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Raj
 *
 In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the i-th domino, so that A[i] and B[i] swap values.

Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

If it cannot be done, return -1.

 

Example 1:



Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by A and B: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
Example 2:

Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
Output: -1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal.
 

Note:

1 <= A[i], B[i] <= 6
2 <= A.length == B.length <= 20000
 */
public class MinimumDominoRotationsForEqualRow {

	/*
	 * 
	 * 
	 * Count the frequency of each number in A and B, respectively; Count the
	 * frequency of A[i] if A[i] == B[i]; If countA[i] + countB[i] - same[i] ==
	 * A.length, we find a solution; otherwise, return -1; min(countA[i], countB[i])
	 * - same[i] is the answer.
	 */
	// https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/discuss/252633/Java-one-pass-counting-O(A-+-B)
	// Time : O(m+n), Space : O(1)
	public int minDominoRotations(int[] a, int[] b) {
		int countA[] = new int[7];
		int countB[] = new int[7];
		int same[] = new int[7];
		for (int i = 0; i < a.length; i++) {
			countA[a[i]]++;
			countB[b[i]]++;
			if (a[i] == b[i]) /// same[k] records the occurrence of k, where k == A[i] == B[i].
				same[a[i]]++;
		}
		for (int i = 1; i < 7; i++) {
			if (countA[i] + countB[i] - same[i] >= a.length) {
				return Math.min(countA[i], countB[i]) - same[i];
			}
		}
		return -1;
	}

	public int minDominoRotations2(int[] A, int[] B) {
		int r1 = res(A, B), r2 = res(B, A);
		return r1 == -1 ? r2 : r2 == -1 ? r1 : Math.min(r1, r2);
	}

	int res(int[] A, int[] B) {
		if (A.length != B.length)
			return -1;
		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, Integer> cmap = new HashMap<>();
		for (int n : A)
			map.put(n, map.getOrDefault(n, 0) + 1);
		System.out.println(map);
		for (int i = 0; i < B.length; i++) {
			if (A[i] != B[i]) {
				map.put(B[i], map.getOrDefault(B[i], 0) + 1);
				cmap.put(B[i], cmap.getOrDefault(B[i], 0) + 1);
			}
		}
		System.out.println(map);
		int res = A.length + 1;
		for (int key : map.keySet()) {
			if (map.get(key) == A.length)
				res = Math.min(cmap.getOrDefault(key, 0), res);
		}
		return res == A.length + 1 ? -1 : res;
	}

	public static void main(String[] args) {
		int result = -1;
		MinimumDominoRotationsForEqualRow obj = new MinimumDominoRotationsForEqualRow();
		result = obj.minDominoRotations(new int[] { 2, 1, 2, 4, 2, 2 }, new int[] { 5, 2, 6, 2, 3, 2 });
		System.out.println(result);

		result = obj.minDominoRotations(new int[] { 3, 5, 1, 2, 3 }, new int[] { 3, 6, 3, 3, 4 });
		System.out.println(result);
	}

}
