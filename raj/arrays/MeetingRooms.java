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
 *         Given an array of meeting time intervals consisting of start and end
 *         times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could
 *         attend all meetings. For example, Given [[0, 30],[5, 10],[15, 20]],
 *         return false.
 */
public class MeetingRooms {

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
	public boolean checkWhetherPersonCouldAttendAllMeetings(List<Interval> a) {
		if (null == a || a.size() < 2)
			return true;

		// System.out.println(a);
		Collections.sort(a, new Comparator<Interval>() {
			@Override
			public int compare(Interval a1, Interval a2) {
				return a1.start - a2.start;
			}
		});

		for (int i = 1; i < a.size(); i++) {
			if (a.get(i).start < a.get(i - 1).end) {
				return false;
			}
		}

		return true;
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

		boolean result = false;
		MeetingRooms obj = new MeetingRooms();
		// Time : O(nlogn), Space : O(1)
		result = obj.checkWhetherPersonCouldAttendAllMeetings(intervals);
		System.out.println(result);
	}

}
