/**
 * 
 */
package com.raj.mathamatical;

import java.util.Stack;

/**
 * @author Raj
 *
 *         Implement a basic calculator to evaluate a simple expression string.
 * 
 *         The expression string contains only non-negative integers, +, -, *, /
 *         operators and empty spaces . The integer division should truncate
 *         toward zero.
 * 
 *         You may assume that the given expression is always valid.
 */
public class BasicCalculator2 {

	public static int calculate(String s) {
		if (s == null || s.length() == 0)
			return 0;
		char sign = '+';
		Stack<Integer> stack = new Stack<>();
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				num = (num * 10) + (ch - '0');
			}
			if (i == s.length() - 1 || (!Character.isDigit(ch) && ' ' != ch)) {
				if (sign == '+') {
					stack.push(num);
				} else if (sign == '-') {
					stack.push(-num);
				} else if (sign == '*') {
					stack.push(stack.pop() * num);
				} else if (sign == '/') {
					stack.push(stack.pop() / num);
				}
				num = 0;
				sign = ch;
			}
		}
		int res = 0;
		while (!stack.isEmpty())
			res += stack.pop();
		return res;

	}

	public static void main(String[] args) {
		int res = -1;

		String expr = "3-2*2";
		res = calculate(expr);
		System.out.println(res);
	}

}
