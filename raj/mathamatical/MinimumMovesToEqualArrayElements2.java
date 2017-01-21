/**
 * 
 */
package com.raj.mathamatical;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 *
 *         Given a non-empty integer array, find the minimum number of moves
 *         required to make all array elements equal, where a move is
 *         incrementing a selected element by 1 or decrementing a selected
 *         element by 1.
 * 
 *         You may assume the array's length is at most 10,000.
 * 
 *         Example:
 * 
 *         Input: [1,2,3]
 * 
 *         Output: 2
 * 
 *         Explanation: Only two moves are needed (remember each move increments
 *         or decrements one element):
 * 
 *         [1,2,3] => [2,2,3] => [2,2,2]
 */
public class MinimumMovesToEqualArrayElements2 {

	// Time : O(n), Space : O(1)
	public static int minMoves2(int a[]) {
		int median = findMedian(a);

		int count = 0;
		for (int i : a) {
			count += Math.abs(i - median);
		}
		return count;
	}

	public static int findMedian(int a[]) {
		return findKthSmallest(a, 0, a.length - 1, a.length / 2);
	}

	public static int findKthSmallest(int a[], int p, int r, int k) {
		while (p <= r) {
			int q = findPivot(a, p, r);
			if (q == k) {
				return a[q];
			}
			if (q > k) {
				r = q - 1;
			} else {
				p = q + 1;
			}
		}
		return -1;
	}

	public static int findPivot(int a[], int p, int r) {
		int key = a[r];
		int j = p;
		for (int i = p; i < r; i++) {
			if (a[i] <= key) {
				CommonUtil.swap(a, i, j++);
			}
		}
		CommonUtil.swap(a, r, j);
		return j;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a[] = { 3, 4, 7, 5, 2, 6, 1, 8 };

		int res = -1;
		res = minMoves2(a);
		System.out.println(res);

		int b[] = { 2, 3, 1 };

		res = minMoves2(b);
		System.out.println(res);

	}

}
