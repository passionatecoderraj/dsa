/**
 * 
 */
package com.raj.mathamatical;

/**
 * @author Raj
 *
 *
 *         Given a non-empty integer array of size n, find the minimum number of
 *         moves required to make all array elements equal, where a move is
 *         incrementing n - 1 elements by 1.
 * 
 *         Example:
 * 
 *         Input: [1,2,3]
 * 
 *         Output: 3
 * 
 *         Explanation: Only three moves are needed (remember each move
 *         increments two elements):
 * 
 *         [1,2,3] => [2,3,3] => [3,4,3] => [4,4,4]
 */
public class MinimumMovesToEqualArrayElements {
	/*
	 * The key idea is increasing n - 1 elements by 1 has the same effect of
	 * decreasing 1 element by 1 So we first find the minimum value of the array
	 * and count the steps of decreasing every element to the minimum.
	 */
	// Time : O(n), Space : O(1)
	public static int minMoves(int a[]) {
		int sum = 0, min = Integer.MAX_VALUE;
		for (int i : a) {
			sum += i;
			min = Math.min(min, i);
		}

		// because we are making all elements equal to minimum and decrease only
		// element by 1 following gives result
		return sum - min * a.length;
	}

	// Time : O(n), Space : O(1)
	public static int minMoves2(int a[]) {
		int min = Integer.MAX_VALUE;
		for (int i : a) {
			min = Math.min(min, i);
		}
		int count = 0;
		for (int i : a) {
			count += i - min;
		}
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a[] = { 1, 2, 3 };
		int res = -1;
		res = minMoves2(a);
		System.out.println(res);
		res = minMoves(a);
		System.out.println(res);

	}

}
