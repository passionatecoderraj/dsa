/**
 * 
 */
package com.raj.arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Raj
 *
 *         Given a set of non-overlapping intervals, insert a new interval into
 *         the intervals (merge if necessary).
 * 
 *         You may assume that the intervals were initially sorted according to
 *         their start times.
 * 
 *         Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
 *         [1,5],[6,9].
 * 
 *         Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge
 *         [4,9] in as [1,2],[3,10],[12,16].
 * 
 *         This is because the new interval [4,9] overlaps with
 *         [3,5],[6,7],[8,10].
 */

public class InsertInterval {

	// Time : O(n), Space : O(n)
	// https://www.programcreek.com/2012/12/leetcode-insert-interval/
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();

		for (Interval interval : intervals) {
			// if new interval starts after cur ends, then add cur
			if (newInterval.start > interval.end) {
				result.add(interval);
			} else if (interval.start > newInterval.end) {
				// if cur starts after new interval ends, then add new interval
				// and make cur as new interval to merge
				result.add(newInterval);
				newInterval = interval;
			} else {
				newInterval = new Interval(Math.min(interval.start, newInterval.start),
						Math.max(newInterval.end, interval.end));
			}
		}

		result.add(newInterval);
		return result;
	}

	// Time : O(n), Space : O(n)
	public List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
		int i = 0;
		List<Interval> result = new LinkedList<>();
		// add all the intervals ending before newInterval starts
		while (i < intervals.size() && newInterval.start > intervals.get(i).end) {
			result.add(intervals.get(i++));
		}

		// merge all overlapping intervals to one considering newInterval
		while (i < intervals.size() && newInterval.end >= intervals.get(i).start) {
			newInterval = new Interval(min(newInterval.start, intervals.get(i).start),
					max(newInterval.end, intervals.get(i).end));
			i++;
		}

		// add the union of intervals we got
		result.add(newInterval);

		// add all the rest
		while (i < intervals.size()) {
			result.add(intervals.get(i++));
		}
		return result;
	}

	// Time : O(n2), Space : O(1)
	public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
		int i = 0;

		// add all the intervals ending before newInterval starts
		while (i < intervals.size() && newInterval.start > intervals.get(i).end) {
			i++;
		}

		// merge all overlapping intervals to one considering newInterval
		while (i < intervals.size() && newInterval.end >= intervals.get(i).start) {
			newInterval = new Interval(min(newInterval.start, intervals.get(i).start),
					max(newInterval.end, intervals.get(i).end));
			// resizing array is costly operation
			intervals.remove(i);
		}

		// add the union of intervals we got
		intervals.add(i, newInterval);

		return intervals;
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(12, 16));

		List<Interval> result = null;
		InsertInterval obj = new InsertInterval();
		// Time : O(n), Space : O(1)
		result = obj.insert(intervals, new Interval(4, 9));
		System.out.println(result);
	}

	static class Interval {
		int start;
		int end;

		public Interval(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "(start=" + start + ", end=" + end + ")";
		}

	}

}
