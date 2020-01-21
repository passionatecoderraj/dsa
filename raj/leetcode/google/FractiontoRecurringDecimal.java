/**
 *
 */
package com.raj.leetcode.google;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Raj
 * 
 *         Given two integers representing the numerator and denominator of a
 *         fraction, return the fraction in string format. If the fractional
 *         part is repeating, enclose the repeating part in parentheses.
 * 
 *         For example, Given numerator = 1, denominator = 2, return "0.5".
 * 
 *         Given numerator = 2, denominator = 1, return "2".
 * 
 *         Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class FractiontoRecurringDecimal {

	// https://leetcode.com/problems/fraction-to-recurring-decimal/discuss/51106/My-clean-Java-solution
	public static String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";
		StringBuilder res = new StringBuilder();
		res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
		long n = Math.abs((long) numerator);
		long d = Math.abs((long) denominator);
		res.append(n / d);
		if (n % d == 0)
			return res.toString();
		res.append(".");
		Map<Long, Integer> map = new HashMap<>();
		n %= d;
		while (n != 0) {
			n *= 10;
			res.append(n / d);
			n %= d;
			if (map.containsKey(n)) {
				res.insert(map.get(n), "(");
				res.append(")");
				break;
			} else {
				map.put(n, res.length());
			}
		}
		return res.toString();
	}

	public static void main(String[] args) {
		String result = null;
		result = fractionToDecimal(1, 2);
		System.out.println(result);
		result = fractionToDecimal(2, 1);
		System.out.println(result);
		result = fractionToDecimal(2, 3);
		System.out.println(result);
		result = fractionToDecimal(22, 3);
		System.out.println(result);
		result = fractionToDecimal(9, 100);
		System.out.println(result);
		result = fractionToDecimal(22, 7);
		System.out.println(result);
	}

}
