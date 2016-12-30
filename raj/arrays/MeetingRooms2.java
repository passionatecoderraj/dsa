/**
 * 
 */
package com.raj.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Raj
 *
 * 
 *         Given an array of meeting time intervals consisting of start and end
 *         times [[s1,e1],[s2,e2],...] find the minimum number of conference
 *         rooms required.
 */
public class MeetingRooms2 {

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

	// Time : O(nlogn), Space : O(1)
	public int countMinimumNuberOfConferenceRoomsRequired(List<Interval> a) {
		if (null == a || a.size() == 0)
			return 0;

		// System.out.println(a);
		Collections.sort(a, new Comparator<Interval>() {
			@Override
			public int compare(Interval a1, Interval a2) {
				return a1.start - a2.start;
			}
		});

		int count = 1;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(a.get(0).end);

		for (int i = 1; i < a.size(); i++) {
			if (a.get(i).start >= pq.peek()) {
				pq.poll();
			} else {
				count++;
			}
			pq.offer(a.get(i).end);
		}

		return count;
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

		int result = -1;
		MeetingRooms2 obj = new MeetingRooms2();
		// Time : O(nlogn), Space : O(1)
		result = obj.countMinimumNuberOfConferenceRoomsRequired(intervals);
		System.out.println(result);
	}

}
