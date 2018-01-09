/**
 * 
 */
package com.raj.arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Raj
 * 
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
 *
 */
public class SlidingWindowMaximum {

	public int[] maxSlidingWindow(int a[], int k) {
		int res[] = null;
		if (k == 0 || k > a.length) {
			res = new int[0];
			return res;
		}

		res = new int[a.length - k + 1];

		Deque<Integer> dq = new ArrayDeque<Integer>();

		for (int i = 0; i < k; i++) {
			while (!dq.isEmpty() && a[i] >= a[dq.peekLast()]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		int idx = 0;
		for (int i = k; i < a.length; i++) {
			res[idx++] = a[dq.peekFirst()];
			while (!dq.isEmpty() && i - dq.peekFirst() >= k) {
				dq.removeFirst();
			}

			while (!dq.isEmpty() && a[i] >= a[dq.peekLast()]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		res[idx++] = a[dq.peekFirst()];
		return res;
	}

	public static void main(String[] args) {

		SlidingWindowMaximum obj = new SlidingWindowMaximum();
		int a[] = { 12, 1, 78, 90, 57, 89, 56 };

		// Time : O(n), Space : O(k)
		int res[] = null;
		res = obj.maxSlidingWindow(a, 3);
		System.out.println(Arrays.toString(res));
	}

}
