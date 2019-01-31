/**
 * 
 */
package com.raj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Raj
 * 
 * We are given a list schedule of employees, which represents the working time for each employee.

Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.

Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.

Example 1:
Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
Output: [[3,4]]
Explanation:
There are a total of three employees, and all common
free time intervals would be [-inf, 1], [3, 4], [10, inf].
We discard any intervals that contain inf as they aren't finite.
Example 2:
Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
Output: [[5,6],[7,9]]
(Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays. For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined.)

Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.

Note:

schedule and schedule[i] are lists with lengths in range [1, 50].
0 <= schedule[i].start < schedule[i].end <= 10^8.

 */
public class EmployeeFreeTime {

	// https://leetcode.com/problems/employee-free-time/discuss/113122/Merge-Sort-O(nlgK)-(Java)
	// Time : O(nlogk), Space : O(k), k = no. of employees
	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		class Node {
			int emp_id;
			int schedule_id;

			public Node(int emp_id, int schedule_id) {
				this.emp_id = emp_id;
				this.schedule_id = schedule_id;
			}
		}
		PriorityQueue<Node> pq = new PriorityQueue<>(schedule.size(),
				(j1, j2) -> schedule.get(j1.emp_id).get(j1.schedule_id).start
						- schedule.get(j2.emp_id).get(j2.schedule_id).start);

		for (int emp_id = 0; emp_id < schedule.size(); emp_id++) {
			pq.offer(new Node(emp_id, 0));
		}

		// get something small for initial case
		int end = schedule.get(pq.peek().emp_id).get(pq.peek().schedule_id).start;
		List<Interval> res = new ArrayList<>();
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (schedule.get(cur.emp_id).get(cur.schedule_id).start > end) {
				res.add(new Interval(end, schedule.get(cur.emp_id).get(cur.schedule_id).start));
			}
			end = Math.max(end, schedule.get(cur.emp_id).get(cur.schedule_id).end);
			if (++cur.schedule_id < schedule.get(cur.emp_id).size()) {
				pq.offer(cur);
			}
		}
		return res;
	}

	// Time : O(nlogn), Space : O(n) n=no.of schedules of all employees
	public List<Interval> employeeFreeTime2(List<List<Interval>> schedule) {
		List<Interval> a = new ArrayList<>();
		for (List<Interval> r : schedule) {
			a.addAll(r);
		}

		Collections.sort(a, (a1, a2) -> a1.start - a2.start);
		int end = a.get(0).end;
		List<Interval> res = new ArrayList<>();

		for (int i = 1; i < a.size(); i++) {
			if (a.get(i).start > end) {
				res.add(new Interval(end, a.get(i).start));
			}
			end = Math.max(end, a.get(i).end);
		}
		return res;
	}

	public static void main(String[] args) {
		EmployeeFreeTime obj = new EmployeeFreeTime();
		List<List<Interval>> schedule = new ArrayList<>();
		Interval[] a = { new Interval(1, 2), new Interval(5, 6) };
		Interval[] b = { new Interval(1, 3) };
		Interval[] c = { new Interval(4, 10) };

		List<Interval> l1 = new ArrayList<>(Arrays.asList(a));
		List<Interval> l2 = new ArrayList<>(Arrays.asList(b));
		List<Interval> l3 = new ArrayList<>(Arrays.asList(c));
		schedule.add(l1);
		schedule.add(l2);
		schedule.add(l3);

		List<Interval> res = obj.employeeFreeTime(schedule);
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
		return "Interval [start=" + start + ", end=" + end + "]";
	}

}
