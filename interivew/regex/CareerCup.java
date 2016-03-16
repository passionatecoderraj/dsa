/**
 * 
 */
package com.interivew.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Raj
 *
 */
public class CareerCup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// reverseSetence("Prithviraj Kumar Dasari. $Hello");
		signedIntegerToStringWithoutUsingBuiltInFunctions(-123);
	}

	public static String reverseSetence(String str) {
		StringBuilder sb = new StringBuilder(str);
		Pattern p = Pattern.compile("[a-zA-Z0-9]+");
		Matcher m = p.matcher(str);
		while (m.find()) {
			reverse(sb, m.start(), m.end() - 1);
		}
		return sb.toString();
	}

	public static void reverse(StringBuilder sb, int l, int r) {
		while (l < r) {
			swap(sb, l++, r--);
		}
	}

	public static void swap(StringBuilder sb, int i, int j) {
		char temp = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, temp);
	}

	/*
	 * Given a series of number form a binary tree find the minimum weight
	 * binary tree. The weight of the node is depth * value of the element +
	 * weight of the left tree + weight of the right tree.
	 * 
	 * Weight of the root node is the weight of the tree . Find the minimum
	 * weight binary tree out of all possible binary trees that are possible.
	 */

	/*
	 * With input as a integer, write an algorithm to convert that to string
	 * without using any built in functions. It is a signed number.
	 * 
	 * Equivalent to String.valueOf(-123); //java
	 * 
	 * https://www.careercup.com/question?id=5165056955252736
	 */

	public static String signedIntegerToStringWithoutUsingBuiltInFunctions(int n) {
		String str = "";
		boolean isNegative = false;

		if (n < 0)
			isNegative = true;

		n = Math.abs(n);
		while (n > 0) {
			str = n % 10 + str;
			n = n / 10;
		}
		if (isNegative)
			str = "-" + str;
		System.out.println(str);
		return str;
	}
}
