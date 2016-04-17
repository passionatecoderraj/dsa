/**
 * 
 */
package com.raj.arrays;

import java.util.PriorityQueue;

/**
 * @author Raj
 *
 */
/*
 * Find Kth largest element in a stream in java
 */

/*
 * http://www.geeksforgeeks.org/kth-largest-element-in-a-stream/
 */
public class FindKthLargestInStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FindKthLargestInStream obj = new FindKthLargestInStream();
		int k = 3, result = -1;
		obj.insertInStream(10, k);
		obj.insertInStream(20, k);
		obj.insertInStream(11, k);
		result = obj.findKthLargest(k);
		System.out.println(result);
		obj.insertInStream(70, k);
		result = obj.findKthLargest(k);
		System.out.println(result);
		obj.insertInStream(50, k);
		result = obj.findKthLargest(k);
		System.out.println(result);
		obj.insertInStream(40, k);
		result = obj.findKthLargest(k);
		System.out.println(result);
		obj.insertInStream(100, k);
		result = obj.findKthLargest(k);
		System.out.println(result);
		obj.insertInStream(5, k);
		result = obj.findKthLargest(k);
		System.out.println(result);

	}

	PriorityQueue<Integer> minHeap;

	public FindKthLargestInStream() {
		minHeap = new PriorityQueue<Integer>();
	}

	// Time : O(1)
	public int findKthLargest(int k) {
		return minHeap.size() < k ? -1 : minHeap.peek();
	}

	public int insertInStream(int val, int k) {
		if (minHeap.size() < k) {
			minHeap.offer(val);
		} else {
			if (val > minHeap.peek()) {
				minHeap.poll();
				minHeap.offer(val);
			}
		}
		return findKthLargest(k);
	}

}
