package com.raj.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
/**
 * 
 * @author Raj
 *
 *Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Median
---------------               -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
Therefore, return the median sliding window as [1,-1,-1,3,5,6].

Note: 
You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
 */
public class SlidingWindowMedian {
	
	// Time : O(nlog), Space : O(k)
	public double[] medianSlidingWindow(int[] a, int k) {
		int n = a.length;
		double res[] = new double[n - k + 1];
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((c, d) -> d.compareTo(c));
		for (int i = 0; i <= n; i++) {
			if (i >= k) {
				res[i - k] = k % 2 != 0 ? maxHeap.peek() : ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0;
				if (a[i - k] <= maxHeap.peek()) {
					maxHeap.remove(a[i - k]);
				} else {
					minHeap.remove(a[i - k]);
				}
			}
			if (i != n)
				insert(a[i], minHeap, maxHeap);
		}
		return res;
	}

	private void insert(int num, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		maxHeap.offer(num);
		if (!minHeap.isEmpty()) {
			if (maxHeap.peek() > minHeap.peek()) {
				int peek = minHeap.poll();
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(peek);
			}
		}
		if (maxHeap.size() - minHeap.size() > 1) {
			minHeap.offer(maxHeap.poll());
		}
	}

	public static void main(String... args) {
		SlidingWindowMedian obj = new SlidingWindowMedian();
		double[] res = null;

		res = obj.medianSlidingWindow(new int[] { 1, 2, 3, 4, 2, 3, 1, 4, 2 }, 3);
		System.out.println(Arrays.toString(res));

		int[] a = { 1, 3, -1, -3, 5, 3, 6, 7 };
		res = obj.medianSlidingWindow(a, 3);
		System.out.println(Arrays.toString(res));
	}
}