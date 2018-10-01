package com.raj.leetcode.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * @author Raj
 *Given n processes, each process has a unique PID (process id) and its PPID (parent process id).

Each process only has one parent process, but may have one or more children processes. This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive integers.

We use two list of integers to represent a list of processes, where the first list contains PID for each process and the second list contains the corresponding PPID.

Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that will be killed in the end. You should assume that when a process is killed, all its children processes will be killed. No order is required for the final answer.

Example 1:
Input: 
pid =  [1, 3, 10, 5]
ppid = [3, 0, 5, 3]
kill = 5
Output: [5,10]
Explanation: 
           3
         /   \
        1     5
             /
            10
Kill 5 will also kill 10.
Note:
The given kill id is guaranteed to be one of the given PIDs.
n >= 1.
 * 
 */

public class KillProcess {

	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < ppid.size(); i++) {
			final int child = pid.get(i);

			map.compute(ppid.get(i), (k, v) -> {
				if (null == v)
					v = new ArrayList<>();
				v.add(child);
				return v;
			});
		}

		List<Integer> res = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		q.add(kill);
		while (!q.isEmpty()) {
			int poll = q.poll();
			res.add(poll);
			if (map.containsKey(poll))
				for (int child : map.get(poll)) {
					q.add(child);
				}
		}
		return res;
	}

	public static void main(String[] args) {
		KillProcess obj = new KillProcess();

		List<Integer> result = null;

		List<Integer> pid = new ArrayList<>();
		pid.add(1);
		pid.add(3);
		pid.add(10);
		pid.add(5);
		List<Integer> ppid = new ArrayList<>();
		ppid.add(3);
		ppid.add(0);
		ppid.add(5);
		ppid.add(3);
		int kill = 5;

		result = obj.killProcess(pid, ppid, kill);
		System.out.println(result);

	}

}
