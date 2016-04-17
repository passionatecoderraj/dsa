/**
 * 
 */
package com.raj.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Raj
 *
 */
/*
 * Median in a stream of integers (running integers), using min-heap and
 * max-heap
 */

/*
 * http://www.ardendertat.com/2011/11/03/programming-interview-questions-13-
 * median-of-integer-stream/
 */
public class MedianInStreamOfIntegers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MedianInStreamOfIntegers obj = new MedianInStreamOfIntegers();
		obj.insertInStream(1);
		System.out.println(obj.getMedian());
		obj.insertInStream(5);
		obj.insertInStream(10);
		obj.insertInStream(12);
		obj.insertInStream(2);
		System.out.println(obj.getMedian());
		obj.insertInStream(3);
		obj.insertInStream(8);
		obj.insertInStream(9);
		System.out.println(obj.getMedian());
	}

	public double insertInStream(int val) {
		maxHeap.add(val);
		if (noOfElementsSoFar % 2 == 0) {
			if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
				// swap top of heap
				int minHeapTop = minHeap.poll();
				int maxHeapTop = maxHeap.poll();
				maxHeap.add(minHeapTop);
				minHeap.add(maxHeapTop);
			}
		} else {
			minHeap.add(maxHeap.poll());
		}
		noOfElementsSoFar++;
		return getMedian();
	}

	public double getMedian() {
		if (noOfElementsSoFar % 2 != 0) {
			return maxHeap.peek();
		} else {
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		}
	}

	int noOfElementsSoFar = 0;
	PriorityQueue<Integer> maxHeap;
	PriorityQueue<Integer> minHeap;

	public MedianInStreamOfIntegers() {
		this.noOfElementsSoFar = 0;
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>(10, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
	}

}
