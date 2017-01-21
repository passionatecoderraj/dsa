/**
 * 
 */
package com.raj.mathamatical;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Raj
 *
 *         Convert a non-negative integer to its english words representation.
 *         Given input is guaranteed to be less than 231 - 1.
 * 
 *         For example,
 * 
 *         123 -> "One Hundred Twenty Three"
 * 
 *         12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 
 *         1234567 ->
 *         "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */
public class IntegerToEnglishWords {

	// consider number : 368,945,678,324
	// Time :O(n)
	public static String integerToEnglishWords(int n) {
		if (0 == n)
			return map.get(n);

		StringBuilder sb = new StringBuilder();

		// greater than equal to Billion
		if (n >= 1000000000) {
			String nBillion = convert(n / 1000000000);
			sb.append(nBillion);
			sb.append(" Billion ");
			n = n % 1000000000;
		}

		// greater than equal to Million
		if (n >= 1000000) {
			String nMillion = convert(n / 1000000);
			sb.append(nMillion);
			sb.append(" Million ");
			n = n % 1000000;
		}

		// greater than equal to Thousand
		if (n >= 1000) {
			String nThousand = convert(n / 1000);
			sb.append(nThousand);
			sb.append(" Thousand ");
			n = n % 1000;
		}
		sb.append(convert(n));
		return sb.toString();
	}

	// this handles values from 1 to 999
	private static String convert(int n) {
		if (n < 20) {
			return map.get(n);
		} else if (n < 100) {
			// if num is between 20 and 99 then get first part
			// ex: 68 means get 60
			int i = (n / 10);
			return map.get(i * 10) + " " + convert(n % 10);
		} else {
			return map.get(n / 100) + " Hundred " + convert(n % 100);
		}
	}

	static Map<Integer, String> map = new HashMap<>();

	static {
		map.put(0, "Zero");
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
		map.put(6, "Six");
		map.put(7, "Seven");
		map.put(8, "Eight");
		map.put(9, "Nine");
		map.put(10, "Ten");
		map.put(11, "Eleven");
		map.put(12, "Twelve");
		map.put(13, "Thirteen");
		map.put(14, "Fourteen");
		map.put(15, "Fifteen");
		map.put(16, "Sixteen");
		map.put(17, "Seventeen");
		map.put(18, "Eighteen");
		map.put(19, "Ninteen");
		map.put(20, "Twenty");
		map.put(30, "Thirty");
		map.put(40, "Forty");
		map.put(50, "Fifty");
		map.put(60, "Sixty");
		map.put(70, "Seventy");
		map.put(80, "Eighty");
		map.put(90, "Ninty");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String result = null;

		result = integerToEnglishWords(93);
		System.out.println(result);

		result = integerToEnglishWords(894);
		System.out.println(result);

		result = integerToEnglishWords(2934);
		System.out.println(result);

		result = integerToEnglishWords(945678324);
		System.out.println(result);

		result = integerToEnglishWords(1945678324);
		System.out.println(result);

	}
}
