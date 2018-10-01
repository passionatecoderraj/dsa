package com.raj.leetcode.google;

import java.util.TreeMap;

/**
 * 
 * @author Raj
 * 
 *A Range Module is a module that tracks ranges of numbers. Your task is to design and implement the following interfaces in an efficient manner.

addRange(int left, int right) Adds the half-open interval [left, right), tracking every real number in that interval. Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval [left, right) that are not already tracked.
queryRange(int left, int right) Returns true if and only if every real number in the interval [left, right) is currently being tracked.
removeRange(int left, int right) Stops tracking every real number currently being tracked in the interval [left, right).
Example 1:
addRange(10, 20): null
removeRange(14, 16): null
queryRange(10, 14): true (Every number in [10, 14) is being tracked)
queryRange(13, 15): false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
queryRange(16, 17): true (The number 16 in [16, 17) is still being tracked, despite the remove operation)
Note:

A half open interval [left, right) denotes all real numbers left <= x < right.
0 < left < right < 10^9 in all calls to addRange, queryRange, removeRange.
The total number of calls to addRange in a single test case is at most 1000.
The total number of calls to queryRange in a single test case is at most 5000.
The total number of calls to removeRange in a single test case is at most 1000.
 */
public class RangeModule {

	/*
	 * https://leetcode.com/problems/range-module/discuss/108910/Java-TreeMap look
	 * in the comments
	 */
	TreeMap<Integer, Integer> intervals = new TreeMap<>();

	/*
	 * For a given interval(left,right) to insert -
	 * 
	 * (1) we see first if left is overlapping start, then we update left to start
	 * (because, start is already floor of left)
	 * 
	 * (2) then we see if right is overlapping with end, then we update right to
	 * end's ending interval.
	 */
	public void addRange(int left, int right) {
		Integer start = intervals.floorKey(left);
		Integer end = intervals.floorKey(right);

		/*
		 * if there is floor of left, it ends after left starts, then update left to
		 * start
		 */
		if (start != null && intervals.get(start) >= left) {
			left = start;
		}
		/*
		 * if there is floor of right, it ends after right ends, update right to end's
		 * end
		 */
		if (end != null && intervals.get(end) > right) {
			right = intervals.get(end);
		}
		intervals.put(left, right);

		intervals.subMap(left, false, right, true).clear();
	}

	public boolean queryRange(int left, int right) {
		Integer start = intervals.floorKey(left);
		if (start == null)
			return false;
		return intervals.get(start) >= right;
	}

	public void removeRange(int left, int right) {
		Integer start = intervals.floorKey(left);
		Integer end = intervals.floorKey(right);
		/*
		 * If there is floor of right and it's ending after right started, then create
		 * new interval from right to it's end's end
		 */
		if (end != null && intervals.get(end) > right) {
			intervals.put(right, intervals.get(end));
		}
		/*
		 * if there is floor of left and it's ending after left started, then create new
		 * interval from start to left
		 */
		if (start != null && intervals.get(start) > left) {
			intervals.put(start, left);
		}
		intervals.subMap(left, true, right, false).clear();
	}

	public static void main(String... args) {
		RangeModule obj = new RangeModule();
		boolean result = false;
		obj.addRange(10, 20);
		System.out.println(obj.intervals);
		obj.removeRange(14, 16);
		System.out.println(obj.intervals);
		result = obj.queryRange(10, 14);
		System.out.println(result);
		result = obj.queryRange(13, 15);
		System.out.println(result);
		result = obj.queryRange(16, 17);
		System.out.println(result);
	}
}