/**
 * 
 */
package com.raj.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Raj 
 * 
 * Given the running logs of n functions that are executed in a nonpreemptive single threaded CPU, find the exclusive time of these functions.

Each function has a unique id, start from 0 to n-1. A function may be called recursively or by another function.

A log is a string has this format : function_id:start_or_end:timestamp. For example, "0:start:0" means function 0 starts from the very beginning of time 0. "0:end:0" means function 0 ends to the very end of time 0.

Exclusive time of a function is defined as the time spent within this function, the time spent by calling other functions should not be considered as this function's exclusive time. You should return the exclusive time of each function sorted by their function id.

Example 1:
Input:
n = 2
logs = 
["0:start:0",
 "1:start:2",
 "1:end:5",
 "0:end:6"]
Output:[3, 4]
Explanation:
Function 0 starts at time 0, then it executes 2 units of time and reaches the end of time 1. 
Now function 0 calls function 1, function 1 starts at time 2, executes 4 units of time and end at time 5.
Function 0 is running again at time 6, and also end at the time 6, thus executes 1 unit of time. 
So function 0 totally execute 2 + 1 = 3 units of time, and function 1 totally execute 4 units of time.
Note:
Input logs will be sorted by timestamp, NOT log id.
Your output should be sorted by function id, which means the 0th element of your output corresponds to the exclusive time of function 0.
Two functions won't start or end at the same time.
Functions could be called recursively, and will always end.
1 <= n <= 100
 * 
 */
public class ExclusiveTimeofFunctions {

	// Time : O(n), Space : O(n)
	public int[] exclusiveTime(int n, List<String> logs) {
		int[] res = new int[n];
		class Log {
			int func;
			int time;

			public Log(int func, int from) {
				this.func = func;
				this.time = from;
			}

		}

		Deque<Log> stack = new LinkedList<>();
		for (String log : logs) {
			String[] a = log.split(":");
			String action = a[1];
			int func = Integer.parseInt(a[0]);
			int time = Integer.parseInt(a[2]);
			// if stack is empty, push cur log on to stack. It must be start
			if (stack.isEmpty()) {
				stack.push(new Log(func, time));
				continue;
			}

			Log top = stack.peek();

			// "start" after "start" scenario
			if (action.equals("start")) {
				// new func is starting, so update top of functions time
				res[top.func] += (time - top.time);
				stack.push(new Log(func, time));
			} else {
				// func reached end, so update it's time
				res[top.func] += (time - top.time) + 1;
				stack.pop();

				if (!stack.isEmpty()) {
					// top function time will be starting from next time
					stack.peek().time = time + 1;
				}
			}

		}
		return res;

	}

	public static void main(String[] args) {
		ExclusiveTimeofFunctions obj = new ExclusiveTimeofFunctions();
		int res[] = null;
		res = obj.exclusiveTime(2, Arrays.asList(new String[] { "0:start:0", "1:start:2", "1:end:5", "0:end:6" }));
		System.out.println(Arrays.toString(res));

		res = obj.exclusiveTime(3, Arrays
				.asList(new String[] { "0:start:0", "1:start:2", "1:end:5", "2:start:6", "2:end:9", "0:end:12" }));
		System.out.println(Arrays.toString(res));

	}

}
