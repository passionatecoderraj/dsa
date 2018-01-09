package com.raj.leetcode;

/**
 * 
 * @author Raj
 *Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:
Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:
Input: 3
Output: False
 */
public class SumOfSquareNumbers {

	// Time : sqrt(c)
	public boolean judgeSquareSum(int c) {
		int r = (int) Math.sqrt(c);
		int l = 0;

		boolean flag = false;
		while (l <= r) {
			int a = l * l;
			int b = r * r;
			if (a + b > c) {
				r--;
			} else if (a + b < c) {
				l++;
			} else {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		SumOfSquareNumbers obj = new SumOfSquareNumbers();
		boolean result = false;
		result = obj.judgeSquareSum(5);
		System.out.println(result);
		result = obj.judgeSquareSum(3);
		System.out.println(result);
	}

}