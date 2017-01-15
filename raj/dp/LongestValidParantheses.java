/**
 * 
 */
package com.raj.dp;

import java.util.Stack;

/**
 * @author Raj
 *
 */

/**
 * 
 * @author Raj
 *
 *         Given a string containing just the characters '(' and ')', find the
 *         length of the longest valid (well-formed) parentheses substring.
 * 
 *         For "(()", the longest valid parentheses substring is "()", which has
 *         length = 2.
 * 
 *         Another example is ")()())", where the longest valid parentheses
 *         substring is "()()", which has length = 4.
 */
public class LongestValidParantheses {

	// Time :O(n), Space : O(n)
	public static int longestValidParentheses(String str) {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '{') {
				stack.push(i);
			} else {
				if (!stack.isEmpty() && str.charAt(stack.peek()) == '{') {
					stack.pop();
				} else {
					stack.push(i);
				}
			}
		}

		if (stack.isEmpty())
			return str.length();
		int right = str.length(), left = 0;

		int maxLen = 0;
		while (!stack.isEmpty()) {
			left = stack.pop();
			maxLen = Math.max(maxLen, right - left - 1);
			right = left;
		}
		maxLen = Math.max(maxLen, right);
		return maxLen;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "{{{{}}}}{";
		int result = -1;

		result = longestValidParentheses(str);
		System.out.println(result);

		str = "}{}{}{";
		result = longestValidParentheses(str);
		System.out.println(result);
		str = "{}}";
		result = longestValidParentheses(str);
		System.out.println(result);
	}

}
