package com.raj.leetcode;

import java.util.Stack;

/*
 *
 * LeetCode Longest Valid Parentheses
 * 
 *http://www.sigmainfy.com/blog/leetcode-longest-valid-parentheses.html 
 */
public class LongestValidParatheses {

	public static void main(String args[]) {
		LongestValidParatheses s = new LongestValidParatheses();
		String str = ")())(()())(()";
		int result = -1;
		result = s.longestValidParatheses(str);
		System.out.println(result);

	}

	public int longestValidParatheses(String str) {
		Stack<Integer> stack = new Stack<>();
		char ch;
		String substring = "";
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (ch == '(') {
				stack.push(i);
			} else {
				if (!stack.isEmpty() && str.charAt(stack.peek()) == '(') {
					stack.pop();
					int idx = stack.isEmpty() ? 0 : stack.peek() + 1;
					String s = str.substring(idx, i + 1);
					if (s.length() > substring.length())
						substring = s;
				} else {
					stack.push(i);
				}
			}

		}
		System.out.println(substring);
		return substring.length();
	}

}