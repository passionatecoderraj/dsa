/**
 * 
 */
package com.raj.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * @author Raj
 *
 */
public class InfixToPostfix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		InfixToPostfix obj = new InfixToPostfix();
		String expr = "5+6*3";
		String result = null;
		result = obj.infixToPostfix(expr, expr.length());
		System.out.println(result);

		String a = "15 6 + 3 *";

		result = obj.infixToPostfixWithMultiDigits(a, a.length());
		System.out.println(result);

	}

	public String infixToPostfixWithMultiDigits(String exp, int n) {
		Deque<Character> stack = new ArrayDeque<Character>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(exp, " ");
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			if (s.matches("[0-9]*")) {
				sb.append(s);
				sb.append(" ");
			} else {
				if (s.length() > 1)
					return null;
				stack.push(s.charAt(0));
			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
			sb.append(" ");
		}
		return sb.toString();
	}

	public String infixToPostfix(String exp, int n) {
		Deque<Character> stack = new ArrayDeque<Character>();
		StringBuilder sb = new StringBuilder();
		char ch = 0;
		for (int i = 0; i < n; i++) {
			ch = exp.charAt(i);
			if (Character.isDigit(ch)) {
				sb.append(ch);
			} else {
				stack.push(ch);
			}
		}

		while (!stack.isEmpty())
			sb.append(stack.pop());
		return sb.toString();
	}

}
