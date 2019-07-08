/**
 * 
 */
package com.raj.mathamatical;

/**
 * @author Raj
 *
 *         Validate if a given string is numeric.
 * 
 *         Some examples:
 * 
 *         "0" => true
 * 
 *         " 0.1 " => true
 * 
 *         "abc" => false
 * 
 *         "1 a" => false
 * 
 *         "2e10" => true
 * 
 *         Note: It is intended for the problem statement to be ambiguous. You
 *         should gather all requirements up front before implementing one.
 * 
 *         https://discuss.leetcode.com/topic/9490/clear-java-solution-with-ifs
 */
public class ValidNumber {

	public boolean isNumber(String s) {
		s = s.trim();
		boolean pointSeen = false;
		boolean eSeen = false;
		boolean numberSeen = false;
		for (int i = 0; i < s.length(); i++) {
			if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
				numberSeen = true;

			} else if (s.charAt(i) == '.') {
				if (eSeen || pointSeen) {
					return false;
				}
				pointSeen = true;
			} else if (s.charAt(i) == 'e') {
				if (eSeen || !numberSeen) {
					return false;
				}
				numberSeen = false;
				eSeen = true;
			} else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
				if (i != 0 && s.charAt(i - 1) != 'e') {
					return false;
				}
				numberSeen = false;
			} else {
				return false;
			}
		}

		return numberSeen;
	}

	// Time : O(n), Space :O(1)
	public boolean isNumber2(String s) {

		boolean numberSeen = false;
		boolean numberAfterE = false;
		boolean pointSeen = false;
		boolean eSeen = false;

		s = s.trim();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				numberSeen = true;
				numberAfterE = true;
			} else if (s.charAt(i) == 'e') {
				if (eSeen || !numberSeen)
					return false;
				numberAfterE = false;
				eSeen = true;
			} else if (s.charAt(i) == '.') {
				if (eSeen || pointSeen)
					return false;
				pointSeen = true;
			} else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				if (i != 0 && s.charAt(i - 1) != 'e') {
					return false;
				}
			} else {
				return false;
			}
		}

		return numberSeen && numberAfterE;
	}

	public static void main(String[] args) {
		boolean res = false;
		ValidNumber obj = new ValidNumber();
		res = obj.isNumber("0.1");
		System.out.println(res);
		res = obj.isNumber("abc");
		System.out.println(res);

		res = obj.isNumber("1 a");
		System.out.println(res);
		res = obj.isNumber("2e10");
		System.out.println(res);

	}

}
