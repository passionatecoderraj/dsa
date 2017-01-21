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
 *         The expression string may contain open ( and closing parentheses ),
 *         the plus + or minus sign -, non-negative integers and empty spaces .
 * 
 *         You may assume that the given expression is always valid.
 * 
 *         Some examples: "1 + 1" = 2 "
 * 
 *         2-1 + 2 " = 3 "
 * 
 *         (1+(4+5+2)-3)+(6+8)" = 23
 */
public class BasicCalculator {

	public static int calculate(String s) {
		int res = 0, sign = 1;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				int operand = ch - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					operand = (operand * 10) + (s.charAt(i + 1) - '0');
					i++;
				}
				res += (operand * sign);
			} else if (ch == '+') {
				sign = 1;
			} else if (ch == '-') {
				sign = -1;
			} else if (ch == '(') {
				stack.push(res);
				stack.push(sign);
				res = 0;
				sign = 1;
			} else if (ch == ')') {
				res = (stack.pop() * res) + stack.pop();
			} else {

			}
		}
		return res;
	}

	public static int calculate2(String s) {
		int res = 0, sign = 1;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				int operand = ch - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					operand = (operand * 10) + (s.charAt(i + 1) - '0');
					i++;
				}
				res += (operand * sign);
			} else if (ch == '+') {
				sign = 1;
			} else if (ch == '-') {
				sign = -1;
			} else if (ch == '(') {
				stack.push(res);
				stack.push(sign);
				res = 0;
				sign = 1;
			} else if (ch == ')') {
				res = (stack.pop() * res) + stack.pop();
			} else {

			}
		}
		return res;
	}

	public static void main(String[] args) {
		int res = -1;

		String expr = "1 + 2";
		res = calculate(expr);
		System.out.println(res);
		res = calculate("(1+(4+5+2)-3)+(6+8)");
		System.out.println(res);
	}

}
