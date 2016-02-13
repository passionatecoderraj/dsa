/**
 * 
 */
package com.raj.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author Raj
 *
 */
public class PostfixEval {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		PostfixEval obj = new PostfixEval();
		String expr = "56+3*";
		double result = -1;
		// Time : O(n),Space : O(n)
		result = obj.evalPostfix(expr, expr.length());
		System.out.println(result);

		String a = "15 6 + 3 *";

		result = obj.evalPostfixHavingMultiDigits(a, a.length());
		System.out.println(result);

		result = obj.evalPostfixHavingMultiDigitss(a, a.length());
		System.out.println(result);

	}

	public double evalPostfixHavingMultiDigitss(String exp, int n) {
		Deque<Double> stack = new ArrayDeque<Double>();
		StringBuffer last = null;
		char ch = 0;
		for (int i = 0; i < n; i++) {
			ch = exp.charAt(i);
			if (Character.isDigit(ch)) {
				if (last == null) {
					last = new StringBuffer();
				}
				last.append(ch);
			} else if (ch == ' ') {
				if (last != null) {
					stack.push(Double.parseDouble(last.toString()));
					last = null;
				}
			} else {
				if (stack.size() < 2)
					return -1;

				double v2 = stack.pop();
				double v1 = stack.pop();

				double res = 0;

				switch (ch) {
				case '+':
					res = v1 + v2;
					break;
				case '-':
					res = v1 - v2;
					break;
				case '*':
					res = v1 * v2;
					break;
				case '/':
					res = v1 / v2;
					break;
				default:
					return -1;
				}
				stack.push(res);
				last = null;
			}
		}

		if (stack.size() != 1)
			return -1;
		return stack.pop();
	}

	public double evalPostfixHavingMultiDigits(String exp, int n) {
		Deque<Double> stack = new ArrayDeque<Double>();
		StringTokenizer st = new StringTokenizer(exp, " ");
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			if (s.matches("[0-9]*")) {
				stack.push(Double.parseDouble(s));
			} else {
				if (s.length() > 1 || stack.size() < 2)
					return -1;

				double v2 = stack.pop();
				double v1 = stack.pop();

				double res = 0;
				char ch = s.charAt(0);

				switch (ch) {
				case '+':
					res = v1 + v2;
					break;
				case '-':
					res = v1 - v2;
					break;
				case '*':
					res = v1 * v2;
					break;
				case '/':
					res = v1 / v2;
					break;
				default:
					return -1;
				}
				stack.push(res);
			}
		}

		if (stack.size() != 1)
			return -1;
		return stack.pop();
	}

	public double evalPostfix(String exp, int n) {
		Stack<Double> stack = new Stack<Double>();
		for (int i = 0; i < n; i++) {
			if (Character.isDigit(exp.charAt(i))) {
				stack.push(Double.parseDouble(exp.substring(i, i + 1)));
			} else {
				if (stack.size() < 2)
					return -1;

				double v2 = stack.pop();
				double v1 = stack.pop();

				double res = 0;
				char ch = exp.charAt(i);

				switch (ch) {
				case '+':
					res = v1 + v2;
					break;
				case '-':
					res = v1 - v2;
					break;
				case '*':
					res = v1 * v2;
					break;
				case '/':
					res = v1 / v2;
					break;
				default:
					return -1;
				}
				stack.push(res);
			}
		}
		if (stack.size() != 1)
			return -1;

		return stack.pop();
	}

}
