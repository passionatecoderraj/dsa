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
 * 
 * 
 * @formatter:off
 * 
Merge Intervals								Start
Meeting Rooms								Start
Meeting Rooms2								Start
Insert Interval								Start
Maximum Length of Pair Chain				Start
Non-overlapping Intervals					End
Minimum Number of Arrows to Burst Balloons	End
@formatter:on
 *
 */
/*
 * 
 */
public class MergeOverlappingIntervals {

		// Time : O(nlogn), Space : O(1)
		public List<Interval> mergeOverlappingIntervals(List<Interval> a, int n) {
			if (n < 2)
				return a;
			Collections.sort(a,(a1,a2)->a1.start-a2.start);
	
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

	

}
