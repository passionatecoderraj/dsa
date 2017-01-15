package com.raj.dp.mathamatical;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 
 * @author Raj
 *
 *         Build Lowest Number by Removing n digits from a given number Given a
 *         string ‘str’ of digits and an integer ‘n’, build the lowest possible
 *         number by removing ‘n’ digits from the string and not changing the
 *         order of input digits.
 * 
 *         Examples:
 * 
 *         Input: str = "4325043", n = 3 Output: "2043"
 * 
 *         http://www.geeksforgeeks.org/build-lowest-number-by-removing-n-digits
 *         -from-a-given-number/
 * 
 *         https://discuss.leetcode.com/topic/59646/straightforward-java-
 *         solution-using-stack/2
 */
public class MinNumberByRemovingNDigits {

	// Time : O(n), Space : O(n)
	public static String minNumberByRemovingNDigits(String str, int n) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			while (n > 0 && !stack.isEmpty() && stack.peek() > str.charAt(i)) {
				stack.pop();
				n--;
			}
			stack.push(str.charAt(i));
		}

		// corner case like "1111"
		while (n > 0) {
			stack.pop();
			n--;
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		sb.reverse();

		while (sb.length() > 1 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}

	// Time : O(n), Space : O(n)
	public static String lowestNumberByRemovingNDigitsUsingDeque(String str, int n) {
		int i = 0;
		Deque<Character> dq = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (; i <= n; i++) {
			insertInNonDecreasingOrder(dq, str.charAt(i));
		}
		while (i < str.length()) {
			sb.append(dq.removeFirst());
			insertInNonDecreasingOrder(dq, str.charAt(i++));
		}
		sb.append(dq.removeFirst());
		while (sb.length() > 1 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}

	private static void insertInNonDecreasingOrder(Deque<Character> dq, char ch) {
		while (!dq.isEmpty() && dq.getLast() > ch) {
			dq.removeLast();
		}
		dq.addLast(ch);
	}

	public static void main(String[] args) {
		String res = null;
		res = minNumberByRemovingNDigits("765028321", 5);
		System.out.println(res);
		res = minNumberByRemovingNDigits("1432219", 3);
		System.out.println(res);
		res = minNumberByRemovingNDigits("10200", 1);
		System.out.println(res);
		res = minNumberByRemovingNDigits("10", 1);
		System.out.println(res);
	}

}
