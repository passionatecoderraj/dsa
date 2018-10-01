/**
 * 
 */
package com.raj.leetcode.google;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Raj 
 * Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].


 *
 */
public class DailyTemperatures {

	// Time :O(n), Space:O(n)
	public int[] dailyTemperatures(int[] a) {
		int[] res = new int[a.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < a.length; i++) {
			while (!stack.isEmpty() && a[i] > a[stack.peek()]) {
				int j = stack.pop();
				res[j] = i - j;
			}
			stack.push(i);
		}
		return res;
	}

	public static void main(String[] args) {
		DailyTemperatures obj = new DailyTemperatures();
		int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };

		int[] res = null;
		res = obj.dailyTemperatures(temperatures);
		System.out.println(Arrays.toString(res));

	}

}
