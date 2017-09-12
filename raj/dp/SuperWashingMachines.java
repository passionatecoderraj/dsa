/**
 * 
 */
package com.raj.dp;

import static java.lang.Integer.MIN_VALUE;

/**
 * @author Raj
 *
 *         You have n super washing machines on a line. Initially, each washing
 *         machine has some dresses or is empty.
 * 
 *         For each move, you could choose any m (1 ≤ m ≤ n) washing machines,
 *         and pass one dress of each washing machine to one of its adjacent
 *         washing machines at the same time .
 * 
 *         Given an integer array representing the number of dresses in each
 *         washing machine from left to right on the line, you should find the
 *         minimum number of moves to make all the washing machines have the
 *         same number of dresses. If it is not possible to do it, return -1.
 * 
 *         Example1
 * 
 *         Input: [1,0,5]
 * 
 *         Output: 3
 * 
 *         Explanation: 1st move: 1 0 <-- 5 => 1 1 4 2nd move: 1 <-- 1 <-- 4 =>
 *         2 1 3 3rd move: 2 1 <-- 3 => 2 2 2 Example2
 * 
 *         Input: [0,3,0]
 * 
 *         Output: 2
 * 
 *         Explanation: 1st move: 0 <-- 3 0 => 1 2 0 2nd move: 1 2 --> 0 => 1 1
 *         1 Example3
 * 
 *         Input: [0,2,0]
 * 
 *         Output: -1
 * 
 *         Explanation: It's impossible to make all the three washing machines
 *         have the same number of dresses.
 */
public class SuperWashingMachines {

	// Time : O(n), Space : O(1)
	// https://discuss.leetcode.com/topic/80059/easy-understand-solution-o-n-time-and-o-1-space
	public int findMinMoves(int[] a) {
		int sum = 0;
		for (int i : a) {
			sum += i;
		}
		if (sum % a.length != 0) {
			return -1;
		}
		int toLeft, toRight, max, target;
		toLeft = 0;
		target = sum / a.length;
		max = MIN_VALUE;
		for (int val : a) {
			toRight = val - target - toLeft;
			max = max(toRight, toLeft, max, toLeft + toRight);
			toLeft = -toRight;
		}
		return max;
	}

	private int max(int a, int b, int c, int d) {
		return Math.max(Math.max(a, b), Math.max(c, d));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SuperWashingMachines obj = new SuperWashingMachines();
		int res = -1;
		int a[] = { 1, 0, 5 };
		res = obj.findMinMoves(a);
		System.out.println(res);
		int b[] = { 0, 3, 0 };
		res = obj.findMinMoves(b);
		System.out.println(res);
		int c[] = { 0, 2, 0 };
		res = obj.findMinMoves(c);
		System.out.println(res);

	}

}
