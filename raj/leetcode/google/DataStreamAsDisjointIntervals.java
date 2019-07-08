package com.raj.leetcode.google;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 
 * @author Raj
 * 
 * Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]
Follow up:
What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?


 */

class SummaryRanges {

	TreeMap<Integer, Integer> intervals;

	/** Initialize your data structure here. */
	public SummaryRanges() {
		intervals = new TreeMap<>();
	}

	public void addNum(int val) {
		int left, right;
		left = right = val;
		Integer floor = intervals.floorKey(left);
		Integer ceil = intervals.ceilingKey(right);
		if (floor != null) {
			if (intervals.get(floor) >= left) {
				return;
			} else if (intervals.get(floor) + 1 == val) {
				left = floor;
			}
		}
		if (ceil != null) {
			if (val + 1 == ceil) {
				right = intervals.get(ceil);
			}
		}
		intervals.put(left, right);
		intervals.subMap(left, false, right, true).clear();
	}

	public List<Interval> getIntervals() {
		List<Interval> res = new ArrayList<>();
		for (Entry<Integer, Integer> e : intervals.entrySet()) {
			res.add(new Interval(e.getKey(), e.getValue()));
		}
		return res;
	}
}

public class DataStreamAsDisjointIntervals {

	public static void main(String... args) {
		SummaryRanges obj = new SummaryRanges();

		List<Interval> res = null;
		obj.addNum(1);
		res = obj.getIntervals();
		System.out.println(res);

		obj.addNum(7);
		res = obj.getIntervals();
		System.out.println(res);

		obj.addNum(5);
		res = obj.getIntervals();
		System.out.println(res);

		obj.addNum(4);
		res = obj.getIntervals();
		System.out.println(res);

		obj.addNum(2);
		res = obj.getIntervals();
		System.out.println(res);

		obj.addNum(3);
		res = obj.getIntervals();
		System.out.println(res);
		
		obj.addNum(2);
		res = obj.getIntervals();
		System.out.println(res);
		

		
	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public String toString() {
		return "(" + start + ", " + end + ")";
	}

}