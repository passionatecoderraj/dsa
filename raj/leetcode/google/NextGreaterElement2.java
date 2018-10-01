/**
 * 
 */
package com.raj.leetcode.google;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Raj
 *
 *Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.
Note: The length of given array won't exceed 10000.
 */
public class NextGreaterElement2 {

	public int[] nextGreaterElements(int[] a) {
		int[] res = new int[a.length];
		Stack<Integer> stack = new Stack<>();
		Arrays.fill(res, -1);
		for (int i = 0; i < a.length * 2; i++) {
			while (!stack.isEmpty() && a[i % a.length] > a[stack.peek()]) {
				int j = stack.pop();
				res[j] = a[i % a.length];
			}
			if (i < a.length)
				stack.push(i % a.length);
		}

		return res;
	}

	public static void main(String[] args) {
		NextGreaterElement2 obj = new NextGreaterElement2();
		int a[] = { 4, 15, 2, 9, 20, 11, 13 };
		int[] res = null;
		res = obj.nextGreaterElements(a);
		System.out.println(Arrays.toString(res));
	}

}
