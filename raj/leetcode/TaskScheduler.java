/**
 * 
 */
package com.raj.leetcode;

import static java.util.Collections.reverseOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Raj
 *
 *Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example 1:
Input: tasks = ['A','A','A','B','B','B'], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
Note:
The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
 */
public class TaskScheduler {

	public int leastInterval(char[] tasks, int n) {
		int count[] = new int[26];
		for (char ch : tasks) {
			count[ch - 'A']++;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>(26, reverseOrder());
		int time = 0;
		for (int i : count) {
			if (i > 0) {
				pq.offer(i);
			}
		}

		while (!pq.isEmpty()) {
			List<Integer> temp = new ArrayList<>();

			for (int i = 0; i <= n; i++) {
				if (!pq.isEmpty()) {
					int top = pq.poll();
					if (top > 1) {
						temp.add(top - 1);
					}
				}
				time++;
				if (pq.isEmpty() && temp.isEmpty())
					break;
			}
			for (int i : temp) {
				pq.offer(i);
			}
		}

		return time;
	}

	public static void main(String[] args) {
		TaskScheduler obj = new TaskScheduler();
		int res = -1;
		res = obj.leastInterval("AAAABBBEEFFGG".toCharArray(), 3);
		System.out.println(res);
		res = obj.leastInterval("ACCCEEE".toCharArray(), 2);
		System.out.println(res);
		res = obj.leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2);
		System.out.println(res);

	}

}
