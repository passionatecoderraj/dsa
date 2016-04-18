/**
 * 
 */
package com.raj.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Raj
 *
 */
/*
 * Merge Overlapping Intervals using Java
 * 
 */
public class MergeOverlappingIntervals {

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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(6, 8));
		intervals.add(new Interval(1, 9));
		intervals.add(new Interval(10, 14));
		intervals.add(new Interval(2, 4));
		intervals.add(new Interval(4, 7));

		List<Interval> result = null;
		MergeOverlappingIntervals obj = new MergeOverlappingIntervals();
		// Time : O(nlogn), Space : O(1)
		result = obj.mergeOverlappingIntervals(intervals, intervals.size());
		System.out.println(result);
	}

	// Time : O(nlogn), Space : O(1)
	public List<Interval> mergeOverlappingIntervals(List<Interval> a, int n) {
		if (n < 2)
			return a;
		// System.out.println(a);
		Collections.sort(a, new Comparator<Interval>() {
			@Override
			public int compare(Interval a1, Interval a2) {
				return a1.start - a2.start;
			}
		});
		// System.out.println(a);
		List<Interval> result = new ArrayList<Interval>();
		Interval prev = a.get(0), cur, merged;
		for (int i = 1; i < a.size(); i++) {
			cur = a.get(i);
			if (cur.start <= prev.end) {
				merged = new Interval(prev.start, Math.max(cur.end, prev.end));
				prev = merged;
			} else {
				result.add(prev);
				prev = cur;
			}
		}
		result.add(prev);

		return result;
	}

}
