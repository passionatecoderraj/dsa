/**
 * 
 */
package com.raj.leetcode.google;

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

	public boolean isValidParantheses(String a) {
		Stack<Character> stack = new Stack<>();
		char ch;
		for (int i = 0; i < a.length(); i++) {
			ch = a.charAt(i);
			if (ch == '{') {
				stack.push('}');
			} else if (ch == '(') {
				stack.push(')');
			} else if (ch == '[') {
				stack.push(']');
			} else if (stack.isEmpty() || stack.pop() != ch) {
				return false;
			}
		}
		return stack.isEmpty();
	}

	public boolean isValidParantheses2(char[] a, int n) {
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

	public static void main(String[] args) {
		ValidParantheses obj = new ValidParantheses();

		String str = "{()}[]";
		boolean result = false;

		// Time : O(n) Space :O(1)
		result = obj.isValidParantheses(str);
		System.out.println(result);
	}

}
