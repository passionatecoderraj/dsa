/**
 * 
 */
package com.raj.leetcode.google;

import java.util.Stack;

/**
 * @author Raj
 *
 *         Given an encoded string, return it's decoded string.
 * 
 *         The encoding rule is: k[encoded_string], where the encoded_string
 *         inside the square brackets is being repeated exactly k times. Note
 *         that k is guaranteed to be a positive integer.
 * 
 *         You may assume that the input string is always valid; No extra white
 *         spaces, square brackets are well-formed, etc.
 * 
 *         Furthermore, you may assume that the original data does not contain
 *         any digits and that digits are only for those repeat numbers, k. For
 *         example, there won't be input like 3a or 2[4].
 * 
 *         Examples:
 * 
 *         s = "3[a]2[bc]", return "aaabcbc".
 * 
 *         s = "3[a2[c]]", return "accaccacc".
 * 
 *         s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {

	// using stack
	public static String decodeString(String str) {
		Stack<Integer> countStack = new Stack<>();
		Stack<String> prevResultStack = new Stack<>();
		StringBuilder resSofar = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (Character.isDigit(ch)) {

				// push result so far on stack
				prevResultStack.push(resSofar.toString());
				resSofar = new StringBuilder();

				int times = ch - '0';
				while (i+1 < str.length() && str.charAt(i+1) != '[') {
					times = (times * 10) + str.charAt(i+1) - '0';
					i++;
				}
				countStack.push(times);

			} else if (ch == '[') {
				
			} else if (ch == ']') {
				// prev result first
				StringBuilder temp = new StringBuilder(prevResultStack.pop());

				int times = countStack.pop();
				while (times-- > 0) {
					temp.append(resSofar.toString());
				}
				resSofar = temp;
			} else {
				resSofar.append(ch);
			}
		}
		return resSofar.toString();
	}

	public static String decodeString2(String str) {
		int i[] = new int[1];
		return helper(str, i);
	}

	private static String helper(String str, int[] i) {
		StringBuilder sb = new StringBuilder();

		while (i[0] < str.length() && str.charAt(i[0]) != ']') {
			char ch = str.charAt(i[0]);
			if (Character.isAlphabetic(ch)) {
				sb.append(ch);
				i[0]++;
			} else {
				// it's got to be digit
				int times = ch - '0';
				i[0]++;
				while (i[0] < str.length() && str.charAt(i[0]) != '[') {
					times = (times * 10) + str.charAt(i[0]) - '0';
					i[0]++;
				}

				i[0]++;// '['
				String res = helper(str, i);
				i[0]++;// ']'
				while (times-- > 0) {
					sb.append(res);
				}
			}
		}
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String result = null;
		String str = "3[a]2[bc]";
		result = decodeString(str);
		System.out.println(result);

		str = "3[a2[c]]";
		result = decodeString(str);
		System.out.println(result);

		str = "2[abc]3[cd]ef";
		result = decodeString(str);
		System.out.println(result);

		str = "12[a]";
		result = decodeString(str);
		System.out.println(result);
	}

}
