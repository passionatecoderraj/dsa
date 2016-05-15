/**
 * 
 */
package com.raj.string;

import java.util.Stack;

/**
 * @author Raj
 *
 */

/*
 * Valid Parentheses
 * 
 * 
 */
public class ValidParantheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ValidParantheses obj = new ValidParantheses();

		String str = "{()}[]";
		boolean result = false;

		// Time : O(n) Space :O(1)
		result = obj.isValidParantheses(str.toCharArray(), str.length());
		System.out.println(result);
	}

	public boolean isValidParantheses(char[] a, int n) {
		Stack<Character> stack = new Stack<>();
		char ch;
		for (int i = 0; i < n; i++) {
			ch = a[i];
			switch (ch) {
			case '{':
			case '(':
			case '[':
				stack.push(ch);
				break;
			case '}':
				if (stack.isEmpty() || stack.peek() != '{')
					return false;
				stack.pop();
				break;
			case ')':
				if (stack.isEmpty() || stack.peek() != '(')
					return false;
				stack.pop();
				break;
			case ']':
				if (stack.isEmpty() || stack.peek() != '[')
					return false;
				stack.pop();
				break;
			default:
				return false;
			}
		}

		return stack.isEmpty();
	}

}
