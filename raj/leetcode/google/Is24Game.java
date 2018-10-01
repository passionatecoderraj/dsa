/**
 * 
 */
package com.raj.leetcode.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Raj
 *
 *
You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.

Example 1:
Input: [4, 1, 8, 7]
Output: True
Explanation: (8-4) * (7-1) = 24
Example 2:
Input: [1, 2, 1, 2]
Output: False
Note:
The division operator / represents real division, not integer division. For example, 4 / (1 - 2/3) = 12.
Every operation done is between two numbers. In particular, we cannot use - as a unary operator. For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
You cannot concatenate numbers together. For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.

 */
public class Is24Game {

	private double eps = 0.0001;

	// https://leetcode.com/problems/24-game/discuss/107673/JAVA-Easy-to-understand.-Backtracking.
	public boolean judgePoint24(int[] a) {
		List<Double> list = new ArrayList<>();
		for (int n : a) {
			list.add((double) n);
		}
		return helper(list);
	}

	private boolean helper(List<Double> list) {
		if (list.size() == 1) {
			return Math.abs(list.get(0) - 24.0) < eps;
		}
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				double v1 = list.get(i), v2 = list.get(j);
				List<Double> newList = new ArrayList<>();
				newList.addAll(Arrays.asList(v1 + v2, v1 * v2, v1 - v2, v2 - v1));
				if (v2 > eps)
					newList.add(v1 / v2);
				if (v1 > eps)
					newList.add(v2 / v1);
				list.remove(j);
				list.remove(i);
				for (double val : newList) {
					list.add(val);
					if (helper(list)) {
						return true;
					}
					list.remove(list.size() - 1);
				}
				list.add(i, v1);
				list.add(j, v2);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Is24Game obj = new Is24Game();

		boolean result = false;
		result = obj.judgePoint24(new int[] { 4, 1, 8, 7 });
		System.out.println(result);
		result = obj.judgePoint24(new int[] { 1, 2, 1, 2 });
		System.out.println(result);

	}

}
