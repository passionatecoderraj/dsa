/**
 * 
 */
package com.raj.string;

/**
 * @author Raj
 *
 */

/*
 * http://algorithms.tutorialhorizon.com/algorithms-find-whether-given-the-
 * sequence-of-parentheses-are-well-formed/
 *
 * Find Whether Given Sequence of parentheses are well formed.
 * 
 */
public class WellFormedParantheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WellFormedParantheses obj = new WellFormedParantheses();

		String str = "{{{{}}}}{}{}{}{}{}{}{}{}{}{}{{{}}}";
		boolean result = false;

		// Time : O(n) Space :O(1)
		result = obj.isWellFormedParantheses(str.toCharArray(), str.length());
		System.out.println(result);
	}

	public boolean isWellFormedParantheses(char[] a, int n) {
		int openParentheses = 0, closedParantheses = 0;
		char ch;
		for (int i = 0; i < n; i++) {
			ch = a[i];
			switch (ch) {
			case '{':
				openParentheses++;
				break;
			case '}':
				closedParantheses++;
				break;
			}
			if (closedParantheses > openParentheses)
				return false;
		}
		return openParentheses == closedParantheses;
	}

}
